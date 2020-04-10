package com.madhu.covid_19india;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StateRecyclerAdapter extends RecyclerView.Adapter<StateRecyclerAdapter.ViewHolder> {

    private List<StateDataPOJO> mList;

    public StateRecyclerAdapter(List<StateDataPOJO> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.state_data_element,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.confirmedButton.setText(mList.get(position).getConfirmed());
        holder.recovered_textView.setText(mList.get(position).getRecovered());
        holder.state_name.setText(mList.get(position).getName());
        holder.active_textView.setText(mList.get(position).getActive());
        holder.demises_textView.setText(mList.get(position).getDeaths());

    }

    @Override
    public int getItemCount() {

        if (mList!=null)return mList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button confirmedButton, state_name;
        TextView recovered_textView, active_textView, demises_textView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            confirmedButton=itemView.findViewById(R.id.confirmed_button);
            state_name=itemView.findViewById(R.id.state_name);
            recovered_textView=itemView.findViewById(R.id.recovered_textView);
            active_textView=itemView.findViewById(R.id.active_textView);
            demises_textView=itemView.findViewById(R.id.demise_textView);

        }
    }

    public void dataChanged(){
        notifyDataSetChanged();
    }
}
