package secondpro;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class notHesap extends JFrame {

	private JPanel contentPane;
	private JTextField txtv;
	private JTextField txtf;
	
	private JLabel lblm;
	private JComboBox<String> cmbu;
	public  double ort=0;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					notHesap frame = new notHesap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static boolean isInteger(String str) 
	{
		 int count = 0 ;
	     for (int i = 0; i < str.length(); i++) 
		 {
			 int ch = (int)str.charAt(i);
			 if (ch>47&&ch<58) 
			 {
			     count++;
			 }
	     }
		 if (count==str.length()) 
		 {
			return true;
		 }
		 if (str.equals(null)) 
		 {
			return false;
		 }
		 return false;
	}
	
	public  boolean control() 
	{
		int vize=Integer.parseInt(txtv.getText());
	   int finall=Integer.parseInt(txtf.getText());
		
		if (vize<0 | vize>100 && finall<0 | finall>100)
		{
			JOptionPane.showMessageDialog(null,"Ge�ersiz vize ve final notu girdiniz!");
			return false;
		}
		
		else if (vize<0 || vize>100)
		{
			JOptionPane.showMessageDialog(null,"Ge�ersiz bir vize notu girdiniz!");
			return false;
		}
		
		else if (finall<0 || finall>100)
		{
			JOptionPane.showMessageDialog(null,"Ge�ersiz bir final notu girdiniz!");
			return false;
		}
		
		else 
		{
			return true;
		}
	}
	public  void hesap() 
	{
		int �ni= cmbu.getSelectedIndex();
		int vize=Integer.parseInt(txtv.getText());
		int finall=Integer.parseInt(txtf.getText());
		
		if(�ni==1) 
		{
			ort=vize*0.45+finall*0.55;
			lblm.setText("<html> �niversite: MAK� <br/>Notu: "+(new DecimalFormat("##.##").format(ort)).replace(',', '.'));

		}
		else if(�ni==2) 
		{
			ort=vize*0.4+finall*0.6;
			lblm.setText("<html> �niversite: ODT� <br/>Notu: "+(new DecimalFormat("##.##").format(ort)).replace(',', '.'));
		}
		else if(�ni==3) 
		{
			ort=vize*0.3+finall*0.7;
			lblm.setText("<html> �niversite: iT� <br/>Notu: "+(new DecimalFormat("##.##").format(ort)).replace(',', '.'));
		}
		else if(�ni==0) 
		{
			JOptionPane.showMessageDialog(null,"L�tfen bir �niversite se�iniz!");
		}
	}
	
	public notHesap() {
		
		setTitle("NOT HESAPLAMA\r\n");
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 404, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblv = new JLabel("Vize notu");
		lblv.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblv.setBounds(10, 34, 112, 28);
		contentPane.add(lblv);
		
		JLabel lblf = new JLabel("Final notu");
		lblf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblf.setBounds(10, 73, 112, 28);
		contentPane.add(lblf);
		
		txtv = new JTextField();
		txtv.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtv.setBounds(126, 38, 94, 20);
		contentPane.add(txtv);
		txtv.setColumns(10);
		
		txtf = new JTextField();
		txtf.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtf.setBounds(126, 73, 94, 20);
		contentPane.add(txtf);
		txtf.setColumns(10);
		
		JButton btn = new JButton("Hesapla");
		btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn.setBounds(230, 105, 156, 28);
		contentPane.add(btn);
		
	    cmbu = new JComboBox();
		cmbu.setFont(new Font("Tahoma", Font.BOLD, 14));
		cmbu.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz!", "MAK\u00DC", "ODT\u00DC", "\u0130T\u00DC"}));
		cmbu.setBounds(126, 105, 94, 28);
		contentPane.add(cmbu);
		
		JLabel lblu = new JLabel("\u00DCniversite");
		lblu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblu.setBounds(10, 112, 82, 20);
		contentPane.add(lblu);
		
		JLabel ba�l�k = new JLabel("Not Hesaplama");
		ba�l�k.setHorizontalAlignment(SwingConstants.CENTER);
		ba�l�k.setFont(new Font("Tahoma", Font.BOLD, 16));
		ba�l�k.setBounds(52, -1, 210, 28);
		contentPane.add(ba�l�k);
		
		lblm = new JLabel("");
		lblm.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblm.setVerticalAlignment(SwingConstants.TOP);
		lblm.setHorizontalAlignment(SwingConstants.LEFT);
		lblm.setBounds(230, 34, 154, 60);
		contentPane.add(lblm);
		lblm.setOpaque(true);
		
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 
				if(isInteger(txtv.getText()) && isInteger(txtf.getText())) 
				{
					if (control())
					{
						hesap();
					}
				}
				
				else 
				{
				   JOptionPane.showMessageDialog(null, "L�tfen sadece say� giriniz :)");
				}
			}
		});
		
	
	}
	
	
}