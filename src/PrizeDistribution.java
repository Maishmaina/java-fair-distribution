package src;
import java.util.*;

public class PrizeDistribution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter comma-separated list of prizes' values: ");
        String prizesInput = scanner.nextLine();
        String[] prizesArray = prizesInput.split(",");

        System.out.print("Enter comma-separated names of winners: ");
        String winnersInput = scanner.nextLine();
        String[] winnersArray = winnersInput.split(",");

        Map<String, List<String>> prizeDistribution = distributePrizes(prizesArray, winnersArray);

        for (Map.Entry<String, List<String>> entry : prizeDistribution.entrySet()) {
            String winner = entry.getKey();
            List<String> prizes = entry.getValue();
            System.out.println(winner + ":" + String.join(",", prizes));
        }

        scanner.close();
    }

    public static Map<String, List<String>> distributePrizes(String[] prizes, String[] winners) {
        List<String> shuffledPrizes = Arrays.asList(prizes);
        Collections.shuffle(shuffledPrizes);

        Map<String, Integer> winnerValues = new HashMap<>();
        for (String winner : winners) {
            winnerValues.put(winner, 0);
        }

        for (String prize : shuffledPrizes) {
            String winnerWithMinValue = getWinnerWithMinValue(winnerValues);
            winnerValues.put(winnerWithMinValue, winnerValues.get(winnerWithMinValue) + Integer.parseInt(prize));
        }

        Map<String, List<String>> result = new HashMap<>();
        for (String winner : winners) {
            result.put(winner, new ArrayList<>());
        }

        for (String prize : prizes) {
            String winnerWithMinValue = getWinnerWithMinValue(winnerValues);
            result.get(winnerWithMinValue).add(prize);
            winnerValues.put(winnerWithMinValue, winnerValues.get(winnerWithMinValue) + Integer.parseInt(prize));
        }

        return result;
    }

    private static String getWinnerWithMinValue(Map<String, Integer> winnerValues) {
        String winnerWithMinValue = null;
        int minValue = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : winnerValues.entrySet()) {
            if (entry.getValue() < minValue) {
                minValue = entry.getValue();
                winnerWithMinValue = entry.getKey();
            }
        }
        return winnerWithMinValue;
    }
}
