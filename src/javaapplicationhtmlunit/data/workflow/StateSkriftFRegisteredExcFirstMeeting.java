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
public class StateSkriftFRegisteredExcFirstMeeting implements State{

    @Override
    public String getState(ElevData elevdata) {
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");
        return "Kritisk skr. fravær d." + dt1.format(elevdata.tid);
    }

    @Override
    public String getStateDialogText(ElevData elevdata) {
        return "<html>"+ elevdata.navn + "<br>Indkaldes til samtale pga. stort skirftligt fravær?</html>";
    }

    @Override
    public State executeThisStateAndmoveToNextState(boolean proceed, ElevData elevdata) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean workflowNotInProgress(ElevData elevdata) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInfo(ElevData elevdata) {
        return "<html><br>Dette step &nbsp;(1): For højt skr. fraværd registreret.<br> Næste step (2): Indkaldelse til samtale om forbedrings deadline & Mails til centraladministrationen</html>"; //To change body of generated methods, choose Tools | Templates.
    }
}
