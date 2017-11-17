package SRS_lab7.start;

import SRS_lab7.interfaces.Ozu;
import SRS_lab7.interfaces.Processor;
import SRS_lab7.interfaces.VideoKarta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("t1000")
public class ModelT1000 extends BaseModel {
    @Value("Black")
    private String color;
    @Value("1996")
    private int year;
    @Value("true")
    private boolean soundEnabled;

    public ModelT1000() {

    }
    @Autowired
    public ModelT1000(@Qualifier("asusOzu") Ozu ozu,
                      @Qualifier("asusVideoKarta") VideoKarta videoKarta,
                      @Qualifier("asusProcessor") Processor processor) {
        super(ozu, videoKarta, processor);
    }

    public ModelT1000(Ozu ozu, VideoKarta videoKarta, Processor processor, String color, int year, boolean soundEnabled) {
        super(ozu, videoKarta, processor);
        this.color = color;
        this.year = year;
        this.soundEnabled = soundEnabled;
    }

    public ModelT1000(String color, int year, boolean soundEnabled) {
        this.color = color;
        this.year = year;
        this.soundEnabled = soundEnabled;
    }

    public void action() {
        getProcessor().Processor();
        getOzu().memory();
        getVideoKarta().videokart();
        System.out.println("color notebook: " + color);
        System.out.println("Year of issue: " + year);
        System.out.println("sound active: " + soundEnabled);
    }

    public void game() {
        System.out.println("T1000 is games!");

    }
    public String getColor(){
        return color;}
    public void setColor(String color){
        this.color=color;

    }
    public int getYear(){
        return year;

    }
    public void setYear(int year){
        this.year=year;

    }
    public boolean isSoundEnabled(){
        return soundEnabled;

    }
    public void setSoundEnabled(boolean soundEnabled){
        this.soundEnabled=soundEnabled;

    }
    public void myInitMethod(){
        System.out.println("Бинды орнатуда қолданылатын қосымша метод");

    }
    public void myDestroyMethod(){
        System.out.println("Бинды жоюда қолданылатын қосымша метод");

    }
}


