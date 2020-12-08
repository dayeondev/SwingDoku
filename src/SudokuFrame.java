import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SudokuFrame extends JFrame {

    private int[][] board = new int[9][9];
    private SudokuButton[][] button;
    private int size = 4;
	private int button_size = 40;

    public SudokuFrame(int board_size){
    	Container c = getContentPane();
        //테스트용 board 생성기
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                board[i][j] = 9;
                button[i][j] = new SudokuButton(board, this);
				c.add(button[i][j]);
            }
        }
        update();
		setTitle("Sudoku");
		setSize(size * button_size + 10, size * button_size + 10);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
     
    }
    
    public void update() {
		SudokuPiece[][] r = board.contents();
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++) {
				if (r[i][j] != null) {
					button[i][j].setBackground(Color.white);
					button[i][j].setText("" + r[i][j].getValue());
				}
			}
    }
}
