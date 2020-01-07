/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc.Formas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Efraim
 */
public class Circulo implements Forma {

    private Point p;
    private int raio;
    private Color corBorda = null;
    private Color corFundo = null;

    public Circulo(int x, int y, int raio) {
        p = new Point(x, y);
        this.raio = raio;
    }

    /*
  *  retorna cordenada do centro do circulo x
     */
    public int x() {
        return p.x;
    }

    /*
  *  retorna cordenada do centro do circulo y
     */
    public int y() {
        return p.y;
    }

    /*
  *  retorna raio do circulo
     */
    public int raio() {
        return raio;
    }

    /*
  *  retorna nova posição do centro do circulo
     */
    public Point mover(Point vetor) {
        p.x += vetor.x;
        p.y += vetor.y;
        return p;
    }

    public void dimensionar(int deltaRaio) {
        raio += deltaRaio;
        if (raio < 0) {
            raio = 0; // nao aceitamos delta(raio) negativo
        }
    }

    @Override
    public void draw(Graphics g) {
        //se a cor de borda for definida, desenha a circunferencia(somente a borda)
        if (null != getCorBorda()) {
            g.setColor(getCorBorda());
            g.drawOval(p.x, p.y, raio, raio); // raios iguais pq é um circulo
        }
        //se tem cor de fundo, pinta a circulo
        if (null != getCorFundo()) {
            g.setColor(getCorFundo());
            g.fillOval(p.x, p.y, raio, raio); // raios iguais pq é um circulo
        }
    }

    public Color getCorBorda() {
        return corBorda;
    }

    public void setCorBorda(Color corBorda) {
        this.corBorda = corBorda;
    }

    public Color getCorFundo() {
        return corFundo;
    }

    public void setCorFundo(Color corFundo) {
        this.corFundo = corFundo;
    }
}
