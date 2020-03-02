package cn.liuhp.base.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-03-02 09:56
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {



    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        //如果是异步的请求，直接response返回

        //非一异步的请求
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof CustomBusinessException) {
            CustomBusinessException customBusinessException = (CustomBusinessException) e;
            modelAndView.addObject("msg", customBusinessException.getMessage());
            modelAndView.setViewName("common/500");
        } else {
            modelAndView.addObject("msg", e.getMessage());
            modelAndView.setViewName("common/400");
        }
        return modelAndView;
    }
}
