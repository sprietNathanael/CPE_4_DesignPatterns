/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import model.pieces.behaviours.Behaviours;

/**
 *
 * @author nathanael
 */
public class BasicBehaviourFactory implements BehaviourFactories{
    
    private static BehaviourFactories thisInstance;
    
    private BasicBehaviourFactory()
    {
    }
    
    public static BehaviourFactories getInstance() {
        if(thisInstance == null)
        {
            thisInstance = new BasicBehaviourFactory();
        }
        return thisInstance;
    }

    @Override
    public Behaviours getBehaviour(int x, int y, Behaviours initialBehaviour) {
        return initialBehaviour;
    }
    
}
