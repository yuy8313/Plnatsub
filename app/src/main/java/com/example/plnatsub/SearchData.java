package com.example.plnatsub;

import android.widget.ImageView;

public class SearchData {
    private String thumbnail;
    private String title;
    private int percent;

    public SearchData(String thumbnail, String title, int percent) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.percent = percent;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }


    @Override
    public String toString() {
        return "SearchData{" +
                "thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", percent=" + percent +
                '}';
    }


}
