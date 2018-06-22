/*
 * Created by JFormDesigner on Thu Jun 21 14:50:56 ICT 2018
 */

package com.phong.frame;

import java.awt.event.*;

import com.phong.graphics.Screen;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private void CustomizeActionPerformed(ActionEvent e) {
        dialog1.setVisible(true);
        pack();
    }

    private void okBtnActionPerformed(ActionEvent e) {
        if(Integer.parseInt(tfSize.getText()) > 1 && Integer.parseInt(tfSize.getText()) <= 10){
            if(Integer.parseInt(tfScore.getText()) >= 1 && Integer.parseInt(tfScore.getText()) <= 10){
                if(Integer.parseInt(tfGamemode.getText()) == 0 || Integer.parseInt(tfGamemode.getText()) == 1){
                    gamemode = Integer.parseInt(tfGamemode.getText());
                    f = new Frame(Integer.parseInt(tfSize.getText()), Integer.parseInt(tfSpeed.getText())*10000,Integer.parseInt(tfScore.getText()));
                    f.setVisible(true);
                    f.setLocationRelativeTo(null);
                    this.dispose();
                    dialog1.dispose();

                }
            }

        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Phong
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        dialog1 = new JDialog();
        lblSize = new JLabel();
        lblSpeed = new JLabel();
        lblScore = new JLabel();
        tfSize = new JTextField();
        tfSpeed = new JTextField();
        tfScore = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        lblGameMode = new JLabel();
        tfGamemode = new JTextField();
        label8 = new JLabel();
        btnOk = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- button1 ----
        button1.setText("Wall Block");
        button1.addActionListener(e -> touchingWallActionPerformed(e));

        //---- button2 ----
        button2.setText("No Wall");
        button2.addActionListener(e -> infiniteWallActionPerformed(e));

        //---- button3 ----
        button3.setText("Customize Game");
        button3.addActionListener(e -> CustomizeActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            Container dialog1ContentPane = dialog1.getContentPane();

            //---- lblSize ----
            lblSize.setText("Size:");

            //---- lblSpeed ----
            lblSpeed.setText("Speed:");

            //---- lblScore ----
            lblScore.setText("Score:");

            //---- tfSize ----
            tfSize.setText("5");

            //---- tfSpeed ----
            tfSpeed.setText("25");

            //---- tfScore ----
            tfScore.setText("1");

            //---- label4 ----
            label4.setText("default: 5, 1 < size <= 10");
            label4.setFont(new Font("Arial", Font.PLAIN, 9));

            //---- label5 ----
            label5.setText("default: 25, lower is faster");
            label5.setFont(new Font("Arial", Font.PLAIN, 9));

            //---- label6 ----
            label6.setText("default: 1, 1 <= score <= 10");
            label6.setFont(new Font("Arial", Font.PLAIN, 9));

            //---- lblGameMode ----
            lblGameMode.setText("Gamemode:");

            //---- tfGamemode ----
            tfGamemode.setText("0");

            //---- label8 ----
            label8.setText("0 is wall block, 1 is no wall.");

            //---- btnOk ----
            btnOk.setText("OK");
            btnOk.addActionListener(e -> okBtnActionPerformed(e));

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65))
                            .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                                .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                    .addComponent(lblScore)
                                    .addGap(16, 16, 16)
                                    .addComponent(tfScore, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label6))
                                .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                    .addComponent(lblSpeed)
                                    .addGap(13, 13, 13)
                                    .addComponent(tfSpeed, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label5))
                                .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                    .addComponent(lblSize, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfSize, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label4))
                                .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                    .addComponent(lblGameMode)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfGamemode, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addComponent(label8)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                            .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(dialog1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSize)
                                    .addComponent(tfSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4)))
                            .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(dialog1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfSpeed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5)
                                    .addComponent(lblSpeed))))
                        .addGap(6, 6, 6)
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(tfScore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6)
                            .addComponent(lblScore))
                        .addGap(18, 18, 18)
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGameMode)
                            .addComponent(tfGamemode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label8)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOk)
                        .addContainerGap(25, Short.MAX_VALUE))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Phong
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JDialog dialog1;
    private JLabel lblSize;
    private JLabel lblSpeed;
    private JLabel lblScore;
    private JTextField tfSize;
    private JTextField tfSpeed;
    private JTextField tfScore;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel lblGameMode;
    private JTextField tfGamemode;
    private JLabel label8;
    private JButton btnOk;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
