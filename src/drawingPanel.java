
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.util.*;
import java.awt.*;
import java.text.AttributedString;
import java.awt.font.TextAttribute;

public class drawingPanel extends JPanel {
    ArrayList AL;
    int flag=0;
    drawingPanel()
    {
         repaint();
    }
    void set( ArrayList al)
    {
        flag=1;   // this enables paintComponent 
        AL = al;
        
        repaint();
    }
    ArrayList sendList()
    {
        return AL;
    }
     public void paintComponent( Graphics g )
      {
         int i;
         super.paintComponent( g ); // call superclass's paintComponent

         Graphics2D g2d = ( Graphics2D ) g; // cast g to Graphics2D
         g2d.setColor(Color.BLACK);
        
         
         if(flag==1)
         {
            for(i=0; i<AL.size(); i++)
            {
                Data mc=(Data)AL.get(i); 
                g2d.setColor(Color.BLACK);
                if(mc.style == 3)
                     g2d.setFont(new Font(mc.fontname,Font.BOLD,mc.fontSize));
                else if(mc.style == 2)
                    g2d.setFont(new Font(mc.fontname,Font.ITALIC,mc.fontSize));
                else if(mc.style == 1)
                {
                    
                    int a= intToHex(mc.color.charAt(1), mc.color.charAt(2));
                    int b=intToHex(mc.color.charAt(3),mc.color.charAt(4));
                    int c=intToHex(mc.color.charAt(5),mc.color.charAt(6));
                    Color cl =new Color(a,b,c);
                    g2d.setColor(cl);
                    g2d.setFont(new Font(mc.fontname,Font.PLAIN,mc.fontSize));
                
                }
                else if(mc.style == 4)  // 4 for A = anchor tag
                {
                     g2d.setColor(Color.BLUE);
                     g2d.setFont(new Font(mc.fontname,Font.PLAIN,mc.fontSize));
                     
                     AttributedString as = new AttributedString(new String(mc.s1));
              
                     as.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                
                     g2d.drawString(as.getIterator(), mc.x, mc.y);
                }
                else
   
                    g2d.setFont(new Font(mc.fontname,Font.PLAIN,12));
                
                if( mc.style != 4 && mc.style != 0 && mc.style!=6)
                {    
                   
                    g2d.drawString(new String(mc.s1), mc.x, mc.y);
             
                }
                g2d.drawImage(mc.picture,mc.x ,mc.y, this);  
                
            }
               
         }
     
      }  
     
     public int intToHex(char s,char t)
	{
		int sum=0;
		if(s=='1')sum+=1;
		else if(s=='2')sum+=2*16;
		else if(s=='3')sum+=3*16;
		else if(s=='4')sum+=4*16;
		else if(s=='5')sum+=5*16;
		else if(s=='6')sum+=6*16;
		else if(s=='7')sum+=7*16;
		else if(s=='8')sum+=8*16;
		else if(s=='9')sum+=9*16;
		else if(s=='A')sum+=10*16;
		else if(s=='B')sum+=11*16;
		else if(s=='C')sum+=12*16;
		else if(s=='D')sum+=13*16;
		else if(s=='E')sum+=14*16;
		else if(s=='F')sum+=15*16;
	
		if(t=='1')sum+=1;
		else if(t=='2')sum+=2;
		else if(t=='3')sum+=3;
		else if(t=='4')sum+=4;
		else if(t=='5')sum+=5;
		else if(t=='6')sum+=6;
		else if(t=='7')sum+=7;
		else if(t=='8')sum+=8;
		else if(t=='9')sum+=9;
		else if(t=='A')sum+=10;
		else if(t=='B')sum+=11;
		else if(t=='C')sum+=12;
		else if(t=='D')sum+=13;
		else if(t=='E')sum+=14;
		else if(t=='F')sum+=15;
	
	
		return sum;
	}
        
}