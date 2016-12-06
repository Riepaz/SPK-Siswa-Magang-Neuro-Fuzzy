/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skp.siswa.magang.preferences;

/**
 *
 * @author Asus
 */
public class preferecePertanyaan{

    /**
     * @param args the command line arguments
     */
    
   private static String pertanyaan [];
   private static String kategori [];
   private static int status [];
   
   public void setPertanyaan(String [] pertanyaan){
       this.pertanyaan = pertanyaan;
   }
    
    public String [] getPertanyaan(){
        return pertanyaan;
    }
    
    public void setKategori(String [] kategori){
       this.kategori = kategori;
    }
    
    public String [] getKategori(){
        return kategori;
    }
    
    public void setStatus(int [] status){
       this.status = status;
    }
    
    public int [] getStatus(){
        return status;
    }
}
