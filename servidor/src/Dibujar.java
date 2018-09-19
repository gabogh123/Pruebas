import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

public class Dibujar extends JPanel {

    private MouseHandler mouseHandler = new MouseHandler();

    private Point Point1 = new Point();
    private Point Point2 = new Point();

    public Dibujar() {
        this.setPreferredSize(new Dimension(640, 480));
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }


    private class MouseHandler extends MouseAdapter {
        boolean dosPuntos=false;

        @Override
        public void mousePressed(MouseEvent e) {
            if(dosPuntos==false){
                Point1 = e.getPoint();
                dosPuntos = true;
            }
            else{
                Point2 = e.getPoint();
                drawLineHelper(Point1,Point2);
                dosPuntos = false;

            }
        }
    }

        public void drawLineHelper(Point prev, Point next){

            Graphics g = getGraphics();
            g.setColor(Color.red);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(5));
            g2.draw(new Line2D.Float(Point1.x, Point1.y, Point2.x, Point2.y));

        }


    public void display() {
        JFrame f = new JFrame("Road Creator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Dibujar rc = new Dibujar();
        rc.display();

    }
}

