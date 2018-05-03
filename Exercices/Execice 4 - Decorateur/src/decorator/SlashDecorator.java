package decorator;
/*
The Design Patterns Java Companion

Copyright (C) 1998, by James W. Cooper

IBM Thomas J. Watson Research Center

http://www.java2s.com/Code/Java/Design-Pattern/DecoratorpatterninJava.htm

*/


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

class SlashDecorator extends Decorator {
	int x1, y1, w1, h1;
        private SlashDecorator self;

	public SlashDecorator(JComponent c) {
		super(c);
		c.repaint();
                this.self = this;
                
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

		});
	}

	public void setBounds(int x, int y, int w, int h) {
		x1 = x;
		y1 = y;
		w1 = w;
		h1 = h;
		super.setBounds(x, y, w, h);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
		g.drawLine(0, 0, w1, h1);
	}

}