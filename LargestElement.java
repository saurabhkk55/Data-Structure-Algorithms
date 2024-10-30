import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LargestElement {
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(5, 5, 3, 9, 12, 4, 8, 2, 3, 12);

        // Finding the largest element
        Optional<Integer> largestElement = numbers.stream()
                .max(Integer::compareTo); // Find the maximum value

        // Print the largest element or a message if the list is empty
        largestElement.ifPresentOrElse(
                num -> System.out.println("Largest element: " + num),
                () -> System.out.println("List is empty.")
        );
    }
}

// Output:
// Largest element: 12
