package retrofit;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String API_URL = "http://35.178.117.57:3000/";
    private static RetrofitClient retrofitClient = null;
    private Retrofit retrofit;
    private RetrofitClient(){
       retrofit = new Retrofit.Builder()
               .addConverterFactory(GsonConverterFactory.create(new Gson()))
               .baseUrl(API_URL)
               .client(new OkHttpClient())
               .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
               .build();
    }
    public static Retrofit getRetrofitInstance(){
        if(retrofitClient == null){
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient.retrofit;
    }
}
