package com.stats.controller.trending;

import com.stats.trending.model.Trending;

import java.util.List;

public class TrendingMasterObject {

    private List<Trending> trendingList;

    public List<Trending> getTrendingList() {
        return trendingList;
    }

    public void setTrendingList(List<Trending> trendingList) {
        this.trendingList = trendingList;
    }
}
