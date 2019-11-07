package retrofit;

import dto.UserInfo;
import dto.UserInterests;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface UserAPIs {
    @GET("/v1/user")
    Single<UserInfo> getUser();

    @GET("/v1/user/{id}/interest")
    Maybe<UserInterests> getUserInterests(@Path("id") int userId);

    @PUT("/v1/user/{id}")
    Completable updateUser(@Path("id") int userId, @Body UserInfo userInfo);
}
