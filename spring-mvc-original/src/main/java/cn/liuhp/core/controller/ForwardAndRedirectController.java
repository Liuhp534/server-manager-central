package cn.liuhp.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-03-01 16:50
 */
@Controller
@RequestMapping("/foAndRe")
public class ForwardAndRedirectController {

    @RequestMapping("helloVoid")
    public void helloVoid(HttpServletRequest request, HttpServletResponse response) {
        try {
            //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);//"/"路径不能丢
           /* System.out.println(request.getContextPath());
            response.sendRedirect(request.getContextPath() + "/param.jsp");*/

            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            StringBuilder sb = new StringBuilder();
            sb.append("<html>");
            sb.append("<head><title>直接返回</title></head>");
            sb.append("<body><h1>直接返回</h1></body>");
            sb.append("</html>");
            response.getWriter().print(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("helloForward")
    public String helloForward(HttpServletRequest request, HttpServletResponse response) {

        return "forward:/hello/sayHello?sayHello=jeff";
    }


    @RequestMapping("helloRedirect")
    public String helloRedirect(HttpServletRequest request, HttpServletResponse response) {

        return "redirect:/hello/sayHello?sayHello=jeff";
    }

}
