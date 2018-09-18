package spider.television.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spider.television.dao.TvSeriesDao;
import spider.television.pojo.TvSeries;

@Service
public class TvSeriesService{

    @Autowired TvSeriesDao tvSeriesDao;

    public List<TvSeries> getAllTvSeries() {
        return tvSeriesDao.getAllTvSeries();
    }

    public TvSeries getTheTvSeries() {
        return tvSeriesDao.getTheTvSeries();
    }
}