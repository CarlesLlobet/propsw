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
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		JPanel panel = new JPanel();
		verticalBox.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(verticalBox_1);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(horizontalBox);
		
		Component horizontalGlue_7 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_7);
		
		JLabel lblAadirRebelde = new JLabel("A\u00F1adir rebelde:");
		horizontalBox.add(lblAadirRebelde);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut);
		
		JComboBox<String> addreb = new JComboBox<String>();
		addreb.setMaximumSize(new Dimension(80, 23));
		horizontalBox.add(addreb);
		addreb.addItem("Escoger rebelde");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut_1);
		
		JLabel lblNewLabel = new JLabel("Base destino:");
		horizontalBox.add(lblNewLabel);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut_2);
		
		JComboBox<String> baseDesti = new JComboBox<String>();
		baseDesti.setMaximumSize(new Dimension(50, 23));
		horizontalBox.add(baseDesti);
		baseDesti.addItem("Escoge base");
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut_3);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		horizontalBox.add(btnNewButton);
		
		Component horizontalGlue_6 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_6);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(horizontalBox_1);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue);
		
		JLabel lblEsborrarRebelde = new JLabel("Borrar rebelde:");
		horizontalBox_1.add(lblEsborrarRebelde);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalBox_1.add(horizontalStrut_4);
		
		JComboBox<String> borrarRebelde = new JComboBox<String>();
		borrarRebelde.setMaximumSize(new Dimension(80, 23));
		horizontalBox_1.add(borrarRebelde);
		borrarRebelde.addItem("Escoge rebelde");
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		horizontalBox_1.add(horizontalStrut_5);
		
		JButton btnNewButton_1 = new JButton("Borrar");
		horizontalBox_1.add(btnNewButton_1);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_1);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_1);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(horizontalBox_2);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_2);
		
		JLabel lblInicioxodo = new JLabel("Inicio \u00E9xodo:");
		horizontalBox_2.add(lblInicioxodo);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalBox_2.add(horizontalStrut_6);
		
		JComboBox<String> iniciEx = new JComboBox<String>();
		iniciEx.setMaximumSize(new Dimension(50, 23));
		horizontalBox_2.add(iniciEx);
		iniciEx.addItem("Escoge base");
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		horizontalBox_2.add(horizontalStrut_7);
		
		JButton btnNewButton_2 = new JButton("Modificar");
		horizontalBox_2.add(btnNewButton_2);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_3);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_2);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3);
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_4);
		
		JLabel lblEjecutar = new JLabel("Ejecuci\u00F3n");
		horizontalBox_3.add(lblEjecutar);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		horizontalBox_3.add(horizontalStrut_8);
		
		JComboBox<String> ejec = new JComboBox<String>();
		ejec.addItem("Escoge ejecución");
		ejec.addItem("FordFulkerson");
		ejec.addItem("Dijkstra");
		ejec.addItem("EK");
		
				ejec.setMaximumSize(new Dimension(50, 23));
				horizontalBox_3.add(ejec);
				
				Component horizontalStrut_9 = Box.createHorizontalStrut(20);
				horizontalBox_3.add(horizontalStrut_9);
				
				JButton btnAceptar = new JButton("Aceptar");
				horizontalBox_3.add(btnAceptar);
				
				Component horizontalGlue_5 = Box.createHorizontalGlue();
				horizontalBox_3.add(horizontalGlue_5);
				
				Component verticalStrut_3 = Box.createVerticalStrut(20);
				verticalBox_1.add(verticalStrut_3);
				
				Box horizontalBox_5 = Box.createHorizontalBox();
				verticalBox_1.add(horizontalBox_5);
				
				JButton button = new JButton("Guardar cambios");
				button.setAlignmentX(Component.CENTER_ALIGNMENT);
				horizontalBox_5.add(button);
				
				Component verticalGlue_1 = Box.createVerticalGlue();
				verticalBox.add(verticalGlue_1);

	}
	
	public void reset(){
		
	}
	
	public void actualitza(String s){
		
	}
}
