import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.*;
public class GameRecords implements ActionListener {

    JFrame frame = new JFrame();
    String uname = "root";
    String password = "aet4gieh9etie3Nokoo7bai4";
    String query = "SELECT * from gameHistory;";
    String url = "jdbc:mysql://65.108.218.58:33306/TicTacToe?autoReconnect=true&useSSL=false";
    //private javax.swing.JTable recordsTable;

    JButton backToMenuBtn = new JButton("Back to Menu");

    GameRecords(){

        URL iconURL = getClass().getResource("logo.jpg");
        // iconURL is null when not found
        ImageIcon icon = new ImageIcon(iconURL);
        frame.setIconImage(icon.getImage());

        String[] ColumnNames= {"No", "Date", "'X'  Player", "'O'  Player", "Winner"};
        String[] [] Data = {{" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "}};
        JTable recordsTable = new JTable(Data, ColumnNames) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        recordsTable.setFont(new Font("San Serif", Font.PLAIN, 20));
        recordsTable.setRowHeight(30);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            throw new RuntimeException(e1);
        }

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, uname, password);
            Statement statement = con.createStatement();
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(ColumnNames);
            recordsTable.setModel(model);
            recordsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            recordsTable.setFillsViewportHeight(true);
            JScrollPane scrollPane = new JScrollPane(recordsTable);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            recordsTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );

            while (resultSet.next()){
                        model.addRow(new String[]{
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                });
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        frame.setVisible(true);
        frame.setBounds(300, 90, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(false);
        frame.add(new JScrollPane(recordsTable));

        backToMenuBtn.setBounds(100, 160, 250, 180);
        backToMenuBtn.setFont(new Font("MV Boli", Font.CENTER_BASELINE,20));
        backToMenuBtn.setBackground(new Color(255,191,31));
        backToMenuBtn.setForeground(new Color(255,255,255));
        backToMenuBtn.setFocusable(false);
        backToMenuBtn.addActionListener(this);
        frame.add(backToMenuBtn, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backToMenuBtn){
            frame.dispose();
            LaunchPage launchPage = new LaunchPage();
        }
    }
}
