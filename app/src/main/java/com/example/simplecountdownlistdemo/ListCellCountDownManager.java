package com.example.simplecountdownlistdemo;

import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 管理类
 * 包含数据源的构建。
 * 倒计时功能的开启和停止
 */
public enum ListCellCountDownManager {
    getInstance();

    /**
     * 数据源
     */
    private List<ListCellModel> dataSourceItemModelList = new ArrayList<>();
    private Random random = new Random();
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(runnable, 1 * 1000);

            for (ListCellModel dataSourceItemModel : dataSourceItemModelList) {
                // 当倒计时大于0
                if (dataSourceItemModel.getLastTime() > 0) {
                    // 倒计时数据-1
                    dataSourceItemModel.setLastTime(dataSourceItemModel.getLastTime() - 1);
                    // 通知观察者改变了
                    dataSourceItemModel.notifyObservers(dataSourceItemModel);
                } else {

                }
            }
        }
    };


    /**
     * 初始化数据源，可以理解为模拟网络请求完成的数据也可以
     */
    public void init() {
        for (int i = 0; i < 5; i++) {
            ListCellModel dataSourceItemModel = new ListCellModel("第" + i + "个Cell", random.nextInt(1000));
            dataSourceItemModelList.add(dataSourceItemModel);
        }
    }

    /**
     * 获取数据源
     *
     * @return
     */
    public List<ListCellModel> getDataSourceItemModelList() {
        if (dataSourceItemModelList == null) {
            dataSourceItemModelList = new ArrayList<>();
        }
        return dataSourceItemModelList;
    }

    /**
     * 开始倒计时
     */
    public void starCountDown() {
        handler.postDelayed(runnable, 1 * 1000);
    }

    /**
     * 结束倒计时，释放此模块
     */
    public void stopCountDown() {
        handler.removeCallbacksAndMessages(null);
        runnable = null;
    }
}
