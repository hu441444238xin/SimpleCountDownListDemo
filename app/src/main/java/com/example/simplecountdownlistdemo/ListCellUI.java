package com.example.simplecountdownlistdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 列表的单个Cell   是观察者
 */
public class ListCellUI extends RelativeLayout implements Observer {

    @BindView(R.id.last_time_textView)
    TextView lastTimeTextView;
    @BindView(R.id.title_textView)
    TextView titleTextView;

    private ListCellModel itemModel;

    public ListCellUI(Context context) {
        super(context);
        initViews(context);
    }


    private void initViews(Context context) {
        LayoutInflater.from(context).inflate(R.layout.count_down_list_cell, this);
        ButterKnife.bind(this);
    }

    // 观察者 （视图） 收到被观察 （数据源） 的变化开始更新 视图
    @Override
    public void update(Observable o, Object arg) {

        ListCellModel itemModel = (ListCellModel) arg;
        lastTimeTextView.setText("倒计时还剩:" + itemModel.getLastTime() + "");


    }


    public void bind(ListCellModel itemModel) {
        this.itemModel = itemModel;

        lastTimeTextView.setText("倒计时还剩:" + itemModel.getLastTime() + "");
        titleTextView.setText(itemModel.getTitle());

        // 像被观察者注册观察者
        itemModel.addObserver(this);
    }


    public void unbind() {
        // 当cell 释放的时候记得移除
        if (itemModel != null) {
            itemModel.deleteObserver(this);
        }
    }
}
