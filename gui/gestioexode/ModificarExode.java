package gui.gestioexode;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.ComponentOrientation;

public class ModificarExode extends JPanel {

	/**
	 * Create the panel.
	 */
	public ModificarExode() {
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBackground(new Color(0,0,0,0));
		Component horizontalGlue_8 = Box.createHorizontalGlue();
		add(horizontalGlue_8);
		
		Box verticalBox = Box.createVerticalBox();
		add(verticalBox);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
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
		horizontalStrut.setMaximumSize(new Dimension(20, 20));
		horizontalBox.add(horizontalStrut);
		
		JComboBox<String> addreb = new JComboBox<String>();
		addreb.setMaximumSize(new Dimension(80, 23));
		horizontalBox.add(addreb);
		addreb.addItem("Escoger rebelde");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setMaximumSize(new Dimension(20, 20));
		horizontalBox.add(horizontalStrut_1);
		
		JLabel lblNewLabel = new JLabel("Base destino:");
		horizontalBox.add(lblNewLabel);
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		horizontalStrut_10.setMaximumSize(new Dimension(20, 20));
		horizontalBox.add(horizontalStrut_10);
		
		JComboBox<String> baseDesti = new JComboBox<String>();
		baseDesti.setMaximumSize(new Dimension(50, 23));
		horizontalBox.add(baseDesti);
		baseDesti.addItem("Escoge base");
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setMaximumSize(new Dimension(20, 20));
		horizontalBox.add(horizontalStrut_2);
		
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
		horizontalStrut_4.setMaximumSize(new Dimension(20, 20));
		horizontalBox_1.add(horizontalStrut_4);
		
		JComboBox<String> borrarRebelde = new JComboBox<String>();
		borrarRebelde.setMaximumSize(new Dimension(80, 23));
		horizontalBox_1.add(borrarRebelde);
		borrarRebelde.addItem("Escoge rebelde");
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setMaximumSize(new Dimension(20, 20));
		horizontalBox_1.add(horizontalStrut_3);
		
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
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		horizontalStrut_5.setMaximumSize(new Dimension(20, 20));
		horizontalBox_2.add(horizontalStrut_5);
		
		JComboBox<String> iniciEx = new JComboBox<String>();
		iniciEx.setMaximumSize(new Dimension(50, 23));
		horizontalBox_2.add(iniciEx);
		iniciEx.addItem("Escoge base");
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalStrut_6.setMaximumSize(new Dimension(20, 20));
		horizontalBox_2.add(horizontalStrut_6);
		
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
		
		JComboBox<String> ejec = new JComboBox<String>();
		ejec.addItem("Escoge ejecución");
		ejec.addItem("FordFulkerson");
		ejec.addItem("Dijkstra");
		ejec.addItem("EK");
				
				Component horizontalStrut_8 = Box.createHorizontalStrut(20);
				horizontalStrut_8.setMaximumSize(new Dimension(20, 20));
				horizontalBox_3.add(horizontalStrut_8);
		
				ejec.setMaximumSize(new Dimension(50, 23));
				horizontalBox_3.add(ejec);
				
				Component horizontalStrut_7 = Box.createHorizontalStrut(20);
				horizontalStrut_7.setMaximumSize(new Dimension(20, 20));
				horizontalBox_3.add(horizontalStrut_7);
				
				JButton btnAceptar = new JButton("Aceptar");
				horizontalBox_3.add(btnAceptar);
				
				Component horizontalGlue_5 = Box.createHorizontalGlue();
				horizontalBox_3.add(horizontalGlue_5);
				
				Component verticalStrut_3 = Box.createVerticalStrut(20);
				verticalBox_1.add(verticalStrut_3);
				
				Box horizontalBox_5 = Box.createHorizontalBox();
				verticalBox_1.add(horizontalBox_5);
				
				Component horizontalGlue_10 = Box.createHorizontalGlue();
				horizontalBox_5.add(horizontalGlue_10);
				
				JButton button = new JButton("Guardar cambios");
				button.setAlignmentX(Component.CENTER_ALIGNMENT);
				horizontalBox_5.add(button);
				
				Component horizontalGlue_11 = Box.createHorizontalGlue();
				horizontalBox_5.add(horizontalGlue_11);
				
				Component verticalGlue_1 = Box.createVerticalGlue();
				verticalBox.add(verticalGlue_1);
				
				Component horizontalGlue_9 = Box.createHorizontalGlue();
				add(horizontalGlue_9);

	}
	
	public void reset(){
		
	}
	
	public void actualitza(String s){
		
	}
}
