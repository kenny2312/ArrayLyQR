/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author kenny
 */
public class PintaTabla extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        String estado = table.getValueAt(row, 1).toString();

        if (estado == "OCUPADO") {
            this.setOpaque(true);

            this.setBackground(Color.BLUE);
            this.setForeground(Color.WHITE);
            if (isSelected) {
                this.setOpaque(true);
                this.setBackground(Color.RED);
                this.setForeground(Color.WHITE);
            }
        } else {
            this.setOpaque(true);
            this.setBackground(Color.BLACK);
            this.setForeground(Color.GREEN);
            if (isSelected) {
                this.setOpaque(true);
                this.setBackground(Color.BLUE);
                this.setForeground(Color.WHITE);
            }
        }
        return this;
    }
}
