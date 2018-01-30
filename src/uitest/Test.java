package uitest;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test {
	Frame frame;
	Button b1, b2;
	
	public Test() {
		frame = new Frame();
		b1 = new Button("Button1");
		b2 = new Button("Button2");
	}
	public void makeUi() {
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose(); //Frame 닫기 이벤트
			}
		});
		frame.setSize(600, 400);
		frame.setBackground(Color.PINK);
		frame.setTitle("New Window");
		
		frame.add(b1);
		frame.add(b2); //b1 위에 b2가 덮어씌어져 표시된다.
		
		frame.setLocation(500, 400);
		frame.setVisible(true);
		
	}
}
