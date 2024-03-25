package practice;

import javax.swing.JOptionPane;

public class Gui {

	public static void main(String[] args) {
	
		String name=JOptionPane.showInputDialog("your name");
		JOptionPane.showMessageDialog(null,"your name is "+name);
		
		int age=Integer.parseInt(JOptionPane.showInputDialog("your age "));
		JOptionPane.showMessageDialog(null,"you are age is "+ age);
		
		double height=Double.parseDouble(JOptionPane.showInputDialog("your height"));
		JOptionPane.showMessageDialog(null, "height "+height);
		
		
    
	}

}
