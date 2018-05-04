/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nathanael
 */
public abstract class CustomObservable {

    protected List<CustomObserver> observers;
    
    public CustomObservable() {
        observers = new ArrayList<CustomObserver>();
    }
    
    public final void addObserver(CustomObserver observer)
    {
        observers.add(observer);
    }
    
    public final void deleteObserver(CustomObserver observer)
    {
        observers.remove(observer);
    }
    
    public abstract void notifyObservers();
    
    
    
}
