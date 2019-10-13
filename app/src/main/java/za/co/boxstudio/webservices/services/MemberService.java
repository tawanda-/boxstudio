package za.co.boxstudio.webservices.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import za.co.boxstudio.webservices.models.Member;

public interface MemberService {

    @FormUrlEncoded
    @POST("login")
    Call<List<Member>> login(@Field("memberId") String memberId, @Field("password") String password);

    @POST("register")
    Call<List<Member>> register(@Body Member member);
}
