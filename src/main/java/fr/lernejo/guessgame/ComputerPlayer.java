package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {
    Logger logger = LoggerFactory.getLogger("Computer");
    private long borneInf = 0;
    public long borneSup = 100;
    private long borneTmp = 50;

    public long askNextGuess() {
        borneTmp = (borneSup + borneInf) / 2;
        return borneTmp;
    }

    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            logger.log("C'est + petit");
            borneSup = borneTmp;
        }
        else {
            logger.log("C'est + grand");
            borneInf = borneTmp;
        }
    }
}
