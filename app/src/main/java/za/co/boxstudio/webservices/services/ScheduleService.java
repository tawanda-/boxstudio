package za.co.boxstudio.webservices.services;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import za.co.boxstudio.webservices.models.Schedule;

public interface ScheduleService {

    @GET("schedule")
    Observable<List<Schedule>> getSchedules();
}
