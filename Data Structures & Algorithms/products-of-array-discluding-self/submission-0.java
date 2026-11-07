
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // Step 1: Store prefix products
        int prefix = 1;

        for (int i = 0; i < n; i++) {
            output[i] = prefix;
            prefix = prefix * nums[i];
        }

        // Step 2: Multiply with suffix products
        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {
            output[i] = output[i] * suffix;
            suffix = suffix * nums[i];
        }

        return output;
    }
}
