import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Level5 extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Serif", Font.BOLD, 20));
        g2d.drawString("Hello, Java 2D!", 50, 50); // テキストを描画

        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("SansSerif", Font.ITALIC, 15));
        g2d.drawString("Drawing text is fun!", 50, 100); // テキストを描画
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Level 5: Text Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new Level5());
        frame.setVisible(true);
    }
}
