package it.wirge.rest.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by enrico on 19/11/15.
 */

@ApiModel(value = "Beat")
public class Beat {

    @ApiModelProperty(required=true, dataType="long")
    private Long currentTime;

    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }
}
