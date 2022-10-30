public class Main {




    public static void main(String[] args) throws Exception {



        int checkMenu = 0;

        while (checkMenu != 3) {

            DiaryService.printMainMenu();
            checkMenu = DiaryService.scanner.nextInt();

            switch (checkMenu) {
                case 1:
                    DiaryService.readDiaryPost();
                    break;

                case 2:
                    DiaryService.writeDiaryPost();
                    break;


                case 3:
                    System.out.println("Ok, då avslutas programmet");
                    break;

            }



        }

    }

}