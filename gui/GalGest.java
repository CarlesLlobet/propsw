package gui;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class GalGest extends JPanelBg {
	
	private JComboBox<String> box;
	private JButton button;
	private CardLayout card = new CardLayout(0, 0);
	private JPanel panel = new JPanel(); 
	private boolean first = true;
	//vistes que es carregaran:
	
    private GalExp eg = new GalExp();
    private GalImp ig = new GalImp();
    private ModificarGalaxia mg = new ModificarGalaxia();
    private GalDraw gd = new GalDraw();
	
	public GalGest() {
        setImage("/images/bg.jpg");
        setLayout(new BorderLayout(0, 0));
        
        Box verticalBox = Box.createVerticalBox();
        verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(verticalBox);
        
        Component verticalStrut_2 = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut_2);
        
        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.setAlignmentY(Component.CENTER_ALIGNMENT);
        verticalBox.add(horizontalBox);
        
        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        horizontalBox.add(horizontalStrut_1);
        
        panel = new JPanel();
        horizontalBox.add(panel);
        panel.setMaximumSize(new Dimension(48515, 562356));
        panel.setLayout(card);
        
        Component horizontalStrut = Box.createHorizontalStrut(20);
        horizontalBox.add(horizontalStrut);
        
        Component verticalStrut = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut);
        
        box = new JComboBox<String>();
        verticalBox.add(box);
        box.setMaximumSize(new Dimension(200, 48));
        
        Box horizontalBox_1 = Box.createHorizontalBox();
        horizontalBox_1.setAlignmentY(Component.CENTER_ALIGNMENT);
        verticalBox.add(horizontalBox_1);
        
        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        horizontalBox_1.add(horizontalStrut_2);
        
        button = new JButton("Atrás");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		Principal.loadMenuCapita();
        	}
        });
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        horizontalBox_1.add(button);
        
        Component horizontalGlue = Box.createHorizontalGlue();
        horizontalBox_1.add(horizontalGlue);
        box.addItem("Consultar");
        box.addItem("Modificar");
        box.addItem("Importar");
        box.addItem("Exportar");
        
        
        //Carreguem les 4 possibles vistes que pot haver-hi: modificar, importar, exportar, dibuixar la galaxia

        
        panel.add(gd,"draw");

        card.show(panel, "draw");

        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	//entrem al if només quan s'hagi seleccionat l'item, para evitar doble reaccion del listener
	                int val = box.getSelectedIndex();
	                JPanel toRemove = getCurrentCard();
	                switch(val){
	                	case 0: 
	                		gd = new GalDraw();
	                        panel.add(gd,"draw");
	                		card.show(panel,"draw");
	                		panel.remove(toRemove);
	                		break;
	                	case 1:
	                		mg = new ModificarGalaxia();
	                        panel.add(mg,"modify");
	                		card.show(panel,"modify");
	                		panel.remove(toRemove);
	                		break;
	                	case 2:
	                		ig = new GalImp();
	                        panel.add(ig,"import");
	                		card.show(panel,"import");
	                		panel.remove(toRemove);
	                		break;
	                	case 3:
	                		eg = new GalExp();
	                        panel.add(eg,"export");
	                		card.show(panel,"export");
	                		panel.remove(toRemove);
	                		break;
	                	default:
	                		System.out.println("DEFAULT");
	                		break;
	                }
                }
            }
        });
        
        
	}
	private JPanel getCurrentCard(){
		//Esborra la unica carta que s'esta mostrant en pantalla
    	JPanel currentcard = null;
	    for (Component c : panel.getComponents() ) {
	        if (c.isVisible() == true) {
	        	currentcard = (JPanel)c;
	        }
	    }
	    return currentcard;
	}
	
	public void focus(){
		box.requestFocusInWindow();
	}
	

	
	
	
	
	
	

}
