/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz;

/**
 *
 * @author euvinmongwe
 */
public class Conversion {

    /**
     * convert Miles to Km
     * @param miles
     * @return 
     */
    public double convertMilesToKilometers(double miles) {

        return (miles * 1.6);
    }
    
    /**
     * convert pounds to kg
     * @param pounds
     * @return 
     */
    public double convertPoundsToKilograms(double pounds){
        
        return (pounds * 0.45);
    }
    
    /**
     * convert kelvin to calculs
     * @param kelvins
     * @return 
     */
    public double convertKelvinToCalculus(double kelvins){
        return (kelvins - 273);
    }

}
