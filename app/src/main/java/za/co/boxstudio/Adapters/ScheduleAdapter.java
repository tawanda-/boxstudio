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

        TextView txtTitle;

        ScheduleViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.schedule_row_title);
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
        holder.txtTitle.setText(dataList.get(position).getStaffID());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
