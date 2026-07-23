class Solution {

    void rc(List<List<Integer>> ans, List<Integer> curr,
            int idx, int target, int[] nums) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (idx == nums.length || target < 0)
            return;

        // Include current element
        curr.add(nums[idx]);
        rc(ans, curr, idx + 1, target - nums[idx], nums);
        curr.remove(curr.size() - 1);

        // Skip duplicates while excluding
        int next = idx + 1;
        while (next < nums.length && nums[next] == nums[idx]) {
            next++;
        }

        rc(ans, curr, next, target, nums);
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        rc(ans, new ArrayList<>(), 0, target, nums);

        return ans;
    }
}