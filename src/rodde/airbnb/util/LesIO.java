package rodde.airbnb.util;

//Package à importer afin d'utiliser l'objet File
import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.Iterator;


public class LesIO {
    public void mlio1a(){
        /**
         creates a file object finds his absolutePath,
         says if it exists, says if it is a directory or a file


         */
        Uti.info("LesIO","mlio1a","");

        //Création de l'objet File
        File f = new File("xyztest.txt");
        System.out.println("Chemin absolu du fichier : " + f.getAbsolutePath());
        System.out.println("Nom du fichier : " + f.getName());
        System.out.println("Est-ce qu'il existe ? " + f.exists());
        System.out.println("Est-ce un répertoire ? " + f.isDirectory());
        System.out.println("Est-ce un fichier ? " + f.isFile());

    }
    public void mlio1b(){
        /**
         displays the list of the files and the directories of the root.
         displays the the contents of subdirectories.
         */

        Uti.info("LesIO","mlio1b","");
        File f = new File("xyztest2.txt");
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
        /**
         writes text in the file mydata.txt by using a buffer
         */
        Uti.info("LesIO","mlio3","");
        try {
            FileWriter fw = new FileWriter("mydata.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print("Hello ");
            pw.println("world !!!");
            pw.println("Fin du fichier");
            pw.close();
        } catch (Exception e) {
            System.err.println("error");
        }
    }
    public Path returnRelativePath(File file, String additionalPath){
        /**
         to get a relative path of an existing file in project.
         the additionalPaths allows to search the file in the
         sub directories' project
         */
        additionalPath ="miscelleanous/";
        Path relativePathInput = Paths.get(additionalPath+file);
        return relativePathInput;
    }
    public Path returnAbsolutePath(Path relativePath){
        return relativePath.toAbsolutePath();
    }
    public void copyFileInAnother() {
        /**

         opens one FileInputStream and one FileOutputStream
         copies the content of the first file in the second
         file
         the content of fOutput is replaced by the content of the inputFile
         */
        File fInput = new File("input.txt");
        File fOutput = new File("output.txt");
        String additionnalPath ="miscelleanous/";

        Path relativePathInput = Paths.get(additionnalPath+"input.txt");
        System.out.println("relativePathInput path: " + relativePathInput);
        Path absolutePathInput = relativePathInput.toAbsolutePath();
        System.out.println("absolutePathInput path: " + absolutePathInput);

        Path relativePathOutput = Paths.get(additionnalPath+"Output.txt");
        System.out.println("relativePathOutput path: " + relativePathOutput);
        Path absolutePathOutput = relativePathOutput.toAbsolutePath();
        System.out.println("absolutePathOutput path: " + absolutePathOutput);

        System.out.println("Chemin absolu du fichier : " + fInput.getAbsolutePath());
        System.out.println("Chemin absolu du fichier : " + fOutput.getAbsolutePath());


        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            try {
                in = new FileInputStream(additionnalPath+"input.txt");
            } catch (FileNotFoundException e) {
                System.out.println("fichier input.txt non trouvé");
                e.printStackTrace();
            }
            try {
                out = new FileOutputStream(additionnalPath+"output.txt");
            } catch (FileNotFoundException e) {
                System.out.println("fichier output.txt non trouvé");
                e.printStackTrace();
            }
            int c;
            while (true) {
                try {
                    if (!((c = in.read()) != -1)) break;
                    try {
                        out.write(c);
                    } catch (IOException e) {
                        System.out.println("opération d'écriture sur fichier output.txt compromise");
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    System.out.println("opération de lecture sur fichier input.txt compromise");
                    e.printStackTrace();
                }
            }
        }finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("anomalie sur fermeture sur fichier input.txt");
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println("anomalie sur fermeture sur fichier output.txt");
                    e.printStackTrace();
                }
            }
        }

    }
    public void test(){
        createNewRealFile( new File("C:\\Users\\demon\\IdeaProjects\\AirBnB\\miscelleanous\\"),"tirlipinpon.txt");

    }

    public void createNewRealFile(File parentFile,String fileName){
        /**
         creates a new file if the file doesn't exist in the path.
         the path is composed of rootProject and the additionalPath.
         */
          String s="";
            try {
                s = parentFile.getPath()+fileName;
                File f = new File(s);
                if (f.createNewFile())
                    System.out.println("File created");
                else
                    System.out.println("File already exists");
            } catch (Exception e) {
                System.out.println("Chemin : "+ s );
                System.err.println(e);
            }
    }
}
