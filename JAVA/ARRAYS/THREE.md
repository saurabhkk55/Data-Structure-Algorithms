<hr style="border: 10px solid green;">

# 16. `To sort an array containing only 0s, 1s, and 2s:`

```java
// Input
int[] arr = {0, 1, 2, 0, 1, 2, 1, 0};

// OUTPUT
[0, 0, 0, 1, 1, 1, 2, 2]
```

```java
public static void sortColors(int[] arr) {
        int low = 0;                // Pointer for 0s
        int mid = 0;                // Pointer for current element
        int high = arr.length - 1;  // Pointer for 2s

   while (mid <= high) {
      if (arr[mid] == 0) {
            // Swap arr[low] and arr[mid]
            int temp = arr[low];
            arr[low] = arr[mid];
            arr[mid] = temp;
            low++;
            mid++;
      } else if (arr[mid] == 1) {
            mid++;
      } else if (arr[mid] == 2) {
            // Swap arr[mid] and arr[high]
            int temp = arr[mid];
            arr[mid] = arr[high];
            arr[high] = temp;
            high--;
      }
   }
}
```
