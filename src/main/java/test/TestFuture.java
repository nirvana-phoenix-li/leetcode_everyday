package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class TestFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long currentTimeMillis = System.currentTimeMillis();

        // 创建一个任务列表
        List<CompletableFuture<String>> taskList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            taskList.add(CompletableFuture.supplyAsync(() -> performTask(String.valueOf(finalI))));
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(taskList.toArray(new CompletableFuture[0]));

        // 当所有任务完成后，获取每个任务的返回值
        CompletableFuture<List<String>> allTaskResults = allOf.thenApply(v ->
                taskList.stream()
                        .map((task) -> {
                                    try {
                                        return task.get(); // 使用get方法获取任务结果
                                    } catch (InterruptedException | ExecutionException e) {
                                        System.err.println("任务失败: " + e.getMessage());
                                        return ""; // 返回一个空的Stream
                                    }
                                }
                        ) // join方法会阻塞当前线程直到对应的CompletableFuture完成
                        .collect(Collectors.toList())
        );

        // 获取并打印所有任务的返回值
        try {
            List<String> results = allTaskResults.get();
            results.forEach(System.out::println);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    private static String performTask(String task) {
        System.out.println("coming task");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "fine" + task;

    }
}
