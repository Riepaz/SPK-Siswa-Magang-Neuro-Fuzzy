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
public class preferenceHasilJawaban {
     
    private static String [][] jawab;
    
    public void setJawaban(String [][] jawab){   
        this.jawab = jawab;
    }
    
    public String [][] getJawab(){
        return jawab;
    }
}
