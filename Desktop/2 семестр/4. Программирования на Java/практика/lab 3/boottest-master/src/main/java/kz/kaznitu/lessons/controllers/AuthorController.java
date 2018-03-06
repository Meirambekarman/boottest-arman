package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Author;
import kz.kaznitu.lessons.reposotories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/demo")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository ;

    @GetMapping("/add")
    public @ResponseBody String addAuthor(@RequestParam("firstname") String firstName,
                                          @RequestParam("lastname") String lastName,
                                          @RequestParam("email") String email){
        Author author = new Author(firstName, lastName, email) ;
        authorRepository.save(author) ;
        return "saved" ;
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Author> allAuthors(){
        return authorRepository.findAll() ;
    }

    @GetMapping("/all2")
    public String allAuthors2(Model model){
        List<Author> authors = (List<Author>) authorRepository.findAll() ;
        model.addAttribute("authors", authors) ;
        return "authors" ;
    }
}
