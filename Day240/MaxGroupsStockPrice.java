package Day240;

import java.util.Stack;

public class MaxGroupsStockPrice {

    public static int getMaxLength(int[] stockPrice) {
        if (stockPrice == null || stockPrice.length == 0) return -1;
        int res = 0;
        int max = stockPrice[0];
        Stack<Integer> stack = new Stack<>();
        stack.push(stockPrice[0]);
        for (int i = 1; i < stockPrice.length; i++) {
            if (max <= stockPrice[i]) {
                res += i;
                max = stockPrice[i];
            } else {
                res += stack.size();
            }
            while (!stack.isEmpty() && stack.peek() < stockPrice[i]) {
                stack.pop();
            }
            stack.push(stockPrice[i]);
        }
        return res + stockPrice.length;
    }

    public static void main(String[] args) {
        int[] stockPrice = {3,1,3,5};
        System.out.println(getMaxLength(stockPrice));
    }
}
