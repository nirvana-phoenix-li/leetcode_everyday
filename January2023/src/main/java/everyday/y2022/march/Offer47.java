package everyday.y2022.march;

public class Offer47 {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dpHelpSquare = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dpHelpSquare[i][j] = grid[i][j];
                } else if (i == 0 && j != 0) {
                    dpHelpSquare[i][j] = grid[i][j] + dpHelpSquare[i][j - 1];
                } else if (i != 0 && j == 0) {
                    dpHelpSquare[i][j] = grid[i][j] + dpHelpSquare[i - 1][j];
                } else if (i != 0 && j != 0) {
                    int max = Math.max(dpHelpSquare[i - 1][j], dpHelpSquare[i][j - 1]);
                    dpHelpSquare[i][j] = grid[i][j] + max;
                }
            }
        }

        return dpHelpSquare[row - 1][col - 1];
    }

    public static void main(String[] args) {
        Offer47 main = new Offer47();

    }
}
