package za.co.boxstudio.ui.fragments;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import za.co.boxstudio.webservices.models.Schedule;

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
/*
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
    */
}
