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
import com.cerezaconsulting.coreproject.presentation.adapters.listeners.OnClickListListener;
import com.cerezaconsulting.coreproject.utils.GlideUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by miguel on 10/01/17.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> implements OnClickListListener {


    private ArrayList<CategoryEntity> list;
    private ArrayList<CategoryEntity> total;
    private Context context;
    private ArrayList<Boolean> status;

    public CategoriesAdapter(ArrayList<CategoryEntity> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void selectAllUnselectWorkers() {

        for (int i = 0; i < list.size(); i++) {
            //if (status.get(i)){
            status.set(i, true);
            notifyItemChanged(i);
            //}
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new ViewHolder(root, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CategoryEntity categoryEntity = list.get(position);

        final ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.tvName.setText(categoryEntity.getName());
        GlideUtils.loadImageCircleTransform(viewHolder.ivIcon, categoryEntity.getImage(), context);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(int position) {
    /*    if (status.get(position)) {
            status.set(position, false);
        } else {
            status.set(position, true);
        }
        notifyItemChanged(position);*/
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.et_cant)
        EditText etCant;
        OnClickListListener assistanceItemListener;

        public ViewHolder(View view, OnClickListListener onClickListListener) {
            super(view);
            ButterKnife.bind(this, view);
            assistanceItemListener = onClickListListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            assistanceItemListener.onClick(getAdapterPosition());
        }
    }
}
