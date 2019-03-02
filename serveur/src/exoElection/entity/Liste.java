package exoElection.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Table(name = "test.LISTE")
public class Liste implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idListe;
	private Collection<Vote> lesVotes;

    public Liste() {
    }

    public int getIdListe() {
        return idListe;
    }

    public void setIdListe(int id) {
        this.idListe = id;
    }

    @OneToMany(targetEntity = Vote.class,cascade=CascadeType.ALL)
    @JoinTable(
            name = "test.LISTE_VOTE",
            joinColumns = @JoinColumn(name = "LISTE_idListe"),
            inverseJoinColumns = @JoinColumn(name = "LESVOTES_id"))
	public Collection<Vote> getLesVotes() {
        return lesVotes ;
    }

    public void setLesVotes(Collection<Vote> lesVotes) {
        this.lesVotes = lesVotes;
    }
}
