/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashMap;
import java.util.Map;
import model.pieces.behaviours.Behaviours;
import model.pieces.behaviours.Cavalier;
import model.pieces.behaviours.Fou;
import model.pieces.behaviours.Tour;

/**
 *
 * @author nathanael
 */
public class TempeteBehaviourFactory implements BehaviourFactories{
    
    private static final Map<Integer,Behaviours> behavioursMap = new HashMap<Integer,Behaviours>();
    static{
        behavioursMap.put(0, Tour.getInstance());
        behavioursMap.put(7, Tour.getInstance());
        behavioursMap.put(1, Cavalier.getInstance());
        behavioursMap.put(6, Cavalier.getInstance());
        behavioursMap.put(2, Fou.getInstance());
        behavioursMap.put(5, Fou.getInstance());
        
    }
    
    private static BehaviourFactories thisInstance;
    
    private TempeteBehaviourFactory()
    {
    }
    
    public static BehaviourFactories getInstance() {
        if(thisInstance == null)
        {
            thisInstance = new TempeteBehaviourFactory();
        }
        return thisInstance;
    }

    @Override
    public Behaviours getBehaviour(int x, int y, Behaviours initialBehaviour) {
        Behaviours res = behavioursMap.get(x);
        res = (res == null) ? initialBehaviour : res;
        return res;
    }
}
