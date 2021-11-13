package com.sanvui.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sanvui.dto.MessageValidator;
import com.sanvui.entities.Employee;
import com.sanvui.services.EmployeeServices;
import com.sanvui.utils.GetMessageUtils;
import org.apache.commons.codec.binary.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

/**
 * @author: VuiSK
 * @created: 12/11/2021-2:07 AM
 * @mailto: sanvankhanh@gmail.com
 */

@WebServlet("/signup")
public class RegistrationController extends HttpServlet {

    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("insertFail",session.getAttribute("insertFail"));
        RequestDispatcher  requestDispatcher = req.getRequestDispatcher("/views/registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = null;
        String lastName = null;
        String userName = null;
        String phone = null;
        String email = null;
        String address = null;
        String password = null;
        String repassword =null;
        LocalDate date = null;
        String gender = null;
        try {
            //        get parameter
            firstName = req.getParameter("fname");
            lastName = req.getParameter("lname");
            userName = req.getParameter("username");
            if(userName.equals("")){
                userName = null;
            }
            phone = req.getParameter("phone");
            if(phone.equals("")){
                phone = null;
            }

            email = req.getParameter("email");
            if(email.equals("")){
                email = null;
            }

            address = req.getParameter("address");
            password = req.getParameter("password");
            if(password.equals("")){
                password = null;
            }
            repassword = req.getParameter("repassword");
            gender = req.getParameter("gender");
            date = toLocalDate(req.getParameter("dateOfBirth"));
            if(date.equals("")){
                date = null;
            }

        }catch(Exception e) {
        }


        //            set Employee
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUserName(userName);
        employee.setPassword(password);
        employee.setAddress(address);
        employee.setPhone(phone);
        employee.setGender(gender);
        employee.setDateOfBirth(date);
        employee.setEmail(email);

        /*
         * check validation
         * if validator != null
         * assign check  = false
         * */

        MessageValidator validator = EmployeeServices.getMessage(employee);
        boolean check = true;

        if (validator != null ){
            check = false;
        }


        /*
         * check repassword vs password
         * if different assign check = false
         * set RePassword
         * */
        if(password!= null && !password.equals(repassword)){
            check = false;
            validator = new MessageValidator();
            validator.setRePassword(getMessage("repassword.equal"));
        }

        Gson gson = new Gson();

//        Check duplication in database
        if(validator == null){

//            check userName
            validator = new MessageValidator();
            boolean checkUser = EmployeeServices.findEmployeeByName(userName);
            boolean checkPhone = EmployeeServices.findEmployeePhone(phone);
            boolean checkMail = EmployeeServices.findEmployeeEmail(email);
            if(checkUser){
                check = false;
                validator.setUserName(getMessage("username.duplicate"));
            }

//            check Phone
            if(checkPhone){
                check = false;
                validator.setPhone(getMessage("phone.duplicate"));
            }
//            check mail
            if(checkMail){
                check = false;
                validator.setEmail(getMessage("email.duplicate"));
            }
        }

//        if check == true
        if(check) {

            /*
            * Insert to database
            * if success return true
            * else
            * return false
            * */

            check = EmployeeServices.insertUser(employee);
        }

        /*
        * check == true
        * set status true
        * responsive to page login
        * */
        if(check){
            validator.setStatus("true");
            PrintWriter out = resp.getWriter();
            out.println(gson.toJson(validator));
            out.flush();
            out.close();
        }

        /*
         * check == false
         * set status false
         * request to page signup
         * */
        if(!check){
            PrintWriter out = resp.getWriter();
            validator.setStatus("false");
            resp.setCharacterEncoding("UTF-8");
            out.println(gson.toJson(validator));
            out.flush();
            out.close();
        }


    }
    /*
    * Convert String to utf-8
    * return String
    * */
    private static  String toEncode(String s){
        byte[] bytes = StringUtils.getBytesUtf8(s);
        String newStringUtf8 =  StringUtils.newStringUtf8(bytes);
        return newStringUtf8;
    }
    private static LocalDate toLocalDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
        return LocalDate.parse(date, formatter);
    }
    private String getMessage(String keyValue) {

        Properties properties = new Properties();
        InputStream inputStream = null;

        String value = null;


        try {
            String part = getServletContext().getRealPath("/WEB-INF/resources/message.properties");

            inputStream = new FileInputStream(part);

//            load properties from file
            properties.load(inputStream);

//            get properties by name
            value = properties.getProperty(keyValue);

        }catch (IOException e) {
            return null;
        } finally {
            // close objects
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return value;
    }
}
