/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnr2i.models.entity;

import dnr2i.util.event.ModelListener;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author user
 */
public class VueTrackLabel extends JFrame implements ModelListener {

    private TrackEntity model;
    private JLabel labelLat, labelLon;

    public VueTrackLabel(TrackEntity m) {
        model = m;
        Container cp = this.getContentPane();
        cp.setLayout(new GridLayout(2, 2));
        cp.add(new JLabel("latitude"));
        cp.add(labelLat = new JLabel("NA"));
        cp.add(new JLabel("longitude"));
        cp.add(labelLon = new JLabel("NA"));
        pack();
               // System.out.println("labelLon="+labelLon+" labelLat="+labelLat);

        miseAJourLabels();
        model.addModelListener(this);
setSize(500,200);
        setVisible(true);

    }

    @Override
    public void modelChanged(Object source) {
        miseAJourLabels();
    }

    private void miseAJourLabels() {
       // System.out.println("model="+model+" labelLat="+labelLat);
        labelLat.setText("" + model.getCurrentPosition().getLatitude());
        labelLon.setText("" + model.getCurrentPosition().getLongitude());

    }

}
