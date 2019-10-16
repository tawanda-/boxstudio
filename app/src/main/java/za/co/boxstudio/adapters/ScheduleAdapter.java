package za.co.boxstudio.adapters;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.Log;
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

        String title = dataList.get(position).getActvityName();
        String staff = "Trainer: "+dataList.get(position).getStaffName()+" "+dataList.get(position).getStaffSurname();
        String d = "Date:     "+dataList.get(position).getScheduleDay();
        String t = "Time:     "+dataList.get(position).getStartTime()+" - "+dataList.get(position).getEndTime();
        String v = "Venue:   "+dataList.get(position).getFacilityName();

        //android.text.style.StyleSpan styleSpan = new android.text.style.StyleSpan(android.graphics.Typeface.BOLD);

        SpannableStringBuilder name = new SpannableStringBuilder(staff);
        name.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannableStringBuilder time = new SpannableStringBuilder(t);
        name.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannableStringBuilder venue = new SpannableStringBuilder(v);
        name.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        holder.line1.setText(title);
        holder.line2.setText(staff);
        holder.line3.setText(d);
        holder.line4.setText(t);
        holder.line5.setText(v);

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
        TextView line4;
        TextView line5;


        ScheduleViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            line1 = mView.findViewById(R.id.item_line_1);
            line2 = mView.findViewById(R.id.item_line_2);
            line3 = mView.findViewById(R.id.item_line_3);
            line4 = mView.findViewById(R.id.item_line_4);
            line5 = mView.findViewById(R.id.item_line_5);
        }
    }
}
