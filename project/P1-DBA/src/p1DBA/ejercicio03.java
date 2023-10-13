package p1DBA;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;

/**
 *
 * @author isma
 */
public class ejercicio03 extends Agent {
    
    @Override
    protected void setup() {
        this.addBehaviour(new TickerBehaviour(this, 2000){
            int i = 0;
            
            @Override
            public void onTick() {
                if (i < 10) {
                    System.out.println("Este es un comportamiento cíclico."
                            + " iteración: " + i);
                } else {
                    this.stop();
                    doDelete();
                }
                i++;
            }
        });
    }
    
    @Override
    public void takeDown() {
        System.out.println("Terminando agente...");
    }
}
