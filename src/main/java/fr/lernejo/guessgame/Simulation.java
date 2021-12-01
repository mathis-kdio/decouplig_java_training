package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long number = this.player.askNextGuess();
        if (number == numberToGuess) {
            logger.log("Partie terminée");
            return true;
        }
        else{
            this.player.respond(number > numberToGuess);
            return false;
        }
    }

    public void loopUntilPlayerSucceed(long maxIter) {
        boolean res;
        long timeStart = System.currentTimeMillis();
        logger.log("Début de la partie");
        for (int i = 0; i < maxIter; i++) {
            res = nextRound();
            if (res == true)
                break;
        }
        long timeEnd = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
        String formatted = sdf.format(new Date(timeEnd - timeStart));
        logger.log(formatted);
    }
}
