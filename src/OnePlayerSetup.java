import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class OnePlayerSetup implements ActionListener {

    JFrame frame= new JFrame();
    // Components of the Form
     Container c;
     JLabel title;
     JLabel name;
     JTextField tname;
     JLabel chooseXO;
     JRadioButton X;
     JRadioButton O;
     ButtonGroup choose;

     JButton backBtn;
    JButton submitBtn;

    public String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        java.util.Date date = new Date();
        return dateFormat.format(date);
    }

    // constructor, to initialize the components
    // with default values.
    public OnePlayerSetup(){
        //setTitle("Registration Form");
        frame.setBounds(300, 90, 500, 400);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);


         c = frame.getContentPane();
        c.setLayout(null);

        title = new JLabel("Tic Tac Toe");
        title.setFont(new Font("MV Boli", Font.BOLD, 30));
        title.setSize(300, 30);
        title.setLocation(150, 30);
        c.add(title);

        name = new JLabel("Your Name");
        name.setFont(new Font("MV Boli", Font.PLAIN, 20));
        name.setSize(200, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("MV Boli", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(250, 100);
        c.add(tname);

        chooseXO = new JLabel("Choose");
        chooseXO.setFont(new Font("MV Boli", Font.PLAIN, 20));
        chooseXO.setSize(100, 20);
        chooseXO.setLocation(100, 150);
        c.add(chooseXO);

        X = new JRadioButton("X");
        X.setFont(new Font("MV Boli", Font.PLAIN, 15));
        X.setSelected(true);
        X.setSize(75, 20);
        X.setFocusable(false);
        X.setLocation(200, 150);
        c.add(X);

        O = new JRadioButton("O");
        O.setFont(new Font("MV Boli", Font.PLAIN, 15));
        O.setSelected(false);
        O.setSize(80, 20);
        O.setFocusable(false);
        O.setLocation(275, 150);
        c.add(O);

      choose = new ButtonGroup();
      choose.add(X);
      choose.add(O);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("MV Boli", Font.PLAIN, 15));
        backBtn.setBackground(new Color(155, 180, 249));
        backBtn.setForeground(new Color(240,240,240));
        backBtn.setSize(100, 20);
        backBtn.setLocation(200, 200);
        backBtn.setFocusable(false);
        backBtn.addActionListener(this);

        submitBtn = new JButton("Submit");
        submitBtn.setFont(new Font("MV Boli", Font.PLAIN, 15));
        submitBtn.setBackground(new Color(91,222,255));
        submitBtn.setForeground(new Color(240,240,240));
        submitBtn.setSize(100, 20);
        submitBtn.setLocation(335, 200);
        submitBtn.setFocusable(false);
        submitBtn.addActionListener(this);

        c.add(submitBtn);
        c.add(backBtn);

       // frame.add(c);

        frame.setVisible(true);
    }



    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        String xPlayerName = null, oPlayerName = null;
        if(X.isSelected()){
            xPlayerName = tname.getText();
            oPlayerName = "Computer";
        } if(O.isSelected()){
        oPlayerName = tname.getText();
        xPlayerName = "Computer";
      }

        if(e.getSource()==submitBtn){
            frame.dispose();
            OnePlayerGame onePlayerGame = new OnePlayerGame(getDate(), xPlayerName, oPlayerName);
        } else if (e.getSource()==backBtn) {
            frame.dispose();
            LaunchPage launchPage = new LaunchPage();

        }


    }
}
