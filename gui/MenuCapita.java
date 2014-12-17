package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
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

public class MenuCapita extends JPanelBg {
	
	private JComboBox<String> box;
	private JComboBox<String> exode;
	private JComboBox<String> exec;
	private JButton btnAcceder;
	private JButton btnNewButton;
	private Component VS2, VS3;
	//private MenuCapita view;
	/**
	 * Create the panel.
	 */
	public MenuCapita() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setImage("/images/bg.jpg");

        Dimension d = new Dimension(150,23);
        
        Component verticalGlue = Box.createVerticalGlue();
        add(verticalGlue);
        
        Box horizontalBox_1 = Box.createHorizontalBox();
        add(horizontalBox_1);
        
        Component horizontalGlue_3 = Box.createHorizontalGlue();
        horizontalBox_1.add(horizontalGlue_3);
        
        box =  new JComboBox<String>();
        horizontalBox_1.add(box);
        box.setRequestFocusEnabled(false);
        box.setFont(new Font("Tahoma", Font.PLAIN, 14));
        box.setMaximumRowCount(10);
        box.addItem("Gestionar rebeldes");
        box.addItem("Gestionar galaxia");
        box.addItem("Gestionar éxodos");
        box.addItem("Gestionar capitán");
        box.addItem("Ejecutar éxodo");
        box.setMaximumSize(new Dimension(150, 48));
        
        Component horizontalGlue_2 = Box.createHorizontalGlue();
        horizontalBox_1.add(horizontalGlue_2);
        
        VS2 = Box.createVerticalStrut(20);
        VS2.setVisible(false);
        add(VS2);
        
        Box horizontalBox_3 = Box.createHorizontalBox();
        add(horizontalBox_3);
        
        Component horizontalGlue_6 = Box.createHorizontalGlue();
        horizontalBox_3.add(horizontalGlue_6);
        
        exode = new JComboBox<String>();
        exode.setVisible(false);
        exode.setRequestFocusEnabled(false);
        exode.setMaximumSize(new Dimension(150, 48));
        exode.setMaximumRowCount(10);
        exode.setFont(new Font("Tahoma", Font.PLAIN, 14));
        horizontalBox_3.add(exode);
        exode.addItem("Selecciona Éxodo");
        
        Component horizontalGlue_7 = Box.createHorizontalGlue();
        horizontalBox_3.add(horizontalGlue_7);
        
        Component verticalStrut = Box.createVerticalStrut(20);
        add(verticalStrut);
        
        Box horizontalBox_4 = Box.createHorizontalBox();
        add(horizontalBox_4);
        
        Component horizontalGlue_8 = Box.createHorizontalGlue();
        horizontalBox_4.add(horizontalGlue_8);
        
        exec = new JComboBox<String>();
        exec.setFont(new Font("Tahoma", Font.PLAIN, 14));
        exec.setMaximumSize(new Dimension(150, 48));
        horizontalBox_4.add(exec);
        exec.addItem("FordFulkerson");
        exec.addItem("DFS");
        exec.addItem("Dijkstra");
        exec.setVisible(false);
        
        Component horizontalGlue_9 = Box.createHorizontalGlue();
        horizontalBox_4.add(horizontalGlue_9);
        
        VS3 = Box.createVerticalStrut(20);
        add(VS3);
        VS3.setVisible(false);
        
        Box horizontalBox_2 = Box.createHorizontalBox();
        add(horizontalBox_2);
        
        Component horizontalGlue_4 = Box.createHorizontalGlue();
        horizontalBox_2.add(horizontalGlue_4);
        
        btnAcceder = new JButton("Acceder");
        horizontalBox_2.add(btnAcceder);
          
        Component verticalGlue_1 = Box.createVerticalGlue();
        add(verticalGlue_1);
        
        Box verticalBox = Box.createVerticalBox();
        verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(verticalBox);
        
		

        Box horizontalBox = Box.createHorizontalBox();
        verticalBox.add(horizontalBox);
        
        Component horizontalGlue_1 = Box.createHorizontalGlue();
        horizontalBox.add(horizontalGlue_1);
        
        btnNewButton = new JButton("Cerrar sesión");
        horizontalBox.add(btnNewButton);
        btnNewButton.setPreferredSize(new Dimension(120, 23));
        btnNewButton.setMaximumSize(new Dimension(120, 48));
        btnNewButton.setRequestFocusEnabled(false);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        Component horizontalGlue = Box.createHorizontalGlue();
        horizontalBox.add(horizontalGlue);
        
                
        
        Component verticalStrut_1 = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut_1);

        
        //LÓGICA DE LA VISTA
        
        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	//entrem al if només quan s'hagi seleccionat l'item, para evitar doble reaccion del listener
                    int val = box.getSelectedIndex();
                    switch(val){
                    	case 4:
                    		exode.setVisible(true);
                    		exec.setVisible(true);
                    		VS2.setVisible(true);
                    		VS3.setVisible(true);
                    		actuExodes();
                    		btnAcceder.setText("Ejecutar");
                    		break;
                    	default:
                    		exode.setVisible(false);
                    		exec.setVisible(false);
                    		actuExodes();
                    		VS2.setVisible(false);
                    		VS3.setVisible(false);
                    		btnAcceder.setText("Acceder");
                    		break;
                    }
	             }
             }
		});
        btnAcceder.setMaximumSize(new Dimension(100, 48));
        
        btnAcceder.setRequestFocusEnabled(false);
        btnAcceder.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAcceder.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        Component horizontalGlue_5 = Box.createHorizontalGlue();
        horizontalBox_2.add(horizontalGlue_5);
        
        btnAcceder.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int val = box.getSelectedIndex();
        		switch(val){
    		case 0:
    			System.out.println("To gestio rebels");
    			deleteView();
    			Principal.loadGestioRebel();
    			break;
    		case 1:
    			System.out.println("To gestio galaxia");
    			deleteView();
    			Principal.loadGestioGalaxia();
    			break;
    		case 2:
    			System.out.println("To gestio exode");
    			deleteView();
    			Principal.loadGestioExode();
    			break;
    		case 3:
    			System.out.println("Gestio capita");
    			deleteView();
    			Principal.loadGestioCapita();
    			break;
    		case 4: //ejecutar exodo
    			System.out.println("Executar exode");
    			int val1 = exode.getSelectedIndex();
    			if(val1 > 0){
    				String idEx = exode.getSelectedItem().toString();
    				int val2 = exec.getSelectedIndex();
    				try {
    					System.out.println("VAL2: " + String.valueOf(val2));
						Principal.getEc().execucio(idEx, val2);
					} catch (IOException e) {
						e.printStackTrace();
					}
    			}
    			else System.out.println("Escoge un exodo correcto");
    			break;
    		default:
        		System.out.println("Seleccionado: " + String.valueOf(val));
    			break;
        		}
        	}
        });
  
        
        btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteView();
				Principal.getCc().logOut();
				Principal.loadLogin();
			}
		});
      
	}
	public void actuExodes(){
		ArrayList<String> s = new ArrayList<String> (Principal.getCc().arrayListExodesOrd());
		exode.removeAllItems();
		exode.addItem("Escoge éxodo");
		for (String s2 : s){
			exode.addItem(s2);
		}
	}
	
	public void config(){
		box.requestFocusInWindow();
		
		//Seleccionamos el botón de acceder como acción principal al pulsar intro
		//JRootPane rootPane = SwingUtilities.getRootPane(btnAcceder); 
		//r/ootPane.setDefaultButton(btnAcceder);
	}
}
