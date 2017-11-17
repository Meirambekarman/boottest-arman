package SRS_lab7.start;

import org.springframework.beans.BeansException;
        import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPost implements BeanPostProcessor {
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println(o + "орнатылғаннан кейін");
        return o;
    }

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println(o+ "орнатыларының алдында");
        return o;
    }
}