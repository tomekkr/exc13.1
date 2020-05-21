import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class ResultsUtils {
    private ResultsUtils() {
    }

    public static void addPlayerToResults(List<Player> results, String input) {
        Player player = createPlayerFromUserInput(input);
        ResultsUtils.addPlayerIfNotDuplicated(results, player);
    }

    public static void saveResultsToFile(List<Player> results, String resultsFileName) {
        try (FileWriter fileWriter = new FileWriter(resultsFileName)) {
            for (Player result : results) {
                fileWriter.write(result.printInfo() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Player createPlayerFromUserInput(String input) {
        String[] elements = input.split(" ");
        int points = Integer.parseInt(elements[2]);
        return new Player(elements[0], elements[1], points);
    }

    private static void addPlayerIfNotDuplicated(List<Player> results, Player player) {
        if (!results.contains(player)) {
            results.add(player);
        }
    }
}
