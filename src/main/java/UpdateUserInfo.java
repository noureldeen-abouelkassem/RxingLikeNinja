import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import dto.UserInfo;
import retrofit.RetrofitClient;
import retrofit.UserAPIs;

public class UpdateUserInfo {
    public static void main(String[] args) {
        UserAPIs userAPIs = RetrofitClient.getRetrofitInstance().create(UserAPIs.class);
        UserInfo newUserInfo = new UserInfo();
        newUserInfo.setName("noureldeen abouelkassem");
        newUserInfo.setGender("male");
        userAPIs.updateUser(10, newUserInfo).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onComplete() {
                System.out.println("Done Successfully");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        });
    }
}
