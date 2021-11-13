package com.sanvui.controller;

import com.sanvui.dto.LoginDTO;

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
 * @created: 11/11/2021-8:49 PM
 * @mailto: sanvankhanh@gmail.com
 */

@WebServlet("/admin-dashboard")
public class AdminController extends HttpServlet {
    private static final long serialVersionUID = 3L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        LoginDTO loginDTO=(LoginDTO) session.getAttribute("loginDTO");
        if(loginDTO != null && loginDTO.getRole().equalsIgnoreCase("ADMIN")){
            RequestDispatcher  requestDispatcher = req.getRequestDispatcher("/views/admin/dashboard.jsp");
            requestDispatcher.forward(req, resp);
        }else{
            resp.sendRedirect("/Home/login");
        }

    }
}
