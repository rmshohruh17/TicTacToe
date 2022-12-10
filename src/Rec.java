import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Rec {
    public static void main(String[] argv) throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("Col1");
        model.addRow(new Object[] { "r1" });
        model.addRow(new Object[] { "r2" });
        model.addRow(new Object[] { "r3" });

        Vector data = model.getDataVector();
        Vector row = (Vector) data.elementAt(1);

        int mColIndex = 0;
        List colData = new ArrayList(table.getRowCount());
        for (int i = 0; i < table.getRowCount(); i++) {
            row = (Vector) data.elementAt(i);
            colData.add(row.get(mColIndex));
        }

        // Append a new column with copied data
        model.addColumn("Col3", colData.toArray());

        JFrame f = new JFrame();
        f.setSize(300, 300);
        f.add(new JScrollPane(table));
        f.setVisible(true);
    }
}








