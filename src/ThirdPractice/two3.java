package ThirdPractice;

import io.reactivex.rxjava3.core.Flowable;

public class two3 {
    public static void main(String[] args) {
        Flowable<Integer> flow = Flowable.just(1,2,3,4,5,6,7,8,9,10);
        Flowable<Integer> finalFlow = flow.skip(3);
        finalFlow.subscribe(item -> System.out.print(item+" "));
    }
}
