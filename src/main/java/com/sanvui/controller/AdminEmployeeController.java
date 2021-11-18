package com.sanvui.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sanvui.convert.EmployeeConvert;
import com.sanvui.model.dao.Imp.BaseDaoImp;
import com.sanvui.model.dto.EmployeeDTO;
import com.sanvui.model.dto.LoginDTO;
import com.sanvui.model.entities.Employee;


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
 * @created: 14/11/2021-8:33 PM
 * @mailto: sanvankhanh@gmail.com
 */
@WebServlet("/admin-dashboard/admin/all-employee")
public class AdminEmployeeController extends HttpServlet {
    private static final long serialVersionUID =6L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session = req.getSession();

        LoginDTO loginDTO=(LoginDTO) session.getAttribute("loginDTO");

        if(loginDTO.getRole().equalsIgnoreCase("ADMIN"))
        {

//            create objectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());

//            create BaseDaoImp
            BaseDaoImp imp = new BaseDaoImp(Employee.class);

//            List<Employee>
            List<Employee> employees = imp.findAll();

//            convert employees to EmployeeDTO
            List<EmployeeDTO> dtos = employees.stream().map((e) ->
                    EmployeeConvert.getInstance().toDTO(e)).collect(Collectors.toList());

//            Remove all user
            dtos = EmployeeConvert.removeUser(dtos);

//            convert to Json
            String arrayToJson = objectMapper.writeValueAsString(dtos);

            PrintWriter out = resp.getWriter();
            out.println(arrayToJson);
            out.flush();
            out.close();
        }else {
            System.out.println("Get fail!");
        }

    }
}
