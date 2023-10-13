package p1DBA;

import jade.core.Agent;
import java.util.Iterator;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;

/**
 *
 * @author isma
 */
public class ejercicio02 extends Agent {
    
    @Override
    protected void setup() {
        this.addBehaviour(new OneShotBehaviour(){
            @Override
            public void action() {
                System.out.println("Este es un comportamiento de una sóla vez."
                        + "Teniendo información...");
            }
        });
        
        this.addBehaviour(new OneShotBehaviour(){
            @Override
            public void action() {
                System.out.println("Este es otro comportamiento de una sóla vez."
                        + "Procesando información...");
            }
        });
        
        this.addBehaviour(new OneShotBehaviour(){
            @Override
            public void action() {
                System.out.println("Este es otro comportamiento de una sóla vez."
                        + "Terminando información...");
                
                doDelete();
            }
        });
    }
    
    @Override
    public void takeDown() {
        System.out.println("Terminando agente...");
    }
}
