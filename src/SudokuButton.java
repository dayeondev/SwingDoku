import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SudokuButton extends JButton implements ActionListener {

	private SudokuBoard board;
	private SudokuFrame frame;
	private int button_num;
	private int arr_i,arr_j;
	
	public SudokuButton(SudokuBoard _board, SudokuFrame _frame, int num, int _i, int _j) {
		board = _board;
		frame = _frame;
		button_num = board.getInitBoard()[_i][_j].getValue();
		arr_i = _i;
		arr_j = _j;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		frame.setSelectedI(arr_i);
		frame.setSelectedJ(arr_j);
//		String s = getText();
//		String input = JOptionPane.showInputDialog("1에서 9 사이의 숫자를 넣어주세요.");
//		if (button_num == Integer.parseInt(input)) {
//			board.getProblemBoard()[arr_i][arr_j].setValue(button_num);
//			frame.update();
//			JOptionPane.showMessageDialog(null, "정답입니다 :)");
//		}
//		else{
//			JOptionPane.showMessageDialog(null, "다른 숫자를 입력해주세요 :(");
//		}
	}

}
