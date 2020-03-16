package rodde.airbnb.Menu;

import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Voyageur;

public class GestionVoyageurs {

    public static void menuListerVoyageurs() {
        Uti.info("GestionVoyageurs","listerVoyageurs","");
        Uti.sep("-", 50);
        indiceVoyageurAffiche();
        System.out.println("Saisir une option");
        System.out.println("1 : Ajouter un voyageur");
        System.out.println("2 : Supprimer un voyageur");
        System.out.println("3 : Retour");
        switch (Menu.choix(3)) {
            case 1:
                Menu.sc.nextLine();
                try {
                    ajouterVoyageur();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    menuListerVoyageurs();
                }
                break;
            case 2:
                Menu.sc.nextLine();
                try {
                    supprimerVoyageur();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    menuListerVoyageurs();
                }
                break;
            case 3:
                Menu.sc.nextLine();

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Menu.choix(3));
        }
    }

    protected static void ajouterVoyageur() throws Exception {
        Uti.info("GestionVoyageurs","ajouterVoyageur()","");

        boolean bOk = false;

        String prenom = "";
        String nom = "";
        int age = -1;
        Voyageur voyageurAjoute;
        // affichage liste des hotes

        //        Menu.getListeHotes().forEach(voyageur->voyageur.afficher());
        indiceVoyageurAffiche();
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
//            listerVoyageurs();

        }
        // instanciation hôte
        voyageurAjoute= new Voyageur(nom,prenom,age);
        // ajout d'un voyageur à la liste des voyageurs
        Menu.getListeVoyageurs().add(voyageurAjoute);
        // affiche la liste de tous les voyageurs
        indiceVoyageurAffiche();
    }
    protected static void supprimerVoyageur() throws Exception{
        Uti.info("GestionVoyageurs","supprimerVoyageur()","");
        if(Menu.getListeVoyageurs().isEmpty()){
            System.out.println("Aucun voyageur à supprimer, la liste est vide.");
        }
        else
        {
            boolean bOk = false;
            int indiceSuppr=0;
            //        Menu.getListeVoyageurs().forEach(voyageur -> voyageur.afficher());
            indiceVoyageurAffiche();
            // saisie indice
            while (!bOk) {
                try {
                    System.out.print("Entrer l'indice': ");
                    indiceSuppr = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (indiceSuppr >= 0 && indiceSuppr <= (Menu.getListeVoyageurs().size()-1)) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un indice compris entre 0 et "+ (Menu.getListeVoyageurs().size()-1));
                }
                indiceVoyageurAffiche();
                //            Menu.getListeVoyageur().forEach(voyageur->voyageur.afficher());
            }
            System.out.println();
            Menu.getListeVoyageurs().remove(indiceSuppr);
            indiceVoyageurAffiche();
        }

    }
    protected static void indiceVoyageurAffiche(){
        Uti.info("GestionVoyageurs","indiceVoyageurAffiche()","");
        // affiche la liste de tous les voyageurs
        int indiceAffi=0;
        for(Voyageur voyageur:Menu.getListeVoyageurs()){
            System.out.print(indiceAffi+". ");
            voyageur.afficher();
            System.out.println();
            indiceAffi++;
        }
    }
}
