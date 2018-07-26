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
public class StateStart implements State{

    @Override
    public String getState(ElevData elevdata) {
        return "-";
    }

    @Override
    public String getStateDialogText(ElevData elevdata) {
        return "<html>" + elevdata.navn + "<br>Start workflow?</html>";
    }

    @Override
    public State executeThisStateAndmoveToNextState(boolean proceed, ElevData elevdata) {
        State newState = this;
        if(proceed){
            if(Utils.kritiskAlmFSkrF(elevdata)){
                newState = new StateAlmOgSkriftFRegisteredExcFirstMeeting();
            }else if(Utils.kritiskAlmF(elevdata)){
                newState = new StateAlmFRegisteredExcFirstMeeting();
            }else{
                newState = new StateSkriftFRegisteredExcFirstMeeting();
            }                        
        }
        return newState;
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
