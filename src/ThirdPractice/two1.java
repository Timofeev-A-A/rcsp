package ThirdPractice;

import io.reactivex.rxjava3.core.Flowable;

import java.util.Arrays;

public class two1 {
    public static Integer[] fillArray() {
        Integer[] array = new Integer[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round((Math.random() * 1000));
        }
        return array;
    }

    public static void main(String[] args) {
        Integer[] array = fillArray();
        System.out.println(Arrays.toString(array));
        Flowable<Integer> flow = Flowable.fromArray(array);
        flow.subscribe(num -> System.out.print(num+" "));
        System.out.print("\n");
        Flowable<Integer> next = flow.map(item -> item*item);
        next.subscribe(num -> System.out.print(num+" "));
    }
}
