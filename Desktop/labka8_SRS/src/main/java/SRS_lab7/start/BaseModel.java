package SRS_lab7.start;

import SRS_lab7.interfaces.Notebook;
import SRS_lab7.interfaces.Ozu;
import SRS_lab7.interfaces.Processor;
import SRS_lab7.interfaces.VideoKarta;


public abstract class BaseModel implements Notebook {
    private Ozu ozu;
    private VideoKarta videoKarta;
    private Processor processor;

    public BaseModel() {
        System.out.println(this + " - BaseModelconstructor()");
    }

    public BaseModel(Ozu ozu, VideoKarta videoKarta, Processor processor) {
        this();
        this.ozu = ozu;
        this.videoKarta = videoKarta;
        this.processor = processor;
    }

    public Ozu getOzu() {
        return ozu;
    }

    public void setOzu(Ozu ozu) {
        this.ozu = ozu;
    }

    public VideoKarta getVideoKarta() {
        return videoKarta;
    }

    public void setVideoKarta(VideoKarta videoKarta) {
        this.videoKarta = videoKarta;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
}