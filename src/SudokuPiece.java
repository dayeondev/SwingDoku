public class SudokuPiece {
    private int value;

    public SudokuPiece(){

    }
    public SudokuPiece(int _value){
        value = _value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
