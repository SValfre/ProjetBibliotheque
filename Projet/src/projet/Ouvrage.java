/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 *
 * @author valfres
 */

public class Ouvrage {
    
    private static int dernierExemplaire;
    private ArrayList<Exemplaire> exemplaires;
    private int ISBN;
    private String titre;
    private String nomEditeur;
    private GregorianCalendar dateParution;
    private Public publif;
    private String nomAuteur;
    
    public Ouvrage(int ISBN, String titre, String nomEditeur, GregorianCalendar dateParution, String nomAuteur, Public publif){

        this.ISBN = ISBN;
        this.titre = titre;
        this.nomEditeur = nomEditeur;
        this.dateParution = dateParution;
        this.nomAuteur = nomAuteur;
        this.publif = publif;
        exemplaires = new ArrayList<>();
    }
    
    public ArrayList getExemplaire(){
        return this.exemplaires;
    }
    
    public Public getPublic(){
       return this.publif;
    }
    
    public void incrementationNbEx(){
        dernierExemplaire += 1;
    }
    public void afficherExemplaire(){
        for (int i=0;i<this.getExemplaire().size();i++){
            exemplaires.get(i).afficherExemplaire();
        }
    }
    public void afficherInfos(){
        System.out.println(" Titre : " + titre + "\n N° ISBN : " + ISBN + "\n écrit par :" + nomAuteur + "\n Edité par : "+ nomEditeur + "\n Paru le : "+ dateParution+ "\n Destiné à un public : "+publif);
    }
    
    public void lierExemplaireOuvrage(Exemplaire e){
        this.exemplaires.add(e);
    }
    
    public void afficherReduit(){
        System.out.println(" Titre : " + titre + "\n N° ISBN : " + ISBN );
    }
    
    public void nouvelExemplaire(){
        GregorianCalendar dateReception = EntreesSorties.lireDate("Entrez la date de reception :");
        boolean empruntable = EntreesSorties.lireBool("Entrez la variable emprntable. t pour oui f pour non : :");
        
        this.incrementationNbEx();
        
        Exemplaire e = new Exemplaire(this, empruntable, dateReception, dernierExemplaire);
    }
}
                       