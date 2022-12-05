import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.JOptionPane;

public class TwoPlayersGame implements ActionListener, Serializable {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JInternalFrame warn = new JInternalFrame("frame1 ", true, true, true);
    JButton[] buttons = new JButton[9];
    JButton prev = new JButton("back");

    JOptionPane myOption = new JOptionPane();

    boolean player1_turn;

    TwoPlayersGame(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 90, 800, 800);

        frame.getContentPane().setBackground(new Color(255,255,255));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(213,221,215));
        textfield.setForeground(new Color(185, 138, 238));
        textfield.add(prev);
        textfield.setFont(new Font("MV Boli",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(213,221,215));

        for(int i=0;i<9;i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

            //buttons[i].setBackground(Color.black)
        }

        for(int i=0;i<9;i+=2){
            buttons[i].setBackground(Color.white);
        }
        for(int i=1;i<9;i+=2){
            buttons[i].setBackground(new Color(213,221,215));
        }

        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    public void firstTurn() {

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(random.nextInt(2)==0) {
            player1_turn=true;
            textfield.setText("X turn");
        }
        else {
            player1_turn=false;
            textfield.setText("O turn");
        }
    }

    public void check() {
        //check X win conditions
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[1].getText()=="X") &&
                        (buttons[2].getText()=="X")
        ) {
            xWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[5].getText()=="X")
        ) {
            xWins(3,4,5);
        }
        if(
                (buttons[6].getText()=="X") &&
                        (buttons[7].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(6,7,8);
        }
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[3].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            xWins(0,3,6);
        }
        if(
                (buttons[1].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[7].getText()=="X")
        ) {
            xWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="X") &&
                        (buttons[5].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(2,5,8);
        }
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(0,4,8);
        }
        if(
                (buttons[2].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            xWins(2,4,6);
        }
        //check O win conditions
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[1].getText()=="O") &&
                        (buttons[2].getText()=="O")
        ) {
            oWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[5].getText()=="O")
        ) {
            oWins(3,4,5);
        }
        if(
                (buttons[6].getText()=="O") &&
                        (buttons[7].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(6,7,8);
        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            oWins(0,3,6);
        }
        if(
                (buttons[1].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[7].getText()=="O")
        ) {
            oWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[5].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(2,5,8);
        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(0,4,8);
        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            oWins(2,4,6);
        }
    }

    public void xWins(int a,int b,int c) {
        buttons[a].setBackground(new Color(185, 138, 238));
        buttons[b].setBackground(new Color(185, 138, 238));
        buttons[c].setBackground(new Color(185, 138, 238));

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");

        //alert button
        String[] myOption = {"Main Menu", "Play Again"};
        int answer = JOptionPane.showOptionDialog(new JFrame(), "Game is over. What's next?", "Action", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, myOption, null);
        if (answer == JOptionPane.YES_OPTION) {
            frame.dispose();
            LaunchPage launchPage = new LaunchPage();
        } else if (answer == JOptionPane.NO_OPTION) {
            frame.dispose();
            TwoPlayersGame TwoPlayersGame = new TwoPlayersGame();
        }
    }

    int number = 9;
    public void oWins(int a,int b,int c) {
        buttons[a].setBackground(new Color(185, 138, 238));
        buttons[b].setBackground(new Color(185, 138, 238));
        buttons[c].setBackground(new Color(185, 138, 238));


        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");

        //alert button
        String[] myOption = {"Main Menu", "Play Again"};
        int answer = JOptionPane.showOptionDialog(new JFrame(), "Game is over. What's next?","Action",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, myOption, null);
        if(answer==JOptionPane.YES_OPTION){
            frame.dispose();
            LaunchPage launchPage = new LaunchPage();
        }
        else if(answer==JOptionPane.NO_OPTION){
            frame.dispose();
            TwoPlayersGame TwoPlayersGame = new TwoPlayersGame();
        }
    }

    public void draw(){
        textfield.setText("Draw");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<9;i++) {
            if(e.getSource()==buttons[i]) {
                if(player1_turn) {
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(239,199,72));
                        buttons[i].setText("X");
                        number -= 1;
                        player1_turn=false;
                        textfield.setText("O turn");
                        check();
                    }
                }
                else {
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(62,119,81));
                        buttons[i].setText("O");
                        number -= 1;
                        player1_turn=true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
            if (number == 0) {
                draw();
                String[] myOption = {"Main Menu", "Play Again"};
                int answer = JOptionPane.showOptionDialog(new JFrame(), "Game is over. What's next?","Action",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, myOption, null);
                if(answer==JOptionPane.YES_OPTION){
                    frame.dispose();
                    LaunchPage launchPage = new LaunchPage();
                }
                else if(answer==JOptionPane.NO_OPTION){
                    frame.dispose();
                    TwoPlayersGame TwoPlayersGame = new TwoPlayersGame();
                }
            }
        }
    }
}

