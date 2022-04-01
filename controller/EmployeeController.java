package controller;

import dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pojo.Employee;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @GetMapping("/employee")
    public String insert(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("all",all);


        return "employee_list";
    }
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeDao.delete(id);
        return"redirect:/employee";
    }
    @PutMapping("/employee")
    public String addEmpl(Employee employee){
        employeeDao.save(employee);

        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}")
    public String getEmployeeById(@PathVariable("id") Integer id , Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);

        return "employee_upadate";
    }
    @PutMapping("/employee")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

}
