package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {
    Logger logger = LoggerFactory.getLogger("Computer");
    private long borneInf = 0;
    public long borneSup = Long.MAX_VALUE;
    private long borneTmp = Long.MAX_VALUE / 2;

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
