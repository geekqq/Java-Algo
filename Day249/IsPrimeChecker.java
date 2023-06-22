package Day249;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class IsPrimeChecker {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);

            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (Method method: methods) {
                if (set.contains(method.getName())) {
                    overload = true;
                    break;
                }
                set.add(method.getName());
            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }

        } catch (Exception e) {
            System.out.println(e);;
        }
    }
}


class Prime {
    public void checkPrime(int... nums) {
        StringBuilder primeNumbers = new StringBuilder();
        for (int num : nums) {
            boolean isPrime = true;
            if (num < 2) isPrime = false;
            else if (num == 2) {
                primeNumbers.append(num).append(" ");
                continue;
            } else {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                primeNumbers.append(num).append(" ");
            }
        }
        System.out.println(primeNumbers);
    }
}