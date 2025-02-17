class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        java.util.Set<Character> charSet = new java.util.HashSet<>();
        for (char c : s.toCharArray()) {
            charSet.add(c);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charSet.contains(Character.toUpperCase(c)) || 
                !charSet.contains(Character.toLowerCase(c))) {
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));
                return left.length() >= right.length() ? left : right;
            }
        }

        return s; 
        
    }
}