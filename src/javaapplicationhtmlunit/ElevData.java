/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationhtmlunit;

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

    public ElevData(String navn, double almF, double skrF, int timerF, int timerIAlt){
        this.navn       = navn;
        this.almF       = almF;
        this.skrF       = skrF;
        this.timerF     = timerF;
        this.timerIAlt  = timerIAlt;
    }
    
    
    
}
