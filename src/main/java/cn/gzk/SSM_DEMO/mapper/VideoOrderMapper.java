package cn.gzk.SSM_DEMO.mapper;/*
 *ClassName:VideoOrderMapper
 *Description:
 *Author: GZK0329
 *Date: 2021/3/26
 */

import cn.gzk.SSM_DEMO.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface VideoOrderMapper {

    VideoOrder findByUserIdAndVideoIdAndState(@Param("user_id") Integer userId, @Param("video_id") Integer videoId, @Param("state") Integer state);


    int saveOrder(VideoOrder videoOrder);
}

