//88. Merge Sorted Array

//What I was thinking:
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = 0, j = 0;
    //遍历 nums2
    while (j < n) {
        //判断 nums1 是否遍历完
        //（nums1 原有的数和当前已经插入的数相加）和 i 进行比较
        if (i == m + j) {
            //将剩余的 nums2 插入
            while (j < n) {
                nums1[m + j] = nums2[j];
                j++;
            }
            return;
        }
        //判断当前 nums2 是否小于 nums1
        if (nums2[j] < nums1[i]) {
            //nums1 后移数组，空出位置以便插入
            for (int k = m + j; k > i; k--) {
                nums1[k] = nums1[k - 1];
            }
            nums1[i] = nums2[j];
            //i 和 j 后移
            j++;
            i++;
        //当前 nums2 不小于 nums1， i 后移
        }else{ 
               i++;  
        }
    }
}

//The better solution
class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        int i=m-1;
		int j=n-1;
		int k = m+n-1;
		while(i >=0 && j>=0)
		{
			if(A[i] > B[j])
				A[k--] = A[i--];
			else
				A[k--] = B[j--];
		}
		while(j>=0)
			A[k--] = B[j--];
    }
};