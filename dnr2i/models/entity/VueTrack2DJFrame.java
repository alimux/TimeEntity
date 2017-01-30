/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnr2i.models.entity;

import javax.swing.*;

/**
 *
 * @author user
 */
public class VueTrack2DJFrame extends JFrame{
    public VueTrack2DJFrame(TrackEntity m)
    {
        VueTrack2D vue=new VueTrack2D(m);
        this.setContentPane(vue);
        this.pack();
        this.setVisible(true);
                this.setSize(500,500);

    }
}
