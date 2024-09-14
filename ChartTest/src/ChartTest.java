import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChartTest extends JFrame{	
	class MyPanel extends JPanel{
		// panel을 그려주는 메서드
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.green);	//색상설정
			//막대그래프
			int height=20;	//막대높이
			int vGap=5; 	//첫번째와 두번째 막대의 여백
			int x=150;		//좌표
			int y=20;		//좌표
			g.fillRect(x, y, 100, height);//1/4분기	//100은 가로사이즈	//height는 높이
			g.fillRect(x, y+height+vGap, 150, height);//2/4분기
			g.fillRect(x, y+(height+vGap)*2, 200, height);//3/4분기
			g.fillRect(x, y+(height+vGap)*3, 300, height);//4/4분기
			
			g.drawString("1/4분기", x-50, y+15);
			g.drawString("2/4분기", x-50, y+15+height+vGap);
			g.drawString("3/4분기", x-50, y+15+(height+vGap)*2);
			g.drawString("4/4분기", x-50, y+15+(height+vGap)*3);
			
			//꺾은선그래프
			int hGap=50;	//가로 간격
			g.drawLine(x, 400, x+hGap, 400-100);	//y좌표는 아래로 갈수록 값이 크다. 즉, 위로 가고 싶으면 빼줘야 함
			g.drawLine(x+hGap, 400-100, x+hGap+hGap, 400-150); //위의 끝점(4번째)과 얘의 y좌표 시작점(2번째)는 같아야 함.
			g.drawLine(x+2*hGap, 400-150, x+hGap+hGap+hGap, 400-220);
			g.drawLine(x+hGap+hGap+hGap, 400-220, x+hGap+hGap+hGap+hGap, 400-50);
			
			//파이차트
			g.setColor(Color.RED);
			g.fillArc(x, 400, 300, 300, 0, 45);	//얘의 6번째값 = 아래의 5번째 값
			g.setColor(Color.GREEN);
			g.fillArc(x, 400, 300, 300, 45, 70);
			g.setColor(Color.BLUE);
			g.fillArc(x, 400, 300, 300, 115, 90);
			g.setColor(Color.ORANGE);
			g.fillArc(x, 400, 300, 300, 205, 155); //얘의 6번째값은 360-(위의 모든 각도)
			
		}		
	}	
	public ChartTest() {
		this.setTitle("챠트연습");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel p=new MyPanel();
		p.setBackground(Color.WHITE);
		this.setContentPane(p);
		
		this.setSize(800, 800);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new ChartTest();
	}
}
