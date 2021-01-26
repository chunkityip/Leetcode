class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<Integer>();
    int factorial = 1;
    for (int i = 0; i < n; i++) {
        nums.add(i + 1);
        if (i != 0) {
            factorial *= i;
        }
    }
    factorial *= n; //先求出 n 的阶乘
    StringBuilder ans = new StringBuilder();
    k = k - 1; // k 变为 k - 1
    for (int i = n; i > 0; i--) { 
        factorial /= (nums.size()); //更新为 n - 1 的阶乘
        int groupNum = k / factorial;
        int num = nums.get(groupNum);
        nums.remove(groupNum);
        k = k % factorial;
        ans.append(num);  

        }
    return ans.toString();
    }
}