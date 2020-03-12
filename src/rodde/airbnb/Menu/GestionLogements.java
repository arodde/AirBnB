package rodde.airbnb.Menu;

import rodde.airbnb.Main;
import rodde.airbnb.logements.Appartement;
import rodde.airbnb.logements.Logement;
import rodde.airbnb.logements.Maison;
import rodde.airbnb.util.Uti;

public class GestionLogements {

    protected static void indiceLogementAffiche () {
        Uti.info("GestionLogements","indiceLogementAffiche()","");
        // affiche la liste de tous les logements
        int indiceAffi = 0;
        for (Logement logement : Menu.getListeLogements()) {
            System.out.print(indiceAffi + ". ");
            logement.afficher();            System.out.println();

            indiceAffi++;
        }
    }
    public static void listerLogements() {
        Uti.info("GestionLogements","listerLogements()","");
        Uti.sep("-", 50);
        System.out.println("Saisir une option");
        System.out.println("1 : Ajouter un logement");
        System.out.println("2 : Supprimer un logement");
        System.out.println("3 : Retour");
        switch (Menu.choix(3)) {
            case 1:
                Menu.sc.nextLine();
                try {
                    ajouterLogement();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    listerLogements();
                }

                break;
            case 2:
                Menu.sc.nextLine();
                try {
                    supprimerLogement();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    listerLogements();
                }

                break;
            case 3:
                Menu.sc.nextLine();

                break;

            default:
                throw new IllegalStateException("Unexpected value: " + Menu.choix(3));
        }
    }

    protected static void ajouterMaison() {
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
        if (Menu.getListeHotes().isEmpty()) {
            System.out.println("Aucun hôte enregistré, Tout logement doit être rattaché à un hôte");

        } else {
            // afficher la liste des hôtes
            GestionHotes.indiceHoteAffiche();
            // saisie nombre de voyageurs
            while (!bOk) {
                try {
                    System.out.print("Entrer le numéro de l'hôte': ");
                    numeroHote = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (numeroHote >= 0 && numeroHote <= (Menu.getListeHotes().size()-1)) {
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
            System.out.println("Entrer l'adresse de l'hôte:");
            adresseHote = Menu.sc.nextLine();
            // superficie
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
            // superficie jardin
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
            // possède piscine
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
            //
            // instanciation maison
            Maison maisonAjoute = new Maison(Menu.getListeHotes().get(numeroHote), tarifJournalier,
                    adresseHote, superficie, nombreVoyageursMax,
                    superficieJardin, possedePiscine);
            // ajout d'un hote à la liste des hotes
            Menu.getListeLogements().add(maisonAjoute);
            // affiche la liste de tous les logement
//            Menu.getListeLogement().forEach(logement->logement.afficher());
            indiceLogementAffiche();

        }
    }

    protected static void ajouterAppartement() {
        Uti.info("GestionLogements", "ajouterAppartement()", "");
        boolean bOk = false;
        int numeroHote = -1;
        int tarifJournalier = 0;
        int superficie = 0;
        int numeroEtage = 0;
        int superficieBalcon = 0;
        int nombreVoyageursMax = 0;
        String adresseHote = "";
        if (Menu.getListeHotes().isEmpty()) {
            System.out.println("Aucun hôte enregistré, Tout logement doit être rattaché à un hôte");
        } else {
            // afficher la liste des hôtes
            GestionHotes.indiceHoteAffiche();
            // saisie nombre de voyageurs
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
            // tarif journalier
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
            // adresse Hôte
            System.out.println("Entrer l'adresse de l'hôte:");
            adresseHote = Menu.sc.nextLine();
            // superficie
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
            // nombre voyageurs max
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
            // numéro etage
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
            // superficie balcon
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
    protected static void ajouterLogement() {
        Uti.info("GestionLogements","ajouterLogement()","");

        Uti.sep("-", 50);
        System.out.println("Saisir une option");
        System.out.println("1 : Ajouter un maison");
        System.out.println("2 : Supprimer un appartement");
        System.out.println("3 : Retour");
        switch (Menu.choix(3)) {
            case 1:
                Menu.sc.nextLine();
                ajouterMaison();
                break;
            case 2:
                Menu.sc.nextLine();
                ajouterAppartement();
                break;
            case 3:
                Menu.sc.nextLine();
                listerLogements();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Menu.choix(3));
        }
    }


    protected static void supprimerLogement ()  {
        Uti.info("GestionLogements","supprimerLogement()","");
        if(Menu.getListeLogements().isEmpty()){
            System.out.println("Aucun logement à supprimer, la liste est vide.");
        }
        else
        {
            boolean bOk = false;

            int indiceSuppr = 0;
            //  Menu.getListeLogements().forEach(logement -> logement.afficher());

            indiceLogementAffiche();
            // saisie indice
            while (!bOk) {
                try {
                    System.out.print("Entrer l'indice': ");
                    indiceSuppr = Menu.sc.nextInt();
                    Menu.sc.nextLine();
                    if (indiceSuppr >= 0 && indiceSuppr <= (Menu.getListeLogements().size() - 1)) {
                        bOk = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("il faut un indice compris entre 0 et " + (Menu.getListeLogements().size() - 1));
                }
                // affiche la liste de tous les logements
                indiceLogementAffiche();
                //  Menu.getListeLogements().forEach(logement->logement.afficher());
            }
            System.out.println();
            Menu.getListeLogements().remove(indiceSuppr);
            indiceLogementAffiche();
        }
    }


}
