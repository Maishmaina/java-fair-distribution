package src;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrizeDistributionTest {
    private PrizeDistribution prizeDistribution;

    @BeforeEach
    public void setUp() {
        prizeDistribution = new PrizeDistribution();
    }

    @Test
    public void testPrizeDistributionEqualTotalValues() {
        String[] prizes = {"100", "200", "300", "400"};
        String[] winners = {"Joshua", "Mahesh", "Lilian"};

        Map<String, List<String>> result = prizeDistribution.distributePrizes(prizes, winners);

        assertEquals(2, result.get("Joshua").size());
        assertEquals(2, result.get("Mahesh").size());
        assertEquals(0, result.get("Lilian").size());

        assertEquals(500, calculateTotalValue(result.get("Joshua")));
        assertEquals(500, calculateTotalValue(result.get("Mahesh")));
        assertEquals(0, calculateTotalValue(result.get("Lilian")));
    }

    private int calculateTotalValue(List<String> prizes) {
        int total = 0;
        for (String prize : prizes) {
            total += Integer.parseInt(prize);
        }
        return total;
    }
}
