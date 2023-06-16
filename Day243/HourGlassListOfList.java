package Day243;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class HourGlassListOfList {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> list = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                list.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(""))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        int maxSum = Integer.MIN_VALUE;
        int rowSize = list.size();
        int colSize = list.get(0).size();
        for (int i = 0; i < rowSize - 2; i++) {
            for (int j = 0; j < colSize - 2; j++) {
                int sumTop = list.get(i).get(j) + list.get(i).get(j + 1) + list.get(i).get(j + 2);
                int sumMid = list.get(i + 1).get(j + 1);
                int sumBot = list.get(i + 2).get(j) + list.get(i + 2).get(j + 1) + list.get(i + 2).get(j + 2);
                int sumHourGlass = sumTop + sumMid + sumBot;
                maxSum = Math.max(maxSum, sumHourGlass);
            }
        }
        System.out.println(maxSum);
    }
}
