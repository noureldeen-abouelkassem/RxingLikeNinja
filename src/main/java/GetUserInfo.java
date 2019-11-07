import dto.UserInfo;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import retrofit.RetrofitClient;
import retrofit.UserAPIs;

public class GetUserInfo {

    public static void main(String[] args) {
        UserAPIs userAPIs = RetrofitClient.getRetrofitInstance().create(UserAPIs.class);
        userAPIs.getUser().subscribe(new SingleObserver<UserInfo>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onSuccess(UserInfo userInfo) {
                System.out.println(userInfo.getName());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        });
    }
}
