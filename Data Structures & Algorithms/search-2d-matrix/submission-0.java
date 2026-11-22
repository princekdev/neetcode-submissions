
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0, high = m - 1;

        // Find the possible row
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target < matrix[mid][0]) {
                high = mid - 1;
            } 
            else if (target > matrix[mid][n - 1]) {
                low = mid + 1;
            } 
            else {
                // Binary search in the selected row
                int l = 0, r = n - 1;

                while (l <= r) {
                    int mid2 = l + (r - l) / 2;

                    if (matrix[mid][mid2] == target)
                        return true;
                    else if (matrix[mid][mid2] < target)
                        l = mid2 + 1;
                    else
                        r = mid2 - 1;
                }

                return false;
            }
        }

        return false;
    }
}
