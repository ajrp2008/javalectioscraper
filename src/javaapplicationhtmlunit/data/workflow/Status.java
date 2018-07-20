/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationhtmlunit.data.workflow;

import javaapplicationhtmlunit.data.ElevData;

/**
 *
 * @author andersjuulr.petersen
 */
public interface Status {
    
    public String getInfo(ElevData elevdata);
    
    public String getStatus(ElevData elevdata);
    
    public boolean workflowNotInProgress(ElevData elevdata);
    
    public String getStatusDialogText(ElevData elevData);
    
    public Status proceedStatus(boolean proceed, ElevData elevData);
    
}
