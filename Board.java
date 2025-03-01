import Piece.PieceType;

public class Board {

    int rowSize;
    int colSize;
    PieceType[][] grid;
    int emptyCells;

    public Board(int rowSize, int colSize) {
        this.rowSize = rowSize;
        this.colSize = colSize;
        this.grid = new PieceType[rowSize][colSize];
        this.emptyCells = rowSize*colSize;
    }

    public boolean isFilled() {
        return emptyCells == 0;
    }

    private boolean checkEmpty(int row, int col) {
        if (grid[row][col] == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean addPiece(int row, int col, Player player) {
        if (checkEmpty(row, col)) {
            grid[row][col] = player.getPieceType();
            emptyCells--;
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < rowSize; i++) {
            // Print row with cell contents
            for (int j = 0; j < colSize; j++) {

                System.out.print(" " + PieceType.printForPiece(grid[i][j]) + " ");
                if (j < colSize - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();

            // Print row separators
            if (i < rowSize - 1) {
                for (int j = 0; j < colSize; j++) {
                    System.out.print("---");
                    if (j < colSize - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
    }

    private int getMax(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public boolean checkWin(int row, int col) {
        //check row
        int streak = 0;
        for (int j=0; j<colSize; j++) {
            if (grid[row][j] == null) {
                streak = 0;
            }
            else if (j==0 || grid[row][j-1] == null) {
                streak = 1;
            }
            else if (grid[row][j].equals(grid[row][j-1])) {
                streak++;
                if (streak == 3) {
                    return true;
                }
            }
            else {
                streak = 1;
            }
        }

        //check cols
        streak = 0;
        for (int j=0; j<rowSize; j++) {
            if (grid[j][col] == null) {
                streak = 0;
            }
            else if (j==0 || grid[j-1][col] == null) {
                streak = 1;
            }
            else if (grid[j][col].equals(grid[j-1][col])) {
                streak++;
                if (streak == 3) {
                    return true;
                }
            }
            else {
                streak = 1;
            }
        }

        //check diagonal left bottom to right top
        streak = 0;
        int sum = row + col;
        for (int i=0; i < colSize; i++) {
            if (!(0<=sum-i && sum-i<rowSize && i>=0 && i<colSize)) {
                continue;
            }
            else if (grid[sum-i][i] == null) {
                streak = 0;
            }
            else if (i==0 || sum-i == 0 || sum-i == rowSize-1 || i==colSize-1 || grid[sum-i+1][i-1] == null) {
                streak = 1;
            }
            else if (grid[sum-i][i].equals(grid[sum-i+1][i-1])) {
                streak++;
                if (streak == 3) {
                    return true;
                }
            }
            else {
                streak = 1;
            }
        }

        //check diagonal lef top to right bottom
        streak = 0;
        int min = getMin(row, col);
        for (int i=row-min, j=col-min; i < rowSize && j < colSize; i++, j++) {
            if (grid[i][j] == null) {
                streak = 0;
            }
            else if (i==0 || j==0 || grid[i-1][j-1] == null) {
                streak = 1;
            }
            else if (grid[i][j].equals(grid[i-1][j-1])) {
                streak++;
                if (streak == 3) {
                    return true;
                }
            }
            else {
                streak = 1;
            }
        }

        return false;
    }

    private int getMin(int a, int b) {
        if (a < b) {
            return a;
        }
        else {
            return b;
        }
    }
}
