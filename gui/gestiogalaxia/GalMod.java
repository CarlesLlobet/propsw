package gui.gestiogalaxia;

import gui.Principal;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GalMod extends JPanel{
	private JTextField nomBase;
	private JTextField cap;
	private JTextField cost;
	
	private JComboBox<String> eliminaBase;
	private JComboBox<String> creaBO;
	private JComboBox<String> creaBD;
	private JComboBox<String> eliminaBO;
	private JComboBox<String> eliminaBD;
	
	
	public GalMod() {
		//PREPARAMOS LA VISTA
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setBackground(new Color(0,0,0,0));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		add(horizontalGlue);
		
		Box verticalBox = Box.createVerticalBox();
		add(verticalBox);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		verticalBox.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Box horizontalBox = Box.createHorizontalBox();
		panel.add(horizontalBox);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut_2);
		
		Box verticalBox_5 = Box.createVerticalBox();
		horizontalBox.add(verticalBox_5);
		verticalBox_5.setAlignmentX(Component.CENTER_ALIGNMENT);
		
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
		
		nomBase = new JTextField();
		nomBase.setMaximumSize(new Dimension(120, 20));
		nomBase.setColumns(10);
		nomBase.setAlignmentX(0.0f);
		horizontalBox_2.add(nomBase);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		horizontalStrut_8.setMaximumSize(new Dimension(20, 30));
		horizontalBox_2.add(horizontalStrut_8);
		
		JButton btnAfegir = new JButton("Afegir");
		horizontalBox_2.add(btnAfegir);
		
		btnAfegir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nom = nomBase.getText();
				if (!nom.equals("")){
					try {
						Principal.getGc().addBase(nom);
						actuCombos();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
				nomBase.setText("");
			}
		});
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setMaximumSize(new Dimension(30, 20));
		verticalBox_5.add(verticalStrut_1);
		
		JLabel lblEliminarBase = new JLabel("Eliminar Base");
		lblEliminarBase.setFont(new Font("Tahoma", Font.BOLD, 14));
		verticalBox_5.add(lblEliminarBase);
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		horizontalBox_4.setAlignmentY(0.5f);
		horizontalBox_4.setAlignmentX(0.0f);
		verticalBox_5.add(horizontalBox_4);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setMaximumSize(new Dimension(20, 20));
		horizontalBox_4.add(horizontalStrut_1);
		
		JLabel lblBaseAEliminar = new JLabel("Base a eliminar:");
		horizontalBox_4.add(lblBaseAEliminar);
		
		Component horizontalStrut_17 = Box.createHorizontalStrut(20);
		horizontalStrut_17.setMaximumSize(new Dimension(20, 20));
		horizontalBox_4.add(horizontalStrut_17);
		
		eliminaBase = new JComboBox<String>();
		eliminaBase.setMaximumSize(new Dimension(80, 20));
		eliminaBase.setAlignmentX(0.0f);
		horizontalBox_4.add(eliminaBase);
		
		Component horizontalStrut_27 = Box.createHorizontalStrut(20);
		horizontalStrut_27.setMaximumSize(new Dimension(20, 20));
		horizontalBox_4.add(horizontalStrut_27);
		
		JButton borrar = new JButton("Eliminar");
		horizontalBox_4.add(borrar);
		
		Component horizontalStrut_18 = Box.createHorizontalStrut(20);
		horizontalStrut_18.setMaximumSize(new Dimension(20, 20));
		horizontalBox_4.add(horizontalStrut_18);
		
		Component horizontalStrut_28 = Box.createHorizontalStrut(20);
		horizontalStrut_28.setMaximumSize(new Dimension(20, 20));
		horizontalBox_4.add(horizontalStrut_28);
		
		Component verticalStrut_9 = Box.createVerticalStrut(20);
		verticalStrut_9.setMaximumSize(new Dimension(30, 20));
		verticalBox_5.add(verticalStrut_9);
		
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
		
		creaBO = new JComboBox<String>();
		horizontalBox_13.add(creaBO);
		creaBO.setAlignmentX(Component.LEFT_ALIGNMENT);
		creaBO.setMaximumSize(new Dimension(80, 20));
		
		Component horizontalStrut_23 = Box.createHorizontalStrut(20);
		horizontalStrut_23.setMaximumSize(new Dimension(20, 20));
		horizontalBox_13.add(horizontalStrut_23);
		
		Component horizontalStrut_29 = Box.createHorizontalStrut(20);
		horizontalStrut_29.setMaximumSize(new Dimension(20, 20));
		horizontalBox_13.add(horizontalStrut_29);
		
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
		
		creaBD = new JComboBox<String>();
		horizontalBox_14.add(creaBD);
		creaBD.setAlignmentX(Component.LEFT_ALIGNMENT);
		creaBD.setMaximumSize(new Dimension(80, 20));
		
		Component horizontalStrut_20 = Box.createHorizontalStrut(20);
		horizontalStrut_20.setMaximumSize(new Dimension(20, 20));
		horizontalBox_14.add(horizontalStrut_20);
		
		Component horizontalStrut_30 = Box.createHorizontalStrut(20);
		horizontalStrut_30.setMaximumSize(new Dimension(20, 20));
		horizontalBox_14.add(horizontalStrut_30);
		
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
		
		cap = new JTextField();
		horizontalBox_15.add(cap);
		cap.setMinimumSize(new Dimension(40, 20));
		cap.setMaximumSize(new Dimension(40, 20));
		cap.setAlignmentX(Component.LEFT_ALIGNMENT);
		cap.setColumns(10);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		verticalStrut_4.setMaximumSize(new Dimension(30, 20));
		verticalBox_5.add(verticalStrut_4);
		
		Box horizontalBox_12 = Box.createHorizontalBox();
		horizontalBox_12.setMinimumSize(new Dimension(0, 100));
		horizontalBox_12.setAlignmentX(Component.LEFT_ALIGNMENT);
		horizontalBox_12.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox_5.add(horizontalBox_12);
		
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
		
		cost = new JTextField();
		horizontalBox_16.add(cost);
		cost.setMinimumSize(new Dimension(40, 30));
		cost.setMaximumSize(new Dimension(40, 20));
		cost.setColumns(10);
		cost.setAlignmentX(0.0f);
		
		Component horizontalStrut_14 = Box.createHorizontalStrut(20);
		horizontalBox_16.add(horizontalStrut_14);
		horizontalStrut_14.setMaximumSize(new Dimension(20, 20));
		
		Component horizontalStrut_15 = Box.createHorizontalStrut(20);
		horizontalBox_16.add(horizontalStrut_15);
		horizontalStrut_15.setMaximumSize(new Dimension(20, 20));
		
		Component horizontalStrut_16 = Box.createHorizontalStrut(20);
		horizontalBox_16.add(horizontalStrut_16);
		horizontalStrut_16.setMaximumSize(new Dimension(20, 20));
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setMaximumSize(new Dimension(30, 20));
		verticalBox_5.add(verticalStrut_2);
		
		JButton crearAd = new JButton("Crear adyacencia");
		verticalBox_5.add(crearAd);
		
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
		
		eliminaBO = new JComboBox<String>();
		eliminaBO.setMaximumSize(new Dimension(80, 20));
		eliminaBO.setAlignmentX(0.0f);
		horizontalBox_1.add(eliminaBO);
		
		Component horizontalStrut_19 = Box.createHorizontalStrut(20);
		horizontalStrut_19.setMaximumSize(new Dimension(20, 20));
		horizontalBox_1.add(horizontalStrut_19);
		
		Component horizontalStrut_31 = Box.createHorizontalStrut(20);
		horizontalStrut_31.setMaximumSize(new Dimension(20, 20));
		horizontalBox_1.add(horizontalStrut_31);
		
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
		
		eliminaBD = new JComboBox<String>();
		eliminaBD.setMaximumSize(new Dimension(80, 20));
		eliminaBD.setAlignmentX(0.0f);
		horizontalBox_3.add(eliminaBD);
		
		Component horizontalStrut_26 = Box.createHorizontalStrut(20);
		horizontalStrut_26.setMaximumSize(new Dimension(20, 20));
		horizontalBox_3.add(horizontalStrut_26);
		
		Component horizontalStrut_32 = Box.createHorizontalStrut(20);
		horizontalStrut_32.setMaximumSize(new Dimension(20, 20));
		horizontalBox_3.add(horizontalStrut_32);
		
		Component verticalStrut_11 = Box.createVerticalStrut(20);
		verticalStrut_11.setMaximumSize(new Dimension(30, 20));
		verticalBox_5.add(verticalStrut_11);
		
		JButton eliminarAd = new JButton("Eliminar adyacencia");
		verticalBox_5.add(eliminarAd);
		
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int val = eliminaBase.getSelectedIndex();
				if (val > 0){
					int idb = Integer.parseInt(eliminaBase.getSelectedItem().toString());
					try {
						Principal.getCc().getGalaxia().removeBase(idb);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					eliminaBase.removeItemAt(val);
					eliminaBase.setSelectedIndex(0);
				}
			}
		});
		
		
		crearAd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bo = creaBO.getSelectedItem().toString();
				int val1 = creaBO.getSelectedIndex();
				String bd = creaBD.getSelectedItem().toString();
				int val2 = creaBD.getSelectedIndex();
				String capa = cap.getText();
				String coste = cost.getText();
				if (val1 > 0 && val2 > 0 && !cap.equals("") && !cost.equals("")){
					try {
						Principal.getGc().createAdjacency(Integer.parseInt(bo), Integer.parseInt(bd), Integer.parseInt(capa), Integer.parseInt(coste));
						actuCombos();
						cap.setText("");
						cost.setText("");
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});		
		
		
		
		eliminarAd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bo = eliminaBO.getSelectedItem().toString();
				int v1 = eliminaBO.getSelectedIndex();
				String bd = eliminaBD.getSelectedItem().toString();
				int v2 = eliminaBD.getSelectedIndex();
				System.out.println("BO: " + bo + " BD: " + bd + "V1: " + v1 + " V2: " + v2);
				if (v1 > 0 && v2 > 0) {
					try {
						//AIXO NO TIRA EXCEPCIO QUAN 
						Principal.getGc().deleteAdjacencia(Integer.parseInt(bo), Integer.parseInt(bd));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						System.out.println("No existe adyacencia");
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					actuCombos();
				}
			}
		});
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4.setMaximumSize(new Dimension(20, 20));
		verticalBox_5.add(horizontalStrut_4);
		
		Component verticalStrut_10 = Box.createVerticalStrut(20);
		horizontalBox.add(verticalStrut_10);
		verticalStrut_10.setMaximumSize(new Dimension(30, 20));
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_1);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		add(horizontalGlue_1);
		
		actuCombos();
	}
	
	
	//Aquesta funcio actualitza els combobox cada vegada que hi hagi un canvi a la galaxia.
	public void actuCombos(){
		System.out.println("ACTUCOMBO");
		//recalculem l'array de les bases que existeixen:
		ArrayList<String> bases = new ArrayList<String>();
		try {
			bases = Principal.getGc().arrayBaseOrd();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("BASES DE LA GALAXIA");
		for (String s: bases){
			System.out.println("ID BASE : "+ s);
		}
		
		
		eliminaBase.removeAllItems();;
		creaBO.removeAllItems();
		creaBD.removeAllItems();
		eliminaBO.removeAllItems();
		eliminaBD.removeAllItems();
		
		eliminaBase.addItem("Escoge Base");
		creaBO.addItem("Escoge Base");
		creaBD.addItem("Escoge Base");
		eliminaBO.addItem("Escoge Base");
		eliminaBD.addItem("Escoge Base");
		
		for(String s : bases){
			eliminaBase.addItem(s);
			creaBO.addItem(s);
			creaBD.addItem(s);
			eliminaBO.addItem(s);
			eliminaBD.addItem(s);
		}
		
		eliminaBase.setSelectedIndex(0);
		creaBO.setSelectedIndex(0);
		creaBD.setSelectedIndex(0);
		eliminaBO.setSelectedIndex(0);
		eliminaBD.setSelectedIndex(0);
		revalidate();
	}	
	
	public void reset(){
		eliminaBase.setSelectedIndex(0);
		creaBO.setSelectedIndex(0);
		creaBD.setSelectedIndex(0);
		eliminaBO.setSelectedIndex(0);
		eliminaBD.setSelectedIndex(0);
		cap.setText("");
		cost.setText("");
		nomBase.setText("");
	}
}
