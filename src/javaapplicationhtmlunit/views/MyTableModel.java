/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationhtmlunit.views;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andersjuulr.petersen
 */
public class MyTableModel extends DefaultTableModel{

    MyTableModel(String[] col, int i) {
        super(col,i);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        @Override
        public Class getColumnClass(int column) {
        
        if (column == 0){
            return String.class;
        }else{
            return Double.class;
        }
           
        }
        
        
    @Override
      public boolean isCellEditable(int row, int column){  
          return false;  
      }
        /*
         List<Color> rowColours = Arrays.asList(
        Color.RED,
        Color.GREEN,
        Color.CYAN
    );

    public void setRowColour(int row, Color c) {
        rowColours.set(row, c);
        fireTableRowsUpdated(row, row);
    }

    public Color getRowColour(int row) {
        return rowColours.get(row);
    }

    @Override
    public int getRowCount() {
        return 3;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return String.format("%d %d", row, column);
    }
*/
    
}
