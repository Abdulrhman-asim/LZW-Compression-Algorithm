package lzw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class window2 {

	public JFrame frame;
	private JTextField txtInputpath;
	private JTextField txtOutputpath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window2 window = new window2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public window2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtInputpath = new JTextField();
		txtInputpath.setText("input_path");
		txtInputpath.setBounds(110, 43, 237, 39);
		frame.getContentPane().add(txtInputpath);
		txtInputpath.setColumns(10);

		txtOutputpath = new JTextField();
		txtOutputpath.setText("output_path");
		txtOutputpath.setBounds(110, 116, 237, 39);
		frame.getContentPane().add(txtOutputpath);
		txtOutputpath.setColumns(10);

		JButton btnCompress = new JButton("compress");
		btnCompress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					Scanner input = new Scanner(new File(txtInputpath.getText()));
					Formatter output = new Formatter(new File(txtOutputpath.getText()));

					String data = input.nextLine();

					algorithm lzw = new algorithm();

					Vector<Tag> tags = lzw.compress(data);
					for (Tag i : tags) {
						output.format("%d ", i.getPosition());
					}
					output.close();
					input.close();
				} catch (Exception asd) {
				}
			}
		});
		btnCompress.setBounds(25, 217, 85, 21);
		frame.getContentPane().add(btnCompress);

		JButton btnDecompress = new JButton("decompress");
		btnDecompress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try {
				
				Scanner input = new Scanner(new File(txtInputpath.getText()));
				Formatter output = new Formatter(new File(txtOutputpath.getText()));
				algorithm lzw = new algorithm();
				String in = input.nextLine();
				
				Vector<Tag> decomptags = new Vector<Tag>();
				String [] hold  = in.split(" ");
				
				Vector<Tag> tags = new Vector<Tag>();
				for (int i = 0 ; i < hold.length ; i++)
				{
					int x = Integer.parseInt(hold[i]);
					tags.add(new Tag(x));
				}
				
				String data = lzw.decompress(tags);
						
				output.format("%s", data);	
				output.close();
				input.close();
				}
				catch(Exception asd) {}
			}
		});
		btnDecompress.setBounds(249, 217, 107, 21);
		frame.getContentPane().add(btnDecompress);
	}

}
