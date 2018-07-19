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
        return "Start fraværdsworkflow for " + elevdata.navn + "?";
    }

    @Override
    public Status proceedStatus(boolean proceed, ElevData elevdata) {
        Status newStatus = this;
        
        if(proceed){
            if(elevdata.almF > GlobalSettingsUtil.MaxAlmF && elevdata.skrF > GlobalSettingsUtil.MaxSkrF ){
                newStatus = new StatusFirstTalkAlmAndSkr();
            }else if(elevdata.almF > GlobalSettingsUtil.MaxAlmF){
                newStatus = new StatusFirstTalkAlm();
            }else{
                newStatus = new StatusFirstTalkSkr();
            }                        
        }
        
        return newStatus;
    }

    @Override
    public boolean workflowNotInProgress(ElevData elevdata) {
        return true;
    }
}
