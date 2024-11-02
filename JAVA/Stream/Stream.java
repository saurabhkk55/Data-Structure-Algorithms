import java.util.*;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7,2,9,8,5);

        // Largest
        Optional<Integer> num = list.stream()
        .max(Integer::compareTo);

        System.out.println("Largest: "+num.get());
        
        // Second Largest
        Optional<Integer> second_largest = list.stream()
        .sorted((a, b) -> b - a)
        .skip(1)
        .findFirst();
        
        System.out.println("Second largest: "+second_largest.get());
        
        // Third smallest
        Optional<Integer> third_smallest = list.stream()
        .sorted()
        .skip(2)
        .findFirst();

        System.out.println("Third smallest: "+third_smallest.get());
        
        // Count even numbers
        long count_even_nums = list.stream()
        .filter(x -> x%2 == 0)
        .count();

        System.out.println("Count even numbers: "+count_even_nums);

        // Even numbers
        List<Integer> even_nums_list = list.stream()
        .filter(x -> x%2 == 0)
        .collect(Collectors.toList());

        System.out.println("Even numbers: "+even_nums_list);

        // Even numbers in Ascending order
        List<Integer> even_nums_asc = list.stream()
        .filter(x -> x%2 == 0)
        .sorted()
        .collect(Collectors.toList());

        System.out.println("Even numbers in Ascending order: "+even_nums_asc);

        // Even numbers in Descending order
        List<Integer> even_nums_desc = list.stream()
        .filter(x -> x%2 == 0)
        .sorted((a, b) -> b - a)
        .collect(Collectors.toList());

        System.out.println("Even numbers in Descending order: "+even_nums_desc);
        
        // Sum of square of odd numbers
        int sum_of_square_of_odd_numbers = list.stream()
        .filter(x -> x%2==1)
        .map(x -> x*x)
        .reduce(0, Integer::sum);

        System.out.println("Sum of square of odd numbers: "+sum_of_square_of_odd_numbers);
        
        // Grouping elements by even or odd
        Map<Boolean,List<Integer>> grouping_elements_by_even_or_odd = list.stream()
        .collect(Collectors.partitioningBy(x -> x%2==0));
        
        System.out.println("Even: "+grouping_elements_by_even_or_odd.get(true));
        System.out.println("Odd: "+grouping_elements_by_even_or_odd.get(false));
        
        
        // Remove duplicates
        List<Integer> list_2 = Arrays.asList(7,7,8,8);
        
        List<Integer> duplicates_removed = list_2.stream()
        .distinct()
        .collect(Collectors.toList());

        System.out.println("Remove duplicates: "+duplicates_removed);

        List<String> str = Arrays.asList("my", "name", "is", "vscode");

        // Longest String length
        Optional<Integer> max_str_len = str.stream()
        .map(String::length)
        .max(Integer::compareTo);

        System.out.println("Longest String length: "+max_str_len.get());

        // Longest String
        Optional<String> longest_str = str.stream()
        .sorted((a, b) -> b.length() - a.length())
        .findFirst();

        System.out.println("Longest String: "+longest_str.get());
        
        // Concat strings with a Delimiter
        String concated_str = str.stream()
        .collect(Collectors.joining(", "));
        
        System.out.println("Concat strings with a Delimiter: "+concated_str);

        // Create a Map of Word Frequencies
        Map<Object,Long> words_freq = str.stream()
        .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        System.out.println("Map of Word Frequencies: "+words_freq);

        String str_2 = "navan";

        // Count Distinct character in string
        long distinct_char_in_string = str_2.chars()
        .distinct()
        .count();
        System.out.println("Count Distinct character in string: "+distinct_char_in_string);

        // Remove duplicates from a string
        String duplicates_removed_from_str = str_2.chars()
        .distinct()
        .mapToObj(c -> (char) c)
        .map(String::valueOf)
        .collect(Collectors.joining());

        System.out.println("Remove duplicates from a string: "+duplicates_removed_from_str);

    }
}

// Output:
// Largest element: 12
