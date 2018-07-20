/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationhtmlunit.data.workflow;

import javaapplicationhtmlunit.data.ElevData;
import utils.Utils;

/**
 *
 * @author andersjuulr.petersen
 */
public class StatusNone implements Status{

    @Override
    public String getStatus(ElevData elevdata) {
        return "-";
    }

    @Override
    public String getStatusDialogText(ElevData elevdata) {
        return "<html>" + elevdata.navn + "<br>Start workflow?</html>";
    }

    @Override
    public Status proceedStatus(boolean proceed, ElevData elevdata) {
        Status newStatus = this;
        if(proceed){
            if(Utils.kritiskAlmFSkrF(elevdata)){
                newStatus = new StatusWfStartedAlmAndSkr();
            }else if(Utils.kritiskAlmF(elevdata)){
                newStatus = new StatusWfStartedAlm();
            }else{
                newStatus = new StatusWfStartedSkr();
            }                        
        }
        return newStatus;
    }

    @Override
    public boolean workflowNotInProgress(ElevData elevdata) {
        return true;
    }

    @Override
    public String getInfo(ElevData elevdata) {
        return "<br>Intet workflow er startet";
    }
}
