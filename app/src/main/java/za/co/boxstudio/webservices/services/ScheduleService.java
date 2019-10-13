package za.co.boxstudio.webservices.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import za.co.boxstudio.webservices.models.Schedule;

public interface ScheduleService {

    @GET("schedule")
    Call<List<Schedule>> getSchedule();
}
