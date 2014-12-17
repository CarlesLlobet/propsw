package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class ImpExp extends JPanel{
	private JTextPane txtpnRuta;
	private JLabel lblNewLabel;
	
	public ImpExp() {
				//Amb això fiquem el fondo del panel transparent.
				setBackground(new Color(0,0,0,0));
				setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
				
				Box verticalBox = Box.createVerticalBox();
				verticalBox.setAlignmentX(Component.CENTER_ALIGNMENT);
				add(verticalBox);
				

				Component verticalStrut_1 = Box.createVerticalStrut(20);
				verticalBox.add(verticalStrut_1);
				
				Box horizontalBox_1 = Box.createHorizontalBox();
				verticalBox.add(horizontalBox_1);
				
				lblNewLabel = new JLabel("New label");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
				horizontalBox_1.add(lblNewLabel);
				
				Box horizontalBox = Box.createHorizontalBox();
				verticalBox.add(horizontalBox);
				
				txtpnRuta = new JTextPane();
				txtpnRuta.setBorder(new LineBorder(new Color(0, 0, 0)));
				txtpnRuta.setMaximumSize(new Dimension(300, 20));
				horizontalBox.add(txtpnRuta);
				txtpnRuta.setText("Ruta");
				
				Component verticalStrut = Box.createVerticalStrut(20);
				verticalBox.add(verticalStrut);
	}
	
	public String getText(){
			return txtpnRuta.getText();
	}
	
	public void setText(String s){
		lblNewLabel.setText(s);
	}
	
	public void reset(){
		txtpnRuta.setText("");
	}
	//Faltaria el evento del botón examinar --> Se abriera la ventana para especificar la ruta de salida/entrada

}
