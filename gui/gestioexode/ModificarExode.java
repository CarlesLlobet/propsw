package gui.gestioexode;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModificarExode extends JPanel {

	/**
	 * Create the panel.
	 */
	public ModificarExode() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		add(verticalBox);
		
		JPanel panel = new JPanel();
		verticalBox.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Box verticalBox_1 = Box.createVerticalBox();
		panel.add(verticalBox_1);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox_1.add(verticalGlue_1);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
		JLabel lblAadirRebelde = new JLabel("A\u00F1adir rebelde:");
		horizontalBox.add(lblAadirRebelde);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumSize(new Dimension(32767, 23));
		horizontalBox.add(comboBox);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut_1);
		
		JLabel lblNewLabel = new JLabel("Base destino:");
		horizontalBox.add(lblNewLabel);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setMaximumSize(new Dimension(32767, 23));
		horizontalBox.add(comboBox_1);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut_3);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		horizontalBox.add(btnNewButton);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_1);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_1);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_2);
		
		JLabel lblEsborrarRebelde = new JLabel("Borrar rebelde:");
		horizontalBox_1.add(lblEsborrarRebelde);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalBox_1.add(horizontalStrut_4);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setMaximumSize(new Dimension(32767, 23));
		horizontalBox_1.add(comboBox_2);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		horizontalBox_1.add(horizontalStrut_5);
		
		JButton btnNewButton_1 = new JButton("Borrar");
		horizontalBox_1.add(btnNewButton_1);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_3);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_1);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_2);
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_4);
		
		JLabel lblInicioxodo = new JLabel("Inicio \u00E9xodo:");
		horizontalBox_2.add(lblInicioxodo);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalBox_2.add(horizontalStrut_6);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setMaximumSize(new Dimension(32767, 23));
		horizontalBox_2.add(comboBox_3);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		horizontalBox_2.add(horizontalStrut_7);
		
		JButton btnNewButton_2 = new JButton("Modificar");
		horizontalBox_2.add(btnNewButton_2);
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_5);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_2);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3);
		
		Component horizontalGlue_6 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_6);
		
		JLabel lblEjecutar = new JLabel("Ejecuci\u00F3n");
		horizontalBox_3.add(lblEjecutar);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		horizontalBox_3.add(horizontalStrut_8);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setMaximumSize(new Dimension(32767, 23));
		horizontalBox_3.add(comboBox_4);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		horizontalBox_3.add(horizontalStrut_9);
		
		JButton btnAceptar = new JButton("Aceptar");
		horizontalBox_3.add(btnAceptar);
		
		Component horizontalGlue_7 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_7);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_3);
		
		Box horizontalBox_5 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_5);
		
		Component horizontalGlue_10 = Box.createHorizontalGlue();
		horizontalBox_5.add(horizontalGlue_10);
		
		JButton button = new JButton("Guardar cambios");
		horizontalBox_5.add(button);
		
		Component horizontalGlue_11 = Box.createHorizontalGlue();
		horizontalBox_5.add(horizontalGlue_11);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox_1.add(verticalGlue);

	}
	
	public void reset(){
		
	}
	
	public void actualitza(String s){
		
	}
}
