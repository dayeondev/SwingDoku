public class SudokuStarter {
    public static void main(String[] args) {
        int SIZE = 9;
        int hole = 10;
        SudokuBoard sudokuBoard = new SudokuBoard(SIZE, hole);
        new SudokuFrame(sudokuBoard);
    }
}
