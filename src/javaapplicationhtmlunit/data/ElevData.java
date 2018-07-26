/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationhtmlunit.data;

import javaapplicationhtmlunit.data.workflow.StateNone;
import java.util.Date;
import javaapplicationhtmlunit.data.workflow.State;

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
        
    public State state    = new StateNone();
    
    public ElevData(String navn, double almF, double skrF, int timerF, int timerIAlt, Date tid){
        this.navn       = navn;
        this.almF       = almF;
        this.skrF       = skrF;
        this.timerF     = timerF;
        this.timerIAlt  = timerIAlt;
        this.tid        = tid;
    }
    
    public String getStatus(){
        return this.state.getState(this);
    }
    
    public String getWorkflowDialogText(){
        return this.state.getStateDialogText(this);
    }
    
    public void proceedWorkflow(boolean proceed){
        this.state = this.state.executeThisStateAndmoveToNextState(proceed, this);
    }
    
    public boolean isWorkflowInProgress(){
        return state.workflowNotInProgress(this);
    }
    
    public String getInfo(){
        return state.getInfo(this);
    }
    
}

