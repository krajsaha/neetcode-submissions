class Solution {

    int partition(int l, int h, int[] nums) {
        int pivot = nums[l];
        int i = l - 1;
        int j = h + 1;

        while (true) {
            // Look for element bigger than or equal to pivot from the left
            do {
                i++;
            } while (nums[i] < pivot);

            // Look for element smaller than or equal to pivot from the right
            do {
                j--;
            } while (nums[j] > pivot);

            // If pointers cross or meet, return the split index
            if (i >= j) {
                return j;
            }

            // Swap elements out of place
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    void quickSort(int l, int h, int[] nums) {
        if (l < h) {
            int pivotIdx = partition(l, h, nums);
            // Hoare partition divides the array into [l, pivotIdx] and [pivotIdx + 1, h]
            quickSort(l, pivotIdx, nums);
            quickSort(pivotIdx + 1, h, nums);
        }
    }

    public int[] sortArray(int[] nums) {
        quickSort(0, nums.length - 1, nums);
        return nums;
    }
}