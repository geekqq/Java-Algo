package Day13;

public class getPhoneNumber {
    public static void main(String[] args) {
        String s = "800gotjunk!";
        System.out.println(getRealNumber(s));
    }

    public static StringBuilder getRealNumber(String s) {
        StringBuilder phoneNumber = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c) && !Character.isLetter(c)) {
                phoneNumber.append("This is not a valid phone number!");
            } else if (Character.isLetter(c)) {
                switch(c) {
                    case 'a': case 'b': case 'c':
                        phoneNumber.append('2');
                        break;
                    case 'd': case 'e': case 'f':
                        phoneNumber.append('3');
                        break;
                    case 'g': case 'h': case 'i':
                        phoneNumber.append('4');
                        break;
                    case 'j': case 'k': case 'l':
                        phoneNumber.append('5');
                        break;
                    case 'm': case 'n': case 'o':
                        phoneNumber.append('6');
                        break;
                    case 'p': case 'q': case 'r': case 's':
                        phoneNumber.append('7');
                        break;
                    case 't': case 'u': case 'v':
                        phoneNumber.append('8');
                        break;
                    case 'w': case 'x': case 'y': case 'z':
                        phoneNumber.append('9');
                        break;
                }
            } else {
                phoneNumber.append(c);
            }
        }
        return phoneNumber;
    }
}
