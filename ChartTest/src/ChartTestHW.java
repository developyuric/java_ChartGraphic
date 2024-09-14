//070224HW #2 & #3 
//2. 꺾은선 그래프에서 x축,y축 표시하기
//3. 분기별 매출액으로 파이차트 그리기 => 분기별 매출액 백분율을 구한 다음 각도로 환산해서 구현
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChartTestHW extends JFrame{	
	class MyPanel extends JPanel{
		// panel을 그려주는 메서드
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
						
			//꺾은선그래프--------------------------------------------------------
			int hGap=50;	//가로 간격
			int x=150;		//좌표
			int y=300;		//좌표
			g.setColor(Color.black);	//색상설정
			
			g.drawLine(x, y, x+5*hGap, y); //x축
			g.drawLine(x+5*hGap, y, x+5*hGap-10, y+10); 
			g.drawLine(x+5*hGap, y, x+5*hGap-10, y-10); 
			g.drawString("Quarterly", x+5*hGap-15, y+30); 			
			
			g.drawLine(x, y-250, x, y); //y축
			g.drawLine(x, y-250, x-10, y-250+10); 
			g.drawLine(x, y-250, x+10, y-250+10); 
			g.drawString("Profit", x-50, y-250+10);			
			
			g.drawLine(x, y, x+hGap, y-100);	
			g.drawLine(x+hGap, y-100, x+hGap+hGap, y-150); 
			g.drawLine(x+2*hGap, y-150, x+hGap+hGap+hGap, y-220);
			g.drawLine(x+hGap+hGap+hGap, y-220, x+hGap+hGap+hGap+hGap, y-50);
			
			g.setColor(Color.blue);
			g.fillOval(x+hGap-3, y-100-3, 6, 6);
			g.setColor(Color.black);
			g.drawString("7 Billion", x+hGap , y-100+20);
			
			g.setColor(Color.green);
			g.fillOval(x+2*hGap-3, y-150-3, 6, 6);
			g.setColor(Color.black);
			g.drawString("10 Billion", x+2*hGap , y-150+20);
			
			g.setColor(Color.orange);
			g.fillOval(x+3*hGap-3, y-220-3, 6, 6);
			g.setColor(Color.black);
			g.drawString("15 Billion", x+3*hGap , y-220-10);
			
			g.setColor(Color.RED);
			g.fillOval(x+4*hGap-3, y-50-3, 6, 6);
			g.setColor(Color.black);
			g.drawString("4 Billion", x+4*hGap +5 , y-50-10);
			
			
			//파이차트------------------------------------------------------------------
			
			double percentage1=70;
			double percentage2=100;
			double percentage3=150;
			double percentage4=40;
			double sum=percentage1+percentage2+percentage3+percentage4;
			
			double P1 = (percentage1/sum)*100;
			double P2 = (percentage2/sum)*100;
			double P3 = (percentage3/sum)*100;
			double P4 = (percentage4/sum)*100;
			
			String formattedP1 = String.format("%.2f", P1);
			String formattedP2 = String.format("%.2f", P2);
			String formattedP3 = String.format("%.2f", P3);
			String formattedP4 = String.format("%.2f", P4);
			
			double angle1=360*P1/100;
			double angle2=360*P2/100;
			double angle3=360*P3/100;
			double angle4=360*P4/100;
			
			String formattedA1 = String.format("%.2f", angle1);
			String formattedA2 = String.format("%.2f", angle2);
			String formattedA3 = String.format("%.2f", angle3);
			String formattedA4 = String.format("%.2f", angle4);
						
			//---------------------------------------------
			g.setColor(Color.blue);
			g.fillArc(x, y+100, 300, 300, 0, (int)percentage1);
			g.setColor(Color.white);
			g.drawString(formattedA1+"˚", x+230, y+190);	
			g.drawString(formattedP1+"%", x+230, y+210);
			
					
			g.setColor(Color.GREEN);
			g.fillArc(x, y+100, 300, 300, (int)percentage1, (int)percentage2);
			g.setColor(Color.white);
			g.drawString(formattedA2+"˚", x+70, y+190);
			g.drawString(formattedP2+"%", x+70, y+210);

			
			g.setColor(Color.orange);
			g.fillArc(x, y+100, 300, 300, (int)percentage1+(int)percentage2, (int)percentage3);
			g.setColor(Color.white);
			g.drawString(formattedA3+"˚", x+70, y+300);			
			g.drawString(formattedP3+"%", x+70, y+320);			
		
			g.setColor(Color.red);
			g.fillArc(x, y+100, 300, 300, (int)sum-(int)percentage4, (int)percentage4);
			g.setColor(Color.white);
			g.drawString(formattedA4+"˚", x+230, y+280);
			g.drawString(formattedP4+"%", x+230, y+300);
			
			//---------------------------------------------			
			g.setColor(Color.blue);
			g.fillRect(x+400, y+150, 10, 10);
			g.drawString("1st Quarter", x+420, y+160);
			g.setColor(Color.black);
			g.drawString(formattedP1+"%", x+500, y+160);
			
			
			g.setColor(Color.green);
			g.fillRect(x+400, y+170, 10, 10);
			g.drawString("2nd Quarter", x+420, y+180);
			g.setColor(Color.black);
			g.drawString(formattedP2+"%", x+500, y+180);

			g.setColor(Color.orange);
			g.fillRect(x+400, y+190, 10, 10);
			g.drawString("3rd Quarter", x+420, y+200);
			g.setColor(Color.black);
			g.drawString(formattedP3+"%", x+500, y+200);

			g.setColor(Color.red);
			g.fillRect(x+400, y+210, 10, 10);
			g.drawString("4th Quarter", x+420, y+220);
			g.setColor(Color.black);
			g.drawString(formattedP4+"%", x+500, y+220);
		}		
	}	
	public ChartTestHW() {
		this.setTitle("ChartTest");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel p=new MyPanel();
		p.setBackground(Color.WHITE);
		this.setContentPane(p);
		
		this.setSize(800, 800);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new ChartTestHW();
	}
}
