/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

/**
 *
 * @author nathanael
 */
public class EnabledDecorator extends Decorator
{
    private static EnabledDecorator previousComponent = null;
    private EnabledDecorator self;
    private JComponent wrappedComponent;

    public EnabledDecorator(JComponent c) {
        super(c);
        this.self = this;
        this.wrappedComponent = c;
        
        //catch mouse movements in inner class
        c.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        self.repaint();
                }

                public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        self.repaint();
                }
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if(previousComponent != null)
                    {
                        previousComponent.setEnable();                  
                    }
                    else
                    {
                       self.setDisable();
                    }
                }

        });
    }
    
    public void setEnable()
    {
        //previousComponent.setVisible(true);
        wrappedComponent.setEnabled(true);
        previousComponent.repaint();
        previousComponent = null;
    }
    
    public void setDisable()
    {
        //self.setVisible(false);
        wrappedComponent.setEnabled(false);
        self.repaint();
        previousComponent = self;
    }
    
}
