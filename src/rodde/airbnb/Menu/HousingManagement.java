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
        int displayedIndex = 0;
        for (Housing housing : Menu.getHousingArrayList()) {
            System.out.print(displayedIndex + ". ");
            housing.display();
            System.out.println();
            displayedIndex++;
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
        int numberHost = -1;
        int daylyTarif = 0;
        int area = 0;
        int gardenArea = 0;
        int maxTravelersNumber = 0;
        boolean ownSwimmingPool = false;
        String repBoolPiscine = "";
        String addressHost = "";
        if (Menu.getHostArrayList().isEmpty()) {
            System.out.println("Aucun hôte enregistré, Tout logement doit être rattaché à un hôte");

        } else {
            HostsManagement.indexOfDisplayedHost();
            while (!bOk) {
                try {
                    System.out.print("Entrer le numéro de l'hôte': ");
                    numberHost = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (numberHost >= 0 && numberHost <= (Menu.getHostArrayList().size()-1)) {
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
                    daylyTarif = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (daylyTarif >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un tarif journalier saisi en chiffre(s) et positif");
                }
            }
            System.out.println("Entrer l'adresse de l'hôte:");
            addressHost = Menu.sc.nextLine();
            bOk=false;
            while (!bOk) {
                try {
                    System.out.print("Entrer la superficie de la maison': ");
                    area = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (area >= 0) {
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
                    maxTravelersNumber = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (maxTravelersNumber >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un nombre maximum de voyageurs saisi en chiffre(s) et positif");
                }
            }
            bOk=false;
            gardenArea = 0;
            while (!bOk) {
                try {
                    System.out.print("Entrer la superficie du jardin': ");
                    gardenArea = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (gardenArea >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut une superficie du jardin saisie en chiffre(s) et positive");
                }
            }
            bOk= false;
            while (!bOk) {
                if (repBoolPiscine.contains("O") /*repBoolPiscine == "O" || repBoolPiscine == "o"*/) {
                    ownSwimmingPool = true;
                    bOk = true;
                } else if (repBoolPiscine.contains("N") /*repBoolPiscine == "N" || repBoolPiscine == "n"*/){
                    ownSwimmingPool = false;
                    bOk = true;
                } else {
                    System.out.println("La maison a t'elle une piscine? (O/N)");
                    repBoolPiscine = Menu.sc.nextLine().toUpperCase();
                    System.out.println(repBoolPiscine);
                }
            }
            House houseAjoute = new House(Menu.getHostArrayList().get(numberHost), daylyTarif,
                    addressHost, area, maxTravelersNumber,
                    gardenArea, ownSwimmingPool);
            Menu.getHousingArrayList().add(houseAjoute);
            indexOfDisplayedHousing();

        }
    }

    protected static void addAppartment() {
        Uti.info("GestionLogements", "ajouterAppartement()", "");
        boolean bOk = false;
        int hostNumber = -1;
        int daylyTarif = 0;
        int area = 0;
        int floorNumber = 0;
        int balconyArea = 0;
        int maxTravelersNumber = 0;
        String hostAddress = "";
        if (Menu.getHostArrayList().isEmpty()) {
            System.out.println("Aucun hôte enregistré, Tout logement doit être rattaché à un hôte");
        } else {
            HostsManagement.indexOfDisplayedHost();
            bOk = false;
            while (!bOk) {
                try {
                    System.out.print("Entrer le numéro de l'hôte': ");
                    hostNumber = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (hostNumber >= 0) {
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
                    daylyTarif = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (daylyTarif >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un tarif journalier saisi en chiffre(s) et positif");
                }
            }
            System.out.println("Entrer l'adresse de l'hôte:");
            hostAddress = Menu.sc.nextLine();
            bOk = false;
            while (!bOk) {
                try {
                    System.out.print("Entrer la superficie de l'appartement': ");
                    area = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (area >= 0) {
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
                    maxTravelersNumber = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (maxTravelersNumber >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un nombre maximum de voyageurs saisi en chiffre(s) et positif");
                }
            }
            bOk = false;
            floorNumber = 0;
            while (!bOk) {
                try {
                    System.out.print("Entrer le numéro de l'étage: ");
                    floorNumber = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (floorNumber >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un numéro d'étage saisie en chiffre(s) et positive");
                }
            }
            bOk = false;
            balconyArea = 0;
            while (!bOk) {
                try {
                    System.out.print("Entrer la superficie du balcon: ");
                    balconyArea = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (balconyArea >= 0) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut une superficie du balcon saisie en chiffre(s) et positive");
                }
            }
            Appartment addedAppartment =
                    new Appartment(Menu.getHostArrayList().get(hostNumber),
                            daylyTarif, hostAddress, area,
                            maxTravelersNumber, floorNumber, balconyArea);
            Menu.getHousingArrayList().add(addedAppartment);
            indexOfDisplayedHousing();


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
