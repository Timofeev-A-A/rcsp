package FirstPractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskOneTwo {
    public static class SummableArray {
        int[] array = TaskOne.fillArray();
        int sum = 0;
        int i = 0;
        public void addToSum() {
            this.sum += this.array[i];
            //System.out.println(this.i);
            this.i += 1;
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        TaskOneOne.SummableArray summableArray = new TaskOneOne.SummableArray();
        ExecutorService executor = Executors.newWorkStealingPool();
        long startTime = System.nanoTime();
        Runnable task = () -> {
            synchronized (lock) {
                summableArray.addToSum();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int el: summableArray.array) {
            executor.submit(task);
        }

        executor.shutdown();

        while (true){
            if (executor.isTerminated())
                break;
        }
        System.out.println(summableArray.sum);
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Total execution in millis: " + elapsedTime/1000000);
        long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Bytes used: " + usedBytes);
    }
}
