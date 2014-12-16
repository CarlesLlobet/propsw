package gui.gestioexode;

import gui.Principal;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.sql.rowset.BaseRowSet;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class ModificarExode extends JPanel {

	/**
	 * Create the panel.
	 */
	private String data[] = {"NO","HAY","INFO","TODAVIA"};
	
	private JComboBox<String> addreb; 
	private JComboBox<String> baseDesti;
	private JComboBox<String> borrarRebelde;
	private JComboBox<String> iniciEx;
	private JComboBox<String> ejec;
	private JComboBox<String> rebelde;
	private JComboBox<String> addbasecamino;
	private JComboBox<String> removebasecamino;
	private JComboBox<String> destireb;
	private JComboBox<String> modreb; 
	private JList<String> list;
	private JLabel lblInicioxodo;
	private JLabel lblEjecutar;
	private Integer numexecucio;
	private String idEx;
	
	private ArrayList<String> rebelsExode; //rebels que participen a l'exode	   
	private ArrayList<String> rebelsCapita; //tots els rebels del capita
	private ArrayList<String> rebelsExclosos; //rebels que no participen
	
	
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
		
		addreb = new JComboBox<String>();
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
		
		baseDesti = new JComboBox<String>();
		baseDesti.setMaximumSize(new Dimension(50, 23));
		horizontalBox.add(baseDesti);
		baseDesti.addItem("Escoge base");
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setMaximumSize(new Dimension(20, 20));
		horizontalBox.add(horizontalStrut_2);
		
		JButton btnAnadir = new JButton("A\u00F1adir");
		horizontalBox.add(btnAnadir);
		
		Component horizontalGlue_6 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_6);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut);
		
		Box horizontalBox_9 = Box.createHorizontalBox();
		horizontalBox_9.setAlignmentY(0.5f);
		verticalBox_1.add(horizontalBox_9);
		
		Component horizontalGlue_15 = Box.createHorizontalGlue();
		horizontalBox_9.add(horizontalGlue_15);
		
		JLabel lblModificarDestinoRebelde = new JLabel("Modificar destino rebelde:");
		horizontalBox_9.add(lblModificarDestinoRebelde);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		horizontalStrut_9.setMaximumSize(new Dimension(20, 20));
		horizontalBox_9.add(horizontalStrut_9);
		
		modreb = new JComboBox<String>();
		modreb.setMaximumSize(new Dimension(80, 23));
		horizontalBox_9.add(modreb);
		
		Component horizontalStrut_15 = Box.createHorizontalStrut(20);
		horizontalStrut_15.setMaximumSize(new Dimension(20, 20));
		horizontalBox_9.add(horizontalStrut_15);
		
		JLabel label_1 = new JLabel("Base destino:");
		horizontalBox_9.add(label_1);
		
		Component horizontalStrut_16 = Box.createHorizontalStrut(20);
		horizontalStrut_16.setMaximumSize(new Dimension(20, 20));
		horizontalBox_9.add(horizontalStrut_16);
		
		destireb = new JComboBox<String>();
		destireb.setMaximumSize(new Dimension(50, 23));
		horizontalBox_9.add(destireb);
		
		Component horizontalStrut_17 = Box.createHorizontalStrut(20);
		horizontalStrut_17.setMaximumSize(new Dimension(20, 20));
		horizontalBox_9.add(horizontalStrut_17);
		
		JButton btnCambiar = new JButton("Cambiar");
		horizontalBox_9.add(btnCambiar);
		
		Component horizontalGlue_16 = Box.createHorizontalGlue();
		horizontalBox_9.add(horizontalGlue_16);
		
		Component verticalStrut_7 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_7);
		
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
		
		borrarRebelde = new JComboBox<String>();
		borrarRebelde.setMaximumSize(new Dimension(80, 23));
		horizontalBox_1.add(borrarRebelde);
		borrarRebelde.addItem("Escoge rebelde");
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setMaximumSize(new Dimension(20, 20));
		horizontalBox_1.add(horizontalStrut_3);
		
		JButton btnBorrar = new JButton("Borrar");
		horizontalBox_1.add(btnBorrar);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_1);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_1);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(horizontalBox_2);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_2);
		
		lblInicioxodo = new JLabel("Inicio \u00E9xodo:");
		horizontalBox_2.add(lblInicioxodo);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		horizontalStrut_5.setMaximumSize(new Dimension(20, 20));
		horizontalBox_2.add(horizontalStrut_5);
		
		iniciEx = new JComboBox<String>();
		iniciEx.setMaximumSize(new Dimension(50, 23));
		horizontalBox_2.add(iniciEx);
		iniciEx.addItem("Escoge base");
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalStrut_6.setMaximumSize(new Dimension(20, 20));
		horizontalBox_2.add(horizontalStrut_6);
		
		JButton btnMod = new JButton("Modificar");
		horizontalBox_2.add(btnMod);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_3);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_2);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3);
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_4);
		
		lblEjecutar = new JLabel("Ejecuci\u00F3n:");
		horizontalBox_3.add(lblEjecutar);
		
		ejec = new JComboBox<String>();
		ejec.addItem("FordFulkerson");
		ejec.addItem("EK");
		ejec.addItem("Dijkstra");

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
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_4);
		
		Box verticalBox_2 = Box.createVerticalBox();
		verticalBox_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBox_4.add(verticalBox_2);
		
		JLabel lblModificarCamins = new JLabel("Modificar Caminos");
		lblModificarCamins.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModificarCamins.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_2.add(lblModificarCamins);
		
		Box horizontalBox_6 = Box.createHorizontalBox();
		horizontalBox_6.setAlignmentY(0.5f);
		verticalBox_2.add(horizontalBox_6);
		
		Box verticalBox_4 = Box.createVerticalBox();
		verticalBox_4.setAlignmentY(Component.TOP_ALIGNMENT);
		horizontalBox_6.add(verticalBox_4);
		
		Box horizontalBox_7 = Box.createHorizontalBox();
		verticalBox_4.add(horizontalBox_7);
		
		JLabel lblRebelde = new JLabel("Rebelde:");
		lblRebelde.setAlignmentY(Component.TOP_ALIGNMENT);
		horizontalBox_7.add(lblRebelde);
		
		rebelde = new JComboBox<String>();
		rebelde.setAlignmentX(Component.LEFT_ALIGNMENT);
		rebelde.setAlignmentY(Component.TOP_ALIGNMENT);
		horizontalBox_7.add(rebelde);
		rebelde.setMaximumSize(new Dimension(80, 23));
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		horizontalStrut_11.setMaximumSize(new Dimension(20, 20));
		horizontalBox_6.add(horizontalStrut_11);
		
		Box verticalBox_3 = Box.createVerticalBox();
		verticalBox_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_3.setAlignmentY(Component.TOP_ALIGNMENT);
		horizontalBox_6.add(verticalBox_3);
		
		JLabel lblCaminoAsignado = new JLabel("Camino asignado:");
		lblCaminoAsignado.setAlignmentY(Component.TOP_ALIGNMENT);
		lblCaminoAsignado.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox_3.add(lblCaminoAsignado);
		
		list = new JList(data);
		list.setAlignmentY(Component.TOP_ALIGNMENT);
		verticalBox_3.add(list);
		
		Component horizontalStrut_12 = Box.createHorizontalStrut(20);
		horizontalStrut_12.setMaximumSize(new Dimension(20, 20));
		horizontalBox_6.add(horizontalStrut_12);
		
		Box verticalBox_5 = Box.createVerticalBox();
		verticalBox_5.setAlignmentY(Component.TOP_ALIGNMENT);
		horizontalBox_6.add(verticalBox_5);
		
		Box horizontalBox_8 = Box.createHorizontalBox();
		verticalBox_5.add(horizontalBox_8);
		
		JLabel lblAadirBase = new JLabel("A\u00F1adir Base: ");
		lblAadirBase.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBox_8.add(lblAadirBase);
		
		addbasecamino = new JComboBox<String>();
		horizontalBox_8.add(addbasecamino);
		addbasecamino.setMaximumSize(new Dimension(50, 23));
		
		Component horizontalStrut_13 = Box.createHorizontalStrut(20);
		horizontalStrut_13.setMaximumSize(new Dimension(20, 20));
		horizontalBox_8.add(horizontalStrut_13);
		
		JButton btnAnadirBase = new JButton("A\u00F1adir");
		horizontalBox_8.add(btnAnadirBase);
		btnAnadirBase.setAlignmentX(0.5f);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		verticalStrut_5.setMaximumSize(new Dimension(20, 20));
		verticalBox_5.add(verticalStrut_5);
		
		Box horizontalBox_10 = Box.createHorizontalBox();
		verticalBox_5.add(horizontalBox_10);
		
		JLabel lblEliminarBase = new JLabel("Eliminar base: ");
		lblEliminarBase.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBox_10.add(lblEliminarBase);
		
		removebasecamino = new JComboBox<String>();
		removebasecamino.setMaximumSize(new Dimension(50, 23));
		horizontalBox_10.add(removebasecamino);
		
		Component horizontalStrut_14 = Box.createHorizontalStrut(20);
		horizontalStrut_14.setMaximumSize(new Dimension(20, 20));
		horizontalBox_10.add(horizontalStrut_14);
		
		JButton btnEliminarBase = new JButton("Eliminar");
		horizontalBox_10.add(btnEliminarBase);
		btnEliminarBase.setAlignmentX(0.5f);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_4);
		
		Box horizontalBox_5 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_5);
		
		Component horizontalGlue_10 = Box.createHorizontalGlue();
		horizontalBox_5.add(horizontalGlue_10);
		
		JButton ejecutar = new JButton("Ejecutar");
		ejecutar.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBox_5.add(ejecutar);
		
		Component horizontalGlue_11 = Box.createHorizontalGlue();
		horizontalBox_5.add(horizontalGlue_11);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_1);
		
		Component horizontalGlue_9 = Box.createHorizontalGlue();
		add(horizontalGlue_9);

		
		//LOGICA DE LA VISTA 
		
		btnAnadir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (idEx != null){
					int val1 = addreb.getSelectedIndex();
					String idreb = addreb.getSelectedItem().toString();
					int val2 = baseDesti.getSelectedIndex();
					int idb = Integer.parseInt(baseDesti.getSelectedItem().toString());
					if(val1>0 && val2>0){
						Principal.getEc().afegirRebelExode(idEx, idreb, idb);
						addreb.removeItem(idreb);
						modreb.addItem(idreb);
						borrarRebelde.addItem(idreb);
						rebelde.addItem(idreb);
						baseDesti.setSelectedIndex(0);
					}
				}
				else System.out.println("Exodo nulo");
			}
		});
		
		btnCambiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (idEx != null){
					int val1 = modreb.getSelectedIndex();
					String idreb = modreb.getSelectedItem().toString();
					int val2 = destireb.getSelectedIndex();
					int idb = Integer.parseInt(destireb.getSelectedItem().toString());
					if(val1>0 && val2>0){
						Principal.getEc().modificarRebelExode(idEx, idreb, idb);
						modreb.setSelectedIndex(0);
						destireb.setSelectedIndex(0);
					}
				}
				else System.out.println("Exodo nulo");
			}
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (idEx != null){
					int val1 = borrarRebelde.getSelectedIndex();
					String idreb = borrarRebelde.getSelectedItem().toString();
					if(val1>0){
						Principal.getEc().treureRebelExode(idEx, idreb);
						addreb.addItem(idreb);
						modreb.removeItem(idreb);
						borrarRebelde.removeItem(idreb);
						rebelde.removeItem(idreb);
						borrarRebelde.setSelectedIndex(0);
					}
				}
				else System.out.println("Exodo nulo");
			}
		});
		
		
		btnMod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (idEx!= null){
					int val = iniciEx.getSelectedIndex();
					if (val > 0){
						int idb = Integer.parseInt(iniciEx.getSelectedItem().toString());
						try {
							Principal.getCc().getGalaxia().getExode(idEx).setIdBaseInici(idb);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					iniciEx.setSelectedItem(0);
				}
				else System.out.println("Exodo nulo");
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblEjecutar.setText("Ejecución: " + ejec.getSelectedItem().toString());
				numexecucio = ejec.getSelectedIndex();
			}
		});

		btnEliminarBase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnAnadirBase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		ejecutar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (idEx != null) {
					try {
						Principal.getEc().execucio(idEx, numexecucio);
						System.out.println("Exodo ejecutado");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}
	
	/*
		private JComboBox<String> addreb; 
		private JComboBox<String> baseDesti;
		private JComboBox<String> borrarRebelde;
		private JComboBox<String> iniciEx;
		private JComboBox<String> ejec;
		private JComboBox<String> rebelde;
		private JComboBox<String> addbasecamino;
		private JComboBox<String> removebasecamino;
		private JList<String> list;
	 */
	
	public void reset(){
			idEx = null;
			numexecucio = 0;
		
			addreb.removeAllItems();
			addreb.addItem("Escoge rebelde");
			
			baseDesti.removeAllItems();
			baseDesti.addItem("Escoge base");
			
			borrarRebelde.removeAllItems();
			borrarRebelde.addItem("Escoge rebelde");
			
			iniciEx.removeAllItems();
			iniciEx.addItem("Escoge base");
			
			ejec.setSelectedIndex(0);
			
			rebelde.removeAllItems();
			rebelde.addItem("Escoge rebelde");
			
			addbasecamino.removeAllItems();
			addbasecamino.addItem("Escoge base");
			
			removebasecamino.removeAllItems();
			removebasecamino.addItem("Escoge base");
			
			modreb.removeAllItems();
			modreb.addItem("Escoge rebelde");
			
			destireb.removeAllItems();
			destireb.addItem("Escoge base");
			
			list = new JList(data);
			
			lblEjecutar.setText("Ejecución: ");
			lblInicioxodo.setText("Inicio éxodo: ");
	}
	
	public void actualitza(String s){
		//s = idExode;
		System.out.println("Actualitza, del exode :" + s );
		idEx = s;
		initBases(); //inicializamos las bases de la galaxia en los comboboxes
		initRebeldes();//inicializamos todos los combobox
		lblInicioxodo.setText("Inicio éxodo: " + Principal.getEc().getIniciExode(s).toString());
	}
	
	/*
	 	private JComboBox<String> addreb; 
		private JComboBox<String> baseDesti;
		private JComboBox<String> borrarRebelde;
		private JComboBox<String> iniciEx;
		private JComboBox<String> ejec;
		private JComboBox<String> rebelde;
		private JComboBox<String> addbasecamino;
		private JComboBox<String> removebasecamino;
									destireb
									modreb
		private JList<String> list;
		
		private ArrayList<String> rebelsExode; //rebels que participen a l'exode	   
		private ArrayList<String> rebelsCapita; //tots els rebels del capita
		private ArrayList<String> rebelsExclosos; //rebels que no participen
	 */
	
	private void initRebeldes(){
		rebelsCapita = new ArrayList(Principal.getCc().arrayListRebelsOrd());
		rebelsExode = new ArrayList(Principal.getEc().getRebelsExode(idEx).keySet());
		rebelsExclosos = new ArrayList<String>();
		for(String reb : rebelsCapita){
			if (!rebelsExode.contains(reb)){
				//si el rebel no es a l'exode es pot afegir
				addreb.addItem(reb);
			}
			else{
				//si esta, es pot esborrar, modificar el seu desti o modificar el seu cami
				borrarRebelde.addItem(reb);
				modreb.addItem(reb);
				rebelde.addItem(reb);
			}
		}	
	}
	
	private void initBases(){
		ArrayList<String> bases = new ArrayList<String>();
		try {
			bases = new ArrayList<String>(Principal.getGc().arrayBaseOrd());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String s: bases){
			baseDesti.addItem(s);
			destireb.addItem(s);
			addbasecamino.addItem(s);
			removebasecamino.addItem(s);
			iniciEx.addItem(s);
		}
		String s = Principal.getEc().getIniciExode(idEx).toString();
		System.out.println("Inicio del exodo: " + s);
		iniciEx.setSelectedItem(s);
	}
	
	
	
	
	
	
}
