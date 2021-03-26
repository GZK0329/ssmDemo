package cn.gzk.SSM_DEMO.controller;/*
 *ClassName:VideoController
 *Description:
 *Author: GZK0329
 *Date: 2021/3/23
 */

import cn.gzk.SSM_DEMO.model.entity.Video;
import cn.gzk.SSM_DEMO.model.entity.VideoBanner;
import cn.gzk.SSM_DEMO.service.VideoService;
import cn.gzk.SSM_DEMO.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;


    @GetMapping("list_videoBanner")
    public JsonData listVideoBanner(){
        try{
            List<VideoBanner> result = videoService.listVideoBanner();
            return JsonData.buildSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return JsonData.buildError("查询出错了");
        }
    }

    @GetMapping("list")
    public JsonData listVideo(){
        try{
            List<Video> result = videoService.listVideo();
            //int i = 1/0;
            return JsonData.buildSuccess(result);
        }catch (Exception e){
            e.printStackTrace();
            return JsonData.buildError("查询失败");
        }
    }

    //@RequestParam(value = "video_id",required = true)
    //value 为参数名称 required=true表示必需要
    @GetMapping("find_detail_by_id")
    public JsonData findDetailById(@RequestParam(value = "video_id",required = true)int videoId){
        try{
            Video video = videoService.findDetailById(videoId);
            return  JsonData.buildSuccess(video);
        }catch (Exception e){
            e.printStackTrace();
            return JsonData.buildError("查询失败");
        }

    }
}
