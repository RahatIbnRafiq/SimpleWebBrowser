
 import javax.swing.text.html.*;
 import javax.swing.text.html.parser.*;
 import java.io.*;
 import java.net.*;
 import javax.swing.text.html.HTML.*;
 import javax.swing.text.*;
 import javax.swing.JTextArea;
 import javax.swing.JPanel;
 import java.awt.Graphics;
 import java.util.*;
 import java.awt.Color;
 import java.awt.Toolkit;
 import java.net.*;
 import java.awt.Image;
  
class Data {
    char []s1;
    int x;
    int y;
    int style;
    String color;
    int fontSize;
    String fontname;
    Image picture;
    String hyper_link;
  
    
    Data(char []s, int x1, int y1, int sTyle)
    {
       
        s1= new char[s.length];
        System.arraycopy(s, 0, s1, 0,s.length);
     
        x = x1;
        y = y1;
        style = sTyle;
    }
    //Data(char []s, int x1, int y1, int FONTSize, String font, int sTyle, String att_color) {    // STYLE  bold = 3 italic= 2 plain=1 link=4 bgcolor=5 title=6
   Data(char []s, int x1, int y1, int FONTSize, String font, int sTyle) {
      
        s1= new char[s.length];
        System.arraycopy(s, 0, s1, 0,s.length);
        fontname = font;
        style = sTyle;
        fontSize = FONTSize;
      
        x = x1;
        y = y1;
    } 
   Data(char []s, int x1, int y1, int FONTSize, String font, String cr, int sTyle) {
       
        s1= new char[s.length];
        System.arraycopy(s, 0, s1, 0,s.length);
        fontname = font;
        style = sTyle;
        fontSize = FONTSize;
        color = cr;
        
        x = x1;
        y = y1;
    } 
   Data(char []s, int x1, int y1, int FONTSize, String font, int sTyle, String hlink) {
        
        s1= new char[s.length];
        System.arraycopy(s, 0, s1, 0,s.length);
        fontname = font;
        style = sTyle;
        fontSize = FONTSize;
        hyper_link = hlink;
    
        x = x1;
        y = y1;
    } 
   Data (Image pic, int x1, int y1, int sTyle)
   {
        picture = pic;
        x = x1;
        y = y1;
        style = sTyle;
   }
   Data (char []s, int sTyle )
   {
       style = sTyle;
        s1= new char[s.length];
       System.arraycopy(s, 0, s1, 0,s.length);
   }
}
  
public class TagStripper extends HTMLEditorKit.ParserCallback {

    Graphics graphics;
    ArrayList<Data> al;        // our main array list 
    drawingPanel dp; 
    int x1=10;
    int y1=30;
    char ln[] = {'\r','\n'};
    int newLevel = 0;
    int att_color=0;
    Image picture;
    int href=0;
    int p=0;
    int support=0;
    int br=0;
    String hlink;
    
    int width;
    int f=0;
    String fontName;
    String color;
    int t=0;
    
    public TagStripper(drawingPanel d )
    {
         al = new ArrayList<Data>();       // here i'm newing array list.....
         dp = d;
         fontName = "Arial";
         color = "#000000";
       
    }  
        
    public void handleStartTag(HTML.Tag tag,MutableAttributeSet attributes, int position){
        
         if (tag == HTML.Tag.TITLE)
         {
             t=1;
         }
        else if (tag == HTML.Tag.H1)
        {
            newLevel = 1;
            this.parsingAttributes(attributes); 
          
        }
        else if (tag == HTML.Tag.H2) 
        {
            newLevel = 2;
            this.parsingAttributes(attributes); 
        }
        else if (tag == HTML.Tag.H3) 
        {
            newLevel = 3;
            this.parsingAttributes(attributes); 
        }
        else if (tag == HTML.Tag.H4) 
        {
            newLevel = 4;
            this.parsingAttributes(attributes); 
        }
        else if (tag == HTML.Tag.H5) 
        {
            newLevel = 5;
            this.parsingAttributes(attributes); 
        }
        else if (tag == HTML.Tag.H6) 
        {
            newLevel = 6;
            this.parsingAttributes(attributes); 
        }
       
        else if(tag == HTML.Tag.A)
        {
            this.parsingAttributes(attributes);     
        } 
       
        else if( tag == HTML.Tag.P) 
        {
            p=1;
     
            this.parsingAttributes(attributes);
        } 
        else if(tag == HTML.Tag.FONT)
        {
            f = 1;
            this.parsingAttributes(attributes);
        }
       
        
    }
 	
