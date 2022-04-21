package com.example.simplecountdownlistdemo;

import java.util.Observable;

/**
 * 单个cell 数据模型 是被观察者
 */
public class ListCellModel extends Observable {

    public ListCellModel(String title, long lastTime) {
        this.title = title;
        this.lastTime = lastTime;
    }

    /**
     * 列表标题
     */
    private String title;

    public String getTitle() {
        return title;
    }

    /**
     * 列表倒计时声音时间
     */
    private long lastTime;

    public long getLastTime() {
        return lastTime;
    }

    /**
     * 当倒计时时间改变需要通知，观察者，我有变更了。
     *
     * @param lastTime
     */
    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
        setChanged();
    }

    @Override
    public String toString() {
        return "DataSourceItemModel{" +
                "title='" + title + '\'' +
                ", lastTime=" + lastTime +
                '}';
    }
}
