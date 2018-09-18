package spider.television.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import spider.television.pojo.TvSeries;


public interface TvSeriesDao {    
    
    @Select("select * from tv_series")
    public List<TvSeries> getAllTvSeries();

    @Select("select * from tv_series")
    public TvSeries getTheTvSeries();
}