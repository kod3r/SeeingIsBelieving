package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.LayoutManager;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

class DrawCircle extends JComponent {
	Color c;
	int size;
	int location;

	public DrawCircle(int size) {
		super();
		this.size = size;
		super.setPreferredSize(new Dimension(size, size));
	}

	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(c);
		g.fillOval(location, location, size, size);
	}
};

public class Framework {

	public static void main(String args[]) {
		JFrame j = new JFrame();

		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(400, 400);
		j.setVisible(true);

		DrawCircle d = new DrawCircle(10);
		d.c = Color.BLACK;
		d.location = 100;

		DrawCircle d1 = new DrawCircle(25);
		d1.c = Color.RED;
		d1.size = 25;

		DrawCircle d3 = new DrawCircle(10);
		d.c = Color.CYAN;
		d.location = 200;

		j.add(d, BorderLayout.CENTER);
		j.add(d1, BorderLayout.BEFORE_LINE_BEGINS);

		// f = new DrawCircle();
	}
}
