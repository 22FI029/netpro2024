import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWT extends Frame {
    private FaceObj[] fobjs = new FaceObj[9];

    public FacesAWT() {
        super("Faces AWT Example");
        setSize(660, 660);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });


        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                fobjs[i + 3 * j] = new FaceObj();
                fobjs[i + 3 * j].setPosition(200 * i + 50, 200 * j + 50);
                fobjs[i + 3 * j].setEmotionLevel(i, j);
            }
        }
    }

    public void paint(Graphics g) {
        for (FaceObj face : fobjs) {
            face.drawFace(g);
        }
    }

    class FaceObj {
        private int x, y;
        private int emotionLevelX, emotionLevelY;

        public void setPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setEmotionLevel(int x, int y) {
            this.emotionLevelX = x;
            this.emotionLevelY = y;
        }

        public void drawFace(Graphics g) {
            // Random skin color
            Color skinColor = new Color(255 - 20 * emotionLevelX, 224 - 20 * emotionLevelY, 189 + 15 * emotionLevelX);
            g.setColor(skinColor);
            g.fillOval(x, y, 150, 150);

            // Draw hair
            g.setColor(Color.BLACK); // You can customize the color based on another attribute
            switch (emotionLevelY) {
                case 0:
                    g.fillArc(x, y - 30, 150, 100, 0, 180);
                    break;
                case 1:
                    g.fillOval(x - 10, y - 40, 170, 60);
                    break;
                case 2:
                    g.fillArc(x, y - 30, 150, 120, 0, 180);
                    break;
            }

            // Eyes
            Color eyeColor = new Color(100 * emotionLevelX, 50 + 50 * emotionLevelY, 150);
            g.setColor(eyeColor);
            g.fillOval(x + 25 + 10 * emotionLevelX, y + 40, 30, 40); // Left eye
            g.fillOval(x + 95 - 10 * emotionLevelX, y + 40, 30, 40); // Right eye

            


            if (emotionLevelY == 1) {
                g.setColor(Color.BLACK);
                g.drawRect(x + 20, y + 35, 60, 50);
                g.drawRect(x + 70, y + 35, 60, 50);
                g.drawLine(x + 80, y + 60, x + 70, y + 60);
            }

        
            g.setColor(Color.RED);
            if (emotionLevelX == 0) {
                g.drawArc(x + 50, y + 100, 50, 20, 180, 180);
            } else if (emotionLevelX == 1) {
                g.fillOval(x + 60, y + 100, 30, 10);
            } else {
                g.drawLine(x + 50, y + 110, x + 100, y + 90);
            }

            
            if (emotionLevelY == 2) {
                g.setColor(Color.GRAY);
                g.drawArc(x + 50, y + 95, 50, 20, 180, -180);
            }
        }
    }

    public static void main(String[] args) {
        new FacesAWT();
    }
}

