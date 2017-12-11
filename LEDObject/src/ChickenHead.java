import java.awt.image.BufferedImage;
        import java.util.Arrays;

public class ChickenHead extends LEDObject {

    public HSBColor pixels[] = CreateHSBArray(261);
    public int[] allIndexes = CreateIndexRange(0, pixels.length - 1);
    public int[] topSection = CreateIndexRange(170, 260);
    public int[][] topSections = {
            CreateIndexRange(170, 178), reverseArray(CreateIndexRange(179, 192)),
            CreateIndexRange(193, 201), reverseArray(CreateIndexRange(202, 214)),
            CreateIndexRange(215, 221), reverseArray(CreateIndexRange(222, 236)),
            CreateIndexRange(237, 244), reverseArray(CreateIndexRange(245, 260))};
    public int[] eyeFront = CreateIndexRange(154, 169);
    public int[] eyeBack = CreateIndexRange(138, 153);
    public int[] beak = CreateIndexRange(107, 137);
    public int[] beakBottom = CreateIndexRange(110, 119);
    public int[] beakTop = reverseArray(CreateIndexRange(120, 137));
    public int[] head = CreateIndexRange(0, 106);

    @Override
    public HSBColor[] GetAllPixels() {
        return this.pixels;
    }
}

