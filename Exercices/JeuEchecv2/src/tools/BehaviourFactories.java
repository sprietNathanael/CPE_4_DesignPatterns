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
public interface BehaviourFactories {
    public Behaviours getBehaviour(int x, int y, Behaviours initialBehaviour);
    public Behaviours buildBehaviour(String classname);
}
