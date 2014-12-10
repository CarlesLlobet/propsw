package gui.gestiogalaxia;

import gui.Principal;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.Box;

import java.awt.Component;

import javax.swing.JTextField;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;

public class GalMod extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public GalMod() {
		setBackground(new Color(0,0,0,0));
		//setBackground(Color.CYAN);
		System.out.println("A PINTAAAR MODIFICAR GALAXIA");
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		add(horizontalGlue);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setMaximumSize(new Dimension(550, 550));
		add(verticalBox);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		Panel panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		verticalBox.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Box verticalBox_5 = Box.createVerticalBox();
		verticalBox_5.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(verticalBox_5);
		
		JLabel lblNomGalaxia = new JLabel("Nombre Galaxia\r\n");
		verticalBox_5.add(lblNomGalaxia);
		lblNomGalaxia.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox_5.add(horizontalBox);
		horizontalBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		horizontalBox.setBackground(Color.WHITE);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setMaximumSize(new Dimension(20, 30));
		horizontalBox.add(horizontalStrut_2);
		
		textField = new JTextField();
		textField.setMaximumSize(new Dimension(120, 20));
		horizontalBox.add(textField);
		textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField.setColumns(10);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setMaximumSize(new Dimension(20, 30));
		horizontalBox.add(horizontalStrut_3);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setPreferredSize(new Dimension(71, 30));
		horizontalBox.add(btnGuardar);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setMaximumSize(new Dimension(30, 20));
		verticalBox_5.add(verticalStrut_2);
		
		JLabel lblAfegirBase = new JLabel("A\u00F1adir Base - Nombre");
		verticalBox_5.add(lblAfegirBase);
		lblAfegirBase.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox_5.add(horizontalBox_2);
		horizontalBox_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		horizontalBox_2.setBackground(Color.WHITE);
		horizontalBox_2.setAlignmentY(0.5f);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		horizontalStrut_7.setMaximumSize(new Dimension(20, 30));
		horizontalBox_2.add(horizontalStrut_7);
		
		textField_1 = new JTextField();
		textField_1.setMaximumSize(new Dimension(120, 20));
		textField_1.setColumns(10);
		textField_1.setAlignmentX(0.0f);
		horizontalBox_2.add(textField_1);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		horizontalStrut_8.setMaximumSize(new Dimension(20, 30));
		horizontalBox_2.add(horizontalStrut_8);
		
		JButton btnAfegir = new JButton("Afegir");
		btnAfegir.setPreferredSize(new Dimension(61, 30));
		horizontalBox_2.add(btnAfegir);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setMaximumSize(new Dimension(30, 20));
		verticalBox_5.add(verticalStrut_1);
		
		JLabel label_4 = new JLabel("Crear Adyacencia\r\n");
		verticalBox_5.add(label_4);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		Box horizontalBox_13 = Box.createHorizontalBox();
		verticalBox_5.add(horizontalBox_13);
		horizontalBox_13.setAlignmentY(Component.CENTER_ALIGNMENT);
		horizontalBox_13.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		horizontalStrut_9.setMaximumSize(new Dimension(20, 20));
		horizontalBox_13.add(horizontalStrut_9);
		
		JLabel lblBaseOrigen = new JLabel("Base Origen");
		horizontalBox_13.add(lblBaseOrigen);
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		horizontalBox_13.add(horizontalStrut_10);
		horizontalStrut_10.setMaximumSize(new Dimension(20, 20));
		
		JComboBox comboBox = new JComboBox();
		horizontalBox_13.add(comboBox);
		comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		comboBox.setMaximumSize(new Dimension(80, 20));
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		verticalStrut_6.setMaximumSize(new Dimension(30, 20));
		verticalBox_5.add(verticalStrut_6);
		
		Box horizontalBox_14 = Box.createHorizontalBox();
		verticalBox_5.add(horizontalBox_14);
		horizontalBox_14.setAlignmentY(Component.CENTER_ALIGNMENT);
		horizontalBox_14.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalStrut_6.setMaximumSize(new Dimension(20, 20));
		horizontalBox_14.add(horizontalStrut_6);
		
		JLabel lblBaseDestino = new JLabel("Base Destino");
		horizontalBox_14.add(lblBaseDestino);
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		horizontalBox_14.add(horizontalStrut_11);
		horizontalStrut_11.setMaximumSize(new Dimension(20, 20));
		
		JComboBox comboBox_1 = new JComboBox();
		horizontalBox_14.add(comboBox_1);
		comboBox_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		comboBox_1.setMaximumSize(new Dimension(80, 20));
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		verticalStrut_5.setMaximumSize(new Dimension(30, 20));
		verticalBox_5.add(verticalStrut_5);
		
		Box horizontalBox_15 = Box.createHorizontalBox();
		verticalBox_5.add(horizontalBox_15);
		horizontalBox_15.setAlignmentY(Component.CENTER_ALIGNMENT);
		horizontalBox_15.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		horizontalStrut_5.setMaximumSize(new Dimension(20, 20));
		horizontalBox_15.add(horizontalStrut_5);
		
		JLabel lblCapacidad = new JLabel("Capacidad");
		horizontalBox_15.add(lblCapacidad);
		
		Component horizontalStrut_12 = Box.createHorizontalStrut(20);
		horizontalBox_15.add(horizontalStrut_12);
		horizontalStrut_12.setMaximumSize(new Dimension(20, 20));
		
