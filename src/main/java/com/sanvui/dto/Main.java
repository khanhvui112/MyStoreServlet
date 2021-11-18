package com.sanvui.dto;

import com.sanvui.model.dao.Imp.EmployeeDaoImp;
import com.sanvui.model.entities.Department;
import com.sanvui.model.entities.Employee;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: VuiSK
 * @created: 07/11/2021-11:22 AM
 * @mailto: sanvankhanh@gmail.com
 */

public class Main {
    public static void main(String[] args) throws IOException, InvalidFormatException {
//        String file = "D:\\SQL&Data\\Excel\\Employee.xlsx";
//        List<Employee> objectList;
//        objectList = ReadFileExcel.readFile(file);
//        System.out.println(objectList);
        EmployeeDaoImp employeeDaoImp = new EmployeeDaoImp();
        employeeDaoImp.salaryDtoList();
    }

    private static List<Employee> getEmployeeList() {
        List<Employee> objectList = new ArrayList<>();
        Employee object;
        for (int i = 0; i < 1000; i++) {
            object = new Employee();
            Department department = new Department();
            object.setEmpId(i);
            object.setLastName("San "+i);
            department.setDepName("Ke toan");
            object.setDepartment(department);
            objectList.add(object);
        }
        return objectList;
    }
}
