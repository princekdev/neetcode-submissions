
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int num : map.keySet()) {
            int freq = map.get(num);
            buckets[freq].add(num);
        }

        int[] ans = new int[k];
        int index = 0;

        for (int i = nums.length; i >= 1; i--) {
            for (int num : buckets[i]) {
                ans[index] = num;
                index++;

                if (index == k) {
                    return ans;
                }
            }
        }

        return ans;
    }
}
