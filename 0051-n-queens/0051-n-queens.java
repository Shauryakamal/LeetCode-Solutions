class Solution {
     public static boolean isSafe(int row, int col, int[] queens) {

        // Check previous rows
        for (int i = 0; i < row; i++) {

            int previousCol = queens[i];

            // Same column
            if (col == previousCol) {
                return false;
            }

            // Diagonal
            if (Math.abs(row - i) == Math.abs(col - previousCol)) {
                return false;
            }
        }

        return true;
    }

    // Backtracking
    public static void solve(
            int row,
            int n,
            int[] queens,
            List<List<String>> result) {

        // Base Case: All queens placed
        if (row == n) {

            List<String> board = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                StringBuilder currentRow = new StringBuilder();

                for (int j = 0; j < n; j++) {

                    if (queens[i] == j) {
                        currentRow.append('Q');
                    } else {
                        currentRow.append('.');
                    }
                }

                board.add(currentRow.toString());
            }

            result.add(board);
            return;
        }

        // Try every column in current row
        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, queens)) {

                // Place queen
                queens[row] = col;

                // Explore next row
                solve(row + 1, n, queens, result);

                // Backtracking: remove queen
                queens[row] = -1;
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {

        int[] queens = new int[n];

        Arrays.fill(queens, -1);

        List<List<String>> result = new ArrayList<>();

        solve(0, n, queens, result);

        return result;
}
}