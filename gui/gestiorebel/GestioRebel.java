package gui.gestiorebel;

import gui.JPanelBg;
import gui.Principal;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

public class GestioRebel extends JPanelBg{
	private JComboBox<String> accio;
	private JComboBox<String> pickrebel;
	private JButton button;
	private JButton btnNewButton;

	public GestioRebel() {
		setImage("/images/bg.jpg");
		setLayout(new BorderLayout(0, 0));
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(verticalBox);

		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		accio = new JComboBox<String>();
		accio.setMaximumSize(new Dimension(150, 20));
		accio.setMinimumSize(new Dimension(150, 20));
		verticalBox.add(accio);
		//preparem el contingut del primer combobox
		accio.addItem("Acción a Ejecutar");
		accio.addItem("Crear rebelde");
		accio.addItem("Modificar rebelde");
		accio.addItem("Consultar rebelde");
		accio.addItem("Eliminar rebelde");
		
		//preparamos el comportamiento segun la selección
		
		accio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
	                int val = accio.getSelectedIndex();
	                if (val <= 1) {
	                	pickrebel.setVisible(false);
	                }
	                else {
	                	pickrebel.setVisible(true);	                
	                }
                }
            }
		});
		
		
		
		
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);
	
		
		pickrebel = new JComboBox<String>();
		pickrebel.setMinimumSize(new Dimension(120, 20));
		pickrebel.setMaximumSize(new Dimension(120, 20));
		pickrebel.setVisible(false);
		verticalBox.add(pickrebel);
		
		pickrebel.addItem("Escoge rebelde");
		pickrebel.addItem("Rebelde 1");
		pickrebel.addItem("Rebelde 2");
		pickrebel.addItem("Rebelde 3");
		pickrebel.addItem("Rebelde 4");
		
		
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_1);
		
		btnNewButton = new JButton("Acceder");
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if (accio.getSelectedIndex() == 0) {
        			JOptionPane.showMessageDialog(Principal.getWindow(), "Por favor, seleccione una opción válida");
        		}
        		else if (pickrebel.getSelectedIndex() == 0 && pickrebel.isVisible()){
        			JOptionPane.showMessageDialog(Principal.getWindow(), "Por favor, seleccione un rebelde");
        		}
        		else {
        			System.out.println("do something");
        		}
        	}	
        });
		
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_1);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setAlignmentY(0.5f);
		verticalBox.add(horizontalBox_1);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setPreferredSize(new Dimension(20, 40));
		horizontalStrut_1.setMinimumSize(new Dimension(20, 40));
		horizontalStrut_1.setMaximumSize(new Dimension(20, 40));
		horizontalBox_1.add(horizontalStrut_1);
		
		button = new JButton("Atr\u00E1s");
		button.setAlignmentX(0.5f);
		horizontalBox_1.add(button);
		 button.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		deleteView();
	        		Principal.loadMenuCapita();
	        	}
	        });
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_1);
	}
	
	public void focus(){
		//Aquesta funcio ens serveix per a establir a quin objecte s'ha de fer focus al carregar la vista
		accio.requestFocusInWindow();
		//Aprofitem per associar la tecla intro amb un boto
		JRootPane rootPane = SwingUtilities.getRootPane(btnNewButton); 
		rootPane.setDefaultButton(btnNewButton);
	}
}