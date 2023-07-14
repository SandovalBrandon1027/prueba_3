import com.sun.source.tree.IfTree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class formulario {
    private JPanel Main;
    private JLabel Codigo;
    private JTextField codigos;
    private JTextField cedulas;
    private JTextField nombres;
    private JTextField apellidos;
    private JComboBox signos;
    private JButton guardar;
    private JButton cargar;
    private JButton Anterior;
    private JButton Siguiente;
    private JComboBox año;
    private JComboBox mes;
    private JComboBox dias;
    private JCheckBox rojo;
    private JCheckBox verde;
    private JCheckBox ninguno;
    private JRadioButton si;
    private JRadioButton no;
    private ArrayList<datos> listaDatos;
    private int ind;




    public formulario() {
        listaDatos = new ArrayList<>();
            guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(guardar,"guardado correctamente");
                String nombre = nombres.getText();
                String apellido = apellidos.getText();
                String cedula = cedulas.getText();
                String codigo = codigos.getText();




                datos ingreso = new datos("","","","");
                listaDatos.add(ingreso);

                for(int i = 0; i < listaDatos.size(); i++){
                    String filePath = i + " Datos.dat ";
                    try(
                            FileOutputStream fileOut = new FileOutputStream(filePath);
                            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
                    ){
                        objOut.writeObject(ingreso);
                        System.out.println("Archivo guardado correctamente");
                    }
                    catch (IOException ex){
                        throw new RuntimeException(ex);
                    }

                }

                nombres.setText("");
                apellidos.setText("");
                cedulas.setText("");
                codigos.setText("");
                //JOptionPane.showMessageDialog(guardar,"guardado correctamente");

            }
        });
        Siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ind < listaDatos.size()-1){
                    ind++;
                    datos datos1 = listaDatos.get(ind);
                    nombres.setText(datos1.getNombre());
                    apellidos.setText(String.valueOf(datos1.getApellido()));
                    cedulas.setText(String.valueOf(datos1.getCedula()));
                    codigos.setText(String.valueOf(datos1.getCodigo()));
                }
            }
        });

        Anterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ind--;
                if(ind > 0){
                    datos datos1 = listaDatos.get(ind);
                    nombres.setText(datos1.getNombre());
                    apellidos.setText(String.valueOf(datos1.getApellido()));
                    cedulas.setText(String.valueOf(datos1.getCedula()));
                    codigos.setText(String.valueOf(datos1.getCodigo()));
                }
            }
        });


}

    public static void main(String[] args) {
        JFrame frame = new JFrame("formulario");
        frame.setContentPane(new formulario().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
