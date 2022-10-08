package Day37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcatTwoStringArrays {
    public static void main(String[] args) {
        String[] a = {"A","E","I"};
        String[] b = {"O", "U"};

        //why <String> can be deleted code still works?
        //Arrays.asList turns array to list so can be connected as list, then use list.toArray() turn it back to array
        List<String> list = new ArrayList(Arrays.asList(a));
        list.addAll(Arrays.asList(b));
        Object[] c = list.toArray();
        System.out.println(Arrays.toString(c));
    }
}
