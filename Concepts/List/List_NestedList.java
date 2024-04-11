import java.util.*;

public class List_NestedList {
    public static void main(String[] args) {
        // Creating a new ArrayList to store Integer values
        List<Integer> ls = new ArrayList<>();
        
        // Adding elements to the list
        ls.add(10);
        ls.add(20);
        
        // Adding multiple elements to the list using Arrays.asList() method
        ls.addAll(Arrays.asList(1, 2));
        ls.addAll(Arrays.asList(5, 6));
        
        // Printing the list
        System.out.println(ls); // Output: [10, 20, 1, 2, 5, 6]
        
        // Accessing and printing an element by index
        System.out.println(ls.get(0)); // Output: 10

        // Creating a list of lists to store lists of Integer values
        List<List<Integer>> temp = new ArrayList<>();
        
        // Adding lists to the list of lists
        // temp.add(ls); // Uncommenting this line would add the 'ls' list to 'temp'
        temp.add(Arrays.asList(22, 33)); // Adding a new list directly
        temp.add(Arrays.asList(55, 44)); // Adding another new list
        
        // Printing the list of lists
        System.out.println(temp); // Output: [[22, 33], [55, 44]]
        
        // Accessing and printing an element from a nested list by index
        System.out.println(temp.get(0).get(1)); // Output: 33
    }
}
