package com.job.practice.bits.controllers;

import com.job.practice.bits.dao.EmployeeDAO;
import com.job.practice.bits.db.models.Employee;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ashif
 */
@Controller
public class IndexController {

    @Autowired
    EmployeeDAO employeeDAO;

    @RequestMapping(value = "/index")
    public String showIndex(ModelMap model) {

        List<Employee> employees = new ArrayList<>();

        employees = employeeDAO.get();

        model.addAttribute("employees", employees);

        return "index";
    }

    /**
     * Method to insert new user
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertUser(@ModelAttribute("employee") Employee employee, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {

            List<ObjectError> error = result.getAllErrors();

            for (ObjectError err : error) {

                System.out.println(err.toString());
            }
            return "";
        }

        if (employee.getName() != null && !employee.getName().isEmpty()
                && employee.getPin() != null && !employee.getPin().isEmpty()
                && employee.getMotherName() != null && !employee.getMotherName().isEmpty()) {

            int value = employeeDAO.insert(employee);

            if (value == 1) {

                List<Employee> employees = new ArrayList<>();

                employees = employeeDAO.get();

                model.addAttribute("employees", employees);

                return "index";
            }
        }

        return "";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateEmployee(@RequestParam("type") String type,
            @ModelAttribute("employee") Employee employee,
            BindingResult result, ModelMap model) {

        if (result.hasErrors()) {

            return "";
        }

        if (type.equals("delete")) {

            employeeDAO.delete(employee.getId());
        } else if (type.equals("update")) {

            employeeDAO.update(employee);
        }

        List<Employee> employees = new ArrayList<>();

        employees = employeeDAO.get();

        model.addAttribute("employees", employees);
        return "index";
    }

}
