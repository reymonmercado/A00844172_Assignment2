package com.example.a00844172_assignment2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    private List<CustSched> custScheds = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cust_sched_item, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        CustSched currentCustSched = custScheds.get(position);

        holder.textViewName.setText(currentCustSched.getCustomerNameCS());
        holder.textViewStreet.setText(currentCustSched.getCustomerStreetCS());
        holder.textViewCity.setText(currentCustSched.getCustomerCityCS());
        holder.textViewBday.setText(currentCustSched.getCustomerBdayCS());
        holder.textViewGender.setText(currentCustSched.getCustomerGenderCS());
        holder.textViewServiceType.setText(currentCustSched.getServiceTypeNameCS());
        holder.textViewStartDateTime.setText(currentCustSched.getStartDateTimeCS());
        holder.textViewDuration.setText(currentCustSched.getActualDurationCS());
        holder.textViewStatus.setText(currentCustSched.getStatusCS());

    }

    @Override
    public int getItemCount() {
        return custScheds.size();
    }

    public void setCustScheds(List<CustSched> custScheds) {
        this.custScheds = custScheds;
        notifyDataSetChanged();
    }

    public CustSched getCustSchedAt(int position) {
        return custScheds.get(position);
    }

    class Holder extends RecyclerView.ViewHolder {
        private TextView textViewPriority;
        private TextView textViewName;
        private TextView textViewStreet;
        private TextView textViewCity;
        private TextView textViewBday;
        private TextView textViewGender;
        private TextView textViewServiceType;
        private TextView textViewStartDateTime;
        private TextView textViewDuration;
        private TextView textViewStatus;

        public Holder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewStreet = itemView.findViewById(R.id.text_view_street);
            textViewCity = itemView.findViewById(R.id.text_view_city);
            textViewBday = itemView.findViewById(R.id.text_view_bday);
            textViewGender = itemView.findViewById(R.id.text_view_gender);
            textViewServiceType = itemView.findViewById(R.id.text_view_service_type_name);
            textViewStartDateTime = itemView.findViewById(R.id.text_view_start_date_time);
            textViewDuration = itemView.findViewById(R.id.text_view_actual_duration);
            textViewStatus = itemView.findViewById(R.id.text_view_status);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(custScheds.get(position));
                    }
                }
            });

        }
    }

    public interface OnItemClickListener {
        void onItemClick(CustSched custSched);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
