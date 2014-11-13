import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class DriverEdmondsKarp<T>
{
	private static void introduccion()
    {
        System.out.println("------------------------");
        System.out.println("| Driver de EdmondsKarp |");
        System.out.println("------------------------");
    }

    private static void menu()
    {
        System.out.println("Opcions:");
        System.out.println("1) Crear un nou graf"); 
        System.out.println("2) Obtenir un possible solucio");
        System.out.println("3) Obtenir totes solucions per tal que hi hagi un maxflow de n");
        System.out.println("0) exit");
    }

    public static void main(String[] args) throws IOException 
    {
        introduccion();
        menu();

        EdmondsKarp<Integer> ek;
        Graf<Integer> graf = new Graf<Integer>();
        Integer idNode;
        Integer idSink;
        Integer idTail;
        ArrayList<Integer> solucio;
        ArrayList<ArrayList<Integer>> solucions;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        int option = Integer.parseInt(br.readLine());

        while(option != 0)
        {
            switch(option)
            {
                case 1:
                    System.out.println("Vols conectar nodes?\n 1): si \n 2): no\n");
                    Integer opcio = Integer.parseInt(br.readLine());
                    if(opcio == 1) 
                    {
                        System.out.println("Introdueix el node inicial");
                        Integer inici = Integer.parseInt(br.readLine());
                        try
                        {
                            inici = graf.getNodeId(inici);
                        }catch(IOException e){
                            System.out.println(e);
                        }


                        System.out.println("Introdueix el node destinari");
                        Integer desti = Integer.parseInt(br.readLine());
                        try
                        {
                            desti = graf.getNodeId(desti);
                        }catch(IOException e){
                            System.out.println(e);
                        }

                        System.out.println("Introdueix capacitat de la aresta");
                        Integer cap = Integer.parseInt(br.readLine());
                        System.out.println("Introdueix cost de la aresta");
                        Double cost = Double.parseDouble(br.readLine());
                        try{
                            System.out.println("s'han connectat correctament.\n");
                            graf.conectarNodes(inici, desti, cap, cost);
                        }catch(IOException e){
                            System.out.println(e);
                        }
                       
                    }

                    System.out.println("Vols afegir node?\n 1): si \n 2): no\n");
                    opcio = Integer.parseInt(br.readLine());

                    if(opcio == 1)
                    {
                        System.out.println("Introdueix un numero per node: ");
                        idNode = Integer.parseInt(br.readLine());

                        try {
                            graf.afegirNode(idNode);
                            System.out.println("El node s'ha afegit correctament\n");
                        } catch(IOException e) {
                            System.out.println(e);
                        }
                    }
                break;

                case 2: 
                    System.out.println("Introdueix el node origen\n");
                    idSink = Integer.parseInt(br.readLine());
                    try
                    {
                        idSink = graf.getNodeId(idSink);
                    }catch(IOException e){
                        System.out.println(e);
                    }

                    System.out.println("Introdueix el node desti\n");
                    idTail = Integer.parseInt(br.readLine());
                    try
                    {
                        idTail = graf.getNodeId(idTail);
                    }catch(IOException e){
                        System.out.println(e);
                    }

                    ek = new EdmondsKarp<Integer>(idSink, idTail, graf);
                    solucio = new ArrayList<Integer>();
                    try
                    {  
                        solucio = ek.dameCamino(graf);
                        System.out.println("Resultat: " + 
                            solucio.toString());
                    }
                    catch(IOException e){
                        System.out.println(e);
                    }
                break;


                case 3:
                    System.out.println("Introdueix un maxflow: ");
                    Integer n = Integer.parseInt(br.readLine());
                    solucions = new ArrayList<ArrayList<Integer>>();

                    System.out.println("Introdueix el node origen\n");
                    idSink = Integer.parseInt(br.readLine());
                    try
                    {
                        idSink = graf.getNodeId(idSink);
                    }catch(IOException e){
                        System.out.println(e);
                    }

                    System.out.println("Introdueix el node desti\n");
                    idTail = Integer.parseInt(br.readLine());
                    try
                    {
                        idTail = graf.getNodeId(idTail);
                    }catch(IOException e){
                        System.out.println(e);
                    }

                    ek = new EdmondsKarp<Integer>(idSink, idTail, graf);

                    try
                    {
                        solucions = ek.retorna_camins(graf, n);
                        System.out.println("Resultats: " + 
                            solucions.toString());
                    }
                    catch(IOException e){
                        System.out.println(e);
                    }
                break;

                default: 
                    System.out.println("Opció no implementada");
            }
            menu();
            option = Integer.parseInt(br.readLine());
        }
    }
}