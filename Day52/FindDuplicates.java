package Day52;

public class FindDuplicates {
    public static void main(String[] args) {
        String[] songs = {"pop", "pop", "Rock", "country", "jazz", "country", "country"};
        findDuplicates(songs);
    }

    public static void findDuplicates(String[] strings) {
        int count = 0;
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[i].equals(strings[j])) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println("The duplicate element is: " + strings[i]);
            }
            count = 0;
        }
    }
}
