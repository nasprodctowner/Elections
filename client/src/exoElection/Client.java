package exoElection;

import exoElection.session.VoteItf;

import javax.naming.InitialContext;
import java.util.Scanner;

public class Client {

    private static VoteItf refVoteBean;

    public static void main(String[] args) throws Exception {


        try {

            InitialContext ctx = new InitialContext();
            refVoteBean = (VoteItf) ctx.lookup("VOTE");
        } catch (Exception ex) {
            System.err.println("erreur dans le lookup");
            ex.printStackTrace();
        }


        Scanner scanner = new Scanner(System.in);
        System.out.println("bonjour, identifiez-vous SVP : ?");
        int numero = scanner.nextInt();

        if (refVoteBean.identifier(numero)){
            System.out.println("voter pour une liste : ");
            int idListe = scanner.nextInt();

            if(refVoteBean.voter(idListe)){
                System.out.println("votre vote a été enregistré merci ");
            }else {
                System.out.println("La liste n'est pas bonne, désolé");
            }
        }else{
            System.out.println("Votre numéro est faux");
        }

        /*
        System.out.println("Pour consulter les résultats taper 1 ou 2");
        int choix = scanner.nextInt();

        switch (choix){
            case 1 :
                System.out.println(refVoteBean.consulter());
        }*/


    }
}
