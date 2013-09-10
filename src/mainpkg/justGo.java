package mainpkg;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class justGo extends Applet{
    
    private Canvas screen = new Canvas();//������� ��� ���������

       // ������ �������������� ������
    private CheckboxGroup group = new CheckboxGroup();
    private Checkbox
          // ������� �������������
       r = new Checkbox("�������",group,true),
          // ������� �������������
       g = new Checkbox("�������",group,false),
          // ����� �������������
       b = new Checkbox("�����",group,false);

       // ������ ������� ������� ���������
    private Button clear = new Button("��������");  
    
    /**
    * � ��� ������ ���������� ������������� �������.
    */
    public void init() {
       // ��������� ���������� �������
       setBackground(Color.lightGray);  
       // ��������� �����������
       screen.setSize(300,200);
       screen.setBackground(Color.white);
       r.setForeground(Color.red);
       g.setForeground(Color.green);
       b.setForeground(Color.blue);
       clear.addActionListener(new buttonListener());
       screen.addMouseMotionListener(new scrListener());
       // ���������� ����������� �� ������� �������
       add(r);
       add(g);
       add(b);
       add(screen);
       add(clear);
    }
       // ���������� ��������� ������� ��������
    private class buttonListener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
          screen.repaint();
       }
    }
       // ���������� ��������� ������� ��������������
          //� ����������� ����
    private class scrListener implements MouseMotionListener {
       public void mouseDragged(MouseEvent e) {
          Graphics gr = screen.getGraphics();
          if (group.getSelectedCheckbox()==r)
             gr.setColor(Color.red);
          else if (group.getSelectedCheckbox()==g)
             gr.setColor(Color.green);
          else 
             gr.setColor(Color.blue);
          gr.fillOval(e.getX(),e.getY(),3,3);
       }
       public void mouseMoved(MouseEvent e) {
       }
    }
}
