/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2;

import java.awt.BasicStroke;
import java.awt.Color;
import static java.awt.Color.black;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;



/**
 *
 * @author hussi
 */
public class MyPanel extends JPanel 
{
  //Buttons
    public JButton line , rect , red , blue , oval , green , clearall , undo, freehand,erase   ;    
// Check Boxs
    JCheckBox fill,dotted; 
//Dimentions For Lines and Rectangles and Ovals
    int x1 , y1 , x2 , y2 , temp1, temp2 ;  
    int width , height ; 
    public boolean selected = false;
    public boolean sel = false;
    int flag = 0 ;


public enum Shape { LINE , RECTANGLE,OVAL , DLINE , DRECTANGLE,DOVAL, FRECTANGLE , FLINE , FOVAL,CLEARALL, FREEHAND,ERASE }


Shape shape ;

Color color = black;
    
    // Vectors For Shapes
    
    private Vector<Lines> LinesV;  //For Lines
    private Vector<Rects> RectsV;  //For Rects
    private Vector<Ovals> OvalsV;  //For FOvals
    private Vector<Rects> FRectsV;  //For FRects
    private Vector<Ovals> FOvalsV;  //For FOvals
    private Vector<Lines> DLinesV;
    private Vector<Rects> DRectsV;
    private Vector<Ovals> DOvalsV;
 //---------------------------------Shapes Classes------------------------------------------//   
//Lines
    public class Lines 
    {
        int x1 , y1 , x2 , y2 ;
        Color color ;
        public Lines(int x1, int y1, int x2, int y2, Color color) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.color = color ; 
        }
    }
//Rects
    public class Rects extends MyShape
    {

        public Rects(int x1, int y1, int width, int height, Color color) {
            super(x1, y1, width, height, color);
        }
    
    }
//Ovals
    public class Ovals extends MyShape
    {

        public Ovals(int x1, int y1, int width, int height, Color color) {
            super(x1, y1, width, height, color);
        }
    
    }
    
 
    //-----------------------------------------Panel Constructor----------------------------//
  
  public MyPanel() 
    {
        this.x1 = this.y1 = this.x2 = this.y2 =  0;
        LinesV = new Vector<Lines>();
        RectsV = new Vector<Rects>();
        OvalsV = new Vector<Ovals>();
        FRectsV = new Vector<Rects>();
        FOvalsV = new Vector<Ovals>();
        DLinesV = new Vector<Lines>();
        DRectsV = new Vector<Rects>();
        DOvalsV = new Vector<Ovals>();
        this.setBackground(Color.white);
        this.setFocusable(true);
        
        //Creating Objects for Buttons and Checkboxes 
         freehand = new JButton("FreeHand");
         rect = new JButton("Rectangle");
         line = new JButton("Line");
         oval = new JButton("Oval");
         erase = new JButton("Erase");
         red = new JButton("Red");
         blue = new JButton("Blue");
         green = new JButton("Green");
         clearall = new JButton("Clear All");
         undo = new JButton("Undo");
         fill = new JCheckBox("fill"); 
         dotted = new JCheckBox("Dotted");
         
         //Positioning
         freehand.setBounds(0, 0, 100, 50);
         line.setBounds(0, 50, 100, 50);
         rect.setBounds(0, 100, 100, 50);
         oval.setBounds(0, 150, 100, 50);
         erase.setBounds(0, 200, 100, 50);
         red.setBounds(0, 250, 100, 50);
         blue.setBounds(0, 300, 100, 50);
         green.setBounds(0, 350, 100, 50);
         fill.setBounds(0, 550, 100, 50);
         undo.setBounds(0, 500, 100, 50);
         clearall.setBounds(0, 450, 100, 50);
         dotted.setBounds(0, 600, 100, 50);
         
             //-----------------------Color Buttons----------------------------------------------------//
    red.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.RED;
                
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }         
         });
    green.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.GREEN;
                
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }         
         });
        
    blue.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.BLUE;
                
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
         });
    erase.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = Shape.ERASE;
                //updateUI();
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
         });
    
    //-----------------------Shapes Buttons----------------------------------------------------//     
     fill.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               selected = fill.isSelected();
                if(selected){
switch(shape){
    case RECTANGLE -> {
                            shape = Shape.FRECTANGLE;
                      }
    
    case OVAL ->    {
                            shape = Shape.FOVAL;
                    }
    
    default ->      {
                    }
    }
                
                }
             else{
                switch(shape){
    case FRECTANGLE -> {
                            shape = Shape.RECTANGLE;
                      }
    
    case FOVAL ->    {
                            shape = Shape.OVAL;
                    }
    
    default ->      {
                    }
    }}

                
 throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
         
         
         
         });
 dotted.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               sel = dotted.isSelected();
                if(sel){
switch(shape){
       case LINE -> {
                            shape = Shape.DLINE;
                      }
    
    case RECTANGLE -> {
                            shape = Shape.DRECTANGLE;
                      }
    
    case OVAL ->    {
                            shape = Shape.DOVAL;
                    }
    
    default ->      {
                    }
    }
                
                }else{
switch(shape){
       case DLINE -> {
                            shape = Shape.LINE;
                      }
    
    case DRECTANGLE -> {
                            shape = Shape.RECTANGLE;
                      }
    
    case DOVAL ->    {
                            shape = Shape.OVAL;
                    }
    
    default ->      {
                    }
    }}
