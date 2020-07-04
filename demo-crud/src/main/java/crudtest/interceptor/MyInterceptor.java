package crudtest.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//自定义拦截器，登陆检查
public class MyInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        Object username = request.getSession().getAttribute("username");
        if (username==null)
        {
            //未登陆，拦截
            request.setAttribute("msg","您未登陆，请先登陆");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        else
        {
            return true;
        }
    }
}
