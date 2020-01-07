/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc;

import tccc.Formas.Forma;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author Efraim
 */
public class MyCanvas extends JComponent {

    private ArrayList<Forma> formas = new ArrayList<>();

    public void adicionar(Forma f) {
        formas.add(f);
    }

    public void remover(int i) {
        if (i < formas.size()) {
            formas.remove(i);
        } else {
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Forma f : formas) {
            f.draw(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
}
