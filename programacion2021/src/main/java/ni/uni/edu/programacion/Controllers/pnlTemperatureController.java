/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import ni.uni.edu.programacion.views.PnlConversionTemplate;

/**
 *
 * @author JADPA03
 */
public class pnlTemperatureController implements ActionListener {
    private PnlConversionTemplate pnlConversionTemplate;
    private DefaultComboBoxModel temperatureCmbModel;
    private String TEMPERATURES[] = new String[]{"Celcius","Fahrenheit"}; 
    
    public pnlTemperatureController(PnlConversionTemplate pnlConversionTemplate){
        this.pnlConversionTemplate = pnlConversionTemplate;
    }
    private void initComponent(){
        temperatureCmbModel = new DefaultComboBoxModel(TEMPERATURES);
        pnlConversionTemplate.getCmbFrom().setModel(temperatureCmbModel);
        pnlConversionTemplate.getCmbTo().setModel(temperatureCmbModel);
        
        pnlConversionTemplate.getBtnCalc().addActionListener(this);
        pnlConversionTemplate.getBtnNew().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Convertir")){
            int cmbFromIndex = pnlConversionTemplate.getCmbFrom().getSelectedIndex();
            int cmbToIndex = pnlConversionTemplate.getCmbFrom().getSelectedIndex();
            double value = Double.parseDouble(pnlConversionTemplate.getTxtvalue().getText());
            pnlConversionTemplate.getLblResult().setText("Resultado: " +convertidorTemperature(value, cmbFromIndex, cmbToIndex));
            
            
        }
    }
    private double convertidorTemperature(double value, int from, int to){
        switch(from){
            case 0:
                switch(to){
                    case 0:
                        return value;
                    case 1:
                        return celciusToFahrenheit(value);
                }
            case 1:
                switch(to){
                    case 0:
                        return fahrenheitToCelcius(value);
                    case 1:
                        return value;
                }
        }
        return 0;
    }
    
    private double celciusToFahrenheit(double value){
        return (((double)9/5*value)+32);
        
    }
    private double fahrenheitToCelcius(double value){
        return ((double)5/9*(value-32));
    }
}
