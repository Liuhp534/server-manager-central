package cn.liuhp.base.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 自定义拦截器
 * @author: liuhp534
 * @create: 2020-03-02 10:50
 */
public class CustomInterceptor2 implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("CustomInterceptor2.preHandle, contextPath=" + httpServletRequest.getContextPath());
        //httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/param.jsp");//需要/不然会加上controller路径的
        //httpServletRequest.getRequestDispatcher("/WEB-INF/param.jsp").forward(httpServletRequest, httpServletResponse);//"/"路径不能丢
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("CustomInterceptor2.postHandle");
        //httpServletRequest.getRequestDispatcher("/WEB-INF/param.jsp").forward(httpServletRequest, httpServletResponse);//"/"路径不能丢
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("CustomInterceptor2.afterCompletion");
    }
}
