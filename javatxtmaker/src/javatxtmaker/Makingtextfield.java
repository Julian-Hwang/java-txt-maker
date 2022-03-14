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
	private final static String newline = "\n"; //newline은 줄바꾸기 변수이다.
	public Makingtextfield() {
		
		JFrame frame = new JFrame("텍스트필드 만들기");
		frame.setSize(300, 400); // 프로그램 프레임 전체 크기
		
		TextField textField = new TextField("", 24); // 상단에 textfield를 선언하고 24정도의 크기로 생성
		textField.setText(""); // setText를 선언해서 textfield의 초기값 
		
		TextArea textArea = new TextArea(""); // textarea선언하기
		
		JButton making = new JButton("생성"); //생성버튼 선언
		making.addActionListener(new ActionListener() { //생성버튼 프로그램 만들기
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText(); //textfield의 문자 가져오기
				textArea.append(text+newline); //textfield에 있는 문자를 textarea로 보내고 줄 바꾸기(newline)
				textField.setText(""); //textfield문자를 textarea로 옮긴 후 textfield의 상태(생성을 하고 문자가 없어야 한다.)
			}
		});
		JPanel jp = new JPanel(); //패널 선언
		
		FlowLayout fl = new FlowLayout(30); //flowlayout을 선언해서 컴포넌트의 크기를 조정한다.
		jp.setLayout(fl);
		
		jp.add(textField); //패널에 textfield와 making을 선언한다.
		jp.add(making);
		
		JButton insert = new JButton("삽입"); //삽입버튼을 선언한다.
		insert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File file = new File("C:\\Users\\g_Luna\\Desktop\\text1.txt"); //선언한 경로로 파일을 생성한다.
				FileWriter fw = null; //FileWriter을 선언해서 파일을 선언한다.
				String text = textArea.getText(); //textArea에서 문자를 가지고 온다.
				try {
					fw = new FileWriter(file,true); //FileWriter을 선언하고 file변수를 가지고 온다. 
                                                    //true를 생성해서 기존 text1.txt파일에 문자를 추가할 수 있다.
					fw.write(text); //변수 text에 있는 내용을 작성한다.
					fw.flush(); //버퍼에 저장하고 있는 내용을 클라이언트로 전송한다.
					
					System.out.println("Completed"); // 성공하면 Completed를 출력한다.
				} catch (IOException e1) {
					e1.printStackTrace(); // 실패시 에러메시지를 출력한다.
				} 
			}
		});
		
		jp.add(textField);
		jp.add(making);
		
		frame.add(jp, BorderLayout.NORTH); //textfield와 making이 있는 패널을 위쪽으로 배정한다.
		frame.add(textArea, BorderLayout.CENTER); //textArea를 중간에 배정한다.
		frame.add(insert, BorderLayout.SOUTH); //insert를 아래쪽에 배정한다.
		
		frame.setVisible(true); //프레임을 시각화한다.
	}
	
	public static void main(String[] args) {
		Makingtextfield mtf = new Makingtextfield();
	}

}