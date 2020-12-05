public class SudokuProblemGenerator {
    private int size;
    private SudokuPiece[][] board;

    public SudokuProblemGenerator(int _size){
        size = _size;

    }

    public SudokuPiece[][] cloneBoard(SudokuPiece[][] _board){
        SudokuPiece[][] result = new SudokuPiece[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                result[i][j] = new SudokuPiece(_board[i][j].getValue());
            }
        }
        return result;
    }

    public SudokuPiece[] shake(SudokuPiece[] arr){
        return new SudokuPiece[]{   arr[1], arr[2], arr[0],
                            arr[4], arr[5], arr[3],
                            arr[7], arr[8], arr[6]
                        };
    }

    public SudokuPiece[] shake2(SudokuPiece[] arr){
        return new SudokuPiece[]{   arr[3], arr[4], arr[5],
                            arr[6], arr[7], arr[8],
                            arr[0], arr[1], arr[2]
                        };
    }

    public int[] shuffle(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int n1 = (int)(Math.random()*arr.length);
            int n2 = (int)(Math.random()*arr.length);
            int tmp = arr[n1];
            arr[n1] = arr[n2];
            arr[n2] = tmp;
        }

        return arr;
    }

    private SudokuPiece[][] initBoard(){
        SudokuPiece[][] _board = new SudokuPiece[size][size];

        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                _board[i][j] = new SudokuPiece();
            }
        }

        int[] mixedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        mixedNumbers = shuffle(mixedNumbers);
        for(int i = 0; i < size; i++){
            _board[0][i].setValue(mixedNumbers[i]);
        }
        _board[1] = shake2(_board[0]);
        _board[2] = shake2(_board[1]);
        _board[3] = shake(_board[0]);
        _board[4] = shake2(_board[3]);
        _board[5] = shake2(_board[4]);
        _board[6] = shake(_board[3]);
        _board[7] = shake2(_board[6]);
        _board[8] = shake2(_board[7]);

        return _board;
    }

    public SudokuPiece[][] makeNewBoard() {
        board = initBoard();
        for(int i = 0; i < 3; i++){
            int n1 = (int)(Math.random()*3);
            int n2 = (int)(Math.random()*3);
            SudokuPiece[] tmp = board[n1];
            board[n1] = board[n2];
            board[n2] = tmp;

            n1 = (int)(Math.random()*3);
            n2 = (int)(Math.random()*3);
            tmp = board[n1+3];
            board[n1+3] = board[n2+3];
            board[n2+3] = tmp;

            n1 = (int)(Math.random()*3);
            n2 = (int)(Math.random()*3);
            tmp = board[n1+6];
            board[n1+6] = board[n2+6];
            board[n2+6] = tmp;
        }
        board = cloneBoard(board);

        return board;
    }

    public SudokuPiece[][] makeHoles(SudokuPiece[][] _board, int _numberOfHoles) {

        int numberOfHoles = _numberOfHoles;

        int i, j;

        while(numberOfHoles > 0){

            i = (int)(Math.random()*(size-1));
            j = (int)(Math.random()*(size-1));


            if(_board[i][j].getValue() != 0){
                _board[i][j].setValue(0);
                numberOfHoles--;
            }
        }



        return _board;
    }

////보드 테스트 코드입니다.
//    public static void main(String[] args) {
//        SudokuProblemGenerator testSPG = new SudokuProblemGenerator(9);
//        SudokuPiece[][] testBoard = testSPG.makeNewBoard();
//        for(int i = 0; i < 9; i++){
//            for(int j = 0; j < 9; j++){
//                System.out.print(testBoard[i][j].getValue() + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//
//        testBoard = testSPG.makeHoles(testBoard, 10);
//        for(int i = 0; i < 9; i++){
//            for(int j = 0; j < 9; j++){
//                System.out.print(testBoard[i][j].getValue()==0?"  ":testBoard[i][j].getValue() + " ");
//            }
//            System.out.println();
//        }
//
//    }
}
