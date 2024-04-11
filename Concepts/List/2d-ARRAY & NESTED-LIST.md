# `Decalare and Initialze an 2d-ARRAY & NESTED-LIST`

## `2d-ARRAY`
In Java, you can initialize an array directly using array initializer syntax. Here's how you can initialize a 2D array directly:

```java
int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
```

In this example, `intervals` is a 2D array of integers. Each row of the array represents a sublist, and each column represents an element within that sublist.

Here's the complete code:

```java
class HelloWorld {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(intervals)); // [[1, 3], [2, 6], [8, 10], [15, 18]]
    }
}
```

In this example, `Arrays.deepToString()` is used to print the contents of the 2D array.

---
## `NESTED-LIST`
In Java, we can't directly initialize a list of lists like you would with a 2D array. Lists are dynamic data structures, so their size can change over time, unlike arrays, which have a fixed size once initialized.
```java
import java.util.*;

class HelloWorld {
    public static void main(String[] args) {
        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(Arrays.asList(1, 3));
        intervals.add(Arrays.asList(2, 6));
        intervals.add(Arrays.asList(8, 10));
        intervals.add(Arrays.asList(15, 18));
        System.out.println(intervals); // [[1, 3], [2, 6], [8, 10], [15, 18]]
    }
}
```
OR

However, we can initialize a list of lists in a more concise way using the `Arrays.asList()` method, as shown in the previous example. If you want to initialize a list of lists directly similar to an array initialization, you can use double braces initialization, `but it's less commonly used and not recommended due to readability concerns.`
Here's how we can do it using double braces initialization:
```java
import java.util.*;

class HelloWorld {
    public static void main(String[] args) {
        List<List<Integer>> intervals = new ArrayList<List<Integer>>() {{
            add(Arrays.asList(1, 3));
            add(Arrays.asList(2, 6));
            add(Arrays.asList(8, 10));
            add(Arrays.asList(15, 18));
        }};
        System.out.println(intervals); // [[1, 3], [2, 6], [8, 10], [15, 18]]
    }
}
```

This syntax creates an anonymous subclass of `ArrayList<List<Integer>>` and initializes it with the provided values. However, it's generally discouraged because it creates an unnecessary subclass and can lead to unexpected behavior in some cases. Using the `Arrays.asList()` approach is more readable and preferred.
