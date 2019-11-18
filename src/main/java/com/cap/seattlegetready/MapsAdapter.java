package com.cap.seattlegetready;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MapsAdapter extends RecyclerView.Adapter<MapsAdapter.ProductViewHolder> {

    private Context mCtx;

    private List<Maps> listMaps;

    public MapsAdapter(Context mCtx, List<Maps> productList) {
        this.mCtx = mCtx;
        this.listMaps = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_maps, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        Maps product = listMaps.get(position);

        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getLocahubs());
        holder.textViewRating.setText(String.valueOf(product.getHubs()));
        holder.textViewPrice.setText(String.valueOf(product.getCity()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }


    @Override
    public int getItemCount() {
        return listMaps.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewLocalHubs);
            textViewRating = itemView.findViewById(R.id.textViewCityName);
            textViewPrice = itemView.findViewById(R.id.textViewCityNamesH);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}