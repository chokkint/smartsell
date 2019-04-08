package com.ivantee.smartsell;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ivantee.smartsell.CustomerItemFragment.OnListFragmentInteractionListener;
import com.ivantee.smartsell.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mCName.setText(mValues.get(position).name);
        holder.mScore.setText(mValues.get(position).score);
        holder.mAction.setText(mValues.get(position).action);
        holder.mZc.setText(mValues.get(position).zc);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mCName;
        public final TextView mScore;
        public final TextView mAction;
        public final TextView mZc;
        public final ImageView iAccount;
        public final ImageView addAction;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mCName = (TextView) view.findViewById(R.id.customer_name);
            mScore = (TextView) view.findViewById(R.id.score);
            mAction = (TextView) view.findViewById(R.id.action);
            mZc = (TextView) view.findViewById(R.id.zc);
            iAccount = (ImageView) view.findViewById(R.id.pic);
            addAction = (ImageView) view.findViewById(R.id.addAction);
        }

    }
}
