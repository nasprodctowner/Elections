package exoElection.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test.ELECTEUR")
public class Electeur  implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numElecteur;
    private String nom;
	private String prenom;
	private int age;
	private String categorie;
	private char aVote;

    public Electeur(String nom, String prenom, int age, String categorie, char aVote) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.categorie = categorie;
        this.aVote = aVote;
    }

    public Electeur() {
    }



    public int getNumElecteur() {
        return numElecteur;
    }

    public void setNumElecteur(int id) {
        this.numElecteur = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String n) {
        this.nom = n;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String n) {
        this.prenom = n;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int n) {
        this.age = n;
    }
	
    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String c) {
        this.categorie = c;
    }

    public char getAVote() {
        return aVote;
    }

    public void setAVote(char b) {
        this.aVote = b;
    }
}
