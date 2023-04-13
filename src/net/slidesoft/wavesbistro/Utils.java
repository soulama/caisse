package net.slidesoft.wavesbistro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Rachid El Alaoui , SlideSoft.net
 */
public final class Utils {

    private Utils() {
    }
    
    
    public static final String PRODUCT_DAYLY_STATS = "dailystats.csv";
    public static final String CAT_DB = "categories.ser";
    public static final int TABLES = 15;

    static void saveData(String data) throws IOException {
        File file = new File( getFileName() );
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
            fr.write(data);
        } catch (IOException ex) {    
        } finally{
            if ( !Objects.isNull( fr ) ) {
                fr.close();
            }
        }
    }

    static void error(String message, JFrame parent) {
        JOptionPane.showMessageDialog( parent, message, "Error Message!", JOptionPane.ERROR_MESSAGE);
    }

    public static void info(String message, JFrame parent) {
        JOptionPane.showMessageDialog( parent, message, "Information Message!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    static String getFileName() {
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_uuuu");
        LocalDate localDate = LocalDate.now();
        return dtf.format( localDate ) + "_" + PRODUCT_DAYLY_STATS ;
    }
    
    static String now() {
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        LocalDate localDate = LocalDate.now();
        return dtf.format( localDate ) ;
    }
    
    
    
    static void saveCatDB( CategoryDB db ) {

        try {
            FileOutputStream fos = new FileOutputStream( CAT_DB ); 
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject( db );
            out.close();
            fos.close();
         } catch (IOException i) {
            i.printStackTrace();
         }
        
    }
    
  public static CategoryDB loadCatDB() {
      try {
         FileInputStream fis = new FileInputStream( CAT_DB );
         ObjectInputStream in = new ObjectInputStream(fis);
         CategoryDB cats = (CategoryDB) in.readObject();
         in.close();
         fis.close();
         return cats;
      } catch (Exception i) {
         i.printStackTrace();
         return null;
      }    
    }
}
