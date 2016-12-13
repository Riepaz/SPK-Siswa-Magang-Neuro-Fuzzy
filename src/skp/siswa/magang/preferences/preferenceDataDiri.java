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
public class preferenceDataDiri {
    
    
    private static String nis;
    private static String nama;
    
    public void setNis(String nis){
        this.nis = nis;
    }
    
    public String getNis(){
        return nis;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return nama;
    }
    
}
