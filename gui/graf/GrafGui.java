package gui.graf;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFrame;

import propsw.Base;
import propsw.Graf;

public class GrafGui extends JFrame
{
	private GrafStarWarsPanel graphComponent; 

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;

	public GrafGui() throws IOException
	{
		super("Prueba Graf");

		graphComponent = new GrafStarWarsPanel();			//Inicialitzo el Panel
		graphComponent.setGraf(readFromOficalFile(2)) ;		//Li assigno un Graf<Base>  (En aquest cas el llegeixo del fitxer que va penjar la profe al racó)
		getContentPane().add(graphComponent);				//L'afegeixo al ContentPAne on el vull mostrar
		graphComponent.paintTheGraf();						//Crido a paintTheGraf() i es pinta ordenadament 
		
	}
	
	public void secondTry() throws IOException{
		graphComponent.coloreaAresta(0, 1, "black");		//Es coloreja l'aresta. El tercer parametre pot ser "red", "black" i altres noms de colors 
	}

	public static void main(String[] args) throws IOException
	{
		GrafGui frame = new GrafGui();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 320);
		frame.setVisible(true);
		long h = System.currentTimeMillis();
		while(h+5000 >= System.currentTimeMillis() ){
			
		}
		frame.secondTry();
	}
	
	

	
	
	
	//Lectura del fitxer del profe al racó
	private Graf<Base> readFromOficalFile(int numGrafProba) throws IOException{
	
		Scanner s = new Scanner(new File("graph1.txt"));
		String line = "";
		String[] nums;
		Graf<Base> graf = new Graf<Base>();
		
		
		
		int counter =0;
		boolean finished = false;
		
		//Construim les connexions del graf
		
		int keyCounter = 0;
		HashMap<String,Integer> keys = new HashMap<String,Integer>();
		
		while(s.hasNextLine() && !finished){
			line = s.nextLine();
			nums = line.split(" ");
			if (nums[0].equals("g"))counter++;
			if (counter > numGrafProba)finished = true;
			if (counter == numGrafProba){
				if(nums[0].equals("v")){
					Base b = new Base();
					b.setGraf(graf);
					b.setNom(nums[1]);
					graf.afegirNode(b);
					keys.put(nums[1], keyCounter);
					keyCounter++;
				}
				if(nums[0].equals("e"))graf.conectarNodes(keys.get(nums[1]), keys.get(nums[2]), Integer.parseInt(nums[3]), 5.0);				
			}
		}
		
		return graf;
	}

}

