package FirstPractice;



public class TaskOneOne {
    public static class MultiThreadedSum extends Thread {
        int[] arr;
        public MultiThreadedSum(int[] array){
            this.arr = array;
        }
        public void run() {
            int sum = 0;
            for (int el: arr) {
                sum += el;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        int[] arr = TaskOne.fillArray();
        int sum = 0;
        MultiThreadedSum multiThreadedSum = new MultiThreadedSum(arr);
        new Thread(multiThreadedSum).start();
    }
}