updateUI();
                
// throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
         
         
         
         });
    rect.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                selected = fill.isSelected();
                sel = dotted.isSelected();
                if(sel){
                   shape = Shape.DRECTANGLE;
                 }
                else  {shape = Shape.RECTANGLE;}
                 if(selected){
                   shape = Shape.FRECTANGLE;
                 }
                 else  {shape = Shape.RECTANGLE;}
              //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }         
         });
    freehand.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    
                shape = Shape.FREEHAND ;
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }         
         });
            
         oval.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                sel = dotted.isSelected();
                selected = fill.isSelected();
                if(sel){
                   shape = Shape.DOVAL;
                 }
                else {shape = Shape.OVAL;}
            if(selected){
                   shape = Shape.FOVAL;
                 }
            else {shape = Shape.OVAL;}
                
              //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }  
            
         });
        line.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                sel = dotted.isSelected();
                if(sel){
                   shape = Shape.DLINE;
                 }
                else {shape = Shape.LINE;}
             //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
         });
        
    //----------------------------- Clearing ---------------------------------------------//
    clearall.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                  shape = Shape.CLEARALL;  
                  RectsV.clear();
                  FRectsV.clear();
                  DRectsV.clear();
                  OvalsV.clear();
                  DOvalsV.clear();
                  FOvalsV.clear();
                  LinesV.clear();
                  DLinesV.clear();
                
        repaint();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
         });   
    undo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               flag = 1 ;
               switch(shape){
    case RECTANGLE -> {
                       RectsV.remove((RectsV.size()-1));
                      }
    case DRECTANGLE -> {
                       DRectsV.remove((DRectsV.size()-1));
                      }
    case FRECTANGLE -> {
                       FRectsV.remove((FRectsV.size()-1));
                      }

    case LINE ->    {
                       LinesV.remove((LinesV.size()-1));
                    }
    case DLINE ->    {
                       DLinesV.remove((DLinesV.size()-1));
                    }

    case OVAL ->    {
                       OvalsV.remove((OvalsV.size()-1));
                    }
   case DOVAL ->    {
                       DOvalsV.remove((DOvalsV.size()-1));
                    }
    case FOVAL ->    {
                       FOvalsV.remove((FOvalsV.size()-1));
                    }
    
    default ->      {
                    }
    }
              
         
        repaint();
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
         }); 

         

        this.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mousePressed(MouseEvent e) {

                switch(shape){
    case RECTANGLE -> {
                        x1 = e.getX();
                        y1 = e.getY();
                      }
    case ERASE -> {
                        x1 = e.getX();
                        y1 = e.getY();
                      }
    case DRECTANGLE -> {
                        x1 = e.getX();
                        y1 = e.getY();
                      }
    case FRECTANGLE -> {
                        x1 = e.getX();
                        y1 = e.getY();
                      }

    case LINE ->    {
                        x1 = e.getX();
                        y1 = e.getY();
                    }
    case FREEHAND ->    {
                        x1 = e.getX();
                        y1 = e.getY();
                    }
    case DLINE ->    {
                        x1 = e.getX();
                        y1 = e.getY();
                    }

    case OVAL ->    {
                         x1 = e.getX();
                         y1 = e.getY();
                    }
   case DOVAL ->    {
                         x1 = e.getX();
                         y1 = e.getY();
                    }
    case FOVAL ->    {
                         x1 = e.getX();
                         y1 = e.getY();
                    }
    
    default ->      {
                    }
    }
                        
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseReleased(MouseEvent e) {

             
switch(shape){
    case RECTANGLE -> {
        width = Math.abs(x1-e.getX());
        height = Math.abs(y1-e.getY());
        x1 = Math.min(x1,e.getX());
        y1 = Math.min(y1,e.getY());
        RectsV.add(new Rects(x1,y1,width,height,color));
        updateUI();
                    }
        case DRECTANGLE -> {
        width = Math.abs(x1-e.getX());
        height = Math.abs(y1-e.getY());
        x1 = Math.min(x1,e.getX());
        y1 = Math.min(y1,e.getY());
        DRectsV.add(new Rects(x1,y1,width,height,color));
        updateUI();
                    }
    case FRECTANGLE -> {
        width = Math.abs(x1-e.getX());
        height = Math.abs(y1-e.getY());
        x1 = Math.min(x1,e.getX());
        y1 = Math.min(y1,e.getY());
        FRectsV.add(new Rects(x1,y1,width,height,color));
        updateUI();
                    }
    case OVAL -> {
        width = Math.abs(x1-e.getX());
        height = Math.abs(y1-e.getY());
        x1 = Math.min(x1,e.getX());
        y1 = Math.min(y1,e.getY());
        OvalsV.add(new Ovals(x1,y1,width,height,color));
        updateUI();
                    }
    
    case DOVAL -> {
        width = Math.abs(x1-e.getX());
        height = Math.abs(y1-e.getY());
        x1 = Math.min(x1,e.getX());
        y1 = Math.min(y1,e.getY());
        DOvalsV.add(new Ovals(x1,y1,width,height,color));
        updateUI();
                    }
   case FOVAL -> {
        width = Math.abs(x1-e.getX());
        height = Math.abs(y1-e.getY());
        x1 = Math.min(x1,e.getX());
        y1 = Math.min(y1,e.getY());
        FOvalsV.add(new Ovals(x1,y1,width,height,color));
        updateUI();
                    }
 
    case LINE ->    {
        x2 = e.getX();
        y2 = e.getY();
        LinesV.add(new Lines(x1,y1,x2,y2,color));
        updateUI();
                    }

    case DLINE ->    {
        x2 = e.getX();
        y2 = e.getY();
        DLinesV.add(new Lines(x1,y1,x2,y2,color));
        updateUI();
                    }

    default ->      {
                    }
    }
                
                
                
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        
        
        
        
        
        
        });
        
        this.addMouseMotionListener(new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent e) {
                
switch(shape){
    case RECTANGLE -> {
        width = (e.getX()-x1);
        height = (e.getY()-y1);
        updateUI(); 

                    }
        case FRECTANGLE -> {
        width = (e.getX()-x1);
        height = (e.getY()-y1);
        updateUI(); 
                    }
      case DRECTANGLE -> {
                            width = (e.getX()-x1);
                            height = (e.getY()-y1);
                         updateUI(); 
                         }
    case OVAL -> {
                        width = (e.getX()-x1);
                        height = (e.getY()-y1);
                        updateUI();
                 }
    case DOVAL -> {
                    width = (e.getX()-x1);
                    height = (e.getY()-y1);
                    updateUI();
                  }
    case FOVAL -> {
                    width = (e.getX()-x1);
                     height = (e.getY()-y1);
                     updateUI();
                  }


    case LINE ->    {
                        x2 = e.getX();
                        y2 = e.getY();
                        updateUI();
                    }
    case FREEHAND ->    {
                Graphics g = getGraphics();  
                g.setColor(color);
                g.drawLine(x1, y1, e.getX(), e.getY());
                x1 = e.getX();
                y1 = e.getY();
                        
                        }
        case ERASE ->    {
                Graphics g = getGraphics();  
                g.setColor(Color.white);
                g.fillRect(x1, y1, 10, 10);
                x1 = e.getX();
                y1 = e.getY();
                FRectsV.add(new Rects(x1,y1,10,10,Color.white));
                        
                        }
    case DLINE ->    {
                        x2 = e.getX();
                        y2 = e.getY();
                        updateUI();
                    }

    default ->      {
                    }
    }
                
                
               
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        
        
        
        });
      this.add(line);
      this.add(rect);
      this.add(oval);
      this.add(red); 
      this.add(blue); 
      this.add(green);
      this.add(fill);
      this.add(clearall);
      this.add(dotted);
      this.add(undo);
      this.add(freehand);
      this.add(erase);
    }
