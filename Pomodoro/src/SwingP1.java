import javax.swing.*;

public class SwingP1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create an instance of the jframe
		JFrame f = new JFrame();
		
		JButton b = new JButton("click"); // Creating instance of JButton
		b.setBounds(130, 100, 100, 40); // x axis, y axis, width, height;
		
		f.add(b); //adding button in JFrame
		
		f.setSize(400, 500); // 400 width, 500 height;
		f.setLayout(null);
		f.setVisible(true);
		
	}

}
