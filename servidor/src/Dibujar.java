import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Dibujar extends JPanel {

    private MouseHandler mouseHandler = new MouseHandler();

    private Point Point1 = new Point();
    private Point Point2 = new Point();

    public ArrayList<Line2D> lineas = new ArrayList<Line2D>();

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

                double x1 = Point1.getX();
                double y1 = Point1.getY();
                double x2 = Point2.getX();
                double y2 = Point2.getY();

                if (Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)) <= 200) {
                    drawLineHelper(Point1, Point2);
                    dosPuntos = false;

                }else{
                    dosPuntos = false;
                }
            }
        }
    }

        public void drawLineHelper(Point prev, Point next){

            Graphics g = getGraphics();
            g.setColor(Color.red);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(5));
            g2.draw(new Line2D.Float(Point1.x, Point1.y, Point2.x, Point2.y));
            lineas.add(new Line2D.Float(Point1.x, Point1.y, Point2.x, Point2.y));
            System.out.println(lineas);

        }


    public void display() {
        JFrame f = new JFrame("Dibujar");
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

