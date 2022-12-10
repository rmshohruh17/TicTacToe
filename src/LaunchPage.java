import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;



public class LaunchPage implements ActionListener {


    JFrame frame = new JFrame();
    JLabel label = new JLabel("Tic Tac Toe");
    JButton myButton = new JButton("One player");
    JButton myButton2 = new JButton("Two players");
    JButton myButton3 = new JButton("Records");



    LaunchPage() {

        URL iconURL = getClass().getResource("logo.jpg");
        // iconURL is null when not found
        ImageIcon icon = new ImageIcon(iconURL);
        frame.setIconImage(icon.getImage());

        GridPane grid = new GridPane();
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(40, 3, 10, 3));
        JPanel layout = new JPanel(new GridBagLayout());
        layout.setBorder(new EmptyBorder(40, 5, 10, 5));
        JPanel btnPanel = new JPanel(new GridLayout(10, 1, 10, 20));


        btnPanel.add(label);

        btnPanel.add(myButton);
        btnPanel.add(myButton2);
        btnPanel.add(myButton3);

        myButton.setBounds(100, 160, 250, 180);
        myButton.setFont(new Font("MV Boli", Font.CENTER_BASELINE,20));
        myButton.setBackground(new Color(255,191,31));
        myButton.setForeground(new Color(255,255,255));
        myButton.setFocusable(false);
        myButton.addActionListener(this);

        myButton2.setBounds(100, 160, 250, 180);
        myButton2.setFont(new Font("MV Boli", Font.CENTER_BASELINE,20));
        myButton2.setBackground(new Color(255,62,165));
        myButton2.setForeground(new Color(255,255,255));
        myButton2.setFocusable(false);
        myButton2.addActionListener(this);

        myButton3.setBounds(100, 160, 250, 180);
        myButton3.setFont(new Font("MV Boli", Font.CENTER_BASELINE,20));
        myButton3.setBackground(new Color(118,141,253));
        myButton3.setForeground(new Color(255,255,255));
        myButton3.setFocusable(false);
        myButton3.addActionListener(this);

        label.setFont(new Font("MV Boli", Font.BOLD, 40));


        layout.add(btnPanel);
        panel.add(layout, BorderLayout.CENTER);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setBounds(300, 90, 500, 400);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==myButton2){
                frame.dispose();
            TwoPlayersSetup twoPlayersSetup = new TwoPlayersSetup();
        }
        else if (e.getSource()==myButton) {
            frame.dispose();
            OnePlayerSetup onePlayerSetup = new OnePlayerSetup();
        }

        else if (e.getSource()==myButton3) {
            frame.dispose();
            GameRecords gameRecords = new GameRecords();
        }


    }
}
