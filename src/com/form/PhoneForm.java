package com.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Center.Center;
import Connect.Connect;

import com.dao.PhoneDAO;
import com.vo.Phone;

public class PhoneForm extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 6951743246765691693L;

	private static JLabel lblEmpHead, lblLine, lblPhNo, lblOwnerName, lblAmt,
			lblDate, lblOwnerJob, lblOwnerAddr, lblOwnerAge, lblOwnerNRC;
	private static JTextField txtPhNo, txtOwnerName, txtAmt, txtDate,
			txtOwnerJob, txtOwnerAddr, txtOwnerAge, txtOwnerNRC;
	private static JButton cmdSave, cmdFind, cmdUpdate, cmdClear, cmdDelete;
	private static JPanel mainPanel, lblPanel, btnPanel;
	private static Phone ph;
	private static Connect Conn;
	private static Center center;
	private static String currentDate;
	private static SimpleDateFormat formatter;
	private static Date dt;

	public PhoneForm() {

		currentDate = new String();
		formatter = new SimpleDateFormat("MMM - dd - yyyy", Locale.getDefault());
		dt = new java.util.Date();
		currentDate = formatter.format(dt);

		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		// Label Panel

		lblPanel = new JPanel();
		lblPanel.setLayout(null);

		lblEmpHead = new JLabel(" Phone Book ");
		lblEmpHead.setFont(new Font("TimesRoman", Font.BOLD, 22));
		lblEmpHead.setBounds(210, 10, 300, 20);
		lblLine = new JLabel(" =================");
		lblLine.setBounds(210, 23, 300, 20);
		lblLine.setForeground(Color.red);

		lblPhNo = new JLabel("Phone No :");
		lblPhNo.setFont(new Font("TimesRoman", Font.BOLD, 12));
		lblPhNo.setBounds(25, 50, 200, 20);
		txtPhNo = new JTextField();
		txtPhNo.setFont(new Font("TimesRoman", Font.BOLD, 12));
		txtPhNo.setBounds(200, 50, 150, 20);
		txtPhNo.addKeyListener(this);

		lblOwnerName = new JLabel("Owner Name :");
		lblOwnerName.setFont(new Font("TimesRoman", Font.BOLD, 12));
		lblOwnerName.setBounds(25, 80, 200, 20);
		txtOwnerName = new JTextField();
		txtOwnerName.setFont(new Font("TimesRoman", Font.BOLD, 12));
		txtOwnerName.setBounds(200, 80, 150, 20);
		txtOwnerName.addKeyListener(this);

		lblDate = new JLabel("Date :");
		lblDate.setBounds(430, 25, 80, 20);
		lblDate.setFont(new Font("TimesRoman", Font.BOLD, 14));
		txtDate = new JTextField();
		txtDate.setFont(new Font("TimesRoman", Font.BOLD, 14));
		txtDate.setBounds(480, 25, 100, 20);
		txtDate.setEnabled(false);
		txtDate.setText(currentDate);

		lblOwnerAge = new JLabel("Age :");
		lblOwnerAge.setFont(new Font("TimesRoman", Font.BOLD, 12));
		lblOwnerAge.setBounds(25, 110, 200, 20);
		txtOwnerAge = new JTextField();
		txtOwnerAge.setFont(new Font("TimesRoman", Font.BOLD, 12));
		txtOwnerAge.setBounds(200, 110, 80, 20);
		txtOwnerAge.addKeyListener(this);

		lblOwnerNRC = new JLabel("NRC No : ");
		lblOwnerNRC.setFont(new Font("TimesRoman", Font.BOLD, 12));
		lblOwnerNRC.setBounds(25, 140, 200, 20);
		txtOwnerNRC = new JTextField();
		txtOwnerNRC.setFont(new Font("TimesRoman", Font.BOLD, 12));
		txtOwnerNRC.setBounds(200, 140, 150, 20);
		txtOwnerNRC.addKeyListener(this);

		lblOwnerJob = new JLabel("Occupation :");
		lblOwnerJob.setFont(new Font("TimesRoman", Font.BOLD, 12));
		lblOwnerJob.setBounds(25, 170, 200, 20);
		txtOwnerJob = new JTextField();
		txtOwnerJob.setFont(new Font("TimesRoman", Font.BOLD, 12));
		txtOwnerJob.setBounds(200, 170, 250, 20);
		txtOwnerJob.addKeyListener(this);

		lblOwnerAddr = new JLabel("Address :");
		lblOwnerAddr.setFont(new Font("TimesRoman", Font.BOLD, 12));
		lblOwnerAddr.setBounds(25, 200, 200, 20);
		txtOwnerAddr = new JTextField();
		txtOwnerAddr.setFont(new Font("TimesRoman", Font.BOLD, 12));
		txtOwnerAddr.setBounds(200, 200, 380, 20);
		txtOwnerAddr.addKeyListener(this);

		lblAmt = new JLabel("Amount :");
		lblAmt.setFont(new Font("TimesRoman", Font.BOLD, 12));
		lblAmt.setBounds(25, 230, 200, 20);
		txtAmt = new JTextField();
		txtAmt.setFont(new Font("TimesRoman", Font.BOLD, 12));
		txtAmt.setBounds(200, 230, 80, 20);
		txtAmt.addKeyListener(this);

		lblPanel.add(lblEmpHead);
		lblPanel.add(lblLine);
		lblPanel.add(lblPhNo);
		lblPanel.add(txtPhNo);
		lblPanel.add(lblOwnerName);
		lblPanel.add(txtOwnerName);
		lblPanel.add(lblAmt);
		lblPanel.add(txtAmt);
		lblPanel.add(lblDate);
		lblPanel.add(txtDate);
		lblPanel.add(lblOwnerAge);
		lblPanel.add(txtOwnerAge);
		lblPanel.add(lblOwnerJob);
		lblPanel.add(txtOwnerJob);
		lblPanel.add(lblOwnerAddr);
		lblPanel.add(txtOwnerAddr);
		lblPanel.add(lblOwnerNRC);
		lblPanel.add(txtOwnerNRC);

		// Button Panel
		btnPanel = new JPanel();
		btnPanel.setLayout(null);

		cmdSave = new JButton("Save");
		cmdSave.setMnemonic('S');
		cmdSave.setFont(new Font("TimesRoman", Font.BOLD, 12));
		cmdSave.setBounds(25, 10, 80, 25);
		cmdSave.addActionListener(this);

		cmdFind = new JButton("Find by contact #");
		cmdFind.setMnemonic('F');
		cmdFind.setFont(new Font("TimesRoman", Font.BOLD, 12));
		cmdFind.setBounds(125, 10, 140, 25);
		cmdFind.addActionListener(this);

		cmdUpdate = new JButton("Update");
		cmdUpdate.setMnemonic('u');
		cmdUpdate.setFont(new Font("TimesRoman", Font.BOLD, 12));
		cmdUpdate.setBounds(294, 10, 80, 25);
		cmdUpdate.addActionListener(this);

		cmdDelete = new JButton("Delete");
		cmdDelete.setMnemonic('D');
		cmdDelete.setFont(new Font("TimesRoman", Font.BOLD, 12));
		cmdDelete.setBounds(404, 10, 80, 25);
		cmdDelete.addActionListener(this);

		cmdClear = new JButton("Clear");
		cmdClear.setMnemonic('C');
		cmdClear.setFont(new Font("TimesRoman", Font.BOLD, 12));
		cmdClear.setBounds(510, 10, 80, 25);
		cmdClear.addActionListener(this);

		btnPanel.add(cmdUpdate);
		btnPanel.add(cmdClear);
		btnPanel.add(cmdSave);
		btnPanel.add(cmdFind);
		btnPanel.add(cmdDelete);

		mainPanel.add(lblPanel);
		lblPanel.setBounds(0, 0, 600, 300);
		mainPanel.add(btnPanel);
		btnPanel.setBounds(0, 300, 600, 110);

		getContentPane().add(mainPanel);
		cmdUpdate.setEnabled(false);
		cmdDelete.setEnabled(false);
	}

	public void keyReleased(KeyEvent evt) {
	}

	public void keyTyped(KeyEvent evt) {
	}

	public void keyPressed(KeyEvent evt) {
		Object obj = evt.getSource();
		int key = evt.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			if (obj == txtPhNo) {
				txtOwnerName.requestFocus();
				BlankCheck(txtPhNo);
			}
			if (obj == txtOwnerName) {
				txtOwnerAge.requestFocus();
				BlankCheck(txtOwnerName);
			}
			if (obj == txtOwnerAge) {
				txtOwnerNRC.requestFocus();
				BlankCheck(txtOwnerAge);
			}
			if (obj == txtOwnerNRC) {
				txtOwnerJob.requestFocus();
				BlankCheck(txtOwnerNRC);
			}
			if (obj == txtOwnerJob) {
				txtOwnerAddr.requestFocus();
				BlankCheck(txtOwnerJob);
			}
			if (obj == txtOwnerAddr) {
				txtAmt.requestFocus();
				BlankCheck(txtOwnerAddr);
			}
			if (obj == txtAmt) {
				cmdSave.requestFocus();
				BlankCheck(txtAmt);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		Conn = new Connect();
		Phone phone = new Phone();

		Object obj = e.getSource();
		if (obj == cmdClear) {
			Clear();
		}
		if (obj == cmdSave) {
			setPhone();
			PhoneDAO.Save(Conn.getConnection(), ph);
			Clear();
		}
		if (obj == cmdFind) {
			setPhone();
			phone = PhoneDAO.GetPhone(Conn.getConnection(), ph);
			if (phone.getOwner() == null || phone.getOwner().equals("")) {
				JOptionPane.showMessageDialog(null, "Your Phone No is not available..");
				txtPhNo.setText("");
			} else {
				txtPhNo.setText(phone.getNo());
				txtOwnerName.setText(phone.getOwner());
				txtAmt.setText(phone.getAmt());
				txtDate.setText(phone.getDate());
				txtOwnerAge.setText(phone.getAge());
				txtOwnerNRC.setText(phone.getNrc());
				txtOwnerJob.setText(phone.getJob());
				txtOwnerAddr.setText(phone.getAddr());
			}
			cmdSave.setEnabled(false);
			cmdUpdate.setEnabled(true);
			cmdDelete.setEnabled(true);
		}
		if (obj == cmdDelete) {
			setPhone();
			PhoneDAO.Delete(Conn.getConnection(), ph);
			Clear();
			cmdSave.setEnabled(true);
			cmdUpdate.setEnabled(false);
			cmdDelete.setEnabled(false);
		}
		if (obj == cmdUpdate) {
			setPhone();
			PhoneDAO.Update(Conn.getConnection(), ph);
			Clear();
			cmdSave.setEnabled(true);
			cmdUpdate.setEnabled(false);
			cmdDelete.setEnabled(false);
		}
	}

	public void Clear() {
		txtPhNo.setText("");
		txtOwnerName.setText("");
		txtAmt.setText("");
		txtOwnerJob.setText("");
		txtOwnerAddr.setText("");
		txtOwnerAge.setText("");
		txtOwnerNRC.setText("");
	}

	public void BlankCheck(JTextField txt) {
		if (txt.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "You Must Enter The Text  Box");
			txt.requestFocus();
		}
	}

	// Set Phone Information
	public void setPhone() {
		ph = new Phone();
		ph.setNo(txtPhNo.getText().trim());
		ph.setOwner(txtOwnerName.getText().trim());
		ph.setAge(txtOwnerAge.getText().trim());
		ph.setNrc(txtOwnerNRC.getText().trim());
		ph.setJob(txtOwnerJob.getText().trim());
		ph.setAddr(txtOwnerAddr.getText().trim());
		ph.setAmt(txtAmt.getText().trim());
		ph.setDate(txtDate.getText().trim());
	}

	// Main Function
	public static void main(String[] args) {
		PhoneForm frmForm = new PhoneForm();
		center = new Center(frmForm, 600, 400);
		frmForm.setVisible(true);
		frmForm.setResizable(false);
		frmForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}