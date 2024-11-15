import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 0, 9, 5, 4, 1, 9);

        // remove duplicates
        List<Integer> ans = list.stream()
        .distinct()
        .collect(Collectors.toList());
        System.out.println("ans: " + ans);

        // even
        List<Integer> even = list.stream()
        .filter(x -> x%2==0)
        .collect(Collectors.toList());
        System.out.println("even: " + even);

        // odd
        List<Integer> odd = list.stream()
        .filter(x -> x%2==1)
        .collect(Collectors.toList());
        System.out.println("odd: " + odd);

        // odd_sqr_sum
        int odd_sqr_sum = list.stream()
        .filter(x -> x%2==1)
        .map(x -> x*x)
        .reduce(0, Integer::sum);
        System.out.println("odd_sqr_sum: " + odd_sqr_sum);
        
        // max
        Optional<Integer> max = list.stream()
        .max(Integer::compareTo);
        System.out.println("max: " + max.get());

        // second highest
        Optional<Integer> second_highest = list.stream()
        .distinct()
        .sorted((a, b) -> b - a)
        .skip(1)
        .findFirst();
        System.out.println("second_highest: " + second_highest.get());

        // third highest
        Optional<Integer> third_highest = list.stream()
        .distinct()
        .sorted((a, b) -> b - a)
        .skip(1)
        .findFirst();
        System.out.println("third_highest: " + third_highest.get());

        // partitioning for odd and even
        Map<Boolean, List<Integer>> partition = list.stream()
        .distinct()
        .collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println("partition even: " + partition.get(true));
        System.out.println("partition odd: " + partition.get(false));

        List<String> str = List.of("i", "am", "vscode");

        // max string
        Optional<String> max_str = str.stream()
        .max((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("max_str: "+max_str.get());

        // second_max_str_len
        Optional<Integer> second_max_str_len = str.stream()
        .map(String::length)
        .sorted((a, b) -> b-a)
        .skip(1)
        .findFirst();
        System.out.println("second_max_str_len: " + second_max_str_len.get());
        
        // second_max_str
        Optional<String> second_max_str = str.stream()
        .sorted((a, b) -> b.length() - a.length())
        .skip(1)
        .findFirst();
        System.out.println("second_max_str: " + second_max_str.get());

        // concat str
        String conact_str = str.stream()
        .collect(Collectors.joining(", "));
        System.out.println("conact_str: " + conact_str);

        Map<String, Long> word_freq = str.stream()
        .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println("word_freq: " + word_freq);
        
        String s = "navan";
        
        // rem_duplicates_str
        String rem_duplicates_str = s.chars()
        .distinct()
        .mapToObj(c -> (char) c)
        .map(String::valueOf)
        .collect(Collectors.joining());
        System.out.println("rem_duplicates_str: " + rem_duplicates_str);
    }
}