package rodde.airbnb.Menu;

import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Traveler;

public class TravellersManagement {

    public static void listTravelersMenu() {
        Uti.info("GestionVoyageurs","listerVoyageurs","");
        Uti.sep("-", 50);
        indexOfDisplayedTraveler();
        System.out.println("Saisir une option");
        System.out.println("1 : Ajouter un voyageur");
        System.out.println("2 : Supprimer un voyageur");
        System.out.println("3 : Retour");
        switch (Menu.choice(3)) {
            case 1:
                Menu.sc.nextLine();
                try {
                    addTraveler();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    listTravelersMenu();
                }
                break;
            case 2:
                Menu.sc.nextLine();
                try {
                    deleteTraveler();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    listTravelersMenu();
                }
                break;
            case 3:
                Menu.sc.nextLine();

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Menu.choice(3));
        }
    }

    protected static void addTraveler() throws Exception {
        Uti.info("GestionVoyageurs","ajouterVoyageur()","");

        boolean bOk = false;

        String prenom = "";
        String nom = "";
        int age = -1;
        Traveler voyageurAjoute;
        // affichage liste des hotes

        //        Menu.getListeHotes().forEach(voyageur->voyageur.afficher());
        indexOfDisplayedTraveler();
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
        voyageurAjoute= new Traveler(nom,prenom,age);
        // ajout d'un voyageur à la liste des voyageurs
        Menu.getTravelerArrayList().add(voyageurAjoute);
        // affiche la liste de tous les voyageurs
        indexOfDisplayedTraveler();
    }
    protected static void deleteTraveler() throws Exception{
        Uti.info("GestionVoyageurs","supprimerVoyageur()","");
        if(Menu.getTravelerArrayList().isEmpty()){
            System.out.println("Aucun voyageur à supprimer, la liste est vide.");
        }
        else
        {
            boolean bOk = false;
            int indiceSuppr=0;
            //        Menu.getListeVoyageurs().forEach(voyageur -> voyageur.afficher());
            indexOfDisplayedTraveler();
            // saisie indice
            while (!bOk) {
                try {
                    System.out.print("Entrer l'indice': ");
                    indiceSuppr = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (indiceSuppr >= 0 && indiceSuppr <= (Menu.getTravelerArrayList().size()-1)) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un indice compris entre 0 et "+ (Menu.getTravelerArrayList().size()-1));
                }
                indexOfDisplayedTraveler();
                //            Menu.getListeVoyageur().forEach(voyageur->voyageur.afficher());
            }
            System.out.println();
            Menu.getTravelerArrayList().remove(indiceSuppr);
            indexOfDisplayedTraveler();
        }

    }
    protected static void indexOfDisplayedTraveler(){
        /**
         * display the list's element with index and call the
         * display method of this element and go to the next line
         */
        Uti.info("GestionVoyageurs","indiceVoyageurAffiche()","");
        // affiche la liste de tous les voyageurs
        int indiceAffi=0;
        for(Traveler voyageur:Menu.getTravelerArrayList()){
            System.out.print(indiceAffi+". ");
            voyageur.display();
            System.out.println();
            indiceAffi++;
        }
    }
}
