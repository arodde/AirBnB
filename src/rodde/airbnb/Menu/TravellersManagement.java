package rodde.airbnb.Menu;

import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Traveler;

public class TravellersManagement {
    /**
     this class manages the menu in console menu for add, delete operations
     */
    public static void listTravelersMenu() {
        /**
         displays the travelers' menu
         */
        Uti.info("GestionVoyageurs","listerVoyageurs","");
        Uti.sep("-", 50);
        indexOfDisplayedTraveler();
        System.out.println("Saisir une option");
        System.out.println("1 : Ajouter un voyageur");
        System.out.println("2 : Supprimer un voyageur");
        System.out.println("3 : Retour");
        switch (Menu.choiceValueInTheList(3)) {
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
                throw new IllegalStateException("Unexpected value: " + Menu.choiceValueInTheList(3));
        }
    }

    protected static void addTraveler() throws Exception {
        /**
         add traveler in the list of travelers
         */
        Uti.info("GestionVoyageurs","ajouterVoyageur()","");

        boolean bOk = false;

        String prenom = "";
        String nom = "";
        int age = -1;
        Traveler voyageurAjoute;
        indexOfDisplayedTraveler();
        System.out.print("Entrer le prénom: ");
        prenom = Menu.sc.nextLine();
        System.out.print("Entrer le nom: ");
        nom = Menu.sc.nextLine();
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

        }
        voyageurAjoute= new Traveler(nom,prenom,age);
        Menu.getTravelerArrayList().add(voyageurAjoute);
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
        int indiceAffi=0;
        for(Traveler voyageur:Menu.getTravelerArrayList()){
            System.out.print(indiceAffi+". ");
            voyageur.display();
            System.out.println();
            indiceAffi++;
        }
    }
}
