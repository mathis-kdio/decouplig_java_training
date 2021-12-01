package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        // long randomNumber = random.nextLong(); // génère un nombre entre Long.MIN_VALUE et Long.MAX_VALUE
        long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
        if (args[0].equals("-interactive")) {
            Simulation simulation = new Simulation(new HumanPlayer());
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }
        else if (args[0].equals("-auto")){
            Simulation simulation = new Simulation(new ComputerPlayer());
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Integer.parseInt(args[1]));
        }
        else {
            System.out.println("Il manque un argument\n -interactive si vous voulez jouer\n -auto pour laisser le robot");
        }
    }
}
