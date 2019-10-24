package za.co.boxstudio.ui.activities;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
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
    private View progressBar;
    private CoordinatorLayout layout;

    private List<Schedule> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.schedule_recycler);
        layout = findViewById(R.id.layoutSchedule);
        progressBar = findViewById((R.id.viewScheduleProgressBar));

        mAdapter = new ScheduleAdapter(ScheduleActivity.this, dataList );
        layoutManager = new LinearLayoutManager(ScheduleActivity.this);

        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(layoutManager);

        if(progressBar.getVisibility() == View.GONE) {
            progressBar.setVisibility(View.VISIBLE);
        }

        updateRecycler();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(this.getClass().getSimpleName(), "START");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(this.getClass().getSimpleName(), "RESUME");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(this.getClass().getSimpleName(), "STOP");
    }


    private void updateRecycler(){

        this.disposable = ScheduleStream.streamFetchSchedules().subscribeWith(new DisposableObserver<List<Schedule>>() {
            @Override
            public void onNext(List<Schedule> schedules) {
                updateUI(schedules);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                if(progressBar.getVisibility() == View.VISIBLE) {
                    progressBar.setVisibility(View.GONE);
                }
                Snackbar.make(layout, R.string.error_messge, Snackbar.LENGTH_LONG).show();
            }

            @Override
            public void onComplete() {
            }
        });
    }

    private void updateUI(List<Schedule> schedules){

        if(progressBar.getVisibility() == View.VISIBLE) {
            progressBar.setVisibility(View.GONE);
        }

        dataList.addAll(schedules);
        mAdapter.notifyDataSetChanged();
    }

}
