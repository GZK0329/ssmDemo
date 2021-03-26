package cn.gzk.SSM_DEMO.mapper;

import cn.gzk.SSM_DEMO.model.entity.Episode;
import org.apache.ibatis.annotations.Param;

public interface EpisodeMapper {

    Episode findFirstEpisodeByVideoId(@Param("video_id") Integer videoId);

}
