package exoElection.entity;


import javax.persistence.*;

@Entity
@Table(name = "test.VOTE")
public class Vote  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int age;
	private String categorie;

    public Vote() {
    }

    public Vote(int age, String categorie) {
        this.age = age;
        this.categorie = categorie;
    }


    public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
}
