package cn.liuhp.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionUtils {


    /*
    * 去除session
    * */
    public static void removeSession(HttpServletRequest request, HttpServletResponse response) {
        String temp = request.getHeader("cookie");
        Cookie ncookie = new Cookie("title","xxxxx");
        ncookie.setMaxAge(365 * 24 * 60 * 60);
        response.addCookie(ncookie);
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                cookie.setDomain("localhost");
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
    }

    /*
    * 判断ajax请求
    * */
    public static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
    }


}
