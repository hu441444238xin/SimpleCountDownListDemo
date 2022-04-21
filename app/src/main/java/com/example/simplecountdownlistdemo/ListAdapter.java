package com.example.simplecountdownlistdemo;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class ListAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 创建视图
        return new ListCellViewHolder(new ListCellUI(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListCellUI itemView = (ListCellUI) holder.itemView;
        // 数据绑定
        itemView.bind(ListCellCountDownManager.getInstance.getDataSourceItemModelList().get(position));

    }

    @Override
    public int getItemCount() {
        // 获取数据源size
        return ListCellCountDownManager.getInstance.getDataSourceItemModelList().size();
    }


    private static class ListCellViewHolder extends RecyclerView.ViewHolder {

        private ListCellUI listCell;

        ListCellViewHolder(View itemView) {
            super(itemView);
            listCell = (ListCellUI) itemView;
        }
    }
}
