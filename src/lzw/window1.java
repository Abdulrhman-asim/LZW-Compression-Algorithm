package lzw;
import java.util.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class window1 {

	private JFrame frame;
	private JTextField txtInput;
	private JTextField txtOutput;
	private JButton btnUsingFiles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window1 window = new window1();
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
	public window1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 547, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtInput = new JTextField();
		txtInput.setText("input");
		txtInput.setBounds(74, 60, 264, 30);
		frame.getContentPane().add(txtInput);
		txtInput.setColumns(10);
		
		txtOutput = new JTextField();
		txtOutput.setText("output");
		txtOutput.setBounds(74, 109, 264, 30);
		frame.getContentPane().add(txtOutput);
		txtOutput.setColumns(10);
		
		JButton btnNewButton = new JButton("compress");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				algorithm alg = new algorithm();
				String in = txtInput.getText();
				Vector<Tag> hold = alg.compress(in);
				String data = "";
				for(int i = 0 ; i < hold.size() ; i++)
				{
					data += hold.get(i).toString();
				}
				
				txtOutput.setText(data);
			}
		});
		btnNewButton.setBounds(74, 235, 96, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDecompress = new JButton("decompress");
		btnDecompress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				algorithm alg = new algorithm();
				String in = txtInput.getText();
				String [] hold  = in.split(" ");
				Vector<Tag> tags = new Vector<Tag>();
				for (int i = 0 ; i < hold.length ; i++)
				{
					int x = Integer.parseInt(hold[i]);
					tags.add(new Tag(x));
				}
				
				String data = alg.decompress(tags);
				txtOutput.setText(data);
			}
		});
		btnDecompress.setBounds(276, 235, 99, 30);
		frame.getContentPane().add(btnDecompress);
		
		btnUsingFiles = new JButton("using files");
		btnUsingFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				window2 win = new window2();
				win.frame.setVisible(true);
			}
		});
		btnUsingFiles.setBounds(438, 290, 85, 21);
		frame.getContentPane().add(btnUsingFiles);
	}
}