//----------------------------------------------Painting--------------------------------------------//
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
 
     if( g.getColor() != black)
     {g.setColor(color);}
     else{}

  //-----------------------Painting current shape----------------------------------------------------//       
 
        if(flag !=1)
        {
        
        switch(shape){
             
        case RECTANGLE -> {       
                            g.drawRect(x1, y1, width, height);      
                          }
        
        case DRECTANGLE -> {
        
                             Graphics2D g2d = (Graphics2D) g;

                              float[] dash1 = {2f};
                                BasicStroke bs1 = new BasicStroke(1,  BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 
                                        2.0f,  dash1,2f);
                                 g2d.setStroke(bs1);
                                 g2d.drawRect(x1, y1, width, height);     
                            }
        case CLEARALL -> {
               
                         }
                case ERASE -> {        
                                 g.fillRect(x1, y1, width, height);
                           }

        case FRECTANGLE -> {        
                                 g.fillRect(x1, y1, width, height);
                           }
        
        case OVAL ->    {
        
                                 g.drawOval(x1, y1, width, height);
                        }
        
        case DOVAL ->   {
        
                                Graphics2D g2d = (Graphics2D) g;

                                float[] dash1 = {2f};
                                BasicStroke bs1 = new BasicStroke(1,  BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 
                                2.0f,  dash1,2f);
                                g2d.setStroke(bs1);
                                g2d.drawOval(x1, y1, width, height);
                         }
         
        case FOVAL -> {
       
                                 g.fillOval(x1, y1, width, height);
                       }
    
        case LINE -> {       
                                 g.drawLine(x1, y1, x2, y2);
                     }

        
        case DLINE -> {
        
                                Graphics2D g2d = (Graphics2D) g;

                                float[] dash1 = {2f};
                                BasicStroke bs1 = new BasicStroke(1,  BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 
                                        2.0f,  dash1,2f);
                                g2d.setStroke(bs1);
                                g2d.drawLine(x1, y1, x2, y2);
                      }
    

         default -> {
            }
    }} flag = 0 ;
         //-----------------------Painting previous shapes----------------------------------------------------//
             for(int i = 0 ; i < RectsV.size() ; i++)   
        {
            g.setColor(RectsV.get(i).color);
            g.drawRect(RectsV.get(i).x1, RectsV.get(i).y1, RectsV.get(i).width, RectsV.get(i).height);
        }     
              for(int i = 0 ; i < DRectsV.size() ; i++)   
        {
            g.setColor(DRectsV.get(i).color);
            g.drawRect(DRectsV.get(i).x1, DRectsV.get(i).y1, DRectsV.get(i).width, DRectsV.get(i).height);
        }     
                for(int i = 0 ; i < FRectsV.size() ; i++)   
        {
            g.setColor(FRectsV.get(i).color);
            g.fillRect(FRectsV.get(i).x1, FRectsV.get(i).y1, FRectsV.get(i).width, FRectsV.get(i).height);
        }          
             for(int i = 0 ; i < LinesV.size() ; i++)   
        {
            g.setColor(LinesV.get(i).color);
            g.drawLine(LinesV.get(i).x1, LinesV.get(i).y1, LinesV.get(i).x2, LinesV.get(i).y2);
        }
                  for(int i = 0 ; i < DLinesV.size() ; i++)   
        {
            g.setColor(DLinesV.get(i).color);
            g.drawLine(DLinesV.get(i).x1, DLinesV.get(i).y1, DLinesV.get(i).x2, DLinesV.get(i).y2);
        }
                
               for(int i = 0 ; i < OvalsV.size() ; i++)   
        {
            g.setColor(OvalsV.get(i).color);
            g.drawOval(OvalsV.get(i).x1, OvalsV.get(i).y1, OvalsV.get(i).width, OvalsV.get(i).height);
        }
                              for(int i = 0 ; i < FOvalsV.size() ; i++)   
        {
            g.setColor(FOvalsV.get(i).color);
            g.fillOval(FOvalsV.get(i).x1, FOvalsV.get(i).y1, FOvalsV.get(i).width, FOvalsV.get(i).height);
        }
                             for(int i = 0 ; i < DOvalsV.size() ; i++)   
        {
            g.setColor(DOvalsV.get(i).color);
            g.drawOval(DOvalsV.get(i).x1, DOvalsV.get(i).y1, DOvalsV.get(i).width, DOvalsV.get(i).height);
        }

    }


}
