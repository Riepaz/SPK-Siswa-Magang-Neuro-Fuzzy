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

public class preferenceJawaban {
    private static String Sangat_Penting [];
    private static String Penting [];
    private static String Biasa [];
    private static String Tidak_Penting [];
    private static String Sangat_Tidak_Penting [];
    
    public void setSangat_Penting(String [] Sangat_Penting){
        this.Sangat_Penting = Sangat_Penting;
    }
    public String [] getSangat_Penting(){
        return Sangat_Penting;
    }
    public void setPenting(String [] Penting){
        this.Penting = Penting;
    }
    public String [] getPenting(){
        return Penting;
    }
    public void setBiasa(String [] Biasa){
        this.Biasa = Biasa;
    }
    public String [] getBiasa(){
        return Biasa;
    }
    public void setTidak_Penting (String [] Tidak_Penting){
        this.Tidak_Penting = Tidak_Penting;
    }
    public String [] getTidak_Penting(){
        return Tidak_Penting;
    }
    public void setSangat_Tidak_Penting (String [] Sangat_Tidak_Penting){
        this.Sangat_Tidak_Penting = Sangat_Tidak_Penting;
    }
    public String [] getSangat_Tidak_Penting(){
        return Sangat_Tidak_Penting;
    }
    
}
