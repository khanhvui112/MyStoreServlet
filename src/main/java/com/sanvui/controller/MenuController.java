package com.sanvui.controller;

import com.sanvui.convert.MenuConvert;
import com.sanvui.model.dto.LoginDTO;
import com.sanvui.model.dto.MenuDTO;
import com.sanvui.model.entities.Menu;
import com.sanvui.services.MenuServices;
import com.sanvui.utils.ConvertToJsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: VuiSK
 * @created: 16/11/2021-1:57 PM
 * @mailto: sanvankhanh@gmail.com
 */
@WebServlet("/menu")
public class MenuController extends HttpServlet {
    private static final long serialVersionUID = 7L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session = req.getSession();

//        get List Menu from database
        List<Menu> menus = MenuServices.findAll();

        LoginDTO dto =(LoginDTO) session.getAttribute("loginDTO");

//        Declare convert
        ConvertToJsonUtils converts = new ConvertToJsonUtils(Menu.class);
        //            convert Menus to MenuDTO
        List<MenuDTO> dtos = menus.stream().map((e) ->
                MenuConvert.getInstance().toDTO(e)).collect(Collectors.toList());

        dtos = MenuConvert.removeByStatus(dtos, 0);
        String jsons = converts.convertToJson(dtos);

        PrintWriter out = resp.getWriter();
        out.println(jsons);
        out.flush();
        out.close();
    }
}
