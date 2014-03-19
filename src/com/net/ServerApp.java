package com.net;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ServerApp extends JFrame implements Runnable, ActionListener {

	JPanel mainPanel;
	JPanel bottomPanel;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	Border border;
	JTextArea txtChatMess;
	JScrollPane scroll;
	JTextField txtMess;
	JLabel lblEnterMess;
	JButton cmdSend;
	JButton cmdReset;
	
	ServerSocket server = null;
	Socket socket = null;
	Scanner read = null;
	PrintWriter write = null;
	
	public ServerApp(){
		super("服务器");
		mainPanel = new JPanel();
		bottomPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(bottomPanel,BorderLayout.SOUTH);
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		bottomPanel.setLayout(gbl);
		
		txtChatMess = new JTextArea(15,20);
		txtChatMess.setEditable(false);
		scroll = new JScrollPane(txtChatMess);
		mainPanel.add(scroll);
		
		border = BorderFactory.createRaisedBevelBorder();
		txtMess = new JTextField(15);
		lblEnterMess = new JLabel("请输入消息：");
		cmdSend = new JButton("发 送");
		cmdSend.setPreferredSize(new Dimension(50,20));
		cmdSend.setEnabled(false);
		cmdSend.addActionListener(this);
		cmdReset = new JButton("清 空");
		cmdReset.setPreferredSize(new Dimension(50,20));
		cmdReset.addActionListener(this);
		cmdSend.setBorder(border);
		cmdReset.setBorder(border);
		
		gbc.gridx = 3;
		gbc.gridy = 10;
		gbl.setConstraints(lblEnterMess, gbc);
		bottomPanel.add(lblEnterMess);
		
		gbc.gridx = 10;
		//gbc.fill = gbc.BOTH;
		gbl.setConstraints(txtMess,gbc);
		bottomPanel.add(txtMess);
		
		gbc.gridx = 3;
		gbc.gridy = 30;
		gbl.setConstraints(cmdSend, gbc);
		bottomPanel.add(cmdSend);
		
		gbc.gridx = 10;
		gbl.setConstraints(cmdReset, gbc);
		bottomPanel.add(cmdReset);
		
		getContentPane().add(mainPanel);
		pack();
		setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getSource() == cmdSend){
			try{
				write.println(txtMess.getText());
				write.flush();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(evt.getSource() == cmdReset){
			txtMess.setText("");
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			server = new ServerSocket(8000);
			while(true){
				socket = server.accept();
				
				if(socket != null){
					txtChatMess.append("服务器消息：客户已连接！\n");
					cmdSend.setEnabled(true);
				}else{
					txtChatMess.append("服务器消息：客户未能连接！\n");
					cmdSend.setEnabled(false);
				}
				
				Connections con = new Connections(socket);
				Thread thread = new Thread(con);
				thread.start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	class Connections implements Runnable{
		Socket clientSock = null;
		
		Connections(Socket s){
			this.clientSock = s;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				read = new Scanner(clientSock.getInputStream());
				write = new PrintWriter(clientSock.getOutputStream());
				
				String result = read.nextLine();
				if(result == null){
					return;
				}
				
				while(!result.trim().equals("Exit!")){
					txtChatMess.append("客户端消息：" + result + "\n");
					if(read.hasNextLine()){
						result = read.nextLine();
					}else{
						Thread.sleep(100);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					read.close();
					write.close();
					socket.close();
					server.close();
					cmdSend.setEnabled(false);
				}catch(Exception ex){
					
				}
			}
		}
	}
	
	public static void main(String[] args){
		ServerApp serverApp = new ServerApp();
		Thread thread = new Thread(serverApp);
		thread.start();
	}
}
