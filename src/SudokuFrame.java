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
    	JPanel cp = new JPanel();
    	cp.setLayout(new BorderLayout());
        JPanel sudokuBoardPanel = new JPanel(new GridLayout(9, 9));
        button = new SudokuButton[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                button[i][j] = new SudokuButton(board, this,1, i, j);
                button[i][j].setPreferredSize(new Dimension(button_size, button_size));
				sudokuBoardPanel.add(button[i][j]);
            }
        }
        cp.add(sudokuBoardPanel, BorderLayout.NORTH);
//        cp.add(answer);

        JPanel setNumberButtonPanel = new JPanel(new GridLayout(1, 9));
        setNumberButton = new SudokuSetNumberButton[9];
        for(int i = 0; i < 9; i++){
            setNumberButton[i] = new SudokuSetNumberButton(i+1, this, board);
            setNumberButton[i].setText("" + (i+1));
            setNumberButton[i].setPreferredSize(new Dimension(button_size, button_size));
            setNumberButtonPanel.add(setNumberButton[i]);
        }


        cp.add(setNumberButtonPanel, BorderLayout.SOUTH);

        update();

        JOptionPane.showMessageDialog(null, "[게임방법]\n화면은 9*9의 스도쿠 보드와 하단의 버튼으로 구성되어 있습니다.\n스도쿠 보드의 빈 칸을 클릭한 후 하단의 숫자 버튼으로 정답을 맞추어보세요.");

        setContentPane(cp);
		setTitle("Sudoku");
		setSize(size * button_size + 10, size * button_size + 110);
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
