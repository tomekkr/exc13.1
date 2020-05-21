import java.util.*;

class Test {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Player> results = new ArrayList<>();
            String input = "";

            do {
                System.out.println("Podaj wynik kolejnego gracza (lub stop):");
                input = scanner.nextLine();
                if (!(input.equalsIgnoreCase("stop"))) {
                    ResultsUtils.addPlayerToResults(results, input);
                }
            } while (!input.equalsIgnoreCase("stop"));

            Collections.sort(results);
            ResultsUtils.saveResultsToFile(results, "stats.csv");
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Wpisane dane są nieprawidłowe, poprawny schemat to: [imię] [nazwisko] [punkty]");
        }
    }
}

