package exoElection.session;

import javax.ejb.Remote;

@Remote
public interface VoteItf {
	boolean identifier(int numElecteur);
    boolean voter(int idListe); 
	String consulter();
	public void makeList();
}
