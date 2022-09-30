package Day00;

public class CheckAge {
    public static void main(String[] args) {
        checkAge(15);
        checkAge(18);
    }

    public static void checkAge(int age) {
        if (age < 18) {
            System.out.println("Access denied - You must be at least 18 years old.");
        } else {
            System.out.println("Access granted - You are old enough!");
        }
    }
}
