package com.softylogics.nazkar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.softylogics.nazkar.adslist.DummyData;

import java.util.List;

/**
* TODO: Replace the implementation with code for your data type.
 */
public class RVAdapterFroAds extends RecyclerView.Adapter<RVAdapterFroAds.ViewHolder> {

    private final List<DummyData> mValues;

    public RVAdapterFroAds(List<DummyData> items) {
        mValues = items;
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ad_item_layout, parent, false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    productDetail pd = new productDetail();
                    FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment , pd);
                    transaction.addToBackStack(null);
                    transaction.commit();

                }
            });

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {


        holder.img.setImageBitmap(mValues.get(position).getImage());
        holder.img.setClipToOutline(true);
        holder.price.setText(mValues.get(position).getPrice());
        holder.title.setText(mValues.get(position).getTitle());

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView img;
        public final TextView price;
        public final TextView title;



        public ViewHolder(View view) {
            super(view);
            mView = view;

            title = view.findViewById(R.id.adnametxtv);
            price = view.findViewById(R.id.adpricetxtv);
            img = view.findViewById(R.id.imagead);


        }


    }
}
