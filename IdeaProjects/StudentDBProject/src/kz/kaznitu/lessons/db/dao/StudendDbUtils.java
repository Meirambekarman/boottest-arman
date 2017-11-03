package kz.kaznitu.lessons.db.dao;


import kz.kaznitu.lessons.db.models.Student;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudendDbUtils {
    private DataSource dataSource ;

    public StudendDbUtils(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Student> getStudents() throws Exception{
        List<Student> students = new ArrayList<Student>() ;
        Student student = null;

        Connection myCon = null ;
        Statement myStmt = null ;
        ResultSet myRst = null ;

        try{
            myCon = dataSource.getConnection() ;
            myStmt = myCon.createStatement() ;
            String sql = "select * from student order by last_name" ;
            myRst = myStmt.executeQuery(sql) ;

            while (myRst.next()){
                int id = myRst.getInt("id") ;
                String firstName = myRst.getString("first_name") ;
                String lastName = myRst.getString("last_name") ;
                String email = myRst.getString("email") ;
                student = new Student(id, firstName, lastName, email) ;
                students.add(student) ;
            }
            return students ;
        }finally {
            close(myCon, myStmt, myRst) ;
        }
    }

    private void close(Connection myCon, Statement myStmt, ResultSet myRst)
            throws SQLException {
        if (myRst != null)
            myRst.close();

        if(myStmt != null)
            myStmt.close();

        if (myCon != null)
            myCon.close();
    }

    public void addStudent(Student student) throws Exception{
        Connection myCon = null ;
        PreparedStatement myStmt = null ;

        try{
            myCon = dataSource.getConnection() ;
            String sql = "insert into student (first_name, last_name, email)" +
                    " values " +
                    "(?, ?, ?)" ;
            myStmt = myCon.prepareStatement(sql) ;
            myStmt.setString(1, student.getFirstName());
            myStmt.setString(2, student.getLastName());
            myStmt.setString(3, student.getEmail());
            myStmt.execute() ;

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            close(myCon, myStmt, null);
        }
    }

    public void deleteStudent(String studentId) throws Exception{
        Connection myCon = null ;
        PreparedStatement myStmt = null ;
        try{
            int id = Integer.parseInt(studentId) ;

            myCon = dataSource.getConnection() ;
            String sql = "Delete from student where id = ?" ;
            myStmt = myCon.prepareStatement(sql) ;
            myStmt.setInt(1, id);
            myStmt.execute() ;
        }finally {
            close(myCon, myStmt, null);
        }

    }

    public Student loadStudent(String studId) throws Exception{
        Connection myCon = null ;
        PreparedStatement myStmt = null ;
        ResultSet myRst = null ;
        Student student = null ;
        try{
            int id = Integer.parseInt(studId) ;

            myCon = dataSource.getConnection() ;
            String sql = "select * from student where id = ?" ;
            myStmt = myCon.prepareStatement(sql) ;
            myStmt.setInt(1, id) ;
            myRst = myStmt.executeQuery() ;
            if(myRst.next()){
                int studentId = myRst.getInt("id") ;
                String firstName = myRst.getString("first_name") ;
                String lastName = myRst.getString("last_name") ;
                String email = myRst.getString("email") ;
                student = new Student(studentId, firstName, lastName, email) ;
                return student ;

            }else{
                throw new Exception("Could not find student id: " + studId);
            }
        }finally {
            close(myCon, myStmt, myRst);
        }
    }

    public void update(Student student) throws Exception{
        Connection myCon = null ;
        PreparedStatement myStmt = null ;

        try{
            myCon = dataSource.getConnection() ;
            String sql = "update student "
                    + "set first_name=?, last_name=?, email=? "
                    + "where id=?";
            myStmt = myCon.prepareStatement(sql);
            myStmt.setString(1, student.getFirstName());
            myStmt.setString(2, student.getLastName());
            myStmt.setString(3, student.getEmail());
            myStmt.setInt(4, student.getId());
            myStmt.execute() ;
            System.out.println("id = " + student.getId() + " firstName = " + student.getFirstName());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            close(myCon, myStmt, null);
        }

    }
}
