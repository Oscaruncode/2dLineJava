
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JPaneMultiple jPaneMultiple = new JPaneMultiple();
                float[] coordinates = jPaneMultiple.getCoordinates();
                new LineDrawing(coordinates).setVisible(true);
            }
        });

    }
}