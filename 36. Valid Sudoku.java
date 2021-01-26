/* Basically , I have no idea how to do so. Just looking the solution
https://leetcode.com/problems/valid-sudoku/discuss/15472/Short%2BSimple-Java-using-Strings

Every time when we saw "without repetition" , we can think of HashSet or HashMap.
In this case , HashSet can do the jon

if any of the box is not "."
add the value into the box 

if any of value are repetition , just return false 

*/


    public boolean isValidSudoku(char [][] board) {
        HashSet<String> found = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if(board[i][j] != ".") {
                    if(!found.add(num + " found in row " + i) ||
                        !found.add(num + " found in column " + j  ||
                        !found.add(num + " found in sub box " + i / 3 + " - " + j / 3){
                            return false;
                    }
                }
            }
        return true;
}
