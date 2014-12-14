package gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class ImpExp extends JPanel{
	private JTextPane txtpnRuta;
	private JButton btnExaminar;
	
	public ImpExp() {
				//Amb això fiquem el fondo del panel transparent.
				setBackground(new Color(0,0,0,0));
				setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
				
				Box verticalBox = Box.createVerticalBox();
				verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
				add(verticalBox);
				

				Component verticalStrut_1 = Box.createVerticalStrut(20);
				verticalBox.add(verticalStrut_1);
				
				Box horizontalBox = Box.createHorizontalBox();
				verticalBox.add(horizontalBox);
				
				Component horizontalStrut = Box.createHorizontalStrut(20);
				horizontalStrut.setMaximumSize(new Dimension(20, 20));
				horizontalBox.add(horizontalStrut);
				
				txtpnRuta = new JTextPane();
				txtpnRuta.setEditable(false);
				txtpnRuta.setBorder(new LineBorder(new Color(0, 0, 0)));
				txtpnRuta.setMaximumSize(new Dimension(500, 20));
				horizontalBox.add(txtpnRuta);
				txtpnRuta.setText("Ruta");
				
				Component horizontalStrut_1 = Box.createHorizontalStrut(20);
				horizontalStrut_1.setMaximumSize(new Dimension(20, 20));
				horizontalBox.add(horizontalStrut_1);
				
				btnExaminar = new JButton("Examinar");
				btnExaminar.setAlignmentX(Component.CENTER_ALIGNMENT);
				horizontalBox.add(btnExaminar);
				
				Component verticalStrut = Box.createVerticalStrut(20);
				verticalBox.add(verticalStrut);
	}
	
	public String getRuta(){
			return txtpnRuta.getText();
	}
	
	public void reset(){
		txtpnRuta.setText("");
	}
	//Faltaria el evento del botón examinar --> Se abriera la ventana para especificar la ruta de salida/entrada

}
