class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0]; 
        int currentSum = nums[0]; //Selim 22bcs13878
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
 {
    
}
