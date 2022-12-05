import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class Rec implements ActionListener {
    JFrame frame;
    JTable table;

    Rec(){
        frame= new JFrame();
        frame.setVisible(true);
        frame.setSize(200, 300);

        table = new JTable();
        table.setBounds(30, 40, 200, 300);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
