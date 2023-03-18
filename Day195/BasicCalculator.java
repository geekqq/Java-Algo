package Day195;

import java.util.Stack;

public class BasicCalculator {

    public static int calculator(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res= 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                res += num * sign;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }

    public static int calculatorII(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (String s : tokens) {
            if (isNumber(s)) {
                stack.push(Integer.parseInt(s));
            } else if (isOperand(s)) {
                stack.push(operate(s, stack.pop(), stack.pop()));
            }
        }
        return stack.pop();
    }

    private static boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        char c = s.charAt(0);
        if (!Character.isDigit(c)) {
            if (!(c == '+' || c == '-')) return false;
            else if (s.length() == 1) return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOperand(String s) {
        if (s == null || s.length() != 1) return false;
        char c = s.charAt(0);
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    private static int operate(String s, int first, int second) {
        char c = s.charAt(0);
        switch (c) {
            case '+' : return second + first;
            case '-' : return second - first;
            case '*' : return second * first;
            case '/' : return second / first;
        }
        return 0;
    }
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculator(s));
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(calculatorII(tokens));
    }
}
