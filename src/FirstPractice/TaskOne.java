package FirstPractice;

public class TaskOne {
    public static int[] fillArray() {
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round((Math.random() * 50));
        }
        return array;
    }
    public static int sequentialSum(int[] array) throws InterruptedException {
        int sum = 0;
        for (int el: array) {
            sum += el;
            Thread.sleep(1);
        }
        return sum;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = fillArray();
        System.out.println(sequentialSum(arr));
    }
}
