package gui.gestioexode;

import gui.JPanelBg;
import gui.Principal;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GestioExode extends JPanelBg{
	private JComboBox<String> accio;
	private JComboBox<String> pickexode;
	private JButton atras;
	private JButton eliminar;
	
	private String idEx = null;
	private CardLayout card = new CardLayout(0, 0);
	private JPanel panel; 
	
	private CreaExode ce = new CreaExode();
	private ModificarExode me = new ModificarExode(); 
	private ConsultaExode conse = new ConsultaExode();

	public GestioExode() {
		setImage("/images/bg.jpg");
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
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
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setPreferredSize(new Dimension(20, 40));
		horizontalStrut.setMinimumSize(new Dimension(20, 40));
		horizontalStrut.setMaximumSize(new Dimension(20, 40));
		horizontalBox_1.add(horizontalStrut);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_2);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox.add(horizontalBox);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_2);
		
		accio = new JComboBox<String>();
		horizontalBox.add(accio);
		accio.setMaximumSize(new Dimension(150, 20));
		accio.setMinimumSize(new Dimension(150, 20));
		
		panel = new JPanel();
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panel.setLayout(card);
		panel.setBackground(new Color(0, 0, 0));
		panel.add(conse,"consex");
		panel.add(ce,"crea");
		panel.add(me,"mod");
		card.show(panel,"consex");
		
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		//preparem el contingut del primer combobox
		accio.addItem("Consultar éxodo");
		accio.addItem("Crear éxodo");
		accio.addItem("Modificar éxodo");
		accio.addItem("Eliminar éxodo");
		

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);
			
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_5);
	
		
		pickexode = new JComboBox<String>();
		horizontalBox_3.add(pickexode);
		pickexode.setMinimumSize(new Dimension(120, 20));
		pickexode.setMaximumSize(new Dimension(120, 20));
		actuPickExode();
		Component horizontalGlue_6 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_6);
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_2);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(verticalBox_1);
		
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox_1.add(verticalGlue_1);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setAlignmentY(Component.CENTER_ALIGNMENT);
		verticalBox_1.add(horizontalBox_2);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_3);
		
		horizontalBox_2.add(panel);

		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_4);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox_1.add(verticalGlue);
		
		eliminar = new JButton("Eliminar");
		eliminar.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(eliminar);
		
		Component verticalGlue_3 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_3);
		eliminar.setVisible(false);
		
		//LOGICA DE LA VISTA
		//preparamos el comportamiento segun la selección
		
		accio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
	                int val = accio.getSelectedIndex();
	                switch(val){
		                case 0: //consultar
	                		panel.setVisible(true);
	                		actuPickExode();
	                		int val3 = pickexode.getSelectedIndex();
	                		if(val3 > 0){
	                			idEx = pickexode.getSelectedItem().toString();
	                			try {
									conse.actualitza(idEx);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
	                		}
	                		else conse.reset();
	                		card.show(panel,"consex");
	                		eliminar.setVisible(false);
	                		break;
	                	case 1: //crear
	                		panel.setVisible(true);
	                		ce.reset();
	                		pickexode.setVisible(false);
	                		card.show(panel,"crea");
	                		eliminar.setVisible(false);
	                		break;
	                	case 2: // modificar
	                		int val2 = pickexode.getSelectedIndex();
	                		actuPickExode();
	                		panel.setVisible(true);
	                		if(val2 > 0){
	                			idEx = pickexode.getSelectedItem().toString();
	                			me.actualitza(idEx);
	                		}
	                		else me.reset();
	                		card.show(panel,"mod");	            
	                		eliminar.setVisible(false);
	                		break;
	                	case 3: //eliminar
	                		eliminar.setVisible(true);
	                		panel.setVisible(false);
	                		actuPickExode();
	                		break;
	                }
	                revalidate();
	                repaint();
                }
            }
		});
		
		pickexode.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					int val = pickexode.getSelectedIndex();
					if (val == 0) idEx = null;
					else idEx = pickexode.getSelectedItem().toString();
					int val2 = accio.getSelectedIndex();
					switch(val2){
						case 0: //consulta
							if (val > 0){
								try {
									conse.actualitza(idEx);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							else conse.reset();
							break;
						case 2: // modifica
							if (val > 0) {
								me.actualitza(pickexode.getSelectedItem().toString());
							}
							else me.reset();
							break;
						default:
							System.out.println("Otras opciones");
							break;
					}
				}
			}
		});
		
		
		eliminar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if (accio.getSelectedIndex() == 0) {
        			JOptionPane.showMessageDialog(Principal.getWindow(), "Por favor, seleccione una opción válida");
        		}
        		else if (pickexode.getSelectedIndex() == 0 && pickexode.isVisible()) {
        			JOptionPane.showMessageDialog(Principal.getWindow(), "Por favor, seleccione una éxodo");
        		}
        		else {
        			System.out.println("do something");
        		}
        	}	
        });		
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
	  	      @Override
	  	      public boolean dispatchKeyEvent(KeyEvent e) { 	    	
	  	    	if (isVisible()) {
	  	    		if (e.getKeyCode() == 27){ //activar boton atras
	  	        		deleteView();
	  	        		Principal.loadMenuCapita();
	  	    		}
	  	        }
	  	    	 return false;
	  	      }
	        });		

		
	}
	
	public void config(){
		//Aquesta funcio ens serveix per a establir a quin objecte s'ha de fer focus al carregar la vista
		accio.requestFocusInWindow();
		//Aprofitem per associar la tecla intro amb un boto
		//JRootPane rootPane = SwingUtilities.getRootPane(button); 
		//rootPane.setDefaultButton(button);
	}
	
	private void actuPickExode(){
		ArrayList<String> exodes = Principal.getCc().ordenarArrayString(new ArrayList<String>(Principal.getGc().getGalaxia().getExodes()));
		pickexode.removeAllItems();
		pickexode.addItem("Escoge Exodo");
		for(String s : exodes){
			pickexode.addItem(s);
		}
		pickexode.setSelectedIndex(0);
		pickexode.setVisible(true);
	}
}
