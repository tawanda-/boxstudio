package za.co.boxstudio.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import za.co.boxstudio.R;
import za.co.boxstudio.webservices.models.Schedule;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    private List<Schedule> dataList;
    private LayoutInflater layoutInflater;


    public ScheduleAdapter(Context context, List<Schedule> dataList){
        this.layoutInflater = LayoutInflater.from(context);
        this.dataList = dataList;
    }


    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_schedule_card_view, parent, false);
        return new ScheduleViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ScheduleViewHolder holder, int position) {

        String staffName = dataList.get(position).getStaffName()+" "+dataList.get(position).getStaffSurname();
        String time = dataList.get(position).getStartTime()+" - "+dataList.get(position).getEndTime();

        holder.line1.setText(dataList.get(position).getActvityName());
        holder.line2.setText(staffName);
        holder.line3.setText(time);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /* VIEW HOLDER*/

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
}
