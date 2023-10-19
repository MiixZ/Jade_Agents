package p1DBA;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import jade.core.behaviours.TickerBehaviour;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author isma
 */
public class ejercicio04 extends Agent {
    public final int TIEMPO_ESPERA = 500;
    Scanner escaner = new Scanner(System.in);
    ArrayList<Float> numeros = new ArrayList<>();
    Boolean media_calculable = false, puedo_coger_numeros = false; 
    int n_numeros = 1;
    
    WakerBehaviour pedirN_numeros = new WakerBehaviour(this, TIEMPO_ESPERA) {
        @Override
        public void onWake() {
            int p = 0;
            try {
                System.out.println("\nMODO 0: Introduzca un número positivo" +
                                   " de elementos numéricos a leer:\n");
                p = escaner.nextInt();
                n_numeros = p;
                puedo_coger_numeros = true;
            } catch (Exception e) {
                System.out.println("\nMODO 0: El número introducido no es válido."
                        + " Vuelva a intentarlo.\n" + escaner.next());
                puedo_coger_numeros = false;
                n_numeros = 1;
            }
        }
    };
    
    TickerBehaviour pedirNumeros = new TickerBehaviour(this, TIEMPO_ESPERA) {
        int i = 0;

        @Override
        public void onTick() {
            float n_actual;

            if (puedo_coger_numeros) {
                try {
                    System.out.println("\nMODO 1: Cogiendo número...\n");
                    n_actual = escaner.nextFloat();
                    numeros.add(n_actual);
                    i++;
                } catch (Exception e) {
                    System.out.println("\nMODO 1: No ha introducido un número válido"
                            + " en la zona " + i + "... Introduzca un sustituto...\n");
                    
                    escaner.next();
                }
            }

            if (i >= n_numeros) {
                media_calculable = true;
                stop();
            }
        }
    };

    TickerBehaviour calcularMedia = new TickerBehaviour(this, TIEMPO_ESPERA*4) {
        @Override
        public void onTick() {
            if (media_calculable) {
                float suma = 0;

                for (int i = 0; i < numeros.size(); i++) {
                    suma += numeros.get(i);
                }

                System.out.println("\nMODO 2: La media es: " + suma/n_numeros);
                stop();
                doDelete();
            } else {
                System.out.println("\nMODO 2: Esperando a recibir todos los números...\n");
            }
        }
    };
    
    @Override
    protected void setup() {
        // Este comportamiento pedirá el número de elementos a leer.
        this.addBehaviour(pedirN_numeros);

        // Este será un comportamiento cíclico que pida los datos hasta que sean correctos.
        this.addBehaviour(pedirNumeros);

        // Este comportamiento calculará la media.
        this.addBehaviour(calcularMedia);   
    }
    
    @Override
    public void takeDown() {
        System.out.println("Terminando agente...");
    }
}
