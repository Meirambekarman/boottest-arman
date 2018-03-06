package kz.kaznitu.lessons.boottestarman.controllers;
import kz.kaznitu.lessons.boottestarman.repositories.EmployeeRepository;
import kz.kaznitu.lessons.boottestarman.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

import java.util.List;

@Controller
@RequestMapping(path = "/demo")



public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee_add_form";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/demo/all2";
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Employee> allEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/all2")
    public String allEmployees2(Model model) {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(@RequestParam("id") long idd) {
        employeeRepository.deleteById(idd);
        return new ModelAndView("redirect:/demo/all2");
    }
    @PostMapping("/editEmployee")
    public String editEmployee(@ModelAttribute Employee employee) {
        Employee employee1 = new Employee();
        employee1.setId(a);
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        employee1.setPhoneNumber(employee.getPhoneNumber());
        employee1.setAddress(employee.getAddress());
        employeeRepository.save(employee1);
        return "redirect:/demo/all2";
    }

    @RequestMapping(value = "/editEmployee",method = RequestMethod.GET)
    public ModelAndView editEmployee(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Employee> employee = (Optional <Employee>) employeeRepository.findById(id);
        model.addAttribute("employee",employee);
        return new ModelAndView("smp");
    }
    @RequestMapping("/editEmployee")
    public String showForm2(Model model){
        model.addAttribute("employee",new Employee());
        return "smp";
    }
}
