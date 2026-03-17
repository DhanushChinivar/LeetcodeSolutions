class Solution {
    public boolean isAnagram(String s, String t) {
        // char[] cs = s.toCharArray();
        // char[] ct = t.toCharArray();
        // Arrays.sort(cs);
        // Arrays.sort(ct);
        if (s.length() != t.length()) return false;
        return s.contains(t);

    }
}
