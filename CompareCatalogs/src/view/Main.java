package view;

import java.awt.EventQueue;

import javax.swing.WindowConstants;

/**
 * Launch the application.
 */
public class Main{

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try{
					Interface frame = new Interface();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});
	}

}