package com.amarnehsoft.zububa.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amarnehsoft.zububa.R;
import com.amarnehsoft.zububa.model.Taxi;
import com.amarnehsoft.zububa.ui.base.BaseViewHolder;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TaxiAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<Taxi> taxis;

    public TaxiAdapter(List<Taxi> taxis) {
        this.taxis = taxis;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_taxi, parent, false);
        return new TaxiHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return taxis==null?0:taxis.size();
    }

    class TaxiHolder extends BaseViewHolder{
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvPhone)
        TextView tvPhone;
        @BindView(R.id.tvDescription)
        TextView tvDescription;

        public TaxiHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        public void onBind(int position) {
            tvName.setText(taxis.get(position).getName());
            tvPhone.setText(taxis.get(position).getPhone());
            tvDescription.setText(taxis.get(position).getDesc());
        }
    }
}
