package Day234;

public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        int sum = 0;
        int remain = 0;
        int pos = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                remain += sum;
                sum = 0;
                pos = i + 1;
            }
        }
        remain += sum;
        return remain >= 0 ? pos : -1;

    }
}
