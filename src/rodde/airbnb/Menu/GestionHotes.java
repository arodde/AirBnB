package rodde.airbnb.Menu;

import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Hote;

public class GestionHotes {

    public static void menuListerHotes() {
        Uti.info("GestionHotes","listerHotes()","");
        Uti.sep("-", 50);
        System.out.println("Saisir une option");
        System.out.println("1 : Ajouter un hôte");
        System.out.println("2 : Supprimer un hôte");
        System.out.println("3 : Retour");
        switch (Menu.choix(3)) {
            case 1:
                Menu.sc.nextLine();
                try {
                    ajouterHote();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    menuListerHotes();
                }

                break;
            case 2:
                Menu.sc.nextLine();
                try {
                    supprimerHote();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    menuListerHotes();
                }

                break;
            case 3:
                Menu.sc.nextLine();

                break;

            default:
                throw new IllegalStateException("Unexpected value: " + Menu.choix(3));
        }
    }


    protected static void ajouterHote() throws Exception {
        Uti.info("GestionHotes","ajouterHote()","");
        boolean bOk = false;

        String prenom = "";
        String nom = "";
        int age = -1;
        Hote hoteAjoute;
        // affichage liste des hotes

        Menu.getListeHotes().forEach(hote->hote.afficher());

        // saisie nom et prénom
        System.out.print("Entrer le prénom: ");
        prenom = Menu.sc.nextLine();
        System.out.print("Entrer le nom: ");
        nom = Menu.sc.nextLine();

        // saisie age
        while (!bOk) {
            try {
                System.out.print("Entrer l'âge': ");
                age = Menu.sc.nextInt();
                Menu.sc.nextLine();
                if (age >= 0) {
                    bOk = true;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("il faut un age saisi en chiffre(s) et positif");
            }
            indiceHoteAffiche();
        }
        // instanciation hôte
        hoteAjoute= new Hote(nom,prenom,age,48);
        // ajout d'un hote à la liste des hotes
        Menu.getListeHotes().add(hoteAjoute);
        // affiche la liste de tous les hôtes
//            Menu.getListeHotes().forEach(hote->hote.afficher());
        indiceHoteAffiche();
    }
    protected static void indiceHoteAffiche(){
        Uti.info("GestionHotes","indiceHoteAffiche()","");
        // affiche la liste de tous les hôtes
        int indiceAffi=0;
        for(Hote hote:Menu.getListeHotes()){
            System.out.print("n° "+indiceAffi+" : ");
            hote.afficher();
            System.out.println();
            indiceAffi++;
        }
    }

    protected static void supprimerHote() throws Exception{
        Uti.info("GestionHotes","supprimerHote()","");

        boolean bOk = false;

        int indiceSuppr=0;
//        Menu.getListeHotes().forEach(hote -> hote.afficher());
        if(Menu.getListeHotes().isEmpty()){
            System.out.println("Aucun hôte à supprimer, la liste est vide.");
        }
        else
        {
            indiceHoteAffiche();
            // saisie indice
            while (!bOk) {
                try {
                    System.out.print("Entrer l'indice': ");
                    indiceSuppr = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (indiceSuppr >= 0 && indiceSuppr <= (Menu.getListeHotes().size()-1)) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un indice compris entre 0 et "+ (Menu.getListeHotes().size()-1));
                }



                // affiche la liste de tous les hôtes
                indiceHoteAffiche();
//            Menu.getListeHotes().forEach(hote->hote.afficher());
            }
            System.out.println();
            Menu.getListeHotes().remove(indiceSuppr);
            indiceHoteAffiche();

        }

    }
}