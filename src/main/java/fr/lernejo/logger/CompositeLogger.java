package fr.lernejo.logger;

public class CompositeLogger implements Logger{
    private final Logger logger1;
    private final Logger logger2;

    public CompositeLogger(Logger logger1, Logger logger2) {
        this.logger1 = logger1;
        this.logger2 = logger2;
    }

    public void log(String message) {
        this.logger1.log(message);
        this.logger2.log(message);
    }
}
