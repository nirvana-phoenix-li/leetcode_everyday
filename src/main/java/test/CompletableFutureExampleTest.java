package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureExampleTest {

    public static void main(String[] args) {
        // 创建一个任务列表
        List<CompletableFuture<List<String>>> taskList = new ArrayList<>();

        taskList.add(CompletableFuture.supplyAsync(() -> performTaskWithError("1")));
        taskList.add(CompletableFuture.supplyAsync(() -> performTask("2")));
        taskList.add(CompletableFuture.supplyAsync(() -> performTask("3")));


        // 使用allOf来等待所有任务完成
        CompletableFuture<Void> allOf = CompletableFuture.allOf(taskList.toArray(new CompletableFuture[0]));

        // 当所有任务完成后，获取每个任务的返回值，并汇总到一个List<String>中
        CompletableFuture<List<String>> allTaskResults = allOf.thenApply(v ->
                taskList.stream()
                        .flatMap(task -> {
                            try {
                                return task.get().stream(); // 使用get方法获取任务结果
                            } catch (InterruptedException | ExecutionException e) {
                                System.err.println("任务失败: " + e.getMessage());
                                return Stream.<String>empty(); // 返回一个空的Stream
                            }
                        })
                        .collect(Collectors.toList())
        );

        // 获取并打印所有任务的返回值
        try {
            List<String> results = allTaskResults.get();
            results.forEach(System.out::println);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static List<String> performTask(String taskName) {
        // 模拟任务处理，返回List<String>
        List<String> result = new ArrayList<>();
        try {
            Thread.sleep(1000); // 模拟耗时操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result.add(taskName + " result 1");
        result.add(taskName + " result 2");
        return result;
    }

    private static List<String> performTaskWithError(String taskName) {
        // 模拟任务处理，抛出异常
        throw new RuntimeException(taskName + " encountered an error");
    }
}
