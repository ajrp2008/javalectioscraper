/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationhtmlunit.data.workflow;

import java.text.SimpleDateFormat;
import javaapplicationhtmlunit.data.ElevData;

/**
 *
 * @author andersjuulr.petersen
 */
public class StateAlmFRegisteredExcFirstMeeting implements State{

    @Override
    public String getState(ElevData elevdata) {
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM-yy");
        return "Kritisk alm. fravær d." + dt1.format(elevdata.tid);
    }

    @Override
    public String getStateDialogText(ElevData elevdata) {
        return "<html>" + elevdata.navn + "<br>Indkaldes til samtale pga. stort fysisk fravær?</html>";
    }

    @Override
    public State executeThisStateAndmoveToNextState(boolean proceed, ElevData elevdata) {
        //Indkalder til møde        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean workflowNotInProgress(ElevData elevdata) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInfo(ElevData elevdata) {
        return "<html><br>Dette step &nbsp;(1): For højt alm. fraværd registreret.<br> Næste step (2): Indkaldelse til samtale om forbedrings deadline & Mails til centraladministrationen</html>"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
