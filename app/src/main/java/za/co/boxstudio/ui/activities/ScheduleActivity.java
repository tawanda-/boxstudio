package za.co.boxstudio.ui.activities;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import za.co.boxstudio.R;
import za.co.boxstudio.adapters.ScheduleAdapter;
import za.co.boxstudio.webservices.ClientSingleton;
import za.co.boxstudio.webservices.models.Schedule;
import za.co.boxstudio.webservices.services.ScheduleService;
import za.co.boxstudio.webservices.services.ScheduleStream;

public class ScheduleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Disposable disposable;

    private List<Schedule> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.schedule_recycler);

        //recyclerView.setHasFixedSize(true);

        mAdapter = new ScheduleAdapter(ScheduleActivity.this, dataList );
        layoutManager = new LinearLayoutManager(ScheduleActivity.this);

        /*DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.HORIZONTAL);*/

        //recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(layoutManager);

        updateRecycler();

    }

    private void updateRecycler(){

        this.disposable = ScheduleStream.streamFetchSchedules().subscribeWith(new DisposableObserver<List<Schedule>>() {
            @Override
            public void onNext(List<Schedule> schedules) {
                updateUI(schedules);
            }

            @Override
            public void onError(Throwable e) { }

            @Override
            public void onComplete() { }
        });
    }

    private void updateUI(List<Schedule> schedules){
        dataList.addAll(schedules);
        mAdapter.notifyDataSetChanged();
    }

}
