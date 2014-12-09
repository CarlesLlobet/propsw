package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

abstract public class JPanelBg extends JPanel{
	private Image fondo= null;
   
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo,0,0,getWidth(),getHeight(),null);
    }

    public void setImage(String image){
        fondo=new ImageIcon(getClass().getResource(image)).getImage();
     }
    
    protected void deleteView(){
    	Principal.removeView(this);
    }
    
 }
