package za.co.boxstudio.ui.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import za.co.boxstudio.Adapters.ScheduleAdapter;
import za.co.boxstudio.R;
import za.co.boxstudio.Webservices.ClientSingleton;
import za.co.boxstudio.Webservices.models.Schedule;
import za.co.boxstudio.Webservices.services.ScheduleService;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    private static final String ARG_POSITION = "position";
    private int position;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Schedule> dataList = new ArrayList<>();


    public ScheduleFragment() {
        // Required empty public constructor
    }

    public static ScheduleFragment newInstance(int position) {
        ScheduleFragment f = new ScheduleFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_schedule, container, false);

        recyclerView = view.findViewById(R.id.schedule_recycler);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.HORIZONTAL);

        recyclerView.addItemDecoration(dividerItemDecoration);

        //mAdapter = new ScheduleAdapter(getContext(), dataList );
        //recyclerView.setAdapter(mAdapter);

        //updateRecycler();
    }

    private void updateRecycler(){

        ScheduleService service = ClientSingleton.getRetrofitInstance().create(ScheduleService.class);
        Call<List<Schedule>> call = service.getSchedule();
        call.enqueue(new Callback<List<Schedule>>() {

            @Override
            public void onResponse(Call<List<Schedule>> call, Response<List<Schedule>> response) {
                Log.d(this.getClass().getSimpleName(), new Gson().toJson(response));
                dataList = response.body();
                //mAdapter.notifyDataSetChanged();
                //notifyItemInserted
                mAdapter.notifyItemRangeInserted(0, dataList.size());
            }

            @Override
            public void onFailure(Call<List<Schedule>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
