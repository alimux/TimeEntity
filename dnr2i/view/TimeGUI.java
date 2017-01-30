/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnr2i.view;

import dnr2i.models.Time;
import dnr2i.util.event.ModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author user
 */
public class TimeGUI extends JFrame implements ModelListener, ActionListener, ChangeListener {
    
    private Time time;
    
    private final static int WIDTH = 550;
    private final static int HEIGHT = 350;
    
    private JLabel labelDebut, labelFin, labelCourant, labelSynchro;
    
    private JSlider slider;
    
    private JButton bDebut, bFin, bPlay, bPause;
    
    private JCheckBox checkSynchro;
    
    public TimeGUI(Time t) {
        super("Time GUI");
        time = t;
        labelDebut = new JLabel("NA");
        labelFin = new JLabel("NA");
        labelCourant = new JLabel("NA");
        
        Container cp = this.getContentPane();
        cp.setLayout(new GridLayout(4, 1));
        
        Box b2 = Box.createHorizontalBox();
        checkSynchro = new JCheckBox();
        labelSynchro = new JLabel("Synchronisation O/N");
        b2.add(checkSynchro);
        b2.add(labelSynchro);
        cp.add(b2);
        checkSynchro.addActionListener(this);
        
        JPanel labels = new JPanel();
        labels.setLayout(new GridLayout(1, 3));
        labels.add(labelDebut);
        labels.add(labelCourant);
        labels.add(labelFin);
        
        Box b = Box.createHorizontalBox();
        bDebut = new JButton("AllerAuDebut");
        bPlay = new JButton("Play");
        bPause = new JButton("Pause");
        bFin = new JButton("AllerALaFin");
        b.add(bDebut);
        b.add(bPlay);
        b.add(bPause);
        b.add(bFin);
        bPlay.addActionListener(this);
        bPause.addActionListener(this);
        bDebut.addActionListener(this);
        bFin.addActionListener(this);
        cp.add(b);
        
        slider = new JSlider(0, 1000, 0);
        
        slider.addChangeListener(this);
        
        cp.add(slider);
        this.setLocationRelativeTo(null);
        cp.add(labels);
        
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        pack();
        setVisible(true);
        this.setSize(WIDTH, HEIGHT);
        
        time.addModelListener(this);
    }
    
    @Override
    public void modelChanged(Object source) {
        labelDebut.setText("" + time.getStart());
        labelCourant.setText("" + time.getCurrent());
        labelFin.setText("" + time.getEnd());
        
        slider.removeChangeListener(this);
       // System.out.println("value pour slider = "+(int) (time.getRatioFromTime()));// * slider.getMaximum()));
        slider.setValue((int) (time.getRatioFromTime() * slider.getMaximum()));
        slider.addChangeListener(this);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == bDebut) {
            time.setCurrentTime(time.getStart());
        }
        if (source == bFin) {
            time.setCurrentTime(time.getEnd());
        }
        
        if (source == checkSynchro) {
            System.out.println(checkSynchro.isSelected());
            time.switchState(checkSynchro.isSelected());
            
        }
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        time.setTimeToRatio(((double) slider.getValue()) / slider.getMaximum());
    }
    
}
