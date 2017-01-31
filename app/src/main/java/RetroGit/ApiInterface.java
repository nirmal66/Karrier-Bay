package RetroGit;

import Model.LoginRequest;
import Model.LoginResponse;
import Model.Otp;
import Model.SignUpResponse;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by narasinga_m on 8/26/2016.
 */
public interface ApiInterface {
    // @FormUrlEncoded
    @POST("auth/sign_in")
    Call<LoginResponse> getLogin(@Body LoginRequest loginRequest);
    @POST("auth")
    Call<SignUpResponse> getSignUp(@Body RequestBody body);
    @POST("auth/send_otp/{phone}")
    Call<Otp> getOtp(@Path("phone") String phoneNumber);
    @POST("auth/verify/{otp}/phone_number/{phone}")
    Call<Otp> verifyOtp(@Path("otp") String otp, @Path("phone") String phoneNumber);
}
