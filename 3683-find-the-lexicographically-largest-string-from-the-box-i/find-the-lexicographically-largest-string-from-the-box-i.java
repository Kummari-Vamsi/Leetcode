class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1)
            return word;
        int n = word.length(), i, end;
        int split_length = n - numFriends;
        String cur = "", m = "";
        for (i = 0; i < n; i++) {
            end = Math.min(n, i + split_length + 1);
            cur = word.substring(i, end);
            if (cur.compareTo(m) > 0) {
                m = cur;
            }
        }
        return m;
    }
}