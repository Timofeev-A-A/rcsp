package ThirdPractice;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class One {
    public static int randomNumber(int bot, int top) {

        return (int)Math.round(bot + (Math.random() * (top-bot)));
    }
    public static String checkResults(int[] array) {
        if (array[0]>25 && array[1]>70)
            return "ALARM! BRAUCHE SICHERUNG, EINDRINGER IM RAUM, GOTT VERDAMMT, ICH BRAUCHE MEHR SICHERUNG!";
        if (array[0]>25)
            return "Temperature is above the expected: "+array[0];
        if (array[1]>70)
            return "CO2 is above the expected: "+array[1];
        return "All ok for now";
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        Observable<Integer> temp = Observable.interval(1000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.from(executor1)).map(a -> randomNumber(15,30));
        Observable<Integer> co2 = Observable.interval(1000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.from(executor2)).map( a -> randomNumber(30, 100));
        Observable.zip(temp, co2,
                        (observable1, observable2) -> new int[]{observable1, observable2})
                .subscribe(item -> System.out.println(checkResults(item)));
    }
}
