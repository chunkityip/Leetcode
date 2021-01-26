class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return intervals;
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] lastArr = ans.get(ans.size() - 1);
            if (lastArr[1] >= intervals[i][0]) {
                lastArr[1] = Math.max(lastArr[1], intervals[i][1]);
            } else {
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}