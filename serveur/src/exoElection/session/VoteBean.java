package exoElection.session;

import exoElection.entity.Electeur;
import exoElection.entity.Liste;
import exoElection.entity.Vote;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Stateful(mappedName="VOTE")
public class VoteBean implements VoteItf {

    @PersistenceContext(unitName="electionsPU")
    private EntityManager em;


    private Electeur managedElecteur;
    private Liste managedListe;

    @Override
    public boolean identifier(int numElecteur) {
        boolean identified = false;
        try {
            Electeur e = em.find(Electeur.class, numElecteur);

            if (!e.getNom().isEmpty() && e.getAVote() == 'N') {
                identified = true;
                managedElecteur = em.merge(e);
            }
        }catch (Exception e){
            System.out.println("Il n'existe pas");
        }

        return identified;
    }

    @Override
    public boolean voter(int idListe) {

        Collection<Vote> votes = new ArrayList<>();

        Vote v = new Vote();
        votes.add(v);

        Liste liste = em.find(Liste.class,idListe);
        liste.setLesVotes(votes);

        Electeur e = em.find(Electeur.class,managedElecteur.getNumElecteur());
        v.setCategorie(e.getCategorie());
        v.setAge(e.getAge());
        e.setAVote('O');

        em.persist(v);

        return false;
    }

    @Override
    public String consulter() {
        return "";
    }


    public void makeList(){
        Liste liste = new Liste();


        ArrayList<Vote> votes = new ArrayList<>();
        votes.add(makeVote(30,"chomeur"));
        liste.setLesVotes(votes);

        em.persist(liste);
    }

    private Vote makeVote(int age, String sociaux) {
        Vote vote = new Vote(age,sociaux);
        vote.setId(3);
        em.persist(vote);
        return vote;

    }


}
