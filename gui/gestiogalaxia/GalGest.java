package gui.gestiogalaxia;
import gui.ImpExp;
import gui.JPanelBg;
import gui.Principal;
import gui.graf.GrafStarWarsPanel;

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
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GalGest extends JPanelBg {
	private JComboBox<String> box;
	private JButton atras;
	private CardLayout card = new CardLayout(0, 0);
	private JPanel panel = new JPanel(); 
	private JButton impExp;
	
	//vistes que es carregaran:
    private ImpExp eg = new ImpExp();
    private ImpExp ig = new ImpExp();
    private GalMod mg = new GalMod();
    private GrafStarWarsPanel gd = new GrafStarWarsPanel();
	
    private String idEx = null;
    
    
	public GalGest() {
		
		//PREPARAMOS LA VISTA
        setImage("/images/bg.jpg");
        setLayout(new BorderLayout(0, 0));
        
        Box verticalBox = Box.createVerticalBox();
        verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(verticalBox);
        
        Box horizontalBox_1 = Box.createHorizontalBox();
        horizontalBox_1.setAlignmentY(Component.CENTER_ALIGNMENT);
        verticalBox.add(horizontalBox_1);
        
        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        horizontalStrut_2.setPreferredSize(new Dimension(20, 40));
        horizontalStrut_2.setMinimumSize(new Dimension(20, 40));
        horizontalStrut_2.setMaximumSize(new Dimension(20, 40));
        horizontalBox_1.add(horizontalStrut_2);
        
        atras = new JButton("Atrás");
        
        atras.setAlignmentX(Component.CENTER_ALIGNMENT);
        horizontalBox_1.add(atras);
        
        Component horizontalGlue = Box.createHorizontalGlue();
        horizontalBox_1.add(horizontalGlue);
        
        JButton guardar = new JButton("Guardar");
        guardar.setAlignmentX(0.5f);
        horizontalBox_1.add(guardar);
        
        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        horizontalStrut_1.setPreferredSize(new Dimension(20, 40));
        horizontalStrut_1.setMinimumSize(new Dimension(20, 40));
        horizontalStrut_1.setMaximumSize(new Dimension(20, 40));
        horizontalBox_1.add(horizontalStrut_1);
        
        
        //Programem el comportament del botó de retrocedir
        atras.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		deleteView();
        		Principal.loadMenuCapita();
        	}
        }); 
        
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
        
        
        //dibuixem el graf
        try {
			gd.setGraf(Principal.getCc().getGalaxia().getCopiaGraf());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			gd.paintTheGraf();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        card.show(panel, "draw");
                
        Component horizontalGlue_6 = Box.createHorizontalGlue();
        horizontalBox.add(horizontalGlue_6);
        
        impExp = new JButton("New button");
        verticalBox_1.add(impExp);
        impExp.setVisible(false);
                
        Component verticalGlue_1 = Box.createVerticalGlue();
        verticalBox_1.add(verticalGlue_1);
        

        //PROGRAMEM EL COMPORTAMENT DE LA VISTA:
        //Programem el comportament cada cop que el JComboBox canvia de valor
        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	//entrem al if només quan s'hagi seleccionat l'item, para evitar doble reaccion del listener
	                int val = box.getSelectedIndex();
	                switch(val){
	                	case 0: //consulta
	                		//Ocultamos el botón, que no necesitamos
	                		impExp.setVisible(false);
							try {
								gd.setGraf(Principal.getCc().getGalaxia().getCopiaGraf());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								gd.paintTheGraf();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	                        panel.add(gd,"draw");
	                		card.show(panel,"draw");
	                		break;
	                	case 1: //Crear
	                		//Ocultamos el botón, que no necesitamos
	                		impExp.setVisible(false);
	                		//mg.reset();
	                		//mg.actuCombos();
	                		card.show(panel,"modify");
	                		break;
	                	case 2: //Modificar
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
	                revalidate();	
	                repaint();
                }
            }
        });
	}
	
	public void config(){
		box.requestFocusInWindow();
		
		//Centramos el texto del JComboBox
		((JLabel)box.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
	}
}
