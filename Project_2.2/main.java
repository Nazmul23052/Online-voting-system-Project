package com.ovs;

import com.ovs.db.Database;
import com.ovs.ui.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Database.init();
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "Failed to start app: " + e.getMessage(),
                        "OnlineVotingSystem",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
