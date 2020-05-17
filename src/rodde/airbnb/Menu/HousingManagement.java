package rodde.airbnb.Menu;

import rodde.airbnb.logements.Appartment;
import rodde.airbnb.logements.Housing;
import rodde.airbnb.logements.House;
import rodde.airbnb.util.Uti;

public class HousingManagement {
    /**
     this class manages the menu in console menu for add, delete operations
     */
    protected static void indexOfDisplayedHousing() {
        /**
         * display the list's element with index and call the
         * display method of this element and go to the next line
         */
        Uti.info("GestionLogements","indiceLogementAffiche()","");
        // affiche la liste de tous les logements
        int indiceAffi = 0;
        for (Housing logement : Menu.getHousingArrayList()) {
            System.out.print(indiceAffi + ". ");
            logement.display();            System.out.println();

            indiceAffi++;
        }
    }
    public static void listHousingsMenu() {
        /**
         displays the housings' menu
         */
        Uti.info("GestionLogements","listerLogements()","");
        Uti.sep("-", 50);
        System.out.println("Saisir une option");
        System.out.println("1 : Ajouter un logement");
        System.out.println("2 : Supprimer un logement");
        System.out.println("3 : Retour");
        switch (Menu.choiceValueInTheList(3)) {
            case 1:
                Menu.sc.nextLine();
                try {
                    addHousing();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    listHousingsMenu();
                }

                break;
            case 2:
                Menu.sc.nextLine();
                try {
                    deleteHousing();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    listHousingsMenu();
                }

                break;
            case 3:
                Menu.sc.nextLine();

                break;

            default:
                throw new IllegalStateException("Unexpected value: " + Menu.choiceValueInTheList(3));
        }
    }

