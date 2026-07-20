class Solution {
    public boolean search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            // 1. Found the target directly
            if (nums[mid] == target) {
                return true;
            }

            // 2. The Duplicate Trap: If start, mid, and end are all identical,
            // we can't tell which side is sorted. Shrink both ends safely!
            if (nums[s] == nums[mid] && nums[mid] == nums[e]) {
                s = s + 1;
                e = e - 1;
                continue; 
            }

            // 3. Left half is sorted normally
            if (nums[s] <= nums[mid]) {
                // Check if target falls strictly within the sorted left window
                if (target >= nums[s] && target < nums[mid]) {
                    e = mid - 1; 
                } else {
                    s = mid + 1; 
                }
            } 
            // 4. Right half is sorted normally
            else {
                // Check if target falls strictly within the sorted right window
                if (target > nums[mid] && target <= nums[e]) {
                    s = mid + 1; 
                } else {
                    e = mid - 1; 
                }
            }
        }

        return false;
    }
}