package za.co.boxstudio.Webservices.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import za.co.boxstudio.Webservices.models.Schedule;

public interface ScheduleService {

    @GET("schedule")
    Call<List<Schedule>> getSchedule();
}
