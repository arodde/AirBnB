package rodde.airbnb.Menu;

import rodde.airbnb.util.Uti;
import rodde.airbnb.utilisateurs.Host;

public class HostsManagement {
    /**
     this class manages the menu in console menu for add, delete operations
     */
    public static void listHostsMenu() {
        /**
         displays the host' menu
         */
        Uti.info("GestionHotes","listerHotes()","");
        Uti.sep("-", 50);
        System.out.println("Saisir une option");
        System.out.println("1 : Ajouter un hôte");
        System.out.println("2 : Supprimer un hôte");
        System.out.println("3 : Retour");
        switch (Menu.choiceValueInTheList(3)) {
            case 1:
                Menu.sc.nextLine();
                try {
                    addHost();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    listHostsMenu();
                }

                break;
            case 2:
                Menu.sc.nextLine();
                try {
                    deleteHost();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    listHostsMenu();
                }

                break;
            case 3:
                Menu.sc.nextLine();

                break;

            default:
                throw new IllegalStateException("Unexpected value: " + Menu.choiceValueInTheList(3));
        }
    }


    protected static void addHost() throws Exception {
        Uti.info("GestionHotes","ajouterHote()","");
        boolean bOk = false;

        String firstname = "";
        String surname = "";
        int age = -1;
        Host addedHost;
        // affichage liste des hotes

        Menu.getHostArrayList().forEach(hote->hote.display());

        // saisie nom et prénom
        System.out.print("Entrer le prénom: ");
        firstname = Menu.sc.nextLine();
        System.out.print("Entrer le nom: ");
        surname = Menu.sc.nextLine();

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
            indexOfDisplayedHost();
        }
        // instanciation hôte
        addedHost= new Host(surname,firstname,age,48);
        // ajout d'un hote à la liste des hotes
        Menu.getHostArrayList().add(addedHost);
        // affiche la liste de tous les hôtes
//            Menu.getListeHotes().forEach(hote->hote.afficher());
        indexOfDisplayedHost();
    }
    protected static void indexOfDisplayedHost(){
        /**
         * display the list's element with index and call the
         * display method of this element and go to the next line
         */
        Uti.info("GestionHotes","indiceHoteAffiche()","");
        // affiche la liste de tous les hôtes
        int displayedIndex=0;
        for(Host hote:Menu.getHostArrayList()){
            System.out.print("n° "+displayedIndex+" : ");
            hote.display();
            System.out.println();
            displayedIndex++;
        }
    }


    protected static void deleteHost() throws Exception{
        Uti.info("GestionHotes","supprimerHote()","");

        boolean bOk = false;

        int deleteIndex=0;
//        Menu.getListeHotes().forEach(hote -> hote.afficher());
        if(Menu.getHostArrayList().isEmpty()){
            System.out.println("Aucun hôte à supprimer, la liste est vide.");
        }
        else
        {
            indexOfDisplayedHost();
            while (!bOk) {
                try {
                    System.out.print("Entrer l'indice': ");
                    deleteIndex = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (deleteIndex >= 0 && deleteIndex <= (Menu.getHostArrayList().size()-1)) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un indice compris entre 0 et "+ (Menu.getHostArrayList().size()-1));
                }



                indexOfDisplayedHost();
            }
            System.out.println();
            Menu.getHostArrayList().remove(deleteIndex);
            indexOfDisplayedHost();

        }

    }
}