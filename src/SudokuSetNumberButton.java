import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuSetNumberButton extends JButton implements ActionListener {

    private int num;
    private SudokuFrame frame;
    private SudokuBoard board;
    private int selectedI;
    private int selectedJ;

    public SudokuSetNumberButton(int _num, SudokuFrame _frame, SudokuBoard _board) {
        num = _num;
        frame = _frame;
        board = _board;
        addActionListener(this);
    }



    public void actionPerformed(ActionEvent e) {
        selectedI = frame.getSelectedI();
        selectedJ = frame.getSelectedJ();

        if (board.getInitBoard()[selectedI][selectedJ].getValue()==num) {
            board.getProblemBoard()[selectedI][selectedJ].setValue(num);
            frame.update();
            JOptionPane.showMessageDialog(null, "정답입니다 :)");
        }
        else{
            JOptionPane.showMessageDialog(null, "다른 숫자를 입력해주세요 :(");
        }
    }
}
