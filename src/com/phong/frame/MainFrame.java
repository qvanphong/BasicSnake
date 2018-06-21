/*
 * Created by JFormDesigner on Thu Jun 21 14:50:56 ICT 2018
 */

package com.phong.frame;

import java.awt.event.*;

import com.phong.graphics.Screen;

import java.awt.*;
import javax.swing.*;

/**
 * @author Phong
 */
public class MainFrame extends JFrame {
    public static int gamemode;
    private Frame f;
//    public static gameModeChoose;
    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Menu - Choose Game Mode");
        setResizable(false);
        setVisible(true);
        initComponents();
    }




    private void touchingWallActionPerformed(ActionEvent e) {
        gamemode = 0;
        f = new Frame();
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        this.dispose();
    }

    private void infiniteWallActionPerformed(ActionEvent e) {
        gamemode = 1;
        f = new Frame();
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        this.dispose();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Phong
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(1, 1));

        //---- button1 ----
        button1.setText("Touching Wall");
        button1.addActionListener(e -> touchingWallActionPerformed(e));
        contentPane.add(button1);

        //---- button2 ----
        button2.setText("Inifinite Wall");
        button2.addActionListener(e -> infiniteWallActionPerformed(e));
        contentPane.add(button2);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        new MainFrame();
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Phong
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
