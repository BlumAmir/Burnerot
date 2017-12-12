public class SceneAnimation {

    public SceneAnimation(ChickenHead headObject, Wing leftWing, Wing rightWing, Feathers feathersObject) {
        head = new ChickenHeadAnimation(headObject);
        lWing = new ChickenWingAnimation(leftWing);
        rWing = new ChickenWingAnimation(rightWing);
        this.feathers = new FeathersAnimation(feathersObject);
    }

    public void apply(double timePercent) {
        head.apply(timePercent);
        lWing.apply(timePercent);
        rWing.apply(timePercent);
        feathers.apply(timePercent);
    }

    public void newCycle() { }
    public void randomize() { }

    protected ChickenHeadAnimation head;
    protected ChickenWingAnimation lWing;
    protected ChickenWingAnimation rWing;
    protected FeathersAnimation feathers;
}
