import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Player[] teamA = {
            new Player(168, 50),
            new Player(170, 60),
            new Player(169, 66),
            new Player(165, 56),
            new Player(172, 60),
            new Player(170, 70),
            new Player(169, 66),
            new Player(165, 56),
            new Player(171, 72),
            new Player(166, 56),
        };

        Player[] teamB = {
            new Player(170, 66),
            new Player(167, 60),
            new Player(165, 59),
            new Player(166, 58),
            new Player(168, 58),
            new Player(175, 71),
            new Player(172, 68),
            new Player(171, 68),
            new Player(168, 65),
            new Player(169, 60),
        };

        runAllTests(teamA, teamB);
    }

    static void runAllTests(Player[] teamA, Player[] teamB) {
        System.out.println("\n===== TEST: Sorting =====");
        FutsalUtils.sortByHeight(teamA, true);
        FutsalUtils.sortByHeight(teamA, false);
        FutsalUtils.sortByWeight(teamB, true);
        FutsalUtils.sortByWeight(teamB, false);

        System.out.println("\n===== TEST: Min / Max =====");
        FutsalUtils.printMinMax(teamA, "Tim A");
        FutsalUtils.printMinMax(teamB, "Tim B");

        System.out.println("\n===== TEST: Copy Team B to C =====");
        Player[] teamC = FutsalUtils.copyTeam(teamB);
        printTeam(teamC, "Tim C");

        System.out.println("\n===== TEST: Binary Search Tinggi di Tim B =====");
        FutsalUtils.searchByHeight(new ArrayList<>(Arrays.asList(teamB)), 168);
        FutsalUtils.searchByHeight(new ArrayList<>(Arrays.asList(teamB)), 160);

        System.out.println("\n===== TEST: Count Berat Badan di Tim A =====");
        FutsalUtils.countByWeight(new ArrayList<>(Arrays.asList(teamA)), 56);
        FutsalUtils.countByWeight(new ArrayList<>(Arrays.asList(teamA)), 53);

        System.out.println("\n===== TEST: Cek Berat Badan Sama =====");
        FutsalUtils.checkSameWeights(new ArrayList<>(Arrays.asList(teamA)), new ArrayList<>(Arrays.asList(teamB)));
    }

    static void printTeam(Player[] team, String name) {
        System.out.println("Data " + name + ":");
        for (Player p : team) {
            System.out.println("Tinggi: " + p.height + " cm, Berat: " + p.weight + " kg");
        }
    }
}
