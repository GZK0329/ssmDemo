package cn.gzk.SSM_DEMO.exception;/*
 *ClassName:MyExceptionHandler
 *Description:
 *Author: GZK0329
 *Date: 2021/3/23
 */

import cn.gzk.SSM_DEMO.utils.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*
* 异常处理类
*/
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handler(Exception e){
        if(e instanceof MyException){
           MyException myException =  (MyException) e;
           return  JsonData.buildError(myException.getCode(),myException.getMsg());
        }else{
            return JsonData.buildError("全局异常，未知错误！");
        }
    }
}
