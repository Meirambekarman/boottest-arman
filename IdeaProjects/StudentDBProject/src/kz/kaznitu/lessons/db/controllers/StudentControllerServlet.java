package kz.kaznitu.lessons.db.controllers;


import kz.kaznitu.lessons.db.dao.StudendDbUtils;
import kz.kaznitu.lessons.db.models.Student;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentControllerServlet extends HttpServlet{
    private DataSource dataSource ;
    private StudendDbUtils studendDbUtils ;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            InitialContext initialContext = new InitialContext() ;
            dataSource = (DataSource)initialContext.lookup("java:comp/env/jdbc/stud1") ;
            studendDbUtils = new StudendDbUtils(dataSource) ;
        } catch (Exception e) {
            throw new ServletException() ;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        String command = req.getParameter("command") ;
        if (command == null)
            command = "list" ;

        switch (command){
            case "list":
                listStudents(req, resp);
                break ;

            case "add":
                addStudent(req, resp) ;
                break ;

            case "del":
                deleteStudent(req, resp) ;
                break ;
            case "load":
                loadStudent(req, resp) ;
                break ;
            case "update":
                updateStudent(req, resp) ;
                break ;
            default:
                listStudents(req, resp);
        }


    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) {
        String studentId = req.getParameter("studentId") ;
        int id = Integer.parseInt(studentId) ;

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");

        Student student = new Student(id, firstName, lastName, email) ;

        try {
            studendDbUtils.update(student) ;
            resp.sendRedirect("/students");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void loadStudent(HttpServletRequest req, HttpServletResponse resp) {
        String studentId = req.getParameter("studentId") ;

        try {
            Student student = studendDbUtils.loadStudent(studentId) ;
            req.setAttribute("the_student", student);
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/update-student-form.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) {
        String studentId = req.getParameter("studentId") ;
        try {
            studendDbUtils.deleteStudent(studentId) ;
            resp.sendRedirect("/students");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addStudent(HttpServletRequest req, HttpServletResponse resp) {
        String firstName = req.getParameter("firstName") ;
        String lastName = req.getParameter("lastName") ;
        String email = req.getParameter("email") ;

        Student student = new Student(firstName, lastName, email) ;

        try {
            studendDbUtils.addStudent(student) ;
//            listStudents(req, resp);
            resp.sendRedirect("/students");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Student> studentList = studendDbUtils.getStudents() ;
            request.setAttribute("list_students",studentList );
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list-students.jsp") ;
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
