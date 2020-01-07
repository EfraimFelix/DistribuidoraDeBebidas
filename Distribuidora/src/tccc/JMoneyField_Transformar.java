/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Efraim
 */
public class JMoneyField_Transformar {

    public double TransformaParaDouble(String valor) {
        valor = valor.replace(".", "");
        valor = valor.replace(",", ".");
        double a = Double.parseDouble(valor);
        return a;
    }
}
