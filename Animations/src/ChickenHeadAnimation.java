
public class ChickenHeadAnimation extends LEDObjectAnimation {

    public ChickenHeadAnimation(ChickenHead headObject) {
        super(headObject);
        this.headObject = headObject;
    }

    public void addMapperForTopSections(ContinuousEffect effects[]) {
        for(int i=0; i<effects.length && 2*i < this.headObject.topSections.length; i++) {
            addMapper(this.headObject.topSections[2*i], effects[i]);
            addMapper(this.headObject.topSections[2*i+1], effects[i]);
        }
    }

    public void addMapperForTopSections(ContinuousEffect e) {
        for(int[] topSection: this.headObject.topSections) {
            addMapper(topSection, e);
        }
    }

    private ChickenHead headObject;
}
