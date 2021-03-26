package cn.gzk.SSM_DEMO.controller;

import cn.gzk.SSM_DEMO.model.entity.VideoOrder;
import cn.gzk.SSM_DEMO.model.request.OrderRequest;
import cn.gzk.SSM_DEMO.service.VideoOrderService;
import cn.gzk.SSM_DEMO.service.VideoService;
import cn.gzk.SSM_DEMO.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/*
 *ClassName:VideoOrderController
 *Description:
 *Author: GZK0329
 *Date: 2021/3/26
 */
@RestController
@RequestMapping("api/v1/pri/order")
public class VideoOrderController {
    @Autowired
    private VideoOrderService videoOrderService;

    @RequestMapping("save")
    public JsonData saveOrder(@RequestBody OrderRequest videoOrderRequest, HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("id");
        //System.out.println("userId ="+ userId);
        int rows = videoOrderService.saveOrder(userId, videoOrderRequest.getVideoId());
        return rows == 0 ? JsonData.buildError("失败") : JsonData.buildSuccess("下单成功");
    }
}
