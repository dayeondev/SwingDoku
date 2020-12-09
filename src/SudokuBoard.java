public class SudokuBoard {
    private int size = 9;
    private SudokuPiece[][] answerBoard;
    private SudokuPiece[][] problemBoard;
    private SudokuProblemGenerator problem;

    public SudokuBoard(int _size, int _numberOfHoles){
        size = _size;
        problem = new SudokuProblemGenerator(size);
        answerBoard = problem.cloneBoard(problem.makeNewBoard());
        problemBoard = problem.makeHoles(problem.cloneBoard(answerBoard), _numberOfHoles);

    }

    public boolean isFill(int i, int j) {
        return answerBoard[i][j].getValue() != 0;
    }

    public SudokuPiece[][] getProblemBoard() {
        return problemBoard;
    }

    public void setProblemBoard(SudokuPiece[][] problemBoard) {
        this.problemBoard = problemBoard;
    }

    public SudokuPiece[][] getInitBoard() {
        return answerBoard;
    }

    public void setInitBoard(SudokuPiece[][] board) {
        this.answerBoard = board;
    }



    public boolean checkAnswer(SudokuPiece[][] _answerBoard, SudokuPiece[][] _problemBoard){

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(_answerBoard[i][j].getValue() != _problemBoard[i][j].getValue()){
                    return false;
                }
            }
        }

        return true;
    }










    public static void main(String[] args) {
        SudokuBoard sudokuBoard = new SudokuBoard(9, 10);

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(sudokuBoard.getInitBoard()[i][j].getValue() + " ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(sudokuBoard.getProblemBoard()[i][j].getValue()==0?"  ":sudokuBoard.getProblemBoard()[i][j].getValue() + " ");
            }
            System.out.println();
        }
    }
}
