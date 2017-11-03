package kz.kaznitu.lessons.models;

public class Robot {
    private SonyHand hand = new SonyHand();
    private SonyHead head = new SonyHead();
    private SonyLeg leg = new SonyLeg();

    public void action(){
        head.calc();
        hand.catchSomething();
        leg.go();
    }
}
