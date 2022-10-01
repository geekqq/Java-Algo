package Day30;

public class DemoHeights {
    public static void main(String[] args) {
        double fatherHeight = 175;
        double motherHeight = 10;
        double sonHeight = (fatherHeight + motherHeight) * 1.08 / 2;
        double daughterHeight = (fatherHeight * 0.923 + motherHeight) / 2;

        System.out.println(sonHeight);
        System.out.println(daughterHeight);
    }
}
