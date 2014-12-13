package gui;

import gui.gestioexode.GestioExode;
import gui.gestiogalaxia.GalGest;
import gui.gestiorebel.GestioRebel;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JPanel;

public class Principal {
	/**
	 * Launch the application.
	 */
	
	//Contenedores
	private static Ventana window = new Ventana();
	private static JPanel container = new JPanel();
	private static CardLayout card = new CardLayout();

	//Configuramos la ventana y cargamos la vista de Login
	private static void init(){
		container.setLayout(card);
		window.add(container);
		loadLogin();
	}

	public static void main(String[] args) {
		init();
	}
	
	/* Funciones "load..."
	 * Funcionamiento: se declara una instancia de la vista
	 * 				   se carga en el cardlayout y se muestra 
	 * 				   Se llama a la función config para configurar diferentes aspectos
	 * 				   como puede ser el elemento al que se le hará focus, el botón asociado
	 * 				   por defecto con la tecla intro...
	 */
	
	public static void loadLogin(){
		Login l = new Login();
		container.add(l,"login");
		card.show(container,"login");
		window.setVisible(true);
		l.config();
	}
	
	public static void loadGestioGalaxia(){
		GalGest g = new GalGest();
		container.add(g,"gestiog");
		card.show(container,"gestiog");
		window.setVisible(true);
		g.config();
	}
	
	public static void loadGestioExode(){
		GestioExode ge = new GestioExode();
		container.add(ge,"gestexod");
		card.show(container,"gestexod");
		window.setVisible(true);
		ge.config();
	}
	
	public static void loadGestioRebel(){
		GestioRebel gr = new GestioRebel();
		container.add(gr,"gestreb");
		card.show(container,"gestreb");
		window.setVisible(true);
		gr.config();
	}

	public static void loadMenuCapita(){
		MenuCapita mc = new MenuCapita();
		container.add(mc,"menucap");
		card.show(container,"menucap");
		window.setVisible(true);
		mc.config();
	}
	
	
	
	//Función que elimina del contenedor una vista c
	public static void removeView(Component c){
		card.removeLayoutComponent(c);
		container.remove(c);
	}
	
	
	//Conseguir la ventana nos ayuda para crear una alerta desde cualquier vista.
	public static Ventana getWindow(){
		return window;
	}
}
