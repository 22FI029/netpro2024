package guichat;

import java.awt.Color;
import java.awt.Graphics;

class GUIAnimatinFaceLook {
    int h = 100;
    int w = 100;

    int xStart = 0;
    int yStart = 0;

    Color faceColor = Color.gray;

    public void setXY(int x, int y) {
        this.xStart = x;
        this.yStart = y;
    }

    public void setSize(int h, int w) {
        this.h = h;
        this.w = h;
    }

    public void setColor(Color color) {
        this.faceColor = color;
    }


    public GUIAnimatinFaceLook() {
    }

    public void makeFace(Graphics g, String emotion) {
        makeEyes(g, w / 5);
        makeNose(g, h / 5);
        makeMouth(g, w / 2);
        makeEyebrows(g, w / 5, emotion);
    }

    void makeEyes(Graphics g, int eyeSize) {
        g.setColor(Color.blue);
        g.fillArc(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize, 0, 300);
        g.setColor(Color.black);
        g.drawOval(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
        g.drawOval(xStart + (h * 4 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
    }

    public void makeNose(Graphics g, int noseSize) {
        g.drawLine(xStart + (h * 1 / 2), yStart + (w * 2 / 4), xStart + (h * 1 / 2), yStart + (w * 2 / 4) + noseSize);
    }

    public void makeMouth(Graphics g, int mouthSize) {
        int xMiddle = xStart + h / 2;
        int yMiddle = yStart + 3 * w / 4;
        g.drawLine(xMiddle - mouthSize / 2, yMiddle, xMiddle + mouthSize / 2, yMiddle);
    }

    public void makeEyebrows(Graphics g, int eyebrowSize, String emotion) {
        g.setColor(Color.black);
        int xLeftStart = xStart + (h * 2 / 7);
        int xRightStart = xStart + (h * 4 / 7);
        int yPosition = yStart + (w * 1 / 4);

        if (emotion.equals("smile")) {
            g.drawLine(xLeftStart, yPosition, xLeftStart + eyebrowSize, yPosition - 10);
            g.drawLine(xRightStart, yPosition, xRightStart + eyebrowSize, yPosition - 10);
        } else if (emotion.equals("angry")) {
            g.drawLine(xLeftStart, yPosition - 10, xLeftStart + eyebrowSize, yPosition);
            g.drawLine(xRightStart, yPosition - 10, xRightStart + eyebrowSize, yPosition);
        } else {
            g.drawLine(xLeftStart, yPosition, xLeftStart + eyebrowSize, yPosition);
            g.drawLine(xRightStart, yPosition, xRightStart + eyebrowSize, yPosition);
        }
    }
}
