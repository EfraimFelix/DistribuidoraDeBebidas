/*
 * permite desenhar um ponto na tela
 */
package tccc.Formas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Efraim
 */
public class Ponto implements Forma {

    private Point p;
    private Color cor;

    /*
  *  construtor padrão
     */
    public Ponto(int x, int y) {
        cor = Color.BLACK;//cor default
        p = new Point(x, y);
    }

    /*
  *  retorna cordenada x
     */
    public int x() {
        return p.x;
    }

    /*
  *  retorna cordenada y
     */
    public int y() {
        return p.y;
    }

    /*
  *  retorna nova posição do ponto
     */
    public Point mover(Point vetor) {
        p.x += vetor.x;
        p.y += vetor.y;
        return p;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(cor);
        g.drawLine(p.x, p.y, p.x, p.y);
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

}
