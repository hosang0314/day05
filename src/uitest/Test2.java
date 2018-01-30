package uitest;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test2 implements ActionListener{ // Test2에 ActionListener(클릭)을 발생시키겠다.
	Frame frame;
	Button b1, b2,b3,b4,b5;
	
	public Test2() {
		frame = new Frame();
		b1 = new Button("Button1");
		b2 = new Button("Button2");
		b3 = new Button("Button3");
		b4 = new Button("Button4");
		b5 = new Button("Button5");
	}
	public void makeUi() {
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);		
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose(); //Frame 닫기 이벤트
			}
		});
		frame.setSize(600, 400);
		frame.setBackground(Color.PINK);
		frame.setTitle("New Window");
		
		frame.add(b1,"East");
		frame.add(b2,"West"); //b1 위에 b2가 덮어씌어져 표시된다.
		frame.add(b3,"South");
		frame.add(b4,"North");
		frame.add(b5,"Center");
		
		frame.setLocation(500, 400);
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			b1.setBackground(Color.red);
		}else if(e.getSource() == b2) {
			b2.setBackground(Color.blue);
		}else if(e.getSource() == b3) {
			b3.setBackground(Color.GREEN);
		}else if(e.getSource() == b4) {
			b4.setBackground(Color.ORANGE);
		}else if(e.getSource() == b5) {
			b5.setBackground(Color.YELLOW);
		}
		
	}
}
