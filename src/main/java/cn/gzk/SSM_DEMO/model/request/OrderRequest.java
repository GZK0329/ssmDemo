package cn.gzk.SSM_DEMO.model.request;/*
 *ClassName:OrderRequest
 *Description:
 *Author: GZK0329
 *Date: 2021/3/26
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderRequest {

    @JsonProperty("video_id")
    private Integer videoId;

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }
}
