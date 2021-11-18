package com.sanvui.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: VuiSK
 * @created: 14/11/2021-7:29 AM
 * @mailto: sanvankhanh@gmail.com
 */
@WebServlet("/Logout")
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID =5L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session = req.getSession();
        session.getAttribute("loginDTO");
        session.removeAttribute("loginDTO");

        HttpSession sessionLogout = req.getSession();
        sessionLogout.getAttribute("error");
        sessionLogout.setAttribute("error","Đăng xuất thành công");
        sessionLogout.setMaxInactiveInterval(3);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
        requestDispatcher.forward(req, resp);
    }
}
