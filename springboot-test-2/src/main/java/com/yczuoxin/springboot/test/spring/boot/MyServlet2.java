package com.yczuoxin.springboot.test.spring.boot;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class MyServlet2 extends HttpServlet {

    private String name;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        name = config.getInitParameter("name");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        ServletContext context = req.getServletContext();
        context.log("service doGet");
        writer.write("<html><body>hello,world " + name + " </body></html>");


    }
}
