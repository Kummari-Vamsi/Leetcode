class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];
        String ans = "none";
        if(a + b > c && b + c > a && c + a > b) {
            if(a == b && b == c && c == a) {
                ans = "equilateral";
            } else if(a == b || b == c || c == a) {
                ans = "isosceles";
            } else {
                ans = "scalene";
            }
        }
        return ans;
    }
}