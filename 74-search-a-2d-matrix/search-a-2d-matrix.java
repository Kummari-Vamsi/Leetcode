class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length - 1;
        if(end == 0){
            return binarySearch(matrix[0], target);
        }
        while(start <= end){
            int mid = start + (end - start)/2;
            if(matrix[mid][matrix[mid].length -1] >= target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        if(start == matrix.length){
            return false;
        }
        return binarySearch(matrix[start], target);
    }
    public boolean binarySearch(int[] arr, int target){
        int start = 0, end = arr.length - 1;
        while(end >= start){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return false;
    }
}