package com.neo.controller;

import com.neo.model.Employee;
import com.neo.repository.IEmployeeRepository;
import com.neo.service.IEmployeeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
//@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/")
    public ModelAndView getAllEmployees() {
        ModelAndView mav = new ModelAndView("employee");
        List<Employee> employeeList = employeeService.findAll();
        mav.addObject("employees", employeeList);
        return mav;
    }

    @GetMapping("/create")
    public ModelAndView formCreate() {
        Employee employee = new Employee();
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView formEdit(@PathVariable ObjectId id) {
        Employee employee = employeeService.findById(id);
        employee.get_id();
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView formDelete(@PathVariable ObjectId id) {
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createEmployee(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("create");
        } else {
            employeeService.save(employee);
            modelAndView = new ModelAndView("create");
            modelAndView.addObject("message", "create success");
            modelAndView.addObject("employee", employee);
        }
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView updateEmployee(@Validated @PathVariable ObjectId id, @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("edit");
        } else {
            employee.set_id(id);
            employeeService.save(employee);
            modelAndView = new ModelAndView("edit");
            modelAndView.addObject("message", "update succcess");
            modelAndView.addObject("employee", employee);
        }
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable ObjectId id,@ModelAttribute("employee") Employee employee) {

        employeeService.remove(id);
        List<Employee> employeeList = employeeService.findAll();
        return "redirect:/";
    }

}
