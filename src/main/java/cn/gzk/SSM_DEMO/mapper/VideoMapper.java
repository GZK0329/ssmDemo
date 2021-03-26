package cn.gzk.SSM_DEMO.mapper;

import cn.gzk.SSM_DEMO.model.entity.Video;
import cn.gzk.SSM_DEMO.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface VideoMapper {

    //查询所有video
    List<Video> listVideo();

    //查询视频轮播图
    List<VideoBanner> listVideoBanner();

    //按id查找视频详情
    Video findDetailById(@Param(value = "video_id") int videoId);
}
