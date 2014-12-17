package gui.gestiorebel;

import gui.CreaNom;
import gui.JPanelBg;
import gui.Principal;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

public class GestioRebel extends JPanelBg{
	private JComboBox<String> accio;
	private JComboBox<String> pickrebel =  new JComboBox<String>();
	private JButton atras;
	private JButton Boton;
	
	private CardLayout card = new CardLayout(0, 0);
	private JPanel panel; 
	
	private ConsultaRebel cr = new ConsultaRebel();
	private ModificaRebel mr = new ModificaRebel();
	private CreaNom cn = new CreaNom();
	
	public GestioRebel() {
		setImage("/images/bg.jpg");
		setLayout(new BorderLayout(0, 0));
		
		//Cargamos la vista de la consulta de rebeldes por defecto
		panel = new JPanel();
		panel.setLayout(card);
		panel.add(cr,"consulta");
		panel.add(cn,"crea");
		panel.add(mr,"modify");
		card.show(panel, "draw");
		
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(verticalBox);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setAlignmentY(0.5f);
		verticalBox.add(horizontalBox_1);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setPreferredSize(new Dimension(20, 40));
		horizontalStrut_1.setMinimumSize(new Dimension(20, 40));
		horizontalStrut_1.setMaximumSize(new Dimension(20, 40));
		horizontalBox_1.add(horizontalStrut_1);
		
		//Comportamiento del botón Atrás
		atras = new JButton("Atr\u00E1s");
		atras.setAlignmentX(0.5f);
		horizontalBox_1.add(atras);
		atras.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		deleteView();
	        		Principal.loadMenuCapita();
	        	}
	        });
		
				Component horizontalGlue_1 = Box.createHorizontalGlue();
				horizontalBox_1.add(horizontalGlue_1);
				
				JButton guardar = new JButton("Guardar");
				guardar.setAlignmentX(0.5f);
				horizontalBox_1.add(guardar);
				
				guardar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							Principal.getCc().exportarContenidorCapitans();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println("Error al guardar!");
						}
					}
				});
				
				Component horizontalStrut = Box.createHorizontalStrut(20);
				horizontalStrut.setPreferredSize(new Dimension(20, 40));
				horizontalStrut.setMinimumSize(new Dimension(20, 40));
				horizontalStrut.setMaximumSize(new Dimension(20, 40));
				horizontalBox_1.add(horizontalStrut);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_2);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_3);

		accio = new JComboBox<String>();
		horizontalBox_2.add(accio);
		accio.setMaximumSize(new Dimension(150, 20));
		accio.setMinimumSize(new Dimension(150, 20));
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_4);
		
		//preparem el contingut del primer combobox
		accio.addItem("Consultar rebeldes");
		accio.addItem("Modificar rebelde");
		accio.addItem("Crear rebelde");
		accio.addItem("Eliminar rebelde");
		

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_5);
		
		pickrebel = new JComboBox<String>();
		horizontalBox_3.add(pickrebel);
		pickrebel.setMinimumSize(new Dimension(120, 20));
		pickrebel.setMaximumSize(new Dimension(120, 20));
		actupickrebel();
		Component horizontalGlue_6 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_6);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_1);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox.add(verticalBox_1);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		horizontalBox.add(panel);
		
	
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_2);
		
		Boton = new JButton("Ok");
		verticalBox_1.add(Boton);
		Boton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_1);
		Boton.setVisible(false);
		
		//Comportamiento del botón Acceder
		
		Boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					int val = accio.getSelectedIndex();
					revalidate();
					switch(val){
						case 0: //consulta
							
							break;
						case 1: //modifica
							int val2 = pickrebel.getSelectedIndex();
							if (val2 > 0) {
								mr.canvia(pickrebel.getSelectedItem().toString());
							}
							else{
								System.out.println("hauries d'escollir un rebel");
							}
							mr.reset();
							break;
						case 2: //crea
							String nom = cn.getNom();
							if (nom != ""){
								Principal.getCc().crearRebel(nom);
								JOptionPane.showMessageDialog(Principal.getWindow(), "Rebelde añadido con nombre: " + nom);
								cn.reset();
							}
							else {
								JOptionPane.showMessageDialog(Principal.getWindow(), "El Rebelde debe tener un nombre.");
							}
							break;
						case 3:	//esborra
							String val3 = pickrebel.getSelectedItem().toString();
							boolean b = Principal.getCc().eliminarRebel(val3);
							if (b) JOptionPane.showMessageDialog(Principal.getWindow(), "Rebelde eliminado.");
							else JOptionPane.showMessageDialog(Principal.getWindow(), "No existe este rebelde para el capitán");
							actupickrebel();
							break;
						default:
							break;
					}
		    		/*if (pickrebel.getSelectedIndex() == 0 && pickrebel.isVisible()){
		    			JOptionPane.showMessageDialog(Principal.getWindow(), "Por favor, seleccione un rebelde");
		    		}
		    		else {
		    			System.out.println("do something");
		    		}*/
			}	
		});		
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);

		
		//LOGICA DE LA VISTA 
		
		
		pickrebel.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED){
					//Aquí controlamos en que opción estamos cuando se escoge un rebelde
					int val = accio.getSelectedIndex();
					int val2 = pickrebel.getSelectedIndex();
					switch(val){
						case 0: //consulta rebelde
							String idReb = pickrebel.getSelectedItem().toString();
							if(val2 > 0){
								cr.refresh(idReb);
							}
							else cr.reset();
							break;
						case 1://modifica rebel
							String idReb2 = pickrebel.getSelectedItem().toString();
							if(val2 > 0) mr.refresh(idReb2);
							break;
						default:
							break;
					}
				}
			}
		});
		
		//Comportamiento JComboBox
		accio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
	                int val = accio.getSelectedIndex();
	                revalidate();
	                switch(val){
	                case 0:
	                	panel.setVisible(true);
	                	pickrebel.setVisible(true);
	                	actupickrebel();
	                	cr.reset();
	                	Boton.setVisible(false);
	                	card.show(panel,"consulta");
	                	break;
	                case 1:
	                	panel.setVisible(true);
	                	pickrebel.setVisible(true);
	                	actupickrebel();
	                	mr.reset();
	                	Boton.setVisible(true);
	                	Boton.setText("Cambiar nombre");
	                	card.show(panel, "modify");
	                	break;
	                case 2:
	                	panel.setVisible(true);
	                	pickrebel.setVisible(false);
	                	Boton.setVisible(true);
	                	Boton.setText("Crea");
	                	card.show(panel, "crea");
	                	break;
	                case 3: 
	                	panel.setVisible(false);
	                	pickrebel.setVisible(true);
	                	pickrebel.setSelectedIndex(0);
	                	actupickrebel();
	                	Boton.setVisible(true);
	                	Boton.setText("Eliminar");
	                default:	                	
	                	break;
	                }
                }
            }
		});
	}
	
	private void actupickrebel(){
		System.out.println("ACTU PICK REBEL");
		pickrebel.removeAllItems();
		pickrebel.addItem("Escoge rebelde");
		ArrayList<String> rebels = Principal.getCc().arrayListRebelsOrd();
		int i = 1;
		for(String r : rebels){
			System.out.println("Rebelde " + r);
			pickrebel.addItem(r);
			++i;
		}
		pickrebel.setSelectedItem(0);
	}

	public void config(){
		//Aquesta funcio ens serveix per a establir a quin objecte s'ha de fer focus al carregar la vista
		accio.requestFocusInWindow();
		//Aprofitem per associar la tecla intro amb un boto
		//JRootPane rootPane = SwingUtilities.getRootPane(Boton); 
		//rootPane.setDefaultButton(Boton);
	}
}