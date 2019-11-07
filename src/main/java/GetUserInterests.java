import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import dto.InterestsItem;
import dto.UserInterests;
import retrofit.RetrofitClient;
import retrofit.UserAPIs;

public class GetUserInterests {
    public static void main(String[] args) {
        UserAPIs userAPIs = RetrofitClient.getRetrofitInstance().create(UserAPIs.class);
        /*
          user with id 10 has interests
          user with id 11 has no interests
         */
        userAPIs.getUserInterests(10)
                .filter(userInterests -> !userInterests.getInterests().isEmpty())
                .subscribe(new MaybeObserver<UserInterests>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onSuccess(UserInterests userInterests) {
                        for (InterestsItem interestItem : userInterests.getInterests()) {
                            System.out.println("user loves : " + interestItem.getName());
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Sorry user doesn't have any interests");
                    }
                });
    }
}
