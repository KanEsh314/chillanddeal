package com.example.itrain.demohackathon;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DealsFragment extends Fragment {


    public DealsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView card;
        public TextView dealDetail;
        public TextView dealNearby;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_deals, parent, false));
            card = (ImageView) itemView.findViewById(R.id.list_place);
            dealDetail = (TextView) itemView.findViewById(R.id.list_title);
            dealNearby = (TextView) itemView.findViewById(R.id.list_desc);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 3;

        private final String[] dealDetail;
        private final String[] dealNearby;
        private final Drawable[] card;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            dealDetail = resources.getStringArray(R.array.card_name);
            dealNearby = resources.getStringArray(R.array.nearby_deals);
            TypedArray a = resources.obtainTypedArray(R.array.my_cards);
            card = new Drawable[a.length()];
            for (int i = 0; i < card.length; i++) {
                card[i] = a.getDrawable(i);
            }
            a.recycle();
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.card.setImageDrawable(card[position % card.length]);
            holder.dealDetail.setText(dealDetail[position % dealDetail.length]);
            holder.dealNearby.setText(dealNearby[position % dealNearby.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }


    }
