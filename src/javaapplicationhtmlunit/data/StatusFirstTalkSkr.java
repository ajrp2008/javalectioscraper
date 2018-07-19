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
public class StatusFirstTalkSkr implements Status{

    @Override
    public String getStatus(ElevData elevdata) {
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");
        return "Kritisk skr. fravær d." + dt1.format(elevdata.tid);
    }

    @Override
    public String getStatusDialogText(ElevData elevdata) {
        return "Indkald " + elevdata.navn + " til samtale om for stort skirftligt fravær?";
    }

    @Override
    public Status proceedStatus(boolean proceed, ElevData elevdata) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean workflowNotInProgress(ElevData elevdata) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
