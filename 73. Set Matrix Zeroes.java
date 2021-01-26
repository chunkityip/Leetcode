class Solution {
    public void setZeroes(int[][] matrix) {
        // set two boolean to check are firstrow and firstcolumn 0 ?
        boolean firstrow = false;
        boolean firstcol = false;

        int m = matrix.length;
        int n = matrix[0].length;

        // if firstrow or firstcolumn or both have 0 , set firstrow or firstcol to true
        // for later use
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        firstrow = true;
                    if (j == 0)
                        firstcol = true;

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // if firstcolunm is 0 , setting all column to 0
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // if firstrow is 0 , setting all row to 0
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // after change the column , we can fix the original firstcolunm
        if (firstrow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // after change the row, we can fix the original firstrow
        if (firstcol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}