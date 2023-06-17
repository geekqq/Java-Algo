package Day240;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringIndexOf {

    public static void main(String[] args) {
        String s = "348 99 200";
        String[] logs = {"88 99 200", "99 87 100", "12 12 500", "88 99 100"};
        System.out.println(s.substring(0, s.indexOf(' ')));
        int first = s.indexOf(' ');
        int second = s.indexOf(" ", first + 1);
        System.out.println(s.substring(first + 1, second));
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "One");
        map.put(3, "three");
        map.put(4, "four");
        map.put(2, "two");
        map.put(5, "Five");
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey());

        }
//        List<Integer> res = new ArrayListDemo<>();
//        for (int id : map.keySet()) {
//            if (id >= 2) {
//                res.add(id);
//            }
//        }
//        System.out.println(res);
        System.out.println("==================");
        Map<Integer, Integer> idCountMap = new TreeMap<>();
        for (String log : logs) {
            int senderId = getSenderId(log);
            int receiverId = getReceiverId(log);
            System.out.println(senderId);
            System.out.println(receiverId);
            if (senderId == receiverId) {
                idCountMap.put(senderId, idCountMap.getOrDefault(senderId, 0) + 1);
            } else {
                idCountMap.put(senderId, idCountMap.getOrDefault(senderId, 0) + 1);
                idCountMap.put(receiverId, idCountMap.getOrDefault(receiverId, 0) + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int id : idCountMap.keySet()) {
            if (idCountMap.get(id) >= 2) {
                res.add(id);
            }
        }
        System.out.println(res);
        System.out.println(idCountMap.get(12));
    }

    private static int getSenderId(String s) {
        String sender = s.substring(0, s.indexOf(' '));
        return Integer.parseInt(sender);
    }

    private static int getReceiverId(String s) {
        int first = s.indexOf(' ');
        int second = s.indexOf(' ', first + 1);
        String receiver = s.substring(first + 1, second);
        return Integer.parseInt(receiver);
    }

}
