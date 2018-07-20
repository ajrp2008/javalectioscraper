/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationhtmlunit.data;

import javaapplicationhtmlunit.data.workflow.StatusNone;
import javaapplicationhtmlunit.data.workflow.Status;
import java.util.Date;

/**
 *
 * @author andersjuulr.petersen
 */
public class ElevData {    
      
    public String navn      = "";
    public double almF      = 0;
    public double skrF      = 0;
    public int timerF       = 0;
    public int timerIAlt    = 0;
    public Date tid         = null;
        
    public Status status    = new StatusNone();
    
    public ElevData(String navn, double almF, double skrF, int timerF, int timerIAlt, Date tid){
        this.navn       = navn;
        this.almF       = almF;
        this.skrF       = skrF;
        this.timerF     = timerF;
        this.timerIAlt  = timerIAlt;
        this.tid        = tid;
    }
    
    public String getStatus(){
        return this.status.getStatus(this);
    }
    
    public String getWorkflowDialogText(){
        return this.status.getStatusDialogText(this);
    }
    
    public void proceedWorkflow(boolean proceed){
        this.status = this.status.proceedStatus(proceed, this);
    }
    
    public boolean isWorkflowInProgress(){
        return status.workflowNotInProgress(this);
    }
    
    public String getInfo(){
        return status.getInfo(this);
    }
    
}

