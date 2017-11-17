package SRS_lab7.config;

import SRS_lab7.interfaces.Ozu;
import SRS_lab7.interfaces.Processor;
import SRS_lab7.interfaces.VideoKarta;
import SRS_lab7.models.Asus.AsusOzu;
import SRS_lab7.models.Asus.AsusProcessor;
import SRS_lab7.models.Asus.AsusVideoKarta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "SRS_lab7")
public class MyConfigNB {

    @Bean(name="asusOzu")
    public Ozu asusOzu(){

        return new AsusOzu();
    }
    @Bean
    public Processor asusProcessor(){

        return new AsusProcessor();
    }
    @Bean
    public VideoKarta videoKarta(){

        return new AsusVideoKarta() {
        };
    }
}
