import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SudokuFrame extends JFrame {

    private SudokuBoard board;
    private SudokuButton[][] button;
    private SudokuSetNumberButton[] setNumberButton;
    private int size = 9;
	private int button_size = 50;
    private SudokuPiece[][] problemBoard;
    private String BLANKS = "            ";
    private JLabel answer = new JLabel(BLANKS);
    private int selectedI, selectedJ;

    public int getSelectedI() {
        return selectedI;
    }

    public void setSelectedI(int selectedI) {
        this.selectedI = selectedI;
    }

    public int getSelectedJ() {
        return selectedJ;
    }

    public void setSelectedJ(int selectedJ) {
        this.selectedJ = selectedJ;
    }

    public SudokuFrame(SudokuBoard _board){
        board = _board;
    	Container cp = getContentPane();
    	cp.setLayout(new GridLayout(3, 1));
        JPanel sudokuBoardPanel = new JPanel(new GridLayout(9, 9));
        button = new SudokuButton[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                button[i][j] = new SudokuButton(board, this,1, i, j);
				sudokuBoardPanel.add(button[i][j]);
            }
        }
        cp.add(sudokuBoardPanel);
        cp.add(answer);

        JPanel setNumberButtonPanel = new JPanel(new GridLayout(1, 9));
        setNumberButton = new SudokuSetNumberButton[9];
        for(int i = 0; i < 9; i++){
            setNumberButton[i] = new SudokuSetNumberButton(i+1, this, board);
            setNumberButton[i].setText("" + (i+1));
            setNumberButtonPanel.add(setNumberButton[i]);
        }

        cp.add(setNumberButtonPanel);

        update();
		setTitle("Sudoku");
		setSize(size * button_size + 10, size * button_size + 10);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
     
    }
    
    public void update() {
		problemBoard = board.getProblemBoard();
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++) {
				if (problemBoard[i][j] != null) {
					button[i][j].setBackground(Color.white);
					button[i][j].setText("" + (problemBoard[i][j].getValue()!=0?problemBoard[i][j].getValue():""));
				}
			}
    }
}
