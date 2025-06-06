class Solution {
    public String robotWithString(String s) {

        int n = s.length();
        char[] minSuffix = new char[n];
        minSuffix[n - 1] = s.charAt(n - 1);

        for(int i = n - 2; i >= 0; i--) {
            minSuffix[i] = (char) Math.min(s.charAt(i), minSuffix[i + 1]);
        }
        
        StringBuilder p = new StringBuilder();
        Stack<Character> t = new Stack<>();

        for(int i = 0; i < n; i++) {
            t.push(s.charAt(i));

            while(!t.isEmpty() && (i == n - 1 || t.peek() <= minSuffix[i + 1])) {
                p.append(t.pop());
            }
        }

        return p.toString();
    }
}