import javax.swing.JFrame;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class LineDrawing extends JFrame{

    private final float[] coordenadas;
    public LineDrawing(float[] coors){
        super("Pendiente y Ecuación de la recta");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.coordenadas = coors;
    }


    void drawLines(Graphics g){

        Graphics2D g2d = (Graphics2D) g;
        //Eje Y drawing
        g2d.drawString("Eje Y", 250, 45);
        g2d.draw(new Line2D.Float(250.0f, 50f, 250.0f, 450f));
        //Eje X drawing
        g2d.drawString("Eje X", 455, 250);
        g2d.draw(new Line2D.Float(50f, 250f, 450.0f, 250f));


        //Entrada cordenadas
        float x1 = coordenadas[0];
        float y1 = coordenadas[1];
        float x2 = coordenadas[2];
        float y2 = coordenadas[3];



        //Calculo de pendiente y ecuación de la recta
        float pendiente = (y2-y1)/(x2-x1);

        float parteNumericaEcuacion = (pendiente * -x1) + y1;
        String parteNumericaEcuacionYSigno = parteNumericaEcuacion>0? "+" + parteNumericaEcuacion: "" + parteNumericaEcuacion;
        String parteConLiteral = pendiente + "x";
        String ecuacion = parteConLiteral + parteNumericaEcuacionYSigno;

        //Punto 1 , punto 2 , pendiente , ecuación show
        g2d.drawString("Punto 1 = ( " + Math.round(x1) + " , " + Math.round(y1) + " )" , 50, 150);
        g2d.drawString("Punto 2 = ( " + Math.round(x2) + " , " + Math.round(y2) + " )" , 50, 170);
        g2d.drawString("Pendiente = " + pendiente, 50, 190);
        g2d.drawString("Ecuación = " + ecuacion, 50, 210);

        // (0,0) point is at 250,250, so we need to add every coordinate for 250****and *-1 in y for resolve orientation problem
        x1 = x1+250;
        y1 = (y1*-1)+250;
        x2 = x2+250;
        y2 = (y2*-1)+250;


        //Line to draw between two points gived
        g2d.setColor(Color.GRAY);
        g2d.setStroke(new BasicStroke(2f));
        g2d.draw(new Line2D.Float(x1, y1, x2, y2));

        //Line to draw between two far points (for a big line)

        // Calcular las coordenadas para el extremo derecho (x = 1000)
        float farY2 = y1 - pendiente * (1000 - x1);

         // Calcular las coordenadas para el extremo izquierdo (x = -1000)
        float farY3 = y1 - pendiente * (-1000 - x1);

        //Draw long line
        g2d.draw(new Line2D.Float(1000, farY2, -1000, farY3));

        //Draw Two points
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(6f));
        g2d.draw(new Line2D.Float(x1, y1, x1, y1));
        g2d.draw(new Line2D.Float(x2, y2, x2, y2));



    }

    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }


}
