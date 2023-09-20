import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class LineDrawing extends JFrame{

    private final float[] coordenadas;
    public LineDrawing(float[] coors){
        super("Pendiente y punto pendiente");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.coordenadas = coors;
    }


    void drawLines(Graphics g){

        Graphics2D g2d = (Graphics2D) g;
        //Eje Y
        g2d.draw(new Line2D.Float(250.0f, 50f, 250.0f, 450f));
        //Eje X
        g2d.draw(new Line2D.Float(50f, 250f, 450.0f, 250f));


        //System.out.println("("+x1+","+y1+")"+","+"("+x2+","+y2+")");
        // (0,0) point is at 250,250, so we need to add every coordinate for 250****and *-1 in y for resolve orientation problem
        float x1 = (coordenadas[0])+250;
        float y1 = (coordenadas[1]*-1)+250;
        float x2 = (coordenadas[2])+250;
        float y2 = (coordenadas[3]*-1)+250;
        //Line to draw:
        g2d.draw(new Line2D.Float(x1, y1, x2, y2));

     }

    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }


}
