// 57. Insert Interval
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(new int[] { intervals[i][0], intervals[i][1] });
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(new int[] { newInterval[0], newInterval[1] });

        while (i < intervals.length) {
            list.add(new int[] { intervals[i][0], intervals[i][1] });
            i++;
        }

        int[][] ans = new int[list.size()][2];
        for (i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }
}
