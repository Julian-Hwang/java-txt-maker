package javatxtmaker;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Makingtextfield extends JFrame{
	private final static String newline = "\n"; //newline�� �ٹٲٱ� �����̴�.
	public Makingtextfield() {
		
		JFrame frame = new JFrame("�ؽ�Ʈ�ʵ� �����");
		frame.setSize(300, 400); // ���α׷� ������ ��ü ũ��
		
		TextField textField = new TextField("", 24); // ��ܿ� textfield�� �����ϰ� 24������ ũ��� ����
		textField.setText(""); // setText�� �����ؼ� textfield�� �ʱⰪ 
		
		TextArea textArea = new TextArea(""); // textarea�����ϱ�
		
		JButton making = new JButton("����"); //������ư ����
		making.addActionListener(new ActionListener() { //������ư ���α׷� �����
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText(); //textfield�� ���� ��������
				textArea.append(text+newline); //textfield�� �ִ� ���ڸ� textarea�� ������ �� �ٲٱ�(newline)
				textField.setText(""); //textfield���ڸ� textarea�� �ű� �� textfield�� ����(������ �ϰ� ���ڰ� ����� �Ѵ�.)
			}
		});
		JPanel jp = new JPanel(); //�г� ����
		
		FlowLayout fl = new FlowLayout(30); //flowlayout�� �����ؼ� ������Ʈ�� ũ�⸦ �����Ѵ�.
		jp.setLayout(fl);
		
		jp.add(textField); //�гο� textfield�� making�� �����Ѵ�.
		jp.add(making);
		
		JButton insert = new JButton("����"); //���Թ�ư�� �����Ѵ�.
		insert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File file = new File("C:\\Users\\g_Luna\\Desktop\\text1.txt"); //������ ��η� ������ �����Ѵ�.
				FileWriter fw = null; //FileWriter�� �����ؼ� ������ �����Ѵ�.
				String text = textArea.getText(); //textArea���� ���ڸ� ������ �´�.
				try {
					fw = new FileWriter(file,true); //FileWriter�� �����ϰ� file������ ������ �´�. 
                                                    //true�� �����ؼ� ���� text1.txt���Ͽ� ���ڸ� �߰��� �� �ִ�.
					fw.write(text); //���� text�� �ִ� ������ �ۼ��Ѵ�.
					fw.flush(); //���ۿ� �����ϰ� �ִ� ������ Ŭ���̾�Ʈ�� �����Ѵ�.
					
					System.out.println("Completed"); // �����ϸ� Completed�� ����Ѵ�.
				} catch (IOException e1) {
					e1.printStackTrace(); // ���н� �����޽����� ����Ѵ�.
				} 
			}
		});
		
		jp.add(textField);
		jp.add(making);
		
		frame.add(jp, BorderLayout.NORTH); //textfield�� making�� �ִ� �г��� �������� �����Ѵ�.
		frame.add(textArea, BorderLayout.CENTER); //textArea�� �߰��� �����Ѵ�.
		frame.add(insert, BorderLayout.SOUTH); //insert�� �Ʒ��ʿ� �����Ѵ�.
		
		frame.setVisible(true); //�������� �ð�ȭ�Ѵ�.
	}
	
	public static void main(String[] args) {
		Makingtextfield mtf = new Makingtextfield();
	}

}