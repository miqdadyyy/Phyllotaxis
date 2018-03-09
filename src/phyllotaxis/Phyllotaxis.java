/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phyllotaxis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Phyllotaxis extends JPanel {

    double r, c = 6, x = 0, y = 0, alpha, n = 1;
    double R, G, B, MB, MR, MG;
    static final int SCALE = 2;
    private JFrame f;

    public Phyllotaxis(double alpha) {
        setMinimumSize(new Dimension(400 * SCALE, 400 * SCALE));
        setMaximumSize(new Dimension(400 * SCALE, 400 * SCALE));
        setPreferredSize(new Dimension(400 * SCALE, 400 * SCALE));
        this.alpha = alpha;

        f = new JFrame("Phyllotaxis");
        f.setLayout(new BorderLayout());
        f.add(this, BorderLayout.CENTER);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.BLACK);
        f.setVisible(true);
        R = Math.random() * 255;
        G = Math.random() * 255;
        B = Math.random() * 255;
        MR = Math.random();
        MG = Math.random();
        MB = Math.random();

    }

    public void showTime() {
        r = c * Math.sqrt(n);
        x = Math.sin(n * alpha) * r;
        y = Math.cos(n * alpha) * r;
        R += MR;
        G += MG;
        B += MB;
        n++;
        if (R >= 255) {
            R -= 255;
            MR = Math.random();
        }
        if (G >= 255) {
            G -= 255;
            MG = Math.random();
        }
        if (B >= 255) {
            B -= 255;
            MB = Math.random();
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        x += getWidth() / 2;
//        y += getHeight() / 2;
        g2d.translate(getWidth() / 2, getHeight() / 2);
        g2d.setColor(new Color((int) R, (int) G, (int) B));
        g2d.fillOval((int) x, (int) y, 5 * SCALE, 5 * SCALE);
    }

}
