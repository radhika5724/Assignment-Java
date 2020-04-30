

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class TableRender implements TableCellRenderer{
    TableCellRenderer render;
    Border b;
    TableRender(TableCellRenderer r, Color c){
        render = r;
        b = BorderFactory.createCompoundBorder();
        //b = BorderFactory.createCompoundBorder(b, BorderFactory.createMatteBorder(1,0,0,0,c));
        b = BorderFactory.createCompoundBorder(b, BorderFactory.createMatteBorder(0,1,0,0,c));
        b = BorderFactory.createCompoundBorder(b, BorderFactory.createMatteBorder(0,0,1,0,c));
        //b = BorderFactory.createCompoundBorder(b, BorderFactory.createMatteBorder(0,0,0,1,c));
    }
    
        @Override
       public Component getTableCellRendererComponent(JTable table,
           Object value, boolean isSelected, boolean hasFocus, int row, int column) {
               JComponent result = (JComponent)render.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
               result.setBorder(b);
               return result;
       }

}
