/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc;

import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tccc.Formas.Circulo;
import tccc.Formas.Ponto;

/**
 *
 * @author Efraim
 */
public class TelaSplashPanel extends JPanel {
    
    //Cores aleatorias
    
    public static Color getColorAleatoria(){
        Random rand = new Random();
        float r= rand.nextFloat();
        float g= rand.nextFloat();
        float b= rand.nextFloat();
return new Color(r, g, b);
}

    public static void main(String[] args) {
        JFrame tela = new JFrame("Tela Carregamento");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyCanvas canvas = new MyCanvas();
        tela.getContentPane().add(canvas);

        //agora podemos inserir formas no canvas
        for (int i = 0; i < 100; i++) {
            int x = (int) (Math.random() * 300);
            int y = (int) (Math.random() * 300);
            int raio = (int) (Math.random() * 50);
            Color cor =  getColorAleatoria();
            Circulo c = new Circulo(x, y, raio);
            c.setCorBorda(cor);
            if (Math.random()>0.5) {
                c.setCorFundo(cor);
            }
            canvas.adicionar(c);
        }
        
//        for (int i = 0; i < 10; i++) {
//            int x = (int) (Math.random() * 300);
//            int y = (int) (Math.random() * 300);
//            Ponto p = new Ponto(x, y);
//            canvas.adicionar(p);
//        }

        tela.pack();
        tela.setVisible(true);
    }

}
