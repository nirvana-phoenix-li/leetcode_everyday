package test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapCollisionExample {

    // 自定义Key类，故意实现糟糕的hashCode方法制造碰撞
    static class CollisionKey {
        private final String name;
        private final int group; // 用于控制hashCode分组

        public CollisionKey(String name, int group) {
            this.name = name;
            this.group = group;
        }

        // 故意实现会导致哈希碰撞的hashCode
        @Override
        public int hashCode() {
            return group; // 相同group的key会有相同hashCode
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CollisionKey)) return false;
            CollisionKey other = (CollisionKey) obj;
            return this.name.equals(other.name) && this.group == other.group;
        }
    }

    public static void main(String[] String) throws InterruptedException {
        final int THREADS = 15;
        final int KEYS_PER_GROUP = 15;
        final int GROUPS = 2; // 减少分组数增加碰撞概率

        ConcurrentHashMap<CollisionKey, Integer> map = new ConcurrentHashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);

        long startTime = System.currentTimeMillis();

        // 提交并发任务
        for (int g = 0; g < GROUPS; g++) {
            for (int i = 0; i < KEYS_PER_GROUP; i++) {
                final CollisionKey key = new CollisionKey("key-" + g + "-" + i, g);
                executor.submit(() -> {
                    long threadStart = System.currentTimeMillis();
//                     模拟复杂计算
                    for (int j = 0; j < 1000000; j++) {
                        map.compute(key, (k, v) -> v == null ? 1 : v + 1);
                    }
                    long threadEnd = System.currentTimeMillis();
                    System.out.println(Thread.currentThread().getName() +
                            " 处理 " + key.name +
                            " 耗时: " + (threadEnd - threadStart) + "ms");
                });
            }
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        long endTime = System.currentTimeMillis();
        System.out.println("总耗时: " + (endTime - startTime) + "ms");
        System.out.println("Map大小: " + map.size());
    }
}