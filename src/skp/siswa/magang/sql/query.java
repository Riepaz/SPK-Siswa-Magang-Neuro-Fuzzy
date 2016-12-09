/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skp.siswa.magang.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import skp.siswa.magang.preferences.preferecePertanyaan;
import skp.siswa.magang.preferences.preferenceJawaban;
import skp.siswa.magang.view.Form_Pertanyaan;

/**
 *
 * @author Asus
 */
public class query {
    Connection Con;     
    private ResultSet ResPtnyaan; 
    private ResultSet ResJawaban;
    private Statement stm;
    private String [] pertanyaan = new String [46];
    private String [] kategori = new String [46];
    private int [] status = new int [46];
    private String [] Sangat_Penting = new String [46];
    private String [] Penting = new String [46];
    private String [] Biasa = new String [46];
    private String [] Tidak_Penting = new String [46];
    private String [] Sangat_Tidak_Penting = new String [46];

    
    private preferecePertanyaan prefTanya = new preferecePertanyaan();
    private preferenceJawaban prefJawab = new preferenceJawaban();
     
    public query(){
        open_db();
    }
     
    public void open_db() {       
        try{   
            KoneksiMysql kon = new KoneksiMysql ("127.0.0.1","root","","siswa_magang");
            Con = kon.getConnection();   
            System.out.println("Berhasil ");         
         }catch (Exception e) {   
           System.out.println("Error : "+e);   
         } 
    } 
     
    public void panggilPertanyaan(){
        try{
            
            stm = Con.createStatement();             
            ResPtnyaan = stm.executeQuery("select * from siswa_magang_pertanyaan");                              

            int x = 0;            
            ResPtnyaan.beforeFirst();            
            
            while(ResPtnyaan.next()) {                 
                pertanyaan[x] = ResPtnyaan.getString("Pertanyaan");
                kategori[x] = ResPtnyaan.getString("kategori");
                status[x] = ResPtnyaan.getInt("status");
          
                x++;             
            }
            prefTanya.setStatus(status);
            prefTanya.setPertanyaan(pertanyaan);
            prefTanya.setKategori(kategori);
                        
        }catch(SQLException e) {         
            JOptionPane.showMessageDialog(null, e);     
        }
    }
    
    public void PanggilJawaban(){
         try{
            
            stm = Con.createStatement();             
            ResJawaban = stm.executeQuery("select * from siswa_magang_bobot");                              

            int x = 0;            
            ResJawaban.beforeFirst();            
            
            while(ResJawaban.next()) {                 
                Sangat_Penting[x] = ResJawaban.getString("Sangat_Penting");
                Penting[x] = ResJawaban.getString("Penting");
                Biasa[x]= ResJawaban.getString("Biasa");
                Tidak_Penting[x] = ResJawaban.getString("Tidak_Penting");
                Sangat_Tidak_Penting[x] = ResJawaban.getString("Sangat_Tidak_Penting");
          
                x++;             
            }
            prefJawab.setSangat_Penting(Sangat_Penting);
            prefJawab.setPenting(Penting);
            prefJawab.setBiasa(Biasa);
            prefJawab.setTidak_Penting(Tidak_Penting);
            prefJawab.setSangat_Tidak_Penting(Sangat_Tidak_Penting);
            
        }catch(SQLException e) {         
            JOptionPane.showMessageDialog(null, e);     
        }
    }
     
}
     
