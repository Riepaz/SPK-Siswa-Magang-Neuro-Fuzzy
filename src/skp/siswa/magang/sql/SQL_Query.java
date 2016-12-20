/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skp.siswa.magang.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import skp.siswa.magang.preferences.preferecePertanyaan;
import skp.siswa.magang.preferences.preferenceDataDiri;
import skp.siswa.magang.preferences.preferenceHasilJawaban;
import skp.siswa.magang.preferences.preferenceJawaban;

/**
 *
 * @author Asus
 */
public class SQL_Query {
    Connection Con;
    private Statement stm;
    
    private ResultSet ResPtnyaan; 
    private ResultSet ResJawaban;
    private ResultSet ResDatSiswa;
    
    private final String [] pertanyaan = new String [46];
    private final String [] kategori = new String [46];
    private final String [] Sangat_Penting = new String [46];
    private final String [] Penting = new String [46];
    private final String [] Biasa = new String [46];
    private final String [] Tidak_Penting = new String [46];
    private final String [] Sangat_Tidak_Penting = new String [46];
    private final int [] status = new int [46];
    
    private String nis;
    private final preferecePertanyaan prefTanya = new preferecePertanyaan();
    private final preferenceJawaban prefJawab = new preferenceJawaban();
    private final preferenceDataDiri dataDiri = new preferenceDataDiri();
    private final preferenceHasilJawaban hasilJawaban = new preferenceHasilJawaban();
    
    public SQL_Query(){
        open_db();
    }
     
    public final void open_db() {       
        try{   
            SQL_Koneksi kon = new SQL_Koneksi ("127.0.0.1","root","","siswa_magang");
            Con = kon.getConnection();           
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
            ResJawaban = stm.executeQuery("select * from siswa_magang_set_fuzzy");                              

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
     
    public String panggilSiswa(String nis){
        try{
            
            stm = Con.createStatement();             
            ResDatSiswa = stm.executeQuery("select * from siswa_magang_data_siswa where nis = "+nis);                              

            ResDatSiswa.beforeFirst();            
            
            while(ResDatSiswa.next()) {                 
                this.nis = ResDatSiswa.getString("nis");
            }         
        }catch(SQLException e) {         
            JOptionPane.showMessageDialog(null, e);     
        }
        return this.nis;
    }
    
    public void masukDataSiswa(){
        try{
            stm = Con.createStatement();             
            stm.executeUpdate("insert into siswa_magang_data_siswa values ('"
                    +dataDiri.getNis()+"','"+dataDiri.getNama()+"')");                                          
        }catch(SQLException e) {         
            JOptionPane.showMessageDialog(null, e);     
        }
    }
    
    public void updateDataSiswa(){
        try{
            stm = Con.createStatement();             
            stm.executeUpdate("update siswa_magang_data_siswa set nama = '"+dataDiri.getNama()+"' where nis = '"+dataDiri.getNis()+"'");                         
        }catch(SQLException e) {         
            JOptionPane.showMessageDialog(null, e);     
        }
    }
    
    public void masukDataJawaban(){
        try{
            stm = Con.createStatement();
            if(hasilJawaban.getJawab() != null ){
                for(int x = 0; x < hasilJawaban.getJawab().length; x++){
                    for(int y = 0; y < hasilJawaban.getJawab()[x].length; y++){
                        if(hasilJawaban.getJawab()[x][y] != null && !" ".equals(hasilJawaban.getJawab()[x][y])){
                            stm.executeUpdate("insert into siswa_magang_data_nilai "
                                    + " (nis, ID_Pertanyaan, jawaban, nilai) values ('"
                                    + dataDiri.getNis()+"',"+(x+1)+",'"+hasilJawaban.getJawab()[x][y]+"',"+Math.abs(y-5)+")");
                        }
                    }
                }
            }                                          
        }catch(SQLException e) {         
            JOptionPane.showMessageDialog(null, e);     
        }
    }
    
    public void updateDataJawaban(){
        try{
            stm = Con.createStatement();             
            stm.executeUpdate("update siswa_magang_data_siswa set nama = '"+dataDiri.getNama()+"' where nis = '"+dataDiri.getNis()+"'");                         
        }catch(SQLException e) {         
            JOptionPane.showMessageDialog(null, e);     
        }
    }
}
     
