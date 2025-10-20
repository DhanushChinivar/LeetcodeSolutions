import java.util.Arrays;

class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        double minAvg = Double.MAX_VALUE;

        while (start < end) {
            double avg = (nums[start] + nums[end]) / 2.0;
            minAvg = Math.min(minAvg, avg);
            start++;
            end--;
        }

        return minAvg;
    }
}
