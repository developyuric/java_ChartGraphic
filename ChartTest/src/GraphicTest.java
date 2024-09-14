//07/02/24


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicTest extends JFrame{ //JFrame 의 상속을 받음
	// inner class. JPanel을 상속받음
	class MyPanel extends JPanel{
		// 컴포넌트를 그리는 메서드. panel이 생성되거나, 크기가 변경되거나 할 때 자동으로 호출됨. callback임. 자동으로 호출됨
		@Override    //MyPanel 에 커서 두고 source ->override/methods 를 선택
		public void paintComponent(Graphics g) {			
			super.paintComponent(g); //부모클래스의 paintComponent호출
			
			g.setColor(Color.RED); // 색설정			
			g.drawLine(10, 10, 110, 110); //직선   //tab을 누르면 다음 값으로 옮겨감. 왼쪽상단이 시작점(0,0).(시작점x, 시작점y, 끝점x, 끝점y) 
//			g.drawOval(10, 120, 200, 100); //원	//(x,y,가로,세로) 가로=세로 면 반듯한 원이 그려짐.
//			g.drawRect(10, 230, 100, 100); 	//사각형
//			g.drawRoundRect(10, 350, 100, 100, 50, 50); //(x,y,가로,세로,모서리둥글게하는정도,모서리둥글게하는정도) 모서리에 사각형이 있다고 생각하고 원을 그리는 정도
//			g.drawArc(10, 470, 100, 200, 0, 90);   //원호(원의 일부) (x,y,가로,세로,시작각도 오른쪽 가로반지름이 기준. 반시계방향, 이어지는 정도 각도)
//			g.drawString("그래픽스", 10, 600); //문자열을 그림(문자열,문자열,좌표) ->주의!! 얘는 왼쪽 하단이 기준임
		
			
			//fill로 하면 색갈이 다 채워짐
			g.fillOval(10, 120, 200, 100);//원
			g.fillRect(10, 230, 100, 100);//사각형
			g.fillRoundRect(10, 350, 100, 100, 50, 50);//사각형
			g.fillArc(10, 470, 100, 100, 0, 90);//원호
			g.drawString("그래픽스", 10, 600);
		}
		
	}
	
//	//생성자
//	public GraphicTest() {
////		this.setTitle("그래픽연습");  	//this를 굳이 안써도 되지만 쓰면 여러 값들이 나와서 코딩하기 편함
////		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
/////*밑에표시*/this.setSize(800,800);
////		this.setVisible(true);
////위 4줄은 늘 코딩을 하는거임!!!	
	
	public GraphicTest(){
		this.setTitle("그래픽연습"); //this를 굳이 안써도 되지만 쓰면 여러 값들이 나와서 코딩하기 편함
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(new MyPanel()); // panel을 화면에 꽉차게 배치 //panel을 화면에 꽉차게 배치됨 //실행하면 panel을 추가하기 전과 같음. 투명 유리판과 같음
		
/*밑에표시*/this.setSize(800, 800);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new GraphicTest();

	}

}
