import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.net.URL;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;
import javax.swing.JOptionPane;

public class OnePlayerGameO implements ActionListener, Serializable {

    //SQL details
    String uname = "root";
    String password = "aet4gieh9etie3Nokoo7bai4";
    String query = "INSERT INTO gameHistory(Date, X_Player, O_Player, Winner, No)";
    String url = "jdbc:mysql://65.108.218.58:33306/TicTacToe?autoReconnect=true&useSSL=false";

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JInternalFrame warn = new JInternalFrame("frame1 ", true, true, true);
    JButton[] buttons = new JButton[9];
    JButton prev = new JButton("back");
    int bugFixerCounter = 0;

    JOptionPane myOption = new JOptionPane();

    public String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        java.util.Date date = new Date();
        return dateFormat.format(date);
    }

    boolean player1_turn;
    String date, xPlayerName, oPlayerName;
    OnePlayerGameO(String date, String xPlayerName, String oPlayerName){

        bugFixerCounter = 0;

        URL iconURL = getClass().getResource("logo.jpg");
        // iconURL is null when not found
        ImageIcon icon = new ImageIcon(iconURL);
        frame.setIconImage(icon.getImage());

        this.xPlayerName = xPlayerName;
        this.oPlayerName = oPlayerName;
        this.date = date;

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
        textfield.setText("Your turn");
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

        player1_turn = true;
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
        else{
            int counter = 0;
            for (int i=0;i<9;i++){
                if (buttons[i].getText() != ""){
                    counter+=1;
                }
                if(counter == 9){
                    draw();
                }
            }
        }
    }

    public void xWins(int a,int b,int c) {

        if(bugFixerCounter == 0){
            bugFixerCounter +=1;
            buttons[a].setBackground(new Color(185, 138, 238));
            buttons[b].setBackground(new Color(185, 138, 238));
            buttons[c].setBackground(new Color(185, 138, 238));

            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            textfield.setText("X wins");

            //Writing to database
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
                throw new RuntimeException(e1);
            }

            try {
                Connection con = DriverManager.getConnection(url, uname, password);
                Statement statement = con.createStatement();

                int No = 0;
                ResultSet result = statement.executeQuery("select MAX(No) FROM gameHistory;");
                if(result.next()){
                    No = result.getInt(1)+1;
                }

                statement.executeUpdate(query + " VALUES('" + date +"', '" + xPlayerName +"', '" + oPlayerName + "', '" +
                        xPlayerName + "' , " + No+" );");
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            //alert button
            String[] myOption = {"Main Menu", "Play Again"};
            int answer = JOptionPane.showOptionDialog(new JFrame(), "Game is over. "+xPlayerName+" wins. What's next?", "Action", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, myOption, null);

            if (answer == JOptionPane.YES_OPTION) {
                frame.dispose();
                LaunchPage launchPage = new LaunchPage();
            } else if (answer == JOptionPane.NO_OPTION) {
                number = 9;
                frame.dispose();
                OnePlayerGameO OnePlayerGameO = new OnePlayerGameO(getDate(), xPlayerName, oPlayerName);
            }
        }
    }

    int number = 9;

    public void oWins(int a,int b,int c) {

        if(bugFixerCounter == 0){
            bugFixerCounter +=1;
            buttons[a].setBackground(new Color(185, 138, 238));
            buttons[b].setBackground(new Color(185, 138, 238));
            buttons[c].setBackground(new Color(185, 138, 238));


            for(int i=0;i<9;i++) {
                buttons[i].setEnabled(false);
            }
            textfield.setText("O wins");


//Writing to database
            try {
                Connection con = DriverManager.getConnection(url, uname, password);
                Statement statement = con.createStatement();

                int No = 0;
                ResultSet result = statement.executeQuery("select MAX(No) FROM gameHistory;");
                if(result.next()){
                    No = result.getInt(1) + 1;
                }

                statement.executeUpdate(query + " VALUES('" + date +"', '" + xPlayerName +"', '" + oPlayerName + "', '" +
                        oPlayerName + "' , " + No+" );");
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            //alert button
            String[] myOption = {"Main Menu", "Play Again"};
            int answer = JOptionPane.showOptionDialog(new JFrame(), "Game is over. "+oPlayerName+" wins. What's next?","Action",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, myOption, null);
            if(answer==JOptionPane.YES_OPTION){
                frame.dispose();
                LaunchPage launchPage = new LaunchPage();
            }
            else if(answer==JOptionPane.NO_OPTION){
                number = 9;
                frame.dispose();
                OnePlayerGameO OnePlayerGameO = new OnePlayerGameO(getDate(), xPlayerName, oPlayerName);
            }
        }
    }

    public void draw(){

        if (bugFixerCounter == 0){
            bugFixerCounter +=1;
            for(int i=0;i<9;i++) {
                buttons[i].setEnabled(false);
            }
            textfield.setText("Draw");

            //Writing to database
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
                throw new RuntimeException(e1);
            }

            try {
                Connection con = DriverManager.getConnection(url, uname, password);
                Statement statement = con.createStatement();

                int No = 0;
                ResultSet result = statement.executeQuery("select MAX(No) FROM gameHistory;");
                if(result.next()){
                    No = result.getInt(1)+1;
                }

                statement.executeUpdate(query + " VALUES('" + date +"', '" + xPlayerName +"', '" + oPlayerName + "', '" +
                        "=DRAW=" + "'," + No+");");
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            //alert button
            String[] myOption = {"Main Menu", "Play Again"};
            int answer = JOptionPane.showOptionDialog(new JFrame(), "Game is over.It's DRAW. What's next?","Action",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, myOption, null);
            if(answer==JOptionPane.YES_OPTION){
                frame.dispose();
                LaunchPage launchPage = new LaunchPage();
            }
            else if(answer==JOptionPane.NO_OPTION){
                number = 9;
                frame.dispose();
                OnePlayerGameO OnePlayerGameO = new OnePlayerGameO(getDate(), xPlayerName, oPlayerName);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++) {
            if(e.getSource()==buttons[i]) {
                if(player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(239, 199, 72));
                        buttons[i].setText("O");
                        player1_turn = false;
                        check();
                    }
                }
                if (player1_turn == false) {
                    computer();
                    check();
                }
            }
        }
    }
    public void setX(int index) {
        buttons[index].setForeground(new Color(62,119,81));
        buttons[index].setText("X");
        number -= 1;
        player1_turn=true;
        textfield.setText("Your turn");
        check();
    }

    public void computer() {
        // 1st row for O
        if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "")) {
            setX(2);
        }
        else if ((buttons[0].getText() == "X") && (buttons[2].getText() == "X") && (buttons[1].getText() == "")) {
            setX(1);
        }
        else if ((buttons[0].getText() == "") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
            setX(0);
        }
        // 2nd row for O
        else if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "")) {
            setX(5);
        }
        else if ((buttons[3].getText() == "X") && (buttons[5].getText() == "X") && (buttons[4].getText() == "")) {
            setX(4);
        }
        else if ((buttons[3].getText() == "") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
            setX(3);
        }
        // 3rd row for O
        else if ((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "")) {
            setX(8);
        }
        else if ((buttons[6].getText() == "X") && (buttons[8].getText() == "X") && (buttons[7].getText() == "")) {
            setX(7);
        }
        else if ((buttons[6].getText() == "") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
            setX(6);
        }
        // 1st column for O
        else if ((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "")) {
            setX(6);
        }
        else if ((buttons[0].getText() == "X") && (buttons[6].getText() == "X") && (buttons[3].getText() == "")) {
            setX(3);
        }
        else if ((buttons[0].getText() == "") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
            setX(0);
        }
        // 2nd column for O
        else if ((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "")) {
            setX(7);
        }
        else if ((buttons[1].getText() == "X") && (buttons[7].getText() == "X") && (buttons[4].getText() == "")) {
            setX(4);
        }
        else if ((buttons[1].getText() == "") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
            setX(1);
        }
        // 3rd column for O
        else if ((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "")) {
            setX(8);
        }
        else if ((buttons[2].getText() == "X") && (buttons[8].getText() == "X") && (buttons[5].getText() == "")) {
            setX(5);
        }
        else if ((buttons[2].getText() == "") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
            setX(2);
        }
        // 1st diagonal for O
        else if ((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "")) {
            setX(8);
        }
        else if ((buttons[0].getText() == "X") && (buttons[8].getText() == "X") && (buttons[4].getText() == "")) {
            setX(4);
        }
        else if ((buttons[0].getText() == "") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")) {
            setX(0);
        }
        // 2nd diagonal for O
        else if ((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "")) {
            setX(6);
        }
        else if ((buttons[2].getText() == "X") && (buttons[6].getText() == "X") && (buttons[4].getText() == "")) {
            setX(4);
        }
        else if ((buttons[2].getText() == "") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")) {
            setX(2);
        }
        
        // 1st row
        else if ((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "")) {
            setX(2);
        }
        else if ((buttons[0].getText() == "O") && (buttons[2].getText() == "O") && (buttons[1].getText() == "")) {
            setX(1);
        }
        else if ((buttons[0].getText() == "") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
            setX(0);
        }
        // 2nd row
        else if ((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "")) {
            setX(5);
        }
        else if ((buttons[3].getText() == "O") && (buttons[5].getText() == "O") && (buttons[4].getText() == "")) {
            setX(4);
        }
        else if ((buttons[3].getText() == "") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) {
            setX(3);
        }
        // 3rd row
        else if ((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "")) {
            setX(8);
        }
        else if ((buttons[6].getText() == "O") && (buttons[8].getText() == "O") && (buttons[7].getText() == "")) {
            setX(7);
        }
        else if ((buttons[6].getText() == "") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")) {
            setX(6);
        }
        // 1st column
        else if ((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "")) {
            setX(6);
        }
        else if ((buttons[0].getText() == "O") && (buttons[6].getText() == "O") && (buttons[3].getText() == "")) {
            setX(3);
        }
        else if ((buttons[0].getText() == "") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")) {
            setX(0);
        }
        // 2nd column
        else if ((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "")) {
            setX(7);
        }
        else if ((buttons[1].getText() == "O") && (buttons[7].getText() == "O") && (buttons[4].getText() == "")) {
            setX(4);
        }
        else if ((buttons[1].getText() == "") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")) {
            setX(1);
        }
        // 3rd column
        else if ((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "")) {
            setX(8);
        }
        else if ((buttons[2].getText() == "O") && (buttons[8].getText() == "O") && (buttons[5].getText() == "")) {
            setX(5);
        }
        else if ((buttons[2].getText() == "") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")) {
            setX(2);
        }
        // 1st diagonal
        else if ((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "")) {
            setX(8);
        }
        else if ((buttons[0].getText() == "O") && (buttons[8].getText() == "O") && (buttons[4].getText() == "")) {
            setX(4);
        }
        else if ((buttons[0].getText() == "") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")) {
            setX(0);
        }
        // 2nd diagonal
        else if ((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "")) {
            setX(6);
        }
        else if ((buttons[2].getText() == "O") && (buttons[6].getText() == "O") && (buttons[4].getText() == "")) {
            setX(4);
        }
        else if ((buttons[2].getText() == "") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")) {
            setX(2);
        }
        else {
            boolean t = true;
            int randomInt = ThreadLocalRandom.current().nextInt(0, 9);
            //int randomInt = random.nextInt(9);
            while (t) {
                if (buttons[randomInt].getText() == "") {
                    buttons[randomInt].setForeground(new Color(62,119,81));
                    buttons[randomInt].setText("X");
                    number -= 1;
                    player1_turn=true;
                    textfield.setText("Your turn");
                    check();
                    t = false;
                }
                else
                {
                    randomInt = ThreadLocalRandom.current().nextInt(0, 9);
                }
            }
        }
    }
}


