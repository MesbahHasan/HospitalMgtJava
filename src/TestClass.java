
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class TestClass {
    
    
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("famousdoctors.txt");
        Scanner s = new Scanner(f);
        String sk="";
        
        while(s.hasNext())
        {
            String x=s.nextLine();
            sk=sk+x+"\n";
        }
        System.out.println(sk);
        
    }
}
