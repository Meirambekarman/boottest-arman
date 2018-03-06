package kz.kaznitu.lessons.boottestarman.controllers;

import kz.kaznitu.lessons.boottestarman.models.Department;
import kz.kaznitu.lessons.boottestarman.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

import java.util.List;

@Controller
@RequestMapping(path = "/dept")

public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("department", new Department());
        return "department_add_form";
    }

    @PostMapping("/add")
    public String addDepartment(@ModelAttribute Department department) {
        departmentRepository.save(department);
        return "redirect:/demo/sll2";
    }

    @GetMapping("/sll")
    public @ResponseBody
    Iterable<Department> allDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping("/sll2")
    public String allDepartments2(Model model) {
        List<Department> departments = (List<Department>) departmentRepository.findAll();
        model.addAttribute("departments", departments);
        return "departments";
    }

    @RequestMapping(value = "/deleteDepartment", method = RequestMethod.GET)
    public ModelAndView deleteDepartment(@RequestParam("id") long idd) {
        departmentRepository.deleteById(idd);
        return new ModelAndView("redirect:/demo/sll2");
    }
    @PostMapping("/editDepartment")
    public String editDepartment(@ModelAttribute Department department) {
        Department department1 = new Department();
        department1.setId(a);
        department1.setDepartmentName(department.getDepartmentName());
        department1.setCity(department.getCity());
        departmentRepository.save(department1);
        return "redirect:/demo/sll2";
    }

    @RequestMapping(value = "/editDepartment",method = RequestMethod.GET)
    public ModelAndView editDepartment(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Department> department = (Optional <Department>) departmentRepository.findById(id);
        model.addAttribute("department",department);
        return new ModelAndView("inp");
    }
    @RequestMapping("/editDepartment")
    public String showForm2(Model model){
        model.addAttribute("department",new Department());
        return "inp";
    }
}

