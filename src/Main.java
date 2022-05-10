public class Main {
    static int[][] board = new int[8][8];

    public static void main(String[] args) {
        Main test = new Main();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = 0;
            }
        }
        test.tryQueen(0);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == -1) {
                    System.out.print("[] ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    private boolean tryQueen (int i) {
        boolean result = false;
        for (int j = 0; j < 8; j++) {
            if (board[i][j] == 0) {
                setQueen(i, j);
                if (i == 7) {
                    result = true;
                } else {
                    if (!(result = tryQueen(i + 1))) {
                        resetQueen(i, j);
                    }
                }
            }
            if (result)
                break;
        }
        return result;
    }

    private void setQueen (int i, int j){
        for (int x = 0; x < 8; x++) {
            ++board[x][j];
            ++board[i][x];
            int d;
            d = j - i + x;
            if (d >= 0 && d < 8) {
                ++board[x][d];
            }
            d = j + i - x;
            if (d >= 0 && d < 8) {
                ++board[x][d];
            }
            board[i][j] = -1;
        }
    }

    private void resetQueen (int i, int j){
        for (int x = 0; x < 8; x++) {
            --board[x][j];
            --board[i][x];
            int d;
            d = j - i + x;
            if (d >= 0 && d < 8) {
                --board[x][d];
            }
            d = j + i - x;
            if (d >= 0 && d < 8) {
                --board[x][d];
            }
            board[i][j] = 0;
        }
    }
}