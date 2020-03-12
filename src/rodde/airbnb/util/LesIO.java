package rodde.airbnb.util;

//Package à importer afin d'utiliser l'objet File
import java.io.*;


public class LesIO {
    public void mlio1(){
        Uti.info("LesIO","mlio1","");

        //Création de l'objet File
        File f = new File("xyztest.txt");
        System.out.println("Chemin absolu du fichier : " + f.getAbsolutePath());
        System.out.println("Nom du fichier : " + f.getName());
        System.out.println("Est-ce qu'il existe ? " + f.exists());
        System.out.println("Est-ce un répertoire ? " + f.isDirectory());
        System.out.println("Est-ce un fichier ? " + f.isFile());
        System.out.println("Affichage des lecteurs à la racine du PC : ");
        for(File file : f.listRoots())
        {
            System.out.println(file.getAbsolutePath());
            try {
                int i = 1;
                //On parcourt la liste des fichiers et répertoires
                for(File nom : file.listFiles()){
                    //S'il s'agit d'un dossier, on ajoute un "/"
                    System.out.print("\t\t" + ((nom.isDirectory()) ? nom.getName()+"/" : nom.getName()));
                    if((i%4) == 0){
                        System.out.print("\n");
                    }
                    i++;
                }
                System.out.println("\n");
            } catch (NullPointerException e) {
                //L'instruction peut générer une NullPointerException
                //s'il n'y a pas de sous-fichier !
            } finally {
                f = null;
            }
        }
    }

    public void mlio2(){
        Uti.info("LesIO","mlio2","");
// Nous déclarons nos objets en dehors du bloc try/catch
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // On instancie nos objets :
            // fis va lire le fichier
            // fos va écrire dans le nouveau !
            fis = new FileInputStream(new File("xyztest.txt"));
            fos = new FileOutputStream(new File("xyztest2.txt"));

            // On crée un tableau de byte pour indiquer le nombre de bytes lus à
            // chaque tour de boucle
            byte[] buf = new byte[8];

            // On crée une variable de type int pour y affecter le résultat de
            // la lecture
            // Vaut -1 quand c'est fini
            int n = 0;

            // Tant que l'affectation dans la variable est possible, on boucle
            // Lorsque la lecture du fichier est terminée l'affectation n'est
            // plus possible !
            // On sort donc de la boucle
            while ((n = fis.read(buf)) >= 0) {
                // On écrit dans notre deuxième fichier avec l'objet adéquat
                fos.write(buf);
                // On affiche ce qu'a lu notre boucle au format byte et au
                // format char
                for (byte bit : buf) {
                    System.out.print("\t" + bit + "(" + (char) bit + ")");
                }
                System.out.println("");
                //Nous réinitialisons le buffer à vide
                //au cas où les derniers byte lus ne soient pas un multiple de 8
                //Ceci permet d'avoir un buffer vierge à chaque lecture et ne pas avoir de doublon en fin de fichier
                buf = new byte[8];

            }
            System.out.println("Copie terminée !");

        } catch (FileNotFoundException e) {
            // Cette exception est levée si l'objet FileInputStream ne trouve
            // aucun fichier
            e.printStackTrace();
        } catch (IOException e) {
            // Celle-ci se produit lors d'une erreur d'écriture ou de lecture
            e.printStackTrace();
        } finally {
            // On ferme nos flux de données dans un bloc finally pour s'assurer
            // que ces instructions seront exécutées dans tous les cas même si
            // une exception est levée !
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void mlio3(){
        Uti.info("LesIO","mlio3","");
    }
}