    protected static void addHouse() {
        Uti.info("GestionLogements","ajouterMaison()","");
        boolean bOk = false;
        int numeroHote = -1;
        int tarifJournalier = 0;
        int superficie = 0;
        int superficieJardin = 0;
        int nombreVoyageursMax = 0;
        boolean possedePiscine = false;
        String repBoolPiscine = "";
        String adresseHote = "";
        if (Menu.getHostArrayList().isEmpty()) {
            System.out.println("Aucun hôte enregistré, Tout logement doit être rattaché à un hôte");

        } else {
            HostsManagement.indexOfDisplayedHost();
            while (!bOk) {
                try {
                    System.out.print("Entrer le numéro de l'hôte': ");
                    numeroHote = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (numeroHote >= 0 && numeroHote <= (Menu.getHostArrayList().size()-1)) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un numero d'hôte saisi en chiffre(s) et positif");
                }
            }
            bOk=false;
            while (!bOk) {
                try {
                    System.out.print("Entrer le tarif journalier': ");
                    tarifJournalier = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (tarifJournalier >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un tarif journalier saisi en chiffre(s) et positif");
                }
            }
            System.out.println("Entrer l'adresse de l'hôte:");
            adresseHote = Menu.sc.nextLine();
            bOk=false;
            while (!bOk) {
                try {
                    System.out.print("Entrer la superficie de la maison': ");
                    superficie = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (superficie >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut une superficie saisie en chiffre(s) et positive");
                }
            }
            bOk=false;
            while (!bOk) {
                try {
                    System.out.print("Entrer le nombre maximum de voyageurs': ");
                    nombreVoyageursMax = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (nombreVoyageursMax >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un nombre maximum de voyageurs saisi en chiffre(s) et positif");
                }
            }
            bOk=false;
            superficieJardin = 0;
            while (!bOk) {
                try {
                    System.out.print("Entrer la superficie du jardin': ");
                    superficieJardin = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (superficieJardin >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut une superficie du jardin saisie en chiffre(s) et positive");
                }
            }
            bOk= false;
            while (!bOk) {
                if (repBoolPiscine.contains("O") /*repBoolPiscine == "O" || repBoolPiscine == "o"*/) {
                    possedePiscine = true;
                    bOk = true;
                } else if (repBoolPiscine.contains("N") /*repBoolPiscine == "N" || repBoolPiscine == "n"*/){
                    possedePiscine = false;
                    bOk = true;
                } else {
                    System.out.println("La maison a t'elle une piscine? (O/N)");
                    repBoolPiscine = Menu.sc.nextLine().toUpperCase();
                    System.out.println(repBoolPiscine);
                }
            }
            House houseAjoute = new House(Menu.getHostArrayList().get(numeroHote), tarifJournalier,
                    adresseHote, superficie, nombreVoyageursMax,
                    superficieJardin, possedePiscine);
            Menu.getHousingArrayList().add(houseAjoute);
            indexOfDisplayedHousing();

        }
    }

    protected static void addAppartment() {
        Uti.info("GestionLogements", "ajouterAppartement()", "");
        boolean bOk = false;
        int numeroHote = -1;
        int tarifJournalier = 0;
        int superficie = 0;
        int numeroEtage = 0;
        int superficieBalcon = 0;
        int nombreVoyageursMax = 0;
        String adresseHote = "";
        if (Menu.getHostArrayList().isEmpty()) {
            System.out.println("Aucun hôte enregistré, Tout logement doit être rattaché à un hôte");
        } else {
            HostsManagement.indexOfDisplayedHost();
            bOk = false;
            while (!bOk) {
                try {
                    System.out.print("Entrer le numéro de l'hôte': ");
                    numeroHote = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (numeroHote >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un numero d'hôte saisi en chiffre(s) et positif");
                }
            }
            bOk = false;
            while (!bOk) {
                try {
                    System.out.print("Entrer le tarif journalier': ");
                    tarifJournalier = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (tarifJournalier >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un tarif journalier saisi en chiffre(s) et positif");
                }
            }
            System.out.println("Entrer l'adresse de l'hôte:");
            adresseHote = Menu.sc.nextLine();
            bOk = false;
            while (!bOk) {
                try {
                    System.out.print("Entrer la superficie de l'appartement': ");
                    superficie = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (superficie >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut une superficie saisie en chiffre(s) et positive");
                }
            }
            bOk = false;
            while (!bOk) {
                try {
                    System.out.print("Entrer le nombre maximum de voyageurs': ");
                    nombreVoyageursMax = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (nombreVoyageursMax >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un nombre maximum de voyageurs saisi en chiffre(s) et positif");
                }
            }
            bOk = false;
            numeroEtage = 0;
            while (!bOk) {
                try {
                    System.out.print("Entrer le numéro de l'étage: ");
                    numeroEtage = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (numeroEtage >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un numéro d'étage saisie en chiffre(s) et positive");
                }
            }
            bOk = false;
            superficieBalcon = 0;
            while (!bOk) {
                try {
                    System.out.print("Entrer la superficie du balcon: ");
                    superficieBalcon = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (superficieBalcon >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut une superficie du balcon saisie en chiffre(s) et positive");
                }
            }
            Appartment appartementAjoute =
                    new Appartment(Menu.getHostArrayList().get(numeroHote),
                            tarifJournalier, adresseHote, superficie,
                            nombreVoyageursMax, numeroEtage, superficieBalcon);
            Menu.getHousingArrayList().add(appartementAjoute);
            indexOfDisplayedHousing();

      /*
        }if (Menu.getListeHotes().isEmpty()) {
            System.out.println("Aucun hôte enregistré, Tout logement doit être rattaché à un hôte");
        } else {
            // afficher la liste des hôtes
            GestionHotes.indiceHoteAffiche();
            // saisie nombre de voyageurs
            bOk=false;
            while (!bOk) {
                try {
                    System.out.print("Entrer le numéro de l'hôte': ");
                    numeroHote = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (numeroHote >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un numero d'hôte saisi en chiffre(s) et positif");
                }
            }
            // tarif journalier
            bOk=false;
            while (!bOk) {
                try {
                    System.out.print("Entrer le tarif journalier': ");
                    tarifJournalier = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (tarifJournalier >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un tarif journalier saisi en chiffre(s) et positif");
                }
            }
            // adresse Hôte
            adresseHote = Menu.sc.nextLine();
            // superficie
            bOk=false;
            while (!bOk) {
                try {
                    System.out.print("Entrer la superficie': ");
                    superficie = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (superficie >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut une superficie saisie en chiffre(s) et positive");
                }
            }
            // nombre voyageurs max
            bOk=false;
            while (!bOk) {
                try {
                    System.out.print("Entrer le nombre maximum de voyageurs': ");
                    nombreVoyageursMax = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (nombreVoyageursMax >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un nombre maximum de voyageurs saisi en chiffre(s) et positif");
                }
            }
            // numéro etage
            bOk=false;
            numeroEtage = 0;
            while (!bOk) {
                try {
                    System.out.print("Entrer la superficie': ");
                    numeroEtage = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (numeroEtage >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un numéro d'étage saisie en chiffre(s) et positive");
                }
            }
            // superficie balcon
            bOk=false;
            superficieBalcon = 0;
            while (!bOk) {
                try {
                    System.out.print("Entrer la superficie': ");
                    superficieBalcon = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (superficieBalcon >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut une superficie du balcon saisie en chiffre(s) et positive");
                }
            }

            // instanciation maison
            Appartement appartementAjoute =
                    new Appartement(Menu.getListeHotes().get(numeroHote),
                            tarifJournalier, adresseHote, superficie,
                            nombreVoyageursMax, numeroEtage, superficieBalcon);
            // ajout d'un hote à la liste des hotes
            Menu.getListeLogements().add(appartementAjoute);
            // affiche la liste de tous les logement
//            Menu.getListeLogement().forEach(logement->logement.afficher());
            indiceLogementAffiche();

        }
        */
        }
    }
    protected static void addHousing() {
        Uti.info("GestionLogements","ajouterLogement()","");

        Uti.sep("-", 50);
        System.out.println("Saisir une option");
        System.out.println("1 : Ajouter un maison");
        System.out.println("2 : Supprimer un appartement");
        System.out.println("3 : Retour");
        switch (Menu.choiceValueInTheList(3)) {
            case 1:
                Menu.sc.nextLine();
                addHouse();
                break;
            case 2:
                Menu.sc.nextLine();
                addAppartment();
                break;
            case 3:
                Menu.sc.nextLine();
                listHousingsMenu();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Menu.choiceValueInTheList(3));
        }
    }


    protected static void deleteHousing()  {
        Uti.info("GestionLogements","supprimerLogement()","");
        if(Menu.getHousingArrayList().isEmpty()){
            System.out.println("Aucun logement à supprimer, la liste est vide.");
        }
        else
        {
            boolean bOk = false;

            int indiceSuppr = 0;
            //  Menu.getListeLogements().forEach(logement -> logement.afficher());

            indexOfDisplayedHousing();
            // saisie indice
            while (!bOk) {
                try {
                    System.out.print("Entrer l'indice': ");
                    indiceSuppr = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (indiceSuppr >= 0 && indiceSuppr <= (Menu.getHousingArrayList().size() - 1)) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un indice compris entre 0 et " + (Menu.getHousingArrayList().size() - 1));
                }
                // affiche la liste de tous les logements
                indexOfDisplayedHousing();
                //  Menu.getListeLogements().forEach(logement->logement.afficher());
            }
            System.out.println();
            Menu.getHousingArrayList().remove(indiceSuppr);
            indexOfDisplayedHousing();
        }
    }


}
