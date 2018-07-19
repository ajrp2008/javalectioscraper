/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationhtmlunit.data;

/**
 *
 * @author andersjuulr.petersen
 */
public class StatusFirstTalkAlm implements Status{

    @Override
    public String getStatus() {
        return "indkaldt til samtale pga. fysisk fravær";
    }
    
}
