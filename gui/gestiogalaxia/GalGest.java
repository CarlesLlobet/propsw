package gui.gestiogalaxia;
import gui.JPanelBg;
import gui.Principal;

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
    private GalMod mg = new GalMod();
    private GalDraw gd = new GalDraw();
	
	public GalGest() {
        setImage("/images/bg.jpg");
        setLayout(new BorderLayout(0, 0));
        
        Box verticalBox = Box.createVerticalBox();
        verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(verticalBox);
        
        Component verticalStrut_2 = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut_2);
        
        Box horizontalBox_2 = Box.createHorizontalBox();
        verticalBox.add(horizontalBox_2);
        
        Component horizontalGlue_1 = Box.createHorizontalGlue();
        horizontalBox_2.add(horizontalGlue_1);
        
        box = new JComboBox<String>();
        box.setPreferredSize(new Dimension(150, 20));
        box.setMinimumSize(new Dimension(150, 20));
        horizontalBox_2.add(box);
        box.setMaximumSize(new Dimension(200, 48));
        
        Component horizontalGlue_2 = Box.createHorizontalGlue();
        horizontalBox_2.add(horizontalGlue_2);
        box.addItem("Consultar");
        box.addItem("Modificar");
        box.addItem("Importar");
        box.addItem("Exportar");
        
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
        	                		removeCard(toRemove);
        	                		break;
        	                	case 1:
        	                		mg = new GalMod();
        	                        panel.add(mg,"modify");
        	                		card.show(panel,"modify");
        	                		removeCard(toRemove);
        	                		break;
        	                	case 2:
        	                		ig = new GalImp();
        	                        panel.add(ig,"import");
        	                		card.show(panel,"import");
        	                		removeCard(toRemove);
        	                		break;
        	                	case 3:
        	                		eg = new GalExp();
        	                        panel.add(eg,"export");
        	                		card.show(panel,"export");
        	                		removeCard(toRemove);
        	                		break;
        	                	default:
        	                		System.out.println("DEFAULT");
        	                		break;
        	                }
                        }
                    }
                });
        
        Component verticalStrut = Box.createVerticalStrut(20);
        verticalBox.add(verticalStrut);
        
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
        
        Box horizontalBox_1 = Box.createHorizontalBox();
        horizontalBox_1.setAlignmentY(Component.CENTER_ALIGNMENT);
        verticalBox.add(horizontalBox_1);
        
        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        horizontalStrut_2.setPreferredSize(new Dimension(20, 40));
        horizontalStrut_2.setMinimumSize(new Dimension(20, 40));
        horizontalStrut_2.setMaximumSize(new Dimension(20, 40));
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
        
        
        //Carreguem les 4 possibles vistes que pot haver-hi: modificar, importar, exportar, dibuixar la galaxia

        
        panel.add(gd,"draw");
        gd.setLayout(new BorderLayout(0, 0));

        card.show(panel, "draw");
        
        
	}
	
	private void removeCard(Component c){
		panel.remove(c);
		this.revalidate();
		this.repaint();
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
