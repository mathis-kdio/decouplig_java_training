package fr.lernejo.logger;

public abstract class LoggerFactory implements Logger {
    public static Logger getLogger(String name) {
        return new CompositeLogger(new ContextualLogger(name, new ConsoleLogger()), new ContextualLogger(name, new FileLogger("src/main/java/fr/lernejo/logger/log.txt")));
    }
}
