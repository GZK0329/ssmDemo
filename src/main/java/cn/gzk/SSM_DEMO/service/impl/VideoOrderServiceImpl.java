package cn.gzk.SSM_DEMO.service.impl;/*
 *ClassName:VideoOrderServiceImpl
 *Description:
 *Author: GZK0329
 *Date: 2021/3/26
 */

import cn.gzk.SSM_DEMO.mapper.VideoMapper;
import cn.gzk.SSM_DEMO.mapper.VideoOrderMapper;
import cn.gzk.SSM_DEMO.model.entity.Video;
import cn.gzk.SSM_DEMO.model.entity.VideoOrder;
import cn.gzk.SSM_DEMO.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private VideoMapper videoMapper;


    @Override
    public int saveOrder(Integer userId, Integer videoId) {

        //判断是否已经购买
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId, videoId, 1);
        //如果已经存在 不为空 则返回0无法再生成订单
        if(videoOrder != null) return 0;


        Video video = videoMapper.findById(videoId);

        VideoOrder newVideoOrder = new VideoOrder();
        //设置创建时间
        newVideoOrder.setCreateTime(new Date());
        //订单编号 随机生成
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        newVideoOrder.setState(1);
        //设置这个订单的花费
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());


        int rows = videoOrderMapper.saveOrder(newVideoOrder);

        if(row == 1){

        }
        return rows;
    }
}
