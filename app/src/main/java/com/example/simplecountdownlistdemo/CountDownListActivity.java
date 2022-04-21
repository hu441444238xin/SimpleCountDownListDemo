package com.example.simplecountdownlistdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 实现列表每个Cell倒计时
 */
public class CountDownListActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_list);
        ButterKnife.bind(this);
        // 初始化数据源,可以理解为网络请求数据源
        ListCellCountDownManager.getInstance.init();

        listAdapter = new ListAdapter();

        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        listAdapter.notifyDataSetChanged();

        // 数据源请求成功后，开始倒计时
        ListCellCountDownManager.getInstance.starCountDown();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 当页面销毁的时候记得释放倒计时
        ListCellCountDownManager.getInstance.stopCountDown();
    }
}
