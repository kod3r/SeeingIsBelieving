package graphics;

import java.awt.Frame;

public class Framework {

	public static Frame createWindow(String title) {
		Frame newFrame = new Frame(title);
		return newFrame;
	}

	public static void main(String args[]) {
		Frame f = createWindow("hello World");
		f.setVisible(true);
		f.setBounds(0, 0, 400, 300);
	}
}
