package p1DBA;

import jade.core.Agent;
import java.util.Iterator;

/**
 *
 * @author isma
 */
public class ejercicio01 extends Agent {
    @Override
    protected void setup() {
        System.out.println("Hola! Soy tu primer agente");
        
        System.out.println("Mi nombre es " + getAID().getLocalName());
        System.out.println("Mi GUID es " + getAID().getName());
        System.out.println("Mis direcciones son: ");
        
        Iterator it = getAID().getAllAddresses();
        
        while(it.hasNext()) {
            System.out.println("- " + it.next());
        }
        
        doDelete();
    }

    @Override
    public void takeDown() {
        System.out.println("Terminando agente...");
    }
}
