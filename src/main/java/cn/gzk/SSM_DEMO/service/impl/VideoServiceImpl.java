package cn.gzk.SSM_DEMO.service.impl;/*
 *ClassName:VideoServiceImpl
 *Description:
 *Author: GZK0329
 *Date: 2021/3/23
 */

import cn.gzk.SSM_DEMO.model.entity.Video;
import cn.gzk.SSM_DEMO.model.entity.VideoBanner;
import cn.gzk.SSM_DEMO.mapper.VideoMapper;
import cn.gzk.SSM_DEMO.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> listVideo() {

        return videoMapper.listVideo();
    }

    @Override
    public List<VideoBanner> listVideoBanner() {
        return videoMapper.listVideoBanner();
    }

    @Override
    public Video findDetailById(int videoId) {
        return videoMapper.findDetailById(videoId);
    }
}
