package gui.gestiogalaxia;
import gui.ImpExp;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GalGest extends JPanelBg {
	private JComboBox<String> box;
	private JButton button;
	private CardLayout card = new CardLayout(0, 0);
	private JPanel panel = new JPanel(); 
	private JButton impExp;
	
	//vistes que es carregaran:
    private ImpExp eg = new ImpExp();
    private ImpExp ig = new ImpExp();
    private GalMod mg = new GalMod();
    private GalDraw gd = new GalDraw();
	
	public GalGest() {
		
		//PREPARAMOS LA VISTA
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
        
        Box verticalBox_1 = Box.createVerticalBox();
        verticalBox.add(verticalBox_1);
        
        Component verticalGlue = Box.createVerticalGlue();
        verticalBox_1.add(verticalGlue);
        
        Box horizontalBox = Box.createHorizontalBox();
        verticalBox_1.add(horizontalBox);
        horizontalBox.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        Component horizontalGlue_5 = Box.createHorizontalGlue();
        horizontalBox.add(horizontalGlue_5);
        
        panel = new JPanel();
        horizontalBox.add(panel);
        panel.setMaximumSize(new Dimension(48515, 562356));
        panel.setLayout(card);
        
        //Carreguem toas las vistas que vamos a utilizar y mostramos el dibujo
        panel.add(gd,"draw");
        panel.add(mg,"modify");
        panel.add(ig,"import");
        panel.add(eg,"export");
        card.show(panel, "draw");
                
        Component horizontalStrut = Box.createHorizontalStrut(20);
        horizontalBox.add(horizontalStrut);
                
        impExp = new JButton("New button");
        horizontalBox.add(impExp);
        impExp.setVisible(false);
                
        Component horizontalGlue_6 = Box.createHorizontalGlue();
        horizontalBox.add(horizontalGlue_6);
                
        Component verticalGlue_1 = Box.createVerticalGlue();
        verticalBox_1.add(verticalGlue_1);
        
        Box horizontalBox_3 = Box.createHorizontalBox();
        verticalBox.add(horizontalBox_3);
        
        Component horizontalGlue_3 = Box.createHorizontalGlue();
        horizontalBox_3.add(horizontalGlue_3);
        
        Component horizontalGlue_4 = Box.createHorizontalGlue();
        horizontalBox_3.add(horizontalGlue_4);
        
        Box horizontalBox_1 = Box.createHorizontalBox();
        horizontalBox_1.setAlignmentY(Component.CENTER_ALIGNMENT);
        verticalBox.add(horizontalBox_1);
        
        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        horizontalStrut_2.setPreferredSize(new Dimension(20, 40));
        horizontalStrut_2.setMinimumSize(new Dimension(20, 40));
        horizontalStrut_2.setMaximumSize(new Dimension(20, 40));
        horizontalBox_1.add(horizontalStrut_2);
        
        button = new JButton("Atrás");
        
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        horizontalBox_1.add(button);
        
        Component horizontalGlue = Box.createHorizontalGlue();
        horizontalBox_1.add(horizontalGlue);
        

        //PROGRAMEM EL COMPORTAMENT DE LA VISTA:
        //Programem el comportament cada cop que el JComboBox canvia de valor
        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	//entrem al if només quan s'hagi seleccionat l'item, para evitar doble reaccion del listener
	                int val = box.getSelectedIndex();
	                validate();	
	                switch(val){
	                	case 0: 
	                		//Ocultamos el botón, que no necesitamos
	                		impExp.setVisible(false);
	                		gd = new GalDraw();
	                        panel.add(gd,"draw");
	                		card.show(panel,"draw");
	                		break;
	                	case 1:
	                		//Ocultamos el botón, que no necesitamos
	                		impExp.setVisible(false);
	                		mg = new GalMod();	                		
	                		card.show(panel,"modify");
	                		break;
	                	case 2:
	                		//Marcamos como visible el botón importar/exportar y le asignamos el texto según su función.
	                		impExp.setVisible(true);
	                		impExp.setText("Importar");
	                		ig.reset();
	                		//Cargamos el panel de importar
	                		card.show(panel,"import");
	                		break;
	                	case 3:
	                		//Marcamos como visible el botón de importar/exportar y le asignamos el texto según su función
	                		impExp.setVisible(true);
	                		impExp.setText("Exportar");
	                		eg.reset();
	                		//Cargamos el panel de exportar
	                		card.show(panel,"export");
	                		break;
	                	default:
	                		System.out.println("DEFAULT");
	                		break;
	                }
                }
            }
        });
        
        
        //Programem el comportament del botó de retrocedir
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		Principal.loadMenuCapita();
        	}
        }); 
        
        //FALTA PROGRAMAR LA LOGICA SEGUN EXP/IMPORTAR llamadas correspondientes. IMPEXP no tiene lógica ninguna. (matizar)
        
	}
	
	
	public void config(){
		box.requestFocusInWindow();
		
		//Centramos el texto del JComboBox
		((JLabel)box.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
	}
}
