package com.mysiming.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import com.mysiming.util.MD5Util;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class Md5Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	protected JFileChooser jfc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Md5Frame frame = new Md5Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Md5Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton button = new JButton("���...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ʵ�����ļ�ѡ��Ի���
				  jfc = new JFileChooser();
				//��ʾ�Ի���
				int result = jfc.showOpenDialog(null);
				String filepath = "";
				//�ж��Ƿ�ѡ���ļ�
				if (result == JFileChooser.APPROVE_OPTION){
					//ѡ���ļ�����·��
					filepath = jfc.getSelectedFile().getAbsolutePath();
					//��ֵ
					textField.setText(filepath);
				}
			}
		});
		
		JButton btnmd = new JButton("����Md5");
		btnmd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ȡѡ���ļ�file����
				File file = jfc.getSelectedFile();
				//����File�������MD5
				String filemd5 = MD5Util.getMd5ByFile(file);
				//��ֵ
				textField_1.setText(filemd5);	
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("��ȡ�ļ�");
		
		JLabel lblMd = new JLabel("Md5ֵ");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(lblMd))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_1)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnmd, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(34))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnmd)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMd))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
