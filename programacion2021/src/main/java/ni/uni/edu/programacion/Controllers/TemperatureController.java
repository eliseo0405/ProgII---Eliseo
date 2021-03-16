/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ni.uni.edu.programacion.views.panels.PnlTemperature;
/**
 *
 * @author elias
 */
public class TemperatureController implements ActionListener {

    private PnlTemperature PnlTemperature;
    
    public TemperatureController(PnlTemperature PnlTemperature){
        this.PnlTemperature = PnlTemperature;
        initComponent();
    }
    private void initComponent(){
        PnlTemperature.getBntCalc().addActionListener(this);
        PnlTemperature.getBntNew().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equalsIgnoreCase("Calcular")){
           
           if(PnlTemperature.getTxtF() == null){
               double n1;
               n1 = Double.parseDouble(PnlTemperature.getTxtC().getText());
                PnlTemperature.getTxtF().setText(String.valueOf(conversionFaC(n1)));
               
           }
           if(PnlTemperature.getTxtC() == null){
               double n2;
                 n2 = Double.parseDouble(PnlTemperature.getTxtF().getText());
                PnlTemperature.getTxtC().setText(String.valueOf(conversionCaF(n2)));
               
           }
           
       }else if(e.getActionCommand().equalsIgnoreCase("Nuevo")){
            PnlTemperature.getTxtC().setText("");
            PnlTemperature.getTxtF().setText("");
            
           PnlTemperature.getTxtF().requestFocus();
        }
      
       
       
    }
    private double conversionFaC(double a){
        return ((a-32)/1.8);
    }
    private double conversionCaF(double a){
        return((a*1.8)+32);
    }
}
