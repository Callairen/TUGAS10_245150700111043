import java.util.*;

public class FutsalUtils {

    public static void sortByHeight(Player[] team, boolean ascending) {
        Arrays.sort(team, Comparator.comparingInt(p -> p.height));
        if (!ascending) Collections.reverse(Arrays.asList(team));
    }

    public static void sortByWeight(Player[] team, boolean ascending) {
        Arrays.sort(team, Comparator.comparingInt(p -> p.weight));
        if (!ascending) Collections.reverse(Arrays.asList(team));
    }

    public static void printMinMax(Player[] team, String name) {
        int minHeight = Integer.MAX_VALUE, maxHeight = Integer.MIN_VALUE;
        int minWeight = Integer.MAX_VALUE, maxWeight = Integer.MIN_VALUE;

        for (Player p : team) {
            if (p.height < minHeight) minHeight = p.height;
            if (p.height > maxHeight) maxHeight = p.height;
            if (p.weight < minWeight) minWeight = p.weight;
            if (p.weight > maxWeight) maxWeight = p.weight;
        }

        System.out.println("-- Min Max untuk " + name + " --");
        System.out.println("Tinggi Min: " + minHeight + ", Tinggi Max: " + maxHeight);
        System.out.println("Berat Min: " + minWeight + ", Berat Max: " + maxWeight);
    }

    public static Player[] copyTeam(Player[] team) {
        Player[] copy = new Player[team.length];
        for (int i = 0; i < team.length; i++) {
            copy[i] = new Player(team[i].height, team[i].weight);
        }
        return copy;
    }

    public static void searchByHeight(ArrayList<Player> team, int target) {
        team.sort(Comparator.comparingInt(p -> p.height));
        int index = Collections.binarySearch(team, new Player(target, 0), Comparator.comparingInt(p -> p.height));
        System.out.println("Binary Search tinggi " + target + ": " + (index >= 0 ? "Ditemukan" : "Tidak ditemukan"));
    }

    public static void countByWeight(ArrayList<Player> team, int target) {
        int count = 0;
        for (Player p : team) {
            if (p.weight == target) count++;
        }
        System.out.println("Jumlah pemain dengan berat " + target + " kg: " + count);
    }

    public static void checkSameWeights(ArrayList<Player> teamA, ArrayList<Player> teamB) {
        Set<Integer> weightsA = new HashSet<>();
        for (Player p : teamA) weightsA.add(p.weight);

        for (Player p : teamB) {
            if (weightsA.contains(p.weight)) {
                System.out.println("Ada berat badan sama antara Tim A dan Tim B: " + p.weight + " kg");
                return;
            }
        }
        System.out.println("Tidak ada berat badan yang sama antara Tim A dan Tim B.");
    }
}
