package Day240;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractContents {
    public static void main(String[] args) {

        String regex = "<(.+)>([^<>]+)</(\\1)>";
        Pattern p = Pattern.compile(regex);

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String line = in.nextLine();

            // Write your code here
            Matcher m = p.matcher(line);

            boolean bandera = true;
            while (m.find()) {
                System.out.println(m.group(2));
                bandera = false;
            }

            if (bandera) {
                System.out.println("None");
            }

            testCases--;
        }
    }
}
