import java.util.*;

class Solution {
    public int[] divisors(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                list.add(i); // add divisor
            }
        }

        // Convert List to int[]
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
