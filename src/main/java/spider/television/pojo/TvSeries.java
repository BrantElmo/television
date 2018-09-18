package spider.television.pojo;

import java.sql.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
// import lombok.ToString;

// @ToString
@Data
@AllArgsConstructor
public class TvSeries {
    @Null private Integer id;
    @NotNull String name;
    @DecimalMin("1") Integer seasonCount;
    @JsonFormat(timezone="GTM+8", pattern="yyyy-MM-dd") @Past Date originRelease;
    // @NotNull @Size(min=1) private List< @NotNull @Valid TvCharacter> tvCharacters;
}