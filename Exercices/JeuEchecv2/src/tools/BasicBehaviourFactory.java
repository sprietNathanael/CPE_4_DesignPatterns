/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    @Override
    public Behaviours buildBehaviour(String classname)
    {
        Behaviours res = null;
        try {
            res = (Behaviours)Class.forName(classname).getMethod("getInstance", null).invoke(null, null);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TempeteBehaviourFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TempeteBehaviourFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(TempeteBehaviourFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(TempeteBehaviourFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(TempeteBehaviourFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(TempeteBehaviourFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
}
