package com.nato.panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class WinPanel extends JPanel {
    private final JLabel winMessage;
    private final JFrame parent;
    private final JLabel image;
    private final JLabel pointsMessage;
    private final JLabel points;

    public WinPanel(JFrame parent) {
        this.winMessage = new JLabel("YOU WON, CONGRATS.");
        this.parent = parent;
        this.pointsMessage = new JLabel("Your final score was:");
        this.points = new JLabel("00");

        BufferedImage trophyImage;

        try {
            trophyImage = ImageIO.read(new File("C:\\Users\\nero\\projects\\NATO-Phonetic-Alphabet\\trophy.jpg"));
        } catch (Exception e) {
            trophyImage = new BufferedImage(1, 1, 1);
        }

        this.image = new JLabel(new ImageIcon(trophyImage));
    }

    public void set(int finalScore) {
        setLayout(null);
        setSize(parent.getSize());
        setBackground(Color.white);

        winMessage.setBounds(this.getWidth() / 2 - 120, this.getHeight() / 10, 280, 20);
        winMessage.setFont(new Font("Dialog", Font.BOLD, 20));
        winMessage.setForeground(Color.decode("#058E3F"));
        add(winMessage);

        pointsMessage.setBounds(this.getWidth() / 2 - 50, this.getHeight() / 2 + 100, 120, 20);
        add(pointsMessage);

        points.setBounds(this.getWidth() / 2, this.getHeight() / 2 + 120, 40, 20);
        points.setText(String.format("%02d", finalScore));
        add(points);

        image.setBounds(this.getWidth() / 2 - 200, this.getHeight() / 2 - 300, 400, 400);
        add(image);
    }
}
