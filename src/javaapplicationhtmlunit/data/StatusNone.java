/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationhtmlunit.data;

import utils.GlobalSettingsUtil;

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
            if(elevdata.almF > GlobalSettingsUtil.MaxAlmF && elevdata.skrF > GlobalSettingsUtil.MaxSkrF ){
                newStatus = new StatusWfStartedAlmAndSkr();
            }else if(elevdata.almF > GlobalSettingsUtil.MaxAlmF){
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
