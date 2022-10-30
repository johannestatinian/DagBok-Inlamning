import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiaryService {


    static Scanner scanner = new Scanner(System.in);
    static ObjectMapper mapper = new ObjectMapper();

    static List<Post> posts;

    static {
        try {
            posts = List.of(mapper.readValue(Paths.get("diary-uploads.json").toFile(), Post[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static List<Post> tempPost = new ArrayList<>();


    /**
     *
     * @throws IOException Metod för att läsa upp inläggen som finns, foreach loop för att loopa igenom alla inlägg,
     * och hämta titel, inläggstext och datum inlägget skapades
     */
    static void readDiaryPost() throws IOException {
        System.out.println("Här är alla inlägg: " + "\n");
        List<Post> tempPosts = List.of(DiaryService.mapper.readValue(Paths.get("diary-uploads.json").toFile(), Post[].class));
        for (Post post : tempPosts) {
            System.out.println("Titel: " + post.getTitle());
            System.out.println("Text: " + post.getDiaryText());
            System.out.println("Datum: " + post.getDate() + "\n");
        }
    }


    /**
     *
     * @throws Exception Metod för att skapa inlägg. Scanner används för att sätta värde på titel och inläggstext.
     * Sedan skickas användares värden in i json-fil med alla inlägg (diary-uploads.json)
     * Efter det visas användarens inlägg med hjälp av en for-loop
     */
    static void writeDiaryPost() throws Exception {
        posts = List.of(mapper.readValue(Paths.get("diary-uploads.json").toFile(), Post[].class));
        Post post = new Post();
        tempPost.addAll(posts);


        System.out.println("Titel: ");
        scanner.nextLine();

        post.setTitle(scanner.nextLine());

        scanner.reset();

        System.out.println("Skriv in ditt inlägg: ");

        post.setDiaryText(scanner.nextLine());
        post.setDate(LocalDate.now().toString());
        tempPost.add(post);

        mapper.writeValue(Paths.get("diary-uploads.json").toFile(), tempPost);


        //Skriver ut användarens inlägg efter att användaren lagt upp
        for (int i=0; i<1; i++) {
            System.out.println("Titel: " + post.getTitle());
            System.out.println("Text: " + post.getDiaryText());
            System.out.println("Datum: " + post.getDate() + "\n");
        }



    }


    /**
     * Metod som används varje gång menyn ska visas
     */
    static void printMainMenu() {
        System.out.println("\n" + "1. Läs dagbok");
        System.out.println("2. Skriv inlägg");
        System.out.println("3. Avsluta programmet" + "\n");
    }


}
