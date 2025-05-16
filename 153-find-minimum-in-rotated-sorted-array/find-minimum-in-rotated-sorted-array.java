class Solution {
    public int findMin(int[] nums) {
        int s = 0, e = nums.length - 1;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            mid = s + (e - s) / 2;

            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1])
                return nums[mid + 1];

            if (mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid];

            if (nums[mid] < nums[s]) {
                e = mid - 1;
            } else {
                if (nums[e] < nums[mid])
                    s = mid + 1;
                else
                    e = mid - 1;
            }
        }
        return nums[mid];
    }
}