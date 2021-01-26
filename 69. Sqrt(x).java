//69. Sqrt(x)
class Solution {
    public int mySqrt(int x) {
        int start =1;
        int end = x;
        int answer =0;
        while(start<=end){
            int mid = start + (end -start)/2;
            int div = x /mid;
            if (div == mid){
                return mid;
            }else if ( mid < div){
                answer = mid;
                start = mid +1;
            }else{
                end = mid -1;
            }
        }
    return answer;
}
}