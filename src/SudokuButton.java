import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SudokuButton extends JButton implements ActionListener {

	private SudokuBoard board;
	private SudokuFrame frame;
	private int button_num;
	private int col,row;
	
	public SudokuButton(SudokuBoard b, SudokuFrame f, int num, int i, int j) {
		board = b;
		frame = f;
		button_num = num;
		col = j;
		row = i;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (getText().equals("")) {
			String input = JOptionPane.showInputDialog("Select 1~9");
			if (button_num == Integer.parseInt(input)) {
				board.getSudokuBoard()[i][j].setvalue(button_num);
				frame.update();
				board.fillholes();  //빈칸에 숫자 넣기	
			}
		}
	}
	
	public static void main(String[] args) {
     
	}
}
