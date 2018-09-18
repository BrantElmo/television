package spider.television.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.Data;

@Data
public class TvCharacter {
    @Null private Integer id;
    @Null private Integer tvSeriesId;
    @NotNull String name;
}