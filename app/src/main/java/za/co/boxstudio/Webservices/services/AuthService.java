package za.co.boxstudio.Webservices.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;
import za.co.boxstudio.Webservices.models.Auth;
import za.co.boxstudio.Webservices.models.Login;
import za.co.boxstudio.Webservices.models.Member;

public interface AuthService {

    @POST("login")
    Call<List<Member>> login(@Field("memberId") String memberId, @Field("password") String password);

    @POST("register")
    Call<List<Member>> register(@Body Member member);

}