		textField_2 = new JTextField();
		horizontalBox_15.add(textField_2);
		textField_2.setMinimumSize(new Dimension(40, 20));
		textField_2.setMaximumSize(new Dimension(40, 20));
		textField_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField_2.setColumns(10);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		verticalStrut_4.setMaximumSize(new Dimension(30, 20));
		verticalBox_5.add(verticalStrut_4);
		
		Box horizontalBox_12 = Box.createHorizontalBox();
		horizontalBox_12.setMinimumSize(new Dimension(0, 100));
		horizontalBox_12.setAlignmentX(Component.LEFT_ALIGNMENT);
		horizontalBox_12.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox_5.add(horizontalBox_12);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4.setMaximumSize(new Dimension(20, 20));
		horizontalBox_12.add(horizontalStrut_4);
		
		Box horizontalBox_16 = Box.createHorizontalBox();
		verticalBox_5.add(horizontalBox_16);
		horizontalBox_16.setAlignmentY(Component.CENTER_ALIGNMENT);
		horizontalBox_16.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setMaximumSize(new Dimension(20, 20));
		horizontalBox_16.add(horizontalStrut);
		
		JLabel lblCoste = new JLabel("Coste");
		horizontalBox_16.add(lblCoste);
		
		Component horizontalStrut_13 = Box.createHorizontalStrut(20);
		horizontalBox_16.add(horizontalStrut_13);
		horizontalStrut_13.setMaximumSize(new Dimension(20, 20));
		
		textField_3 = new JTextField();
		horizontalBox_16.add(textField_3);
		textField_3.setMinimumSize(new Dimension(40, 30));
		textField_3.setMaximumSize(new Dimension(40, 20));
		textField_3.setColumns(10);
		textField_3.setAlignmentX(0.0f);
		
		Component horizontalStrut_14 = Box.createHorizontalStrut(20);
		horizontalBox_16.add(horizontalStrut_14);
		horizontalStrut_14.setMaximumSize(new Dimension(20, 20));
		
		Component horizontalStrut_15 = Box.createHorizontalStrut(20);
		horizontalBox_16.add(horizontalStrut_15);
		horizontalStrut_15.setMaximumSize(new Dimension(20, 20));
		
		Component horizontalStrut_16 = Box.createHorizontalStrut(20);
		horizontalBox_16.add(horizontalStrut_16);
		horizontalStrut_16.setMaximumSize(new Dimension(20, 20));
		
		JButton button = new JButton("Crear adyacencia");
		horizontalBox_16.add(button);
		button.setMinimumSize(new Dimension(117, 30));
		button.setMaximumSize(new Dimension(117, 20));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setMaximumSize(new Dimension(30, 20));
		verticalBox_5.add(verticalStrut);
		
		JLabel lblEliminarAdyacencia = new JLabel("Eliminar adyacencia");
		verticalBox_5.add(lblEliminarAdyacencia);
		lblEliminarAdyacencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setAlignmentY(0.5f);
		horizontalBox_1.setAlignmentX(0.0f);
		verticalBox_5.add(horizontalBox_1);
		
		Component horizontalStrut_21 = Box.createHorizontalStrut(20);
		horizontalStrut_21.setMaximumSize(new Dimension(20, 20));
		horizontalBox_1.add(horizontalStrut_21);
		
		JLabel label = new JLabel("Base Origen");
		horizontalBox_1.add(label);
		
		Component horizontalStrut_22 = Box.createHorizontalStrut(20);
		horizontalStrut_22.setMaximumSize(new Dimension(20, 20));
		horizontalBox_1.add(horizontalStrut_22);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setMaximumSize(new Dimension(80, 20));
		comboBox_4.setAlignmentX(0.0f);
		horizontalBox_1.add(comboBox_4);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalStrut_3.setMaximumSize(new Dimension(30, 20));
		verticalBox_5.add(verticalStrut_3);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		horizontalBox_3.setAlignmentY(0.5f);
		horizontalBox_3.setAlignmentX(0.0f);
		verticalBox_5.add(horizontalBox_3);
		
		Component horizontalStrut_24 = Box.createHorizontalStrut(20);
		horizontalStrut_24.setMaximumSize(new Dimension(20, 20));
		horizontalBox_3.add(horizontalStrut_24);
		
		JLabel label_1 = new JLabel("Base Destino");
		horizontalBox_3.add(label_1);
		
		Component horizontalStrut_25 = Box.createHorizontalStrut(20);
		horizontalStrut_25.setMaximumSize(new Dimension(20, 20));
		horizontalBox_3.add(horizontalStrut_25);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setMinimumSize(new Dimension(100, 20));
		comboBox_5.setMaximumSize(new Dimension(80, 20));
		comboBox_5.setAlignmentX(0.0f);
		horizontalBox_3.add(comboBox_5);
		
		Component horizontalStrut_26 = Box.createHorizontalStrut(20);
		horizontalStrut_26.setMaximumSize(new Dimension(20, 20));
		horizontalBox_3.add(horizontalStrut_26);
		
		JButton button_2 = new JButton("Eliminar adyacencia");
		horizontalBox_3.add(button_2);
		
		Component verticalStrut_7 = Box.createVerticalStrut(20);
		verticalStrut_7.setMaximumSize(new Dimension(30, 20));
		verticalBox_5.add(verticalStrut_7);
		
		Component MOLTIMPORTANT = Box.createHorizontalStrut(20);
		MOLTIMPORTANT.setMaximumSize(new Dimension(20, 20));
		verticalBox_5.add(MOLTIMPORTANT);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_1);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		add(horizontalGlue_1);
	}

}
