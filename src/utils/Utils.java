package utils;

import javaapplicationhtmlunit.data.ElevData;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andersjuulr.petersen
 */
public class Utils {
    public static double MaxAlmF = 10;
    public static double MaxSkrF = 15;
    
    public static boolean kritiskAlmF(ElevData elevdata){
        boolean kritisk = false;
        if(elevdata != null){
            kritisk = elevdata.almF > MaxAlmF;
        }
        return kritisk;
    }
    
    public static boolean kritiskSkrF(ElevData elevdata){
        boolean kritisk = false;
        if(elevdata != null){
            kritisk = elevdata.skrF > MaxSkrF;
        }
        return kritisk;
    }
    
    public static boolean kritiskAlmFSkrF(ElevData elevdata){
        return kritiskAlmF(elevdata)&&kritiskSkrF(elevdata);
    }
    
    public static boolean isWorkflowInProgress(ElevData elevdata){
        boolean inProgress = false;
        if(elevdata!=null){
            inProgress = elevdata.isWorkflowInProgress();
        }
        return inProgress;
    }
}
