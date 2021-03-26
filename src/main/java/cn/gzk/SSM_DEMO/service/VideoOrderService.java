package cn.gzk.SSM_DEMO.service;/*
 *ClassName:VideoOrderService
 *Description:
 *Author: GZK0329
 *Date: 2021/3/26
 */

import org.springframework.stereotype.Service;

@Service
public interface VideoOrderService {

    int saveOrder(Integer userId, Integer videoId);
}