    public void handleText(char[]text,int position){

        
         if(t == 1)
         {
             al.add(new Data(text,6));
             t=0;
         }
         if(newLevel == 1)   // H1
         {
            
            al.add(new Data(text,x1,y1,22,"Arial",3));
            y1 = y1+30;
            x1=10;    // for making normal
            newLevel = 0;
         }
         else if(newLevel == 2)   // H2
         {
           
            al.add(new Data(text,x1,y1,20,"Arial",3));
             y1 = y1+30;
            newLevel = 0;
         }
         else if(newLevel == 3)   // H3
         {
          
            al.add(new Data(text,x1,y1,18,"Arial",3));
              y1 = y1+30;
            newLevel = 0;
         }
         else if(newLevel == 4)   // H4
         {
            y1 = y1+30;
            al.add(new Data(text,x1,y1,16,"Arial",3));
            newLevel = 0;
         }
         else if(newLevel == 5)   // H5
         {
             y1 = y1+30;
             al.add(new Data(text,x1,y1,14,"Arial",3));
             newLevel = 0;
         }
         else if(newLevel == 6)   // H2
         {
            y1 = y1+30;
            al.add(new Data(text,x1,y1,12,"Arial",3));
            newLevel = 0;
         }
         
         else if(href == 1)
         {
             al.add(new Data(text,x1,y1,14,"Arial",4,hlink));
             y1 = y1+20;
             //x1=10;
             href = 0;
                  
         }
        else if(p==1)
         {
             
            al.add(new Data(text,x1,y1,14,fontName,color,1));
            y1 = y1+20;
            p = 0;
         } 
         else if(br==1)
         {
            
             al.add(new Data(text,x1,y1,14,fontName,color, 1));
             y1 = y1+20;
         }
       
    }
    public void handleEndTag(HTML.Tag tag,int position)
    {
        if (tag == HTML.Tag.HTML)        // our this if() calls JPanels paint component's data
        {
            
             dp.set(al);
        }
        else if(tag == HTML.Tag.P)
        {
            y1 = y1 + 10;
            x1 = 10;
            fontName="Arial";
        }
        else if(tag == HTML.Tag.FONT)
        {
           f = 0;
           fontName = "Arial";
            
        }
       

    }
	
    public void handleSimpleTag(HTML.Tag tag,MutableAttributeSet attributes,int position){
        if(tag == HTML.Tag.IMG)
        {
            
            this.parsingAttributes(attributes);
        }
        else if(tag == HTML.Tag.BR)
        {
            br=1;
            p=0;
        } 
        

    }
    private void parsingAttributes(AttributeSet attributes) {
        
        Image im;
        int height=0;
        int flag = 0;
        int img=0;
      
        
        Enumeration e = attributes.getAttributeNames( );
        
        while(e.hasMoreElements( )) {
            
            Object name = e.nextElement( );
     
            String value = (String) attributes.getAttribute(name);             
          
            if( name == HTML.Attribute.BGCOLOR)
            {
                
            } 
            else if( name == HTML.Attribute.COLOR)
            {
                System.out.println("color: "+value);
               
                color = value;
            }
            else if(name == HTML.Attribute.SRC)
            {
                             
                System.out.println("in SRC= "+ value);
                
                try {
                    
                    URL val = new URL(value);
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    picture = toolkit.getImage(val);
                    im = picture;
                    img = 1;
               
		}
		catch (MalformedURLException malUrl) {
                    System.err.println(malUrl);
		
		}
               
            } 
            else if(name == HTML.Attribute.HEIGHT)
            {
                height = Integer.parseInt(value);
                flag = 1;
                
            }
            else if(name == HTML.Attribute.WIDTH)
            {
               
                width = Integer.parseInt(value);
                
   
                
            }
            else if(name == HTML.Attribute.ALIGN)
            {
                
                if(value.equals("center"))
                {
                  
                    if(newLevel == 1)
                    {
                        x1=x1+300;
                    }
                    else if(p == 1)
                    {
                        x1 = x1 + 100;
                    }
                    else if(img == 1)
                    {
                        x1=x1+100;
                    }
                   
                }
                else if(value.equals("right"))
                {
                    x1=x1+500;
                }
                
            }
            else if( name == HTML.Attribute.BACKGROUND )
            {
                //System.out.println(" bacgrounddddddddd");
               // href = 1;
            }
            else if( name == HTML.Attribute.HREF )
            {
               
                hlink = value;
                
                href = 1;
            }
             else if( name == HTML.Attribute.FACE)
            {
                 fontName = value;
            }
             
           
        }
        im = picture;
        if(flag == 1)
            {
                al.add(new Data(im,x1,y1,0));
             
                y1 = y1+ 20 + height;
     
                flag = 0;
                x1 = 10;
                img=0;
            }
        
    }
 
}
