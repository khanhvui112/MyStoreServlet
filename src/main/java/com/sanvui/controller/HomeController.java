package com.sanvui.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: VuiSK
 * @created: 11/11/2021-12:42 AM
 * @mailto: sanvankhanh@gmail.com
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/home.jsp");
        requestDispatcher.forward(req, resp);
    }
}
