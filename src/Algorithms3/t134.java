package Algorithms3;

public class t134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            //从i开始遍历
            int sumGas = 0;
            int sumCost = 0;
            int total = 0;
            while (total != n) {
                int j = (i + total) % n;
                sumGas += gas[j];
                sumCost += cost[j];
                if (sumGas - sumCost < 0) {
                    break;
                }
                total++;
            }
            if (total == n)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

}
