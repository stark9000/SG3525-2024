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
public class OscillatorFrequencyCalculator {

    private double CT; // Capacitance (F)
    private double RT_fixed; // User-defined fixed resistor (Ω)
    private double RT_variable; // Variable resistor (Ω)
    private double RD; // Dead time resistance (Ω)
    private double frequency;

    public OscillatorFrequencyCalculator(double RT_fixed_in_Ω) {
        this.RT_fixed = RT_fixed_in_Ω; // Use ohms directly
    }

    public double calculateFrequency(double CT_in_nF, double RT_variable_in_Ω, double RD_in_Ω) {
        this.CT = CT_in_nF * 1e-9; // Convert nF to F
        this.RT_variable = RT_variable_in_Ω; // Use ohms directly
        this.RD = RD_in_Ω;
        double RT_total = this.RT_fixed + this.RT_variable;
        this.frequency = 1 / (this.CT * (0.7 * RT_total + 3 * this.RD));
        return this.frequency; // This is in Hz
    }

    public double calculateFrequencyInKHz(double CT_in_nF, double RT_variable_in_Ω, double RD_in_Ω) {
        double frequencyHz = calculateFrequency(CT_in_nF, RT_variable_in_Ω, RD_in_Ω);
        return frequencyHz / 1000; // Convert Hz to kHz
    }

}
