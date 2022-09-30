package Day25;

public class RabbitAmount {
    public static void main(String[] args) {
        int month = 6;
        System.out.println(getRabbitAmount(month));
    }

    public static int getRabbitAmount(int month) {
        if (month <= 2) return 1;

        while (month > 2) {
            return getRabbitAmount(month - 2) * 2 + getRabbitAmount(month - 1) - getRabbitAmount(month - 2);
        }
        return 0;
    }
}
