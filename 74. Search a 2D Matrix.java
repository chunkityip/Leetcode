// https://www.youtube.com/watch?v=FOa55B9Ikfg
// http://icarus.cs.weber.edu/~dab/cs1410/textbook/7.Arrays/row_major.html

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //whenever the array is sorted, use binary search
        if (matrix.length == 0) return false;
        int m = matrix.length,  n = matrix[0].length;
        int start = 0, end = m * n - 1;
        while (start <= end) {
            //changing the 2d array to 1d array
            int mid = start + (end - start) / 2;
            int mid_value = matrix[mid / n][mid % n];
            if (target == mid_value) {
                return true;
            } else if (target < mid_value) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}