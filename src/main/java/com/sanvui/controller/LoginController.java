package com.sanvui.controller;

import com.sanvui.model.dao.Imp.LoginDTODaoDaoImp;
import com.sanvui.model.dto.LoginDTO;


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
 * @created: 11/11/2021-1:29 AM
 * @mailto: sanvankhanh@gmail.com
 */

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID =2L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        session.setAttribute("loginDTO",session.getAttribute("loginDTO"));
        if(session.getAttribute("loginDTO") == null){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
            requestDispatcher.forward(req, resp);
        }else {
            resp.sendRedirect("./");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        LoginDTODaoDaoImp loginDTODaoDaoImp = new LoginDTODaoDaoImp();
        LoginDTO loginDTO = loginDTODaoDaoImp.getLoginDto(username);
        HttpSession session = req.getSession();
        if (loginDTO.getUserName() != null && loginDTO.getPassword().equals(password)) {

            session.setAttribute("loginDTO",loginDTO);

//            set time save attribute 24h
            session.setMaxInactiveInterval(60*60*24);
            if (loginDTO.getRole().equalsIgnoreCase("ADMIN")
                    || loginDTO.getRole().equalsIgnoreCase("MANAGER")){
                resp.sendRedirect("/Home/admin-dashboard");
            }else {
                resp.sendRedirect("./");
            }

        }else {
            req.setAttribute("error", "Tên tài khoản hoặc mật khẩu không chính xác.");
            session.setMaxInactiveInterval(5);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
}
