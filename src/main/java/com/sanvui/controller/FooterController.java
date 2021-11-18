package com.sanvui.controller;

import com.sanvui.convert.FooterConvert;
import com.sanvui.model.entities.Footer;
import com.sanvui.model.entities.Menu;
import com.sanvui.services.FooterService;
import com.sanvui.utils.ConvertToJsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: VuiSK
 * @created: 17/11/2021-2:26 PM
 * @mailto: sanvankhanh@gmail.com
 */
@WebServlet("/footer")
public class FooterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        List<Footer> footers = FooterService.findAll();
        //            convert footers to Footer
        List<Footer> dtos = footers.stream().map((e) ->
                FooterConvert.getInstance().toDTO(e)).collect(Collectors.toList());

        //        Declare convert
        ConvertToJsonUtils converts = new ConvertToJsonUtils(Menu.class);

//        remove status false
        dtos = FooterConvert.removeByStatus(dtos, 0);

//        convert to Json
        String jsons = converts.convertToJson(dtos);
        PrintWriter out = resp.getWriter();
        out.println(jsons);
        out.flush();
        out.close();
    }
}
