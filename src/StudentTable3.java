

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class StudentTable3 extends JFrame implements ActionListener {
    
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;
    private Container c;
    private Font font1,font2,font3;
    private JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl12;
    private JTextField jtNo,jtName,jtPhone;
    private JButton Insert,Update,Delete,Clear,Exit;
    private JTextArea jtAddress;
    
    
    private String[] columns = {"patient no","patient name","phone","address"};
    private String[] rows = new String[4];
    StudentTable3()
    {
        initComponents();
    }
    public void  initComponents()
    {
         String file = "monir.txt";
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250,100,1050,500);
        setTitle("Student Information Table");
        setResizable(false);
        
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);
        font1 = new Font("Arial",Font.BOLD,20);
        font2 =new Font("Arial",Font.PLAIN,20);
        font3 =new Font("Arial",Font.BOLD,20);
        
        jl1 = new JLabel("FILL ALL INFO:");
        jl1.setBounds(20, 20, 200, 30);
        jl1.setFont(font1);
        c.add(jl1);
        
        jl12 = new JLabel("Patient Profile");
        jl12.setBounds(600, 20, 350, 30);
        jl12.setFont(font1);
        c.add(jl12);
        
        jl2 = new JLabel(" Patient No :");
        jl2.setBounds(30, 60, 120, 30);
        jl2.setFont(font2);
        c.add(jl2);
        
        jtNo = new JTextField();
        jtNo.setBounds(150, 60, 220, 30);
        jtNo.setFont(font2);
        c.add(jtNo);
        
        jl3 = new JLabel("Patient Name:");
        jl3.setBounds(30, 110, 140, 30);
        jl3.setFont(font2);
        c.add(jl3);
        
        jtName = new JTextField();
        jtName.setBounds(150, 110, 220, 30);
        jtName.setFont(font2);
        c.add(jtName);
        
        jl4 = new JLabel("Phone :");
        jl4.setBounds(60, 160, 90, 30);
        jl4.setFont(font2);
        c.add(jl4);
        
        jtPhone = new JTextField();
        jtPhone.setBounds(150, 160, 220, 30);
        jtPhone.setFont(font2);
        c.add(jtPhone);
       
        
        
     
        jl10= new JLabel("Address.:");
        jl10.setBounds(30, 210, 180, 30);
        jl10.setFont(font2);
        c.add(jl10);
        
        jtAddress= new JTextArea();
        jtAddress.setBounds(160, 210,150, 140);
        jtAddress.setFont(font2);
        
        c.add(jtAddress);
        Exit= new JButton("Exit");
        Exit.setBounds(580,400,100,30);
        Exit.setFont(font2);
        c.add(Exit);
        
        Delete= new JButton("Delete");
        Delete.setBounds(70, 400,100,30);
        Delete.setFont(font2);
        c.add(Delete);
        
        Update= new JButton("Update");
        Update.setBounds(200, 400,100,30);
        Update.setFont(font2);
        c.add(Update);
        
        Clear= new JButton("Clear");
        Clear.setBounds(330, 400,100,30);
        Clear.setFont(font2);
        c.add(Clear);
        
        Insert= new JButton("Insert");
        Insert.setBounds(460, 400,100,30);
        Insert.setFont(font2);
        c.add(Insert);
        
        
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setFont(font3);
        table.setSelectionBackground(Color.RED);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        scroll = new JScrollPane(table);
        scroll.setBounds(400,60,600,300);
        c.add(scroll);
        
       showdata();        
        
        
        Exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                 Main ob;
                 ob=new Main();
                 ob.setVisible(true);
                //System.exit(0);
            }

             private void exit(int i) {
                 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             }
        });
        Delete.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e)
            {
                  int NumberOfRow = table.getSelectedRow();
               if(NumberOfRow>=0)
               {
                   model.removeRow(NumberOfRow);
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"No row has beed selected or no row exist");
               }
            }
            
            
            
           

         
            
        });
                 
                   Update.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e)
            {
                int n =table.getSelectedRow();
                String fno=jtNo.getText();
                String fname=jtName.getText();
                String fphone=jtPhone.getText();
              
                String faddress=jtAddress.getText();
                
                model.setValueAt(fno,n,0);
                model.setValueAt(fname,n,1);
                model.setValueAt(fphone,n,2);
                model.setValueAt(faddress,n,3);
               }

         
            
        }); 
        
                    Clear.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e)
            {
                jtNo.setText(null);
                jtName.setText(null);
                jtPhone.setText(null);
            
                jtAddress.setText(null);
                
          
            
            
               
            }

         
            
        });
                           
               
                   
                    
              Insert.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e)
            {
                
                rows[0]  =jtNo.getText();
                rows[1] =jtName.getText();
                rows[2] =jtPhone.getText();
                
                rows[3] =jtAddress.getText();
                model.addRow(rows);
              
           String s=rows[0]+" "+rows[1]+" "+rows[2]+" "+rows[3]+"\r\n";                        
                  try{
            FileOutputStream fout = new FileOutputStream("Patient.txt",true);
            
            char ch[]=s.toCharArray();
            for(int i=0;i<s.length();i++)
            {
                fout.write(ch[i]);
            }
            fout.close();
            
        }catch(Exception m)
        {
            
        }
               
              
            }

         
            
        }); 
            
        
            
              table.addMouseListener(new MouseAdapter(){
                    
                    @Override
                    public void mouseClicked(MouseEvent em)
                    {
                       int NumberOfRow = table.getSelectedRow();
                        String fNo = model.getValueAt(NumberOfRow,0).toString();
                        String fName = model.getValueAt(NumberOfRow,1).toString();
                        String fPhone = model.getValueAt(NumberOfRow,2).toString();
                        
                        String fAddress= model.getValueAt(NumberOfRow,3).toString();
                        
                        jtNo.setText(fNo);
                        jtName.setText(fName);
                        jtPhone.setText(fPhone);
                        
                        jtAddress.setText(fAddress);
                       
                        
                    }
                });
       
        
        
        
        
        
        
    }
    public void showdata()
    {
         try{
         File f = new File("Patient.txt");
         Scanner s = new Scanner(f);
         while(s.hasNext())
                 {
                   
                     rows[0]=s.next();
                     rows[1]=s.next();
                     rows[2]=s.next();
                     rows[3]=s.next();
                     
                     model.addRow(rows);
                    
                 }
     
     }catch(Exception ex)
     {
         
     }
    }
    public void DeleteRecord(String filePath,String removeTerm,int positionOfTerm,String delimiter)
    {
        int position = positionOfTerm-1;
    String tempFile = "temp.txt";
    File oldFile = new File(filePath);
    File newFile = new File(tempFile);
    String currentLine;
    String data[];
    
    try{
        
        FileWriter fw = new FileWriter(tempFile,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        
        FileReader fr= new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        while((currentLine=br.readLine())!=null)
        {
            data= currentLine.split(" ");
            if(!(data[position].equalsIgnoreCase(removeTerm)))
            {
                pw.println(currentLine);
            }
        }
        pw.flush();
        pw.close();
        fr.close();
        br.close();
        bw.close();
        fw.close();
        oldFile.delete();
        System.out.println(oldFile.exists());
        File dump = new File(filePath);
        newFile.renameTo(dump);
    }catch(Exception em)
    {
        
    }
    }

    
   
    

    
    public static void main(String[] args)  {
        
        StudentTable3 ob = new StudentTable3();
        ob.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
