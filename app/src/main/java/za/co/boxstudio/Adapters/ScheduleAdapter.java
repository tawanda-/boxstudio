package za.co.boxstudio.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import za.co.boxstudio.R;
import za.co.boxstudio.Webservices.models.Schedule;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    private List<Schedule> dataList;
    private Context context;

    public ScheduleAdapter(Context context, List<Schedule> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class ScheduleViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView line1;
        TextView line2;
        TextView line3;


        ScheduleViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            line1 = mView.findViewById(R.id.item_line_1);
            line2 = mView.findViewById(R.id.item_line_2);
            line3 = mView.findViewById(R.id.item_line_3);
        }
    }

    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_schedule, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ScheduleViewHolder holder, int position) {
        holder.line1.setText(dataList.get(position).getActivity().getName());
        holder.line2.setText(dataList.get(position).getInstructor().getName()+" "+dataList.get(position).getInstructor().getSurname());
        holder.line3.setText(dataList.get(position).getStartTime()+" - "+dataList.get(position).getEndTime());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
