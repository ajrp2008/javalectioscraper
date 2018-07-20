/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationhtmlunit.data;

import java.text.SimpleDateFormat;

/**
 *
 * @author andersjuulr.petersen
 */
public class StatusWfStartedAlm implements Status{

    @Override
    public String getStatus(ElevData elevdata) {
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM-yy");
        return "Kritisk alm. fravær d." + dt1.format(elevdata.tid);
    }

    @Override
    public String getStatusDialogText(ElevData elevdata) {
        return "<html>" + elevdata.navn + "<br>Indkaldes til samtale pga. stort fysisk fravær?</html>";
    }

    @Override
    public Status proceedStatus(boolean proceed, ElevData elevdata) {
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
