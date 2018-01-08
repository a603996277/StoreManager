package www.aodong.cn;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
@SuppressWarnings("serial")
public class ShowNullStore extends JFrame {
	JScrollPane jscrollPane;

	public ShowNullStore(){
		Toolkit tk=Toolkit.getDefaultToolkit(); 
		Image img=tk.getImage("image/junji1.png");// GIF��JPEG �� PNG   
		img.flush();	
		setIconImage(img);
		Container n = this.getContentPane();
		n.setLayout(null);
		
		JLabel JLmes=new JLabel();
		n.add(JLmes);
		JLmes.setBounds(30, 30, 130, 35);
		JLmes.setText("�ղֺ���ʾ:");
		JLmes.setFont(new Font("�꿬��", Font.BOLD, 18));
		
		
		JButton jButton=new JButton();
		n.add(jButton);
		jButton.setText("ˢ��");
		jButton.setBounds(410, 30, 70, 30);
		
		JLabel JLmes1=new JLabel();
		n.add(JLmes1);
		JLmes1.setBounds(30, 200, 130, 35);
		JLmes1.setText("���:");
		JLmes1.setFont(new Font("�꿬��", Font.BOLD, 18));
		
		JLabel JLmes11=new JLabel();
		n.add(JLmes11);
		JLmes11.setBounds(250, 200, 130, 35);
		JLmes11.setText("ȡ��:");
		JLmes11.setFont(new Font("�꿬��", Font.BOLD, 18));
		
		JLabel JLmes2=new JLabel();
		n.add(JLmes2);
		JLmes2.setBounds(30, 240, 100, 35);
		JLmes2.setText("�ղֺ�:");
		
		JLabel JLmes21=new JLabel();
		n.add(JLmes21);
		JLmes21.setBounds(250, 240, 90, 35);
		JLmes21.setText("ȡ���̺�:");
		
		final JFormattedTextField tx21=new JFormattedTextField();
		n.add(tx21);
		tx21.setBounds(350, 240, 100, 30);
		
		
		final JFormattedTextField tx1=new JFormattedTextField();
		n.add(tx1);
		tx1.setBounds(140, 240, 100, 30);
		//tx1.setFont(new Font("�꿬��", Font.BOLD, 18));
		
		JLabel JLmes3=new JLabel();
		n.add(JLmes3);
		JLmes3.setBounds(30, 280, 100, 35);
		JLmes3.setText("���̺�:");
		
		
		
		final JFormattedTextField tx2=new JFormattedTextField();
		n.add(tx2);
		tx2.setBounds(140, 280, 100, 30);
		
		JLabel JLmes31=new JLabel();
		n.add(JLmes31);
		JLmes31.setBounds(250, 280, 100, 35);
		JLmes31.setText("ȡ���ֺ�:");
		
		final JFormattedTextField tx31=new JFormattedTextField();
		n.add(tx31);
		tx31.setBounds(350, 280, 100, 30);
		
		JLabel JLmes41=new JLabel();
		n.add(JLmes41);
		JLmes41.setBounds(250, 320, 100, 35);
		JLmes41.setText("ȡ����:");
		
		final JFormattedTextField tx41=new JFormattedTextField();
		n.add(tx41);
		tx41.setBounds(350, 320, 100, 30);

		
		JLabel JLmes4=new JLabel();
		n.add(JLmes4);
		JLmes4.setBounds(30, 320, 100, 35);
		JLmes4.setText("������:");

		final JFormattedTextField tx3=new JFormattedTextField();
		n.add(tx3);
		tx3.setBounds(140, 320, 100, 30);
		this.JFormattedText(tx3);
		JButton jButton1=new JButton();
		n.add(jButton1);
		jButton1.setText("ȷ�����");
		jButton1.setBounds(30, 370, 100, 30);
		
		JButton jButton2=new JButton();
		n.add(jButton2);
		jButton2.setText("ȡ��");
		jButton2.setBounds(350, 370, 100, 30);
		//���
		jButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DBStore dbStore=new DBStore();
				String sstoreName=tx1.getText();				
				String aString=dbStore.dealNullStare(sstoreName);
				String spalletName=tx2.getText();
				String spalletNumber=tx3.getText();
				System.out.println(aString);
				if (!sstoreName.equals("")) {
					if (!spalletName.equals("")) {
						if (!spalletNumber.equals("")) {
							if (aString.equals("0")) {
								dbStore.setZero();
								dbStore.saveStore(spalletName, spalletNumber, sstoreName);
								JOptionPane.showMessageDialog(null, "����ɹ�");
							} else {
			                   JOptionPane.showMessageDialog(null, "����Ĳ��ǿղֺ�") ;
							}	
						} else {
                   JOptionPane.showMessageDialog(null, "����������Ϊ��");}
					} else {
                   tx2.setText("���̺Ų���Ϊ�գ�");
					}
				} else {
                   tx1.setText("�ֿ�Ų���Ϊ��!");
				}
				
				
			}
		});
		//ȡ��
		jButton2.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
			    String	spalletName=tx21.getText();
				DBStore dbStore = new DBStore();
			    System.out.println(spalletName);
				// TODO Auto-generated method stub
			    Map	rs=dbStore.getStore(spalletName);
			    String storeName;
			    String palletNumber;
			    String	sstoreName=(String) rs.get("1");
			    if (sstoreName!=null) {
			    	String	spalletNumber=(String) rs.get("2");
					System.out.println(sstoreName+"////"+spalletNumber);
					tx31.setText(sstoreName);
					tx41.setText(spalletNumber);
		            JOptionPane.showMessageDialog(null, "ȡ���ɹ�");
				} else {
					JOptionPane.showMessageDialog(null, "�ֿ�û�и�����"); 
				}
			    
			}});
		final JTextArea jta=new JTextArea(4,15);
		jta.setTabSize(4);  
		jta.setFont(new Font("�꿬��", Font.BOLD, 18));  
		jta.setLineWrap(true);// �����Զ����й���  
		jta.setWrapStyleWord(true);// ������в����ֹ���
		//jta.setBackground(Color.pink);  
		jscrollPane = new JScrollPane(jta); 
		n.add(jscrollPane);
		jscrollPane.setBounds(30, 75, 450, 100);
		//this.setJTextArea(jta);

		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DBStore dbStore=new DBStore();
				dbStore.setZero();
	            String string=dbStore.nullStore();
				jta.setText(string);
	            
			}
		});
		
		
		
		
	}
    public void JFormattedText( final JFormattedTextField text )  {
   	 
	       //JPanel panel = new JPanel();
	      // text = new JFormattedTextField(new java.text.DecimalFormat("#0"));
	        //text = new JFormattedTextField();
      text.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
	       //text.setFont(new java.awt.Font("����", 0, 12)); // NOI18N
	       //text.setMaximumSize(new java.awt.Dimension(50, 21));
	       //text.setMinimumSize(new java.awt.Dimension(50, 21));
	      // text.setPreferredSize(new java.awt.Dimension(50, 21));
	       //����������ַ�
	       text.addKeyListener(new java.awt.event.KeyAdapter() {
	           public void keyReleased(java.awt.event.KeyEvent evt) {
	               String old = text.getText();
	               JFormattedTextField.AbstractFormatter formatter = text.getFormatter();
	               if (!old.equals("")) { 
	                   if (formatter != null) {
	                       String str = text.getText();
	                       try {
	                           long page = 0;
							try {
								page = (Long) formatter.stringToValue(str);
								//int number1=new Long(page).intValue();
							} catch (java.text.ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	                           //text.setText("��ʽ����");
	                       } catch (ParseException pe) {
	                           text.setText(" ");//�����쳣ֱ�ӽ��ı�����ֵ����Ϊ1
	                       }
	                   }
	               }
	           }
	       });
	      // panel.add(text);
	       //this.add(panel);
	      // this.setBounds(a, b, c, d);
	   }
	 		
	/**
	 * @param args
	 * @throws Exception 
	 */
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//DBStore dbStore=new DBStore();
		//dbStore.setZero();
		ShowNullStore timeFrame = new ShowNullStore();
		timeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		timeFrame.setSize(530, 500);
		timeFrame.setLocation(300, 100);
		timeFrame.setVisible(true);
	}

}
