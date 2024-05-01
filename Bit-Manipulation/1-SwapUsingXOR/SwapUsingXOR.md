# `Swap 2 numbers using XOR`

```java
public class SwapUsingXOR {
    public static void main(String[] args) {
        int a = 5;
        int b = 8;

        System.out.println("Before swapping:");
        System.out.println("a = " + a + ", b = " + b);

        // Swapping using XOR
        a = a ^ b; // Step 1: a = a ^ b (a now holds the XOR of original a and b)
        b = a ^ b; // Step 2: b = (a ^ b) ^ b (this simplifies to a because b ^ b = 0)
        a = a ^ b; // Step 3: a = (a ^ b) ^ a (this simplifies to b because a ^ a = 0)

        System.out.println("After swapping:");
        System.out.println("a = " + a + ", b = " + b);
    }
}
```

**Explanation**:

1. `a = a ^ b;`:
   - `a` now holds the XOR of the original values of `a` and `b`.

2. `b = a ^ b;`:
   - Here, `b` is assigned `(a ^ b) ^ b`.
   - Using the property that `x ^ x = 0` for any `x`, this simplifies to `a`.

3. `a = a ^ b;`:
   - Now `a` is assigned `(a ^ b) ^ a`.
   - Again, using the property that `x ^ x = 0`, this simplifies to `b`.

Therefore, after these operations:
- `a` becomes `b` (the original value of `b`).
- `b` becomes `a` (the original value of `a`).

This swapping method works without using an additional variable and relies on the properties of XOR operations, where `x ^ x = 0` and `x ^ 0 = x`. This technique is efficient and compact for swapping two integer variables in-place.