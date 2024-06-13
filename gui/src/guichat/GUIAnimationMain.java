package guichat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

class GUIAnimationMain extends JPanel {

    GUIAnimatinFaceLook[] face = new GUIAnimatinFaceLook[2];
    String[] emotions = new String[2];

    public GUIAnimationMain() {
        face[0] = new GUIAnimatinFaceLook();
        face[1] = new GUIAnimatinFaceLook();
        emotions[0] = "neutral";
        emotions[1] = "neutral";
    }

    public void setFaceColor(int which, Color color) {
        face[which].setColor(color);
        repaint();
    }

    public void setFacePlace(int which, int x, int y, String msg) {
        face[which].setXY(x, y);
        repaint();
    }

    public void setFaceEmotion(int which, String emotion) {
        emotions[which] = emotion;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < face.length; i++) {
            face[i].makeFace(g2, emotions[i]);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animated Face");
        GUIAnimationMain animation = new GUIAnimationMain();
        frame.add(animation);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        new GUIAniMultiTCPServer2(animation);
    }
}
