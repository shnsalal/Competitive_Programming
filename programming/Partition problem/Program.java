
public class Program {
    public static void main(String[] args) {
        int[] nums = {2,2,3,4,5,6,7};
        if(partition(nums)) {
            System.out.println("true");
        } else {   
            System.out.println("false");
        }
    }

    public static boolean partition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0) {
            return false;
        }

        return isSubArraySum(nums, nums.length, sum / 2);
    }

    public static boolean isSubArraySum(int[] nums, int n, int sum) {
        if(sum == 0) {
            return true;
        }

        if(n == 0 && sum != 0) {
            return false;
        }

        if(nums[n-1] > sum) {
            return isSubArraySum(nums, n-1, sum);
        }

        return isSubArraySum(nums, n-1, sum) || isSubArraySum(nums, n-1, sum - nums[n-1]);
    }
}