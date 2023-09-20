import javax.swing.*;
public class JPaneMultiple {
    private JTextField x1Field = new JTextField();
    private JTextField y1Field = new JTextField();
    private JTextField x2Field = new JTextField();
    private JTextField y2Field = new JTextField();

    public float[] getCoordinates() {
        Object[] message = {
                "x1", x1Field,
                "y1", y1Field,
                "x2", x2Field,
                "y2", y2Field
        };

        boolean repeatInput = true;
        while (repeatInput) {
            int option = JOptionPane.showConfirmDialog(null, message, "Cordenadas", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {

                if( !x1Field.getText().isEmpty() && !y1Field.getText().isEmpty() && !x2Field.getText().isEmpty() && !y2Field.getText().isEmpty()){
                    //Solo cuando se ha oprimido ok y los campos estan completos, el programa deja de ejecutar el ciclo y retorna el array
                    float x1 = Float.parseFloat(x1Field.getText());
                    float y1 = Float.parseFloat(y1Field.getText());
                    float x2 = Float.parseFloat(x2Field.getText());
                    float y2 = Float.parseFloat(y2Field.getText());
                    return new float[]{x1, y1, x2, y2};
                }

            }

        }

        return null;
    }


}
