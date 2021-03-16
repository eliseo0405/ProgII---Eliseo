/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.AncestorListener;
import ni.uni.edu.programacion.views.panels.PnlMoneda;
/**
 *
 * @author elias
 */
public class MonedaController implements ActionListener{

    private PnlMoneda pnlMoneda;
    
    public MonedaController(PnlMoneda PnlMoneda){
       this.pnlMoneda = pnlMoneda;
       initComponent();
    }
     private void initComponent(){
        pnlMoneda.getBntCambioAD().addActionListener(this);
        pnlMoneda.getBntNew().addActionListener(this);
        pnlMoneda.getBntCambioAC().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(pnlMoneda.getTxtDolar() == null){
               double n1;
               n1 = Double.parseDouble(pnlMoneda.getTxtCordoba().getText());
                pnlMoneda.getTxtDolar().setText(String.valueOf(conversionDaC(n1)));
               
           }
           if(pnlMoneda.getTxtCordoba() == null){
               double n2;
                 n2 = Double.parseDouble(pnlMoneda.getTxtDolar().getText());
                pnlMoneda.getTxtCordoba().setText(String.valueOf(conversionCaD(n2)));
               
           }
           
       else if(e.getActionCommand().equalsIgnoreCase("Nuevo")){
            pnlMoneda.getTxtCordoba().setText("");
            pnlMoneda.getTxtDolar().setText("");
            
           pnlMoneda.getTxtCordoba().requestFocus();
        }
    }
    private double conversionDaC(double a){
        return(a*34.9);
    }
    private double conversionCaD(double a){
        return(a/34.9);
    }
}
