package com.softylogics.nazkar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softylogics.nazkar.ItemFragment.OnListFragmentInteractionListener;
import com.softylogics.nazkar.adslist.DummyData;
import com.softylogics.nazkar.animalList.animalList;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link animalList} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class RVAdapterForCircularAds extends RecyclerView.Adapter<RVAdapterForCircularAds.ViewHolder> {

    private final List<DummyData> mValues;
    private final OnListFragmentInteractionListener mListener;

    public RVAdapterForCircularAds(List<DummyData> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.circularimageanimallayout, parent, false);


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
        public final TextView title;



        public ViewHolder(View view) {
            super(view);
            mView = view;

            title = view.findViewById(R.id.adnametxtv);
            img = view.findViewById(R.id.imagead);


        }


    }
}
