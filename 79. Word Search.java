class Solution {
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int i, int j, int index) {
        if (index == word.length())
            return true;
        int m = board.length;
        int n = board[0].length;
        // if the row.length smaller than 0 , OR , row bigger than row.length
        // OR , the cloumn.length smaller than 0 , OR , cloumn bigger than cloumn.length
        // OR , the character of word isn't match to board, return false
        if (i < 0 || i >= m || j < 0 || j >= n || word.charAt(index) != board[i][j])
            return false;

        char c = board[i][j];
        // when the found the match , notice to * to avoid eapeating index
        board[i][j] = '*';

        // search by up , down , left , right
        boolean founded = helper(board, word, i - 1, j, index + 1) || helper(board, word, i + 1, j, index + 1)
                || helper(board, word, i, j - 1, index + 1) || helper(board, word, i, j + 1, index + 1);

        board[i][j] = c;
        return founded;
    }
}