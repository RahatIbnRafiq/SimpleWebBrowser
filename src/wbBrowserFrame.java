
 import javax.swing.text.html.*;
 import javax.swing.text.html.parser.*;
 import java.io.*;
 import java.net.*;
 import javax.swing.text.html.HTML.*;
 import javax.swing.text.*;
 import javax.swing.JPanel;
 import java.util.*;
 import java.awt.event.MouseListener;
 import java.awt.event.MouseEvent;
 import java.awt.Cursor;
 import java.awt.event.MouseMotionListener;
 
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JComboBox;
 
 public class wbBrowserFrame extends javax.swing.JFrame {

    String s;
    ArrayList fAL;
    String title;
    int al_flag=0;
    String a[];    
    int index = 0;
    int flag2=0;    // for controlling mouse move 
    int search=0;
            
    public wbBrowserFrame(String st) {
       
        super(st);
        title = st;
    
        a = new String[10];
        initComponents();
        
    }
    
    public  static  class ParseGetter extends HTMLEditorKit {    // this is the other inner class
	 	public HTMLEditorKit.Parser getParser(){
	 		return super.getParser();
	 	}
    }   // parse getter ends
    
    
     private void initComponents() {
         
        searchField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
      
        d = new drawingPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        
        refresh = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        front = new javax.swing.JButton();
        back = new javax.swing.JButton();
       
        ExitMenu = new javax.swing.JMenuItem();
        aboutItem = new javax.swing.JMenuItem();
        
        jComboBox1 = new javax.swing.JComboBox();
        webSearch = new javax.swing.JTextField();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        okButton.setText("GO");
        okButton.setBorder(null);
        okButton.setBorderPainted(false);
        
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        
        
        
        /* refresh.setIcon(new javax.swing.ImageIcon("refresh.jpg")); // NOI18N

        stop.setIcon(new javax.swing.ImageIcon("stop.gif")); // NOI18N

        front.setIcon(new javax.swing.ImageIcon("front.gif")); // NOI18N

        back.setIcon(new javax.swing.ImageIcon("back.gif")); // NOI18N */
        
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.jpg"))); // NOI18N
        refresh.setBorderPainted(false);

        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stop.gif"))); // NOI18N
        stop.setBorderPainted(false);

        front.setIcon(new javax.swing.ImageIcon(getClass().getResource("/front.gif"))); // NOI18N
        front.setBorderPainted(false);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back.gif"))); // NOI18N
        back.setBorder(null);
        back.setBorderPainted(false);

        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        front.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frontActionPerformed(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        
         jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yahoo","wikipedia(en)", "AltaVista", "DMoz" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        webSearch.setText("search here!");
        webSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                webSearchMouseClicked(evt);
            }
        });
        webSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webSearchActionPerformed(evt);
            }
        });


       jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
       jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
       
       
        d.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(d);
     
        d.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2000, Short.MAX_VALUE)
        );      // 718, 581

 
        jScrollPane1.setViewportView(d);
   
       
        jMenu1.setText("File");
    
        ExitMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exit.gif"))); // NOI18N
        ExitMenu.setText("Exit");
        ExitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuActionPerformed(evt);
            }
        });
        jMenu1.add(ExitMenu);

        jMenuBar1.add(jMenu1);
        

        jMenu2.setText("Help");
        
        aboutItem.setText("About");
        aboutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutItemActionPerformed(evt);
            }
        });
        jMenu2.add(aboutItem);
        
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
         layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(front, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(webSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(back, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                        .addComponent(front, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                        .addComponent(stop, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                        .addComponent(refresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(webSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

      
        
        MouseHandler hand = new MouseHandler(); 
        d.addMouseListener(hand);
        
        
        pack();
    }
     
    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {   
        if(index > 0)
        {
            ++index;
        } 
        a[index]=searchField.getText();
        System.out.println("u typed "+a[index]);
        starting();
        load_arrayList();
        flag2 = 1;
    
    }   
    
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
        /*Cursor hg=new Cursor(Cursor.HAND_CURSOR);
        setCursor(hg); */
        if(index > 0)
        {
            ++index;
        } 
        a[index]=searchField.getText();
        starting();
        load_arrayList();        
        flag2 = 1;
        
    }   
    
    private void frontActionPerformed(java.awt.event.ActionEvent evt) {
       
        if(a[index+1] != null)
        {
            searchField.setText(a[++index]);
            starting();
            load_arrayList();
        }
        else
            System.out.println("no webpage to go");
        
    }
    private void backActionPerformed(java.awt.event.ActionEvent evt) {
       
        if(index>0)
        {
            searchField.setText(a[--index]);
            starting();
            load_arrayList();
        }
        else 
            System.out.println("out of lower bound");
        
    }

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("refreeeeeesh");
        starting();
        load_arrayList();
    
    }
    private void ExitMenuActionPerformed(java.awt.event.ActionEvent evt) {

        System.exit(0);
    }
    private void aboutItemActionPerformed(java.awt.event.ActionEvent evt) {
      
         About about = new About();
         about.setVisible(true);
        
    }
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {

         JComboBox cb = (JComboBox)evt.getSource();
         System.out.println(cb.getSelectedItem());
         String select = (String)cb.getSelectedItem();
         /*if(select.equals("Yahoo"))
                  {
                       System.out.println("yahoooooooo");
                        search = 1;
                  } */
         if(select.equals("wikipedia(en)"))
         {
             search = 2;
         }
         else if(select.equals("AltaVista"))
         {
             search = 3;
         }
         else if(select.equals("DMoz"))
         {
             search = 4;
         }
 
    }

    private void webSearchActionPerformed(java.awt.event.ActionEvent evt) {
 
        if(search == 0)    // Yahoo
        {
            String yahoo = "http://search.yahoo.com/search?p="+webSearch.getText()+"&fr=yfp-t-501&toggle=1&cop=mss&ei=UTF-8" ;
            searchField.setText(yahoo); 
            if(index > 0)
            {
                ++index;
            } 
            a[index]=searchField.getText();
            starting();
            load_arrayList();        
            flag2 = 1;
        }
        else if(search == 2)     // wikipedia
        {
            String wikipedia = "http://en.wikipedia.org/wiki/Special:Search?search="+webSearch.getText()+"&go=Go";
            searchField.setText(wikipedia); 
            if(index > 0)
            {
                ++index;
            } 
            a[index]=searchField.getText();
            starting();
            load_arrayList();        
            flag2 = 1;
 
        }
        else if(search == 3)     // AltaVista
        {
            String AltaVista = "http://www.altavista.com/web/results?itag=ody&q="+webSearch.getText()+"&kgs=1&kls=0 ";
            searchField.setText(AltaVista); 
            if(index > 0)
            {
                ++index;
            } 
            a[index]=searchField.getText();
            starting();
            load_arrayList();        
            flag2 = 1;
 
        }
        else if(search == 4)     // DMoz
        {
            String DMoz = "http://search.dmoz.org/cgi-bin/search?search="+webSearch.getText();
            searchField.setText(DMoz); 
            if(index > 0)
            {
                ++index;
            } 
            a[index]=searchField.getText();
            starting();
            load_arrayList();        
            flag2 = 1;
        }
        
    }

    private void webSearchMouseClicked(java.awt.event.MouseEvent evt) {
    // TODO add your handling code here:
        webSearch.setText(null);
    }
    
    void load_arrayList()
    {
        fAL = d.sendList();
        int i;
          
        for(i=0; i < fAL.size();i++)
        {
            Data mc=(Data)fAL.get(i);
            
            if(mc.style == 6)
            {
                this.setTitle(new String(mc.s1)+"-"+title);
            }
 
        }  
    }
    void starting()
    {
        s = searchField.getText();
        
        if( s.startsWith("http://"))
        {
            
        }
        else
             s = "http://"+s;
        
        searchField.setText(s);
        System.out.println(s);
  
        ParseGetter kit=new ParseGetter();
        HTMLEditorKit.Parser parser=kit.getParser();

        HTMLEditorKit.ParserCallback callback=new TagStripper(d);

        try{
                URL u = new URL(s);

                InputStream in=new BufferedInputStream(u.openStream());
                InputStreamReader r=new InputStreamReader(in);
                parser.parse(r,callback,true);
               
        }catch(IOException e){
                System.out.println("exception in url");
        }   
    }
    class MouseHandler implements MouseListener, MouseMotionListener  {
        
        public void mouseClicked( MouseEvent event )
        {
           System.out.println(event.getX() +" " + event.getY() );
           int i;
           for(i=0; i < fAL.size();i++)
            {
                Data mc=(Data)fAL.get(i);
                if(mc.style == 4)
                {
                
                    if( event.getX()>=mc.x && event.getX()<= (mc.x+(mc.s1.length * 6)) && event.getY()<=mc.y && event.getY()>= (mc.y-15)  )
                    {
                        System.out.println(" " + mc.hyper_link);
                        searchField.setText(mc.hyper_link );
                        a[++index]=searchField.getText();
                        starting();
                        load_arrayList();
                        break;
                    }
                }
          
            } // end method mouseClicked
        }
        public void mousePressed( MouseEvent event )
        {
           
        } // end method mousePressed

        // handle event when mouse released after dragging
        public void mouseReleased( MouseEvent event )
        {
           
        } // end method mouseReleased

        // handle event when mouse enters area
        public void mouseEntered( MouseEvent event )
        {
           /* int i;
            
            if(flag2 == 1)
            {   
                for(i=0; i < fAL.size();i++)
                {
                    Data mc=(Data)fAL.get(i);
                    //System.out.println("sytleeeeeee " +ab.style);
                    if(mc.style == 4)
                    {
                        System.out.println("yuppppppp");
                        System.out.println(event.getX() +" entered   " + event.getY() );
                       //if( event.getX()>=mc.x || event.getY()>=mc.y ||  event.getX()<=(mc.x + (mc.s1.length*6)) || event.getY()<=(mc.y + 15)  )
                       // if( event.getX()>=mc.x && event.getX()<= (mc.x+(mc.s1.length * 6)) && event.getY()<=mc.y && event.getY()>= (mc.y-15)  )
                        if( (event.getX()>=mc.x) && (event.getX()<= (mc.x+(mc.s1.length * 6)) )&& (event.getY()<=mc.y) && (event.getY()>= (mc.y-15))  )
                        {
                            System.out.println("essssssssssssssss");
                            Cursor hg=new Cursor(Cursor.HAND_CURSOR);
                            setCursor(hg);
                            break;
                        }
                    }
                }  
            } */
           
        } // end method mouseEntered
        public void mouseExited( MouseEvent event )
        {
            /* int i;
            for(i=0; i < fAL.size();i++)
            {
                Data ab=(Data)fAL.get(i);
                System.out.println("sytleeeeeee " +ab.style);
                if(ab.style == 4)
                {
                   //if( event.getX()>=mc.x || event.getY()>=mc.y ||  event.getX()<=(mc.x + (mc.s1.length*6)) || event.getY()<=(mc.y + 15)  )
                    if( event.getX()<=ab.x && event.getX()>= (ab.x+(ab.s1.length * 6)) && event.getY()>=ab.y && event.getY()<= (ab.y-15)  )
                    {
                        System.out.println("");
                        Cursor hg=new Cursor(Cursor.DEFAULT_CURSOR);
                        setCursor(hg);
                        break;
                    }
                }
            }  */
         
        } // end method mouseExited

     public void mouseDragged( MouseEvent event )
     {
         
     }
     public void mouseMoved( MouseEvent event )
     {
         
     }

    }
    
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
 
    drawingPanel d;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton refresh;
    private javax.swing.JButton stop;
    private javax.swing.JButton back;
    private javax.swing.JButton front;
    private javax.swing.JMenuItem ExitMenu;
    private javax.swing.JMenuItem aboutItem;
            
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JTextField webSearch;
    // End of variables declaration                   

}