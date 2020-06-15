package com.example.springboot.servlet;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements javax.servlet.Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        System.out.println("myfilter process...");
//        chain.doFilter(request,response);
    }

    @Override
    public void destroy()
    {

    }
}
