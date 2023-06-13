package Day242;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatedWords {

    public static String removeRepeatedWords(String sentence) {
        Set<String> uniqueWords = new HashSet<>();
        StringBuilder res = new StringBuilder();

        //
        //\b(\w+)\b
        //\b(\w+)(?:\W+\1\b)+
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sentence);

        while (matcher.find()) {
            String word = matcher.group(1);
            if (uniqueWords.contains(word.toLowerCase())) {
                continue;
            }
            uniqueWords.add(word.toLowerCase());
            res.append(word).append(" ");
        }
        return res.toString().trim();
    }

    public static String removeRepeatedWordsII(String sentence) {
        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(sentence);
        while (m.find()) {
            sentence = sentence.replaceAll(m.group(), m.group(1));
        }
        return sentence;
    }

    public static void main(String[] args) {
        String sentence = "I love Love to TO tO code";
        String sentence1 = "Hello hello Ab aB";
        System.out.println(removeRepeatedWords(sentence));
        System.out.println(removeRepeatedWords(sentence1));
        System.out.println(removeRepeatedWordsII(sentence));
        System.out.println(removeRepeatedWordsII(sentence1));
    }
}
