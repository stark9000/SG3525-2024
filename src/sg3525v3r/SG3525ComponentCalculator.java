/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg3525v3r;

/**
 *
 * @author saliya
 */
public class SG3525ComponentCalculator {

    private static final double DEFAULT_RD_OHMS = 470.0; // Fixed value for RD in ohms

    // Method to calculate frequency based on CT, RT, and RD
    public double calculateFrequency(double CT_in_nF, double RT_in_ohms) {
        double CT = CT_in_nF * 1e-9; // Convert nF to F
        return 1 / (CT * (0.7 * RT_in_ohms + 3 * DEFAULT_RD_OHMS));
    }

    // Method to calculate RT based on desired frequency and fixed values of CT and RD
    public double calculateRT(double frequency, double CT_in_nF) {
        double CT = CT_in_nF * 1e-9; // Convert nF to F
        return (1 / (frequency * CT) - 3 * DEFAULT_RD_OHMS) / 0.7;
    }

    // Method to calculate CT based on desired frequency and given RT
    public double calculateCT(double frequency, double RT_in_ohms) {
        return 1e9 / (frequency * (0.7 * RT_in_ohms + 3 * DEFAULT_RD_OHMS)); // Convert F to nF
    }

}
