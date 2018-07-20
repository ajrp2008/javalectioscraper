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
        return elevdata.almF > MaxAlmF;
    }
    
    public static boolean kritiskSkrF(ElevData elevdata){
        return elevdata.skrF > MaxSkrF;
    }
    
    public static boolean kritiskAlmFSkrF(ElevData elevdata){
        return kritiskAlmF(elevdata)&&kritiskSkrF(elevdata);
    }
    
}
