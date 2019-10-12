package za.co.boxstudio.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import za.co.boxstudio.R;
import za.co.boxstudio.Webservices.models.Schedule;

public class ScheduleAdapter extends PagedListAdapter<Schedule, ScheduleAdapter.ScheduleViewHolder> {

    private List<Schedule> dataList;
    private Context context;

    public ScheduleAdapter(@NonNull DiffUtil.ItemCallback<Schedule> diffCallback) {
        super(diffCallback);
    }

    /*
    public ScheduleAdapter(Context context, List<Schedule> dataList){
        this.context = context;
        this.dataList = dataList;
    }
    */

    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_schedule, parent, false);
        return new ScheduleViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ScheduleViewHolder holder, int position) {
        /*holder.line1.setText(dataList.get(position).getActvityName());
        holder.line2.setText(dataList.get(position).getStaffName()+" "+dataList.get(position).getStaffSurname());
        holder.line3.setText(dataList.get(position).getStartTime()+" - "+dataList.get(position).getEndTime());*/

        Schedule schedule = getItem(position);

        if (schedule != null) {
            //holder.bindTo(schedule);
        } else {
            // Null defines a placeholder item - PagedListAdapter will automatically invalidate
            // this row when the actual object is loaded from the database
            //holder.clear();
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static final DiffUtil.ItemCallback<Schedule> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Schedule>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull Schedule oldUser, @NonNull Schedule newUser) {
                    // User properties may have changed if reloaded from the DB, but ID is fixed
                    return oldUser.getScheduleID() == newUser.getScheduleID();
                }
                @Override
                public boolean areContentsTheSame(
                        @NonNull Schedule oldUser, @NonNull Schedule newUser) {
                    // NOTE: if you use equals, your object must properly override Object#equals()
                    // Incorrectly returning false here will result in too many animations.
                    return oldUser.equals(newUser);
                }
            };

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
