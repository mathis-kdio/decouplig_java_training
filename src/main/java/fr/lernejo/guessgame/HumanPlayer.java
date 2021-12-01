package fr.lernejo.guessgame;

import java.util.Scanner;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class HumanPlayer implements Player {
    Logger logger = LoggerFactory.getLogger("player");

    public long askNextGuess() {
        Scanner sc = new Scanner(System.in);
        return Long.parseLong(sc.nextLine());
    }

    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            logger.log("C'est + petit");
        }
        else {
            logger.log("C'est + grand");
        }
    }
}
