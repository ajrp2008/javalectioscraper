/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationhtmlunit;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andersjuulr.petersen
 */
public class NewClassMyTModel extends DefaultTableModel{

    NewClassMyTModel(String[] col, int i) {
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
    
}
