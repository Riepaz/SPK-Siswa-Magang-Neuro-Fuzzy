/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skp.siswa.magang.metode;

import skp.siswa.magang.preferences.preferenceHasilJawaban;
import skp.siswa.magang.preferences.preferenceWhiteList;

/**
 *
 * @author Asus
 */
public class fuzzifikasi {
    preferenceHasilJawaban jawaban = new preferenceHasilJawaban();
    preferenceWhiteList whiteList = new preferenceWhiteList();
    
    private String [][] whiteListExpanded = new String [46][100];
    private String [][] RasionalisasiJawabExpanded = new String[46][100];

    
    private float pointRanking = 0;
    private float [][]  hasil = new float[46][5];
    
    private float [] storeDomain = new float [46];
    private float rankDomain = 0;
    private float domain = 0;
    
    public fuzzifikasi(){
        for (int x = 0; x < jawaban.getJawab().length; x++) {
            if (jawaban.getJawab()[x][4] != null && !"".equals(jawaban.getJawab()[x][4])) {
                RasionalisasiJawabExpanded [x] = jawaban.getJawab()[x][4].split(" ");
            }
        }
        
        for (int x = 0; x < whiteList.getWhiteList().length; x++) {
            if (whiteList.getWhiteList()[x] != null && !"".equals(whiteList.getWhiteList()[x])) {
                whiteListExpanded[x] = whiteList.getWhiteList()[x].split(" ");
            }
        }
    }
   
    public void inferensiEssay(){
        
        for (int a = 0; a < whiteListExpanded.length; a++) {
            for (int b = 0; b < whiteListExpanded[a].length; b++) {
                if(whiteListExpanded[a][b] != null && !"".equals(whiteListExpanded[a][b])){
                    rankDomain = rankDomain +1;
                }
            }
            storeDomain[a] = rankDomain;
            rankDomain = 0;
        }
        
        for (int x = 0; x < RasionalisasiJawabExpanded.length; x++) {
            for (int y = 0; y < RasionalisasiJawabExpanded[x].length; y++) {
                for (int z = 0; z < whiteListExpanded[x].length; z++) {
                    if (RasionalisasiJawabExpanded[x][y] != null && !"".equals(RasionalisasiJawabExpanded[x][y]) 
                            && whiteListExpanded[x][z] != null && !"".equals(whiteListExpanded[x][z])
                            ) {
                        
                        //Inisialisasi domain
                        domain = storeDomain[x] / 7;
                        
                        if (RasionalisasiJawabExpanded[x][y].toLowerCase()
                                .equals(whiteListExpanded[x][z].toLowerCase()) ) {
                            pointRanking = pointRanking + domain;
                        }
                    }
                }
            }
                
            //perhitungan inferensi kurva bahu dengan 7 poin domain 
            if(pointRanking>= (domain/3) && pointRanking<=domain*4){
                
                //Indikator Cukup
                hasil[x][0] = Math.abs((domain * 4) - pointRanking) / Math.abs((domain * 4)-(domain));
                
                //Indikator Baik
                hasil[x][1] = Math.abs(pointRanking - (domain*2)) / Math.abs((domain * 4)-(domain*2));
                
            }else if (pointRanking>domain*4 && pointRanking<=domain*7){
                
                //Indikator Baik
                hasil[x][2] = Math.abs((domain * 7) - pointRanking) / Math.abs((domain * 7)-(domain*4));
                
                //Indikator Sangat Baik
                hasil[x][3] = Math.abs(pointRanking - (domain*4)) / Math.abs((domain * 7)-(domain*4));
            }else{
                hasil[x][0] = 1;
            }
            
            System.out.println(pointRanking);
            
            pointRanking = 0; 
            domain = 0;
        }
        
        System.out.println("\n\n");
        System.out.println(hasil[5][0]);
        System.out.println(hasil[5][1]);
        System.out.println(hasil[5][2]);
        System.out.println(hasil[5][3]);
        
    }
    
    public void inferensiJawabanSingkat(){
        for (int x = 0; x < jawaban.getJawab().length; x++) {
            if (jawaban.getJawab()[x][1] != null && !"".equals(jawaban.getJawab()[x][1])) {
                hasil[x][5] = Float.parseFloat(jawaban.getJawab()[x][1]);
            }
        }
        
        for (int x = 0; x < jawaban.getJawab().length; x++) {
            if (jawaban.getJawab()[x][2] != null && !"".equals(jawaban.getJawab()[x][2])) {
                hasil[x][5] = Float.parseFloat(jawaban.getJawab()[x][2]);
            }
        }
        
        for (int x = 0; x < jawaban.getJawab().length; x++) {
            if (jawaban.getJawab()[x][3] != null && !"".equals(jawaban.getJawab()[x][3])) {
                hasil[x][5] = Float.parseFloat(jawaban.getJawab()[x][3]);
            }
        }
    }
}
