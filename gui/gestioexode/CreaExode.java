package gui.gestioexode;

import gui.Principal;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreaExode extends JPanel {

	/**
	 * Create the panel.
	 */
	private HashMap<String,Integer> rebelsAfegits;
	private ArrayList<String> rebelsCapita;
	private ArrayList<String> bases;
	private Integer idInici = null;
	private Integer execucio = 0;
	
	private JComboBox<String> baseDesti;
	private JComboBox<String> addreb;
	private JComboBox<String> borrarRebelde;
	private JComboBox<String> iniciEx;
	private JComboBox<String> ejec;
	private JLabel lblInicioxodo;
	private JLabel lblEjecutar;
	
	public CreaExode() {
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
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setMaximumSize(new Dimension(20, 20));
		horizontalBox.add(horizontalStrut_2);
		
		JButton anadir = new JButton("A\u00F1adir");
		horizontalBox.add(anadir);
		
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
		
		borrarRebelde = new JComboBox<String>();
		borrarRebelde.setMaximumSize(new Dimension(80, 23));
		horizontalBox_1.add(borrarRebelde);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setMaximumSize(new Dimension(20, 20));
		horizontalBox_1.add(horizontalStrut_3);
		
		JButton borrar = new JButton("Borrar");
		horizontalBox_1.add(borrar);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_1);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_1);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(horizontalBox_2);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_2);
		
		lblInicioxodo = new JLabel("Inicio \u00E9xodo: ");
		horizontalBox_2.add(lblInicioxodo);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		horizontalStrut_5.setMaximumSize(new Dimension(20, 20));
		horizontalBox_2.add(horizontalStrut_5);
		
		iniciEx = new JComboBox<String>();
		iniciEx.setMaximumSize(new Dimension(50, 23));
		horizontalBox_2.add(iniciEx);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalStrut_6.setMaximumSize(new Dimension(20, 20));
		horizontalBox_2.add(horizontalStrut_6);
		
		JButton modificar = new JButton("Modificar");
		horizontalBox_2.add(modificar);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_3);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_2);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3);
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_4);
		
		lblEjecutar = new JLabel("Ejecuci\u00F3n");
		horizontalBox_3.add(lblEjecutar);
		
		ejec = new JComboBox<String>();
				
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		horizontalStrut_8.setMaximumSize(new Dimension(20, 20));
		horizontalBox_3.add(horizontalStrut_8);

		ejec.setMaximumSize(new Dimension(50, 23));
		horizontalBox_3.add(ejec);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		horizontalStrut_7.setMaximumSize(new Dimension(20, 20));
		horizontalBox_3.add(horizontalStrut_7);
		
		JButton ejecucion = new JButton("Aceptar");
		horizontalBox_3.add(ejecucion);
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_5);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_3);
		
		Box horizontalBox_5 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_5);
		
		Component horizontalGlue_10 = Box.createHorizontalGlue();
		horizontalBox_5.add(horizontalGlue_10);
		
		JButton creaExe = new JButton("Crear y ejecutar");
		creaExe.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBox_5.add(creaExe);
		
		JButton Crear = new JButton("Crear");
		Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		Component horizontalGlue_12 = Box.createHorizontalGlue();
		horizontalBox_5.add(horizontalGlue_12);
		Crear.setAlignmentX(0.5f);
		horizontalBox_5.add(Crear);
		
		Component horizontalGlue_11 = Box.createHorizontalGlue();
		horizontalBox_5.add(horizontalGlue_11);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_1);
		
		Component horizontalGlue_9 = Box.createHorizontalGlue();
		add(horizontalGlue_9);
		
		anadir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String idr = addreb.getSelectedItem().toString();
				Integer idb = Integer.parseInt(baseDesti.getSelectedItem().toString());
				if(addreb.getSelectedIndex()>0 && baseDesti.getSelectedIndex()>0){
					rebelsAfegits.put(idr, idb);
					addreb.removeItem(idr);
					borrarRebelde.addItem(idr);
					addreb.setSelectedIndex(0);
					baseDesti.setSelectedIndex(0);
				}
				else {
					System.out.println("Hay algo mal aquí: rebelde o base");
				}
			}
		});
		
		borrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String idr = borrarRebelde.getSelectedItem().toString();
				if (borrarRebelde.getSelectedIndex() > 0){
					addreb.addItem(idr);
					borrarRebelde.removeItem(idr);
					rebelsAfegits.remove(idr);
					addreb.setSelectedIndex(0);
					borrarRebelde.setSelectedIndex(0);
					baseDesti.setSelectedIndex(0);
				}
			}
		});
		
		modificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String idb = iniciEx.getSelectedItem().toString();
				if (iniciEx.getSelectedIndex() > 0){
					idInici = Integer.parseInt(idb);
					lblInicioxodo.setText("Inicio éxodo: "+ idb);
				}
				else {
					System.out.println("Escoge una base correcta");
				}
				
			}
		});
		
		ejecucion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ex = ejec.getSelectedItem().toString();
				lblEjecutar.setText("Ejecución: " + ex);
				execucio = ejec.getSelectedIndex();
			}
		});
		
		Crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("CREAMOS EXODO");
				creaEx();
				reset();
			}
		});
		
		creaExe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("CREAMOS Y EJECUTAMOS EXODO");
				String id = creaEx();
				if (id != null)ejecutaEx(id);
				else System.out.println("ID EXODO NULO");
				reset();
			}
		});
	}
	
	
	/*
	 * 	
	 *  private HashMap<String,Integer> rebelsAfegits;
		private ArrayList<String> rebelsCapita;
		private Integer idInici;
		private Integer execucio;
		
		private JComboBox<String> baseDesti;
		private JComboBox<String> addreb;
		private JComboBox<String> borrarRebelde;
		private JComboBox<String> iniciEx;
		private JComboBox<String> ejec;
	*/
	
	//TODO CAL MIRAR BASE DESTI != INICI --> THROWS
	private String creaEx(){
		System.out.println("PRINTAMOS LOS REBELDES QUE PARTICIPAN");
		String idexode = null;
		for (Map.Entry<String, Integer> entry : rebelsAfegits.entrySet()) {
		    System.out.println("Rebelde: " + entry.getKey() + " Base: " + String.valueOf(entry.getValue()));
		}
		System.out.println("ID inicio: " + idInici.toString());
		System.out.println("Ejecución: " + execucio.toString());
		try {
			idexode = Principal.getCc().crearExode(idInici);
			for (Map.Entry<String, Integer> entry : rebelsAfegits.entrySet()) {
				Principal.getCc().getGalaxia().getExode(idexode).afegirRebel(entry.getKey(), entry.getValue());
				Principal.getCc().getGalaxia().getExode(idexode).setIdBaseInici(idInici);			
			}
			System.out.println("Se ha creado un exode con id: " + idexode + "y base inicio: " + idInici);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idexode;
	}
	
	private void ejecutaEx(String id){
		try {
			Principal.getEc().execucio(id, execucio);
			System.out.println("Exodo ejecutado con ejecucion: "+ execucio);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Aquesta funcio inicialitza tots els valors dels combobox i prepara les estructures de dades auxiliars*/
	public void reset(){
		System.out.println("REEEEEEEEEEEEEEEEEEEEEEEEEEEESET");
		//HashMap al que s'afegiran els rebels assignats a l'exode
		rebelsAfegits = new HashMap<String,Integer>();
		//Array amb tots els rebels del capità
		rebelsCapita = new ArrayList<String>(Principal.getCc().arrayListRebelsOrd());
		try {bases = Principal.getGc().arrayBaseOrd();} catch (IOException e) {e.printStackTrace();}
		
		idInici = null;
		execucio = null;
		
		lblEjecutar.setText("Ejecución: ");
		lblInicioxodo.setText("Inicio éxodo: ");
		initRebeldes();
		initExodo();
		initEjec();
	}
	
	private void initRebeldes(){
		addreb.removeAllItems();
		addreb.addItem("Escoge rebelde");
		addreb.setSelectedIndex(0);
		for(String s : rebelsCapita){
			addreb.addItem(s);
		}
		
		baseDesti.removeAllItems();
		baseDesti.addItem("Escoge base");
		baseDesti.setSelectedIndex(0);
		for(String s: bases){
			baseDesti.addItem(s);
		}
		
		borrarRebelde.removeAllItems();
		borrarRebelde.addItem("Escoge rebelde");
		borrarRebelde.setSelectedIndex(0);
	}
	
	private void initExodo(){
		iniciEx.removeAllItems();
		iniciEx.addItem("Escoge base");
		iniciEx.setSelectedIndex(0);
		for(String s : bases){
			iniciEx.addItem(s);
		}
		
	}
	
	private void initEjec(){
		ejec.removeAllItems();
		ejec.addItem("FordFulkerson");
		ejec.addItem("DFS");
		ejec.addItem("Dijkstra");
		ejec.setSelectedIndex(0);		
	}
	
	
}