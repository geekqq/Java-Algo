package Day242;

public class ValidateUsername {

    // matches all String 8 - 30 characters, start with letter,
    // the rest character can be any letters or numbers or underscore
    private static final String regex = "^[a-zA-Z][a-zA-Z0-9_]{7,29}$";

    public static void validateUsername(String username) {
        if (username.matches(regex)) {
            System.out.println("this is a valid username");
        } else {
            System.out.println("Username is not valid");
        }
    }

    public static void main(String[] args) {
        validateUsername("1andhjwdn");
    }
}
