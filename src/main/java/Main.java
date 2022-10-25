import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static void printMainMenu() {
        System.out.println("\n" + "1. Läs dagbok");
        System.out.println("2. Skriv inlägg");
        System.out.println("3. Avsluta programmet" + "\n");
    }

    public static String readFileAsString(String file)throws Exception {
        //return new String(Files.readAllBytes(Paths.get(file)));
        //return new String(Files.readAllLines(Paths.get(file)).toString());

        return new String(Files.readAllBytes(Paths.get(file)));
    }

    private static void printRecentPost() {

    }



    public static void main(String[] args) throws Exception {


        Scanner scanner = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();

        List<Post> posts = List.of(mapper.readValue(Paths.get("diary-uploads.json").toFile(), Post[].class));
        List<Post> tempPost = new ArrayList<>();


        int checkMenu = 0;

        while (checkMenu != 3) {

            printMainMenu();
            checkMenu = scanner.nextInt();

            switch (checkMenu) {
                case 1:
                    System.out.println("Här är alla inlägg: " + "\n");
                    List<Post> tempPosts = List.of(mapper.readValue(Paths.get("diary-uploads.json").toFile(), Post[].class));
                    for (Post post : tempPosts) {
                        System.out.println("Titel: " + post.getTitle());
                        System.out.println("Text: " + post.getDiaryText());
                        System.out.println("Datum: " + post.getDate() + "\n");
                    }


                    break;

                case 2:
                    posts = List.of(mapper.readValue(Paths.get("diary-uploads.json").toFile(), Post[].class));
                    Post post = new Post();
                    tempPost.addAll(posts); // (*)


                    System.out.println("Titel: ");
                    //String title;
                    scanner.nextLine();
                    //title = scanner.nextLine();
                    post.setTitle(scanner.nextLine());

                    scanner.reset();

                    System.out.println("Skriv in ditt inlägg: ");
                    //String diaryText;
                    //diaryText = scanner.nextLine();
                    post.setDiaryText(scanner.nextLine());
                    post.setDate(LocalDate.now().toString());
                    tempPost.add(post);


                    mapper.writeValue(Paths.get("diary-uploads.json").toFile(), tempPost);
                    String file = "diary-uploads.json";
                    String json = readFileAsString(file);

                    //Skriver ut användarens inlägg efter att användaren lagt upp
                    for (int i=0; i<1; i++) {
                        System.out.println("Titel: " + post.getTitle());
                        System.out.println("Text: " + post.getDiaryText());
                        System.out.println("Datum: " + post.getDate() + "\n");
                    }









                    /*System.out.println("Skriv din titel här: ");
                    scanner.nextLine();
                    Post post = new Post();
                    post.setTitle(scanner.nextLine());

                    System.out.println("Skriv ditt inlägg här: ");
                    scanner.nextLine();
                    post.setDiaryText(scanner.nextLine());*/

                    break;


                case 3:
                    System.out.println("Ok, då avslutas programmet");
                    break;

            }



        }

    }

}