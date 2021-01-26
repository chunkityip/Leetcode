/* 11. Container With Most Water

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with 
x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
*/

/* when I saw the question, I was confuse that why wasn't 8 * 8 = 64 but is 7 * 7 = 49
However, the questuon ask [x-axis] which mean the contains the most water by both x area and y area.

/* Solution 1 : Brute Force
By comparing each container and container + 1 to see which one contains the most Water

1 as i , j as 8 ,6 ,2 ,5 , 4 , 8 , 3 ,7 : the number of most water contain only 8x and 1y
8 as i , j as 6 ,2 ,5, 4 , 8 , 3 ,7 : the number of most water contain are 7x and 49y(7 * 7)
6 as i , j as 2 ,5, 4 , 8 , 3 ,7 : the number of most water contain are 6x and 36y(6 * 6)
.
.
.
8 as i , j as 7 : the number of most water contain are 1x and 49y(7* 7)
so the answer is 49

we see the pattern here. which contaier is smaller will determine the water number 
so , area = (right - left) * Min(leftHeight , rightHeight)

and then , by compare step by step, we need to found the most water.
so, answer = Max(area, areaN)
*/

//the method will be left - right * Min(nums[i], nums[j])

class Solution {
    public int maxArea(int[] height) {
        int left = 0 , right = height.length - 1 , ans = 0;
        while (left < right) {
            ans = Math.max(ans, Math.min(height[left] , height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
/* Time complexity : O(n2)
Space complexity: O(1)

/* Solution2 : Two Pointer
As we know , the answer are base on height and wight. Therefore, who have the most water and
also most height will be the answer;

Therefore , check the first container and last container becuase we have most height 
if first container smaller than last one , first go forward.
if last container samller than first one , last go backward.
so, it is two pointer.
*/
class Solution {
    public int maxArea(int[] height) {
        int ans = 0 , left = 0, right = height.length - 1;
        while (left < right) {
            ans = Math.max(ans, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
/* Time complexity: O(n)
Space complexity: O(1)