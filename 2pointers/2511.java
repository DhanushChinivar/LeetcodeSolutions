class Solution {
    public int captureForts(int[] forts) {
        int max = 0, last = -1;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] != 0) {
                if (last != -1 && forts[i] != forts[last]) {
                    max = Math.max(max, i - last - 1);
                }
                last = i;
            }
        }
        return max; 
    }
}