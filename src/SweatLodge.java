import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SweatLodge {

    private void createAnimations() {
        animations.add(new TimeChangingSections(head, leftWing, rightWing, feathers));
        animations.add(new Rainbow(head, leftWing, rightWing, feathers));
        animations.add(new Confetti(head, leftWing, rightWing, feathers));
        animations.add(new Alternate(head, leftWing, rightWing, feathers));
        animations.add(new Spikes(head, leftWing, rightWing, feathers));
    }

    private void newAnimation() {
//        currentAnimation = animations.get(animations.size() - 1);
        currentAnimation = animations.get(ThreadLocalRandom.current().nextInt(animations.size()));
        animationLoopTimeMs =  500 * ThreadLocalRandom.current().nextInt(1, 20);
        animationEndEphocTime = System.currentTimeMillis() + animationLoopTimeMs * ThreadLocalRandom.current().nextInt(5, 20);

    }

    public void run() {

        final Network network = new Network();
        network.configure();
        this.createAnimations();
        this.newAnimation();

        while (true) {

           long currTime = System.currentTimeMillis();
           if(currTime > animationEndEphocTime) {
               this.newAnimation();
           }

           double timePercent = (currTime % animationLoopTimeMs) / (double)animationLoopTimeMs;
           long currLoopIndication = (currTime / animationLoopTimeMs);
           if(currLoopIndication != this.lastLoopIndication) {
               currentAnimation.newCycle();
           }
           this.lastLoopIndication = currLoopIndication;
           currentAnimation.apply(timePercent);


           System.gc();
           network.addSegment("test", leftWing.GetRGBColors(0, leftWing.GetPixelsNumber()), 0, 0);
           network.addSegment("test", head.GetRGBColors(0, head.GetPixelsNumber()), 1, 0);
           network.addSegment("test", rightWing.GetRGBColors(0, rightWing.GetPixelsNumber()), 2, 0);
           network.addSegment("test", feathers.GetRGBColors(0, feathers.GetPixelsNumber()), 3, 0);

           network.send();

           try {
                //delay 1,000 = 1sec
                Thread.sleep(30);        //devide 1000 in the number and you will get how many time the loop would work in a second    -   frame rate
            }
            catch (java.lang.InterruptedException interrupt) {
               System.out.println(interrupt.getMessage());
                break;
            }

       }
    }

    List<SceneAnimation> animations = new ArrayList<>();

    SceneAnimation currentAnimation;
    int animationLoopTimeMs;
    long animationEndEphocTime;

    long lastLoopIndication;

    Wing leftWing = new Wing();
    Wing rightWing = new Wing();
    ChickenHead head = new ChickenHead();
    Feathers feathers = new Feathers();

}


