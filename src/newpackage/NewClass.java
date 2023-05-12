/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class NewClass {
    
      public static void main(String[] args) {
        File f = new File("famousdoctors.txt");
        
        String sk="";
        try{
          Scanner s = new Scanner(f);
        while(s.hasNext())
        {
            String x=s.nextLine();
            sk=sk+x+"\n";
        }
        System.out.println(sk);
        
    }catch(Exception e)
    {
        
    }
        
}
}
