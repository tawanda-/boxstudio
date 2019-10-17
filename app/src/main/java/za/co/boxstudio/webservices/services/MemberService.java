package za.co.boxstudio.webservices.services;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import za.co.boxstudio.webservices.models.Login;
import za.co.boxstudio.webservices.models.Member;

public interface MemberService {

    @GET("member")
    Call<Member> getMember(@Query("memberid") String id);

    @FormUrlEncoded
    @POST("login/")
    Call<Login> login(@Field("memberId") String memberId, @Field("password") String password);

    @FormUrlEncoded
    @POST("register/")
    Call<Member> register(@Field("memberEmail") String memberEmail, @Field("memberName") String memberName,
                                @Field("memberSurname") String memberSurname, @Field("membershipID") String membershipID,
                                @Field("memberID") String memberID, @Field("password") String password);

    @FormUrlEncoded
    @POST("booking/")
    Call<Object> booking(@FieldMap Map<String, String> field);
}
