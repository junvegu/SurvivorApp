package com.cerezaconsulting.coreproject.presentation.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.cerezaconsulting.coreproject.R;
import com.cerezaconsulting.coreproject.data.model.CategoryEntity;
import com.cerezaconsulting.coreproject.data.model.KoreanModelEntity;
import com.cerezaconsulting.coreproject.presentation.adapters.listeners.OnClickListListener;
import com.cerezaconsulting.coreproject.utils.GlideUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by miguel on 10/01/17.
 */

public class KoreanAdapter extends RecyclerView.Adapter<KoreanAdapter.ViewHolder> implements OnClickListListener {


    private ArrayList<KoreanModelEntity> mKoreanModelEntities;
    private Context context;

    public KoreanAdapter(ArrayList<KoreanModelEntity> list, Context context) {
        this.mKoreanModelEntities = list;
        this.context = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_korean, parent, false);
        return new ViewHolder(root, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        KoreanModelEntity koreanModelEntity = mKoreanModelEntities.get(position);

        final ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.tvName.setText(koreanModelEntity.getName());
        GlideUtils.loadImageCircleTransform(viewHolder.ivIcon, koreanModelEntity.getImage(), context);


    }


    @Override
    public int getItemCount() {
        return mKoreanModelEntities.size();
    }

    @Override
    public void onClick(int position) {
    }

    public void setItems(ArrayList<KoreanModelEntity> koreanModelEntities) {
        this.mKoreanModelEntities =  koreanModelEntities;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.tv_name)
        TextView tvName;


        OnClickListListener onClickListListener;

        public ViewHolder(View view, OnClickListListener onClickListListener) {
            super(view);
            ButterKnife.bind(this, view);
            this.onClickListListener = onClickListListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickListListener.onClick(getAdapterPosition());
        }
    }
}
