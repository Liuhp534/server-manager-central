package cn.liuhp.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionUtils {


    /*
    * 去除session
    * */
    public static void removeSession(HttpServletRequest request, HttpServletResponse response) {
        /*String temp = request.getHeader("cookie");
        Cookie ncookie = new Cookie("title","xxxxx");
        ncookie.setMaxAge(365 * 24 * 60 * 60);
        response.addCookie(ncookie);*/
        //清除cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                //cookie.setDomain("liuhp.hzins.com");
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        //清除session
        HttpSession session = request.getSession();
        session.invalidate();
    }

    /*
    * 判断ajax请求
    * */
    public static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
    }


}
