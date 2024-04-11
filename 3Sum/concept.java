import java.util.*;

public class concept {
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.add(3);
        System.out.println(ls);
        
        Set<List<Integer>> st1 = new HashSet<>();
        st1.add(Arrays.asList(1, 2)); // Add elements using Arrays.asList()
        st1.add(Arrays.asList(1, 3)); // Add elements using Arrays.asList()
        st1.add(Arrays.asList(1, 2)); // Add elements using Arrays.asList()
        System.out.println(st1);

        Set<int[]> st2 = new HashSet<>();
        st2.add(new int[]{1, 2}); // Correct syntax to add an array to a set
        st2.add(new int[]{1, 3}); // Correct syntax to add an array to a set
        st2.add(new int[]{1, 2}); // Correct syntax to add an array to a set
        System.out.println(st2);
    }
}
