// required imports

import java.io.*;
import java.nio.file.Path;

import static java.nio.file.Files.copy;



public class Main {
    public static void main(String[] args) throws IOException {

        try (FileReader fileReader = new FileReader("README.txt");
             BufferedReader reader = new BufferedReader(fileReader)) {

            // When there are no more lines, readLine() return null.
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        File file = new File("Elements.data");

        try {
            if (file.createNewFile()) {
                System.out.println("Elements data created.");
            } else {
                System.out.println("Elements data already exists.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();

        }

        File newFile = new File("bad-file.txt");

        try {
            if (newFile.createNewFile()) {
                System.out.println("bad-file.txt data created.");
            } else {
                System.out.println("bad-file.txt data already exists.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();

        }

        try (FileWriter fileWriter = new FileWriter("bad-file.txt", true);
             PrintWriter writer = new PrintWriter(fileWriter)) {
            writer.println("Oh, wow.");
            writer.println("This is a bad file.");
            writer.println("It should be deleted.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        File superBadFile = new File("super-bad-file.java");

        try {
            if (superBadFile.createNewFile()) {
                System.out.println("super-bad-file.java data created.");
            } else {
                System.out.println("super-bad-file.java data already exists.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();

        }


        boolean newFileSuccess = newFile.delete();
        if (newFileSuccess) {
            System.out.println("bad-file.txt was deleted.");
        } else {
            System.out.println("bad-file.txt was NOT deleted.");
        }

        boolean superBadSuccess = superBadFile.delete();
        if (superBadSuccess) {
            System.out.println("super-bad-file.java was deleted.");
        } else {
            System.out.println("super-bad-file.java was NOT deleted.");
        }


        boolean dontExistSuccess = new File("this-file-does-not-exist.txt").delete();
        if (dontExistSuccess) {
            System.out.println("this-file-does-not-exist.txt");
        } else {
            System.out.println("this-file-does-not-exist.txt was NOT deleted.");
        }


        File workingDirectory = new File("./destination");
        boolean successful = workingDirectory.mkdir();

        while(true) {
            try {
                copy(Path.of("another.data"), Path.of("./destination/new-elements-file.txt"));
                break;
            } catch (IOException ex) {
                ex.printStackTrace();

            }
        }

        while (true) {
            try {
                if (superBadFile.createNewFile()) {
                    System.out.println("super-bad-file.java data created.");
                } else {
                    System.out.println("super-bad-file.java data already exists.");
                }
            } catch (IOException ex) {
                ex.printStackTrace();

            }

        }



    }




}