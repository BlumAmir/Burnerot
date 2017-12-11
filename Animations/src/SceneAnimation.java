public class SceneAnimation {

    public SceneAnimation(ChickenHead headObject, Wing leftWing, Wing rightWing) {
        head = new ChickenHeadAnimation(headObject);
        lWing = new ChickenWingAnimation(leftWing);
        rWing = new ChickenWingAnimation(rightWing);
    }

    public void apply(double timePercent) {
        head.apply(timePercent);
        lWing.apply(timePercent);
        rWing.apply(timePercent);
    }

    public void newCycle() {

    }

    protected ChickenHeadAnimation head;
    protected ChickenWingAnimation lWing;
    protected ChickenWingAnimation rWing;
}
