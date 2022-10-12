package ThirdPractice;

import io.reactivex.rxjava3.core.Flowable;

import java.util.Random;

public class two2 {
    public static Character[] randomFiller(String alphabet, Random random) {
        Character[] array = new Character[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = alphabet.charAt(random.nextInt(alphabet.length()));
        }
        return array;
    }


    public static void main(String[] args) {
        Random random = new Random();
        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        Flowable<Character> firstFlow = Flowable.fromArray(randomFiller(upper, random));
        Flowable<Character> secondFlow = Flowable.fromArray(randomFiller(digits, random));
        Flowable<String> finalFlow = Flowable.zip(firstFlow, secondFlow,
                (char1, char2) -> String.valueOf(char1) + char2);
        firstFlow.subscribe(item -> System.out.print(item+" "));
        System.out.print("\n");
        secondFlow.subscribe(item -> System.out.print(item+" "));
        System.out.print("\n");
        finalFlow.subscribe(item -> System.out.print(item+" "));
    }
}
