/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnr2i.models.entity;

import dnr2i.models.coordinate.TrackPoint;
import dnr2i.util.event.ModelListener;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class VueTrack2D extends JPanel implements ModelListener {
private final static int COEF=1000;
private final static int DELTA_LON=400;
private final static int DELTA_LAT=-49100;
private final static int SIZE=10;
    private TrackEntity model;
    

    public VueTrack2D(TrackEntity m) {
        model = m;
        model.addModelListener(this);
    }

    @Override
    public void modelChanged(Object source) {
repaint();
//System.out.println("change");
    }

    @Override
   public void paintComponent(Graphics g)
   {
       super.paintComponent(g);
       g.drawString("test", 100, 100);
       Graphics2D g2D=(Graphics2D) g;
       int x=0;
       int y=0;
       boolean first=true;
       for (TrackPoint p : model.getTrackPoints())
       {
           int xx=(int) (p.getLongitude()*COEF)+DELTA_LON;
           int yy=(int) (p.getLatitude()*COEF)+DELTA_LAT;
           if (!first)
           {
               g2D.drawLine(x,y,xx,yy);
           }
           x=xx;
           y=yy;
           //System.out.println("XX="+xx+" YY="+yy);
           first=false;
       }
       g2D.drawOval((int) (model.getCurrentPosition().getLongitude()*COEF)+DELTA_LON-SIZE/2, (int) (model.getCurrentPosition().getLatitude()*COEF)+DELTA_LAT-SIZE/2, SIZE,SIZE);
   }

}
