[TOC]
### JavaWeb

- http协议
    - GET,POST,PUT,DELETE方法
    - request:GET、POST
    - 报文结构：请求行、请求头、请求体(requestLine,header,body)，响应行、响应头、响应体
    - HttpClient库

- Servlet
    - 是Java中的一个interface
    - 是一个Java小程序，用于处理client、server之间的通信

- 生命周期
    - constructor,init,service,destroy

- ServletConfig类
- 继承HttpServlet类,实现其doGet,doPost等方法
- 相对、绝对路径
    - . 表示当前目录
    - .. 表示上一级目录(../../index.html)
    - / 表示绝对路径
        - 被浏览器解析：/==http://ip:port/
        - 被服务器解析：/==http://ip:port/工程路径
- HttpServletRequest、HttpServletResponse
- 两个输出流
    - getOutputStream(),字节流,常用于下载
    - getWriter(),字符流，常用于回传字符串

```java
resp.setContentType("text/html;charset=utf-8");//同时设置服务器、浏览器字符集utf-8
//resp.setCharacterEncoding("utf-8");//设置服务器字符集utf-8
//resp.setHeader("Content-Type","text/html;charset=utf-8");//浏览器也是utf-8
PrintWriter pw=resp.getWriter();
pw.write("haha"); //回传"haha"给浏览器
```
- 重定向 resp.sendRedirect("url");
- Filter 用于拦截请求：权限检查、日记操作、事务管理...
    - 实现Filter并重写其方法，主要操作写在doFilter()内
