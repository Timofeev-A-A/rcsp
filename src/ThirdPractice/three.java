package ThirdPractice;

import io.reactivex.rxjava3.core.Observable;

public class three {
    public static int randomNumber(int bot, int top) {
        return (int)Math.round(bot + (Math.random() * (top-bot)));
    }
    public static UserFriend[] fillArray() {
        UserFriend[] array = new UserFriend[1000];
        for (int i = 0; i < array.length; i++) {
            int userId = (int) Math.round((Math.random() * 50));
            int friendId = (int) Math.round((Math.random() * 50));
            array[i] = new UserFriend(userId,friendId);
        }
        return array;
    }
    public static class UserFriend {
        private final int userId;
        private final int friendId;

        public UserFriend(int userId, int friendId) { this.userId = userId; this.friendId = friendId; }

        public int getUserId() { return userId; }

        @Override
        public String toString() { return "UserFriend{" + "userId=" + userId + ", friendId=" + friendId + '}'; }
    }
    public static Observable<UserFriend> getFriends(int userId, Observable<UserFriend> users) {
        return users.filter(x -> x.getUserId() == userId);
    }

    public static void main(String[] args) {
        UserFriend[] userFriends = fillArray();
        Integer[] randIds = new Integer[15];
        for (int i=0; i<randIds.length; i++)
            randIds[i] = randomNumber(0,50);
        Observable<UserFriend> userFriendObservable = Observable.fromArray(userFriends);
        Observable<UserFriend> filtered = Observable.empty();
        for (Integer randId : randIds) {
            filtered = filtered.concatWith(getFriends(randId, userFriendObservable));
        }
        filtered.subscribe(item -> System.out.print(item.toString()+" "));
    }
}
