package SRS_lab7.start;

import SRS_lab7.config.MyConfigNB;
import SRS_lab7.interfaces.Notebook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NotebookManager {
    public static void main(String [] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfigNB.class);
        Notebook terminator = (Notebook) context.getBean("t1000");
        terminator.action();
    }
}
