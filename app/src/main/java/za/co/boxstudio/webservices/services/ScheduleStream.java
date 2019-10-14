package za.co.boxstudio.webservices.services;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


import za.co.boxstudio.webservices.ClientSingleton;
import za.co.boxstudio.webservices.models.Schedule;

public class ScheduleStream {

    public static Observable<List<Schedule>> streamFetchSchedules(){
        ScheduleService service = ClientSingleton.getRetrofitInstance().create(ScheduleService.class);

        return service.getSchedules()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(10, TimeUnit.SECONDS);
    }
}
