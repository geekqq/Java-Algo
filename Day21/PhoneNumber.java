package Day21;

public class PhoneNumber {
    public static void main(String[] args) {
        String s = "800gotjunk!";
        System.out.println(getPhoneNumber(s));

    }

    public static StringBuilder getPhoneNumber(String letterNumber) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letterNumber.length(); i++) {
            char c = letterNumber.charAt(i);
            if (!Character.isLetter(c) && !Character.isDigit(c)) {
                sb.append("this is not a valid phone number!");
            }
        }

        for (int i = 0; i < letterNumber.length(); i++) {
            char c = letterNumber.charAt(i);
            if (Character.isDigit(c)) sb.append(c);
            else {
                switch (c) {
                    case 'a': case 'b': case 'c':
                        sb.append('2');
                        break;
                    case 'd': case 'e': case 'f':
                        sb.append('3');
                        break;
                    case 'g': case 'h': case 'i':
                        sb.append('4');
                        break;
                    case 'j': case 'k': case 'l':
                        sb.append('5');
                        break;
                    case 'm': case 'n': case 'o':
                        sb.append('6');
                        break;
                    case 'p': case 'q': case 'r': case 's':
                        sb.append('7');
                        break;
                    case 't': case 'u': case 'v':
                        sb.append('8');
                        break;
                    case 'w': case 'x': case 'y': case 'z':
                        sb.append('9');
                        break;
                }
            }
        }
        return sb;
    }
}
