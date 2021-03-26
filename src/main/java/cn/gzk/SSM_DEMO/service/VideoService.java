package cn.gzk.SSM_DEMO.service;

import cn.gzk.SSM_DEMO.model.entity.Video;
import cn.gzk.SSM_DEMO.model.entity.VideoBanner;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface VideoService {
    List<Video> listVideo();

    List<VideoBanner> listVideoBanner();

    Video findDetailById(int videoId);
}
