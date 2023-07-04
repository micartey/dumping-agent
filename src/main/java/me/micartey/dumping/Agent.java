package me.micartey.dumping;

import java.io.File;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class Agent {

    private static final File FOLDER = new File(".dump");

    public static void premain(String arguments, Instrumentation instrumentation) {
        instrumentation.addTransformer(new DumpClassTransformer(FOLDER));
    }

    public static void agentmain(String arguments, Instrumentation instrumentation) throws UnmodifiableClassException {
        instrumentation.addTransformer(new DumpClassTransformer(FOLDER), true);

        for (Class<?> clazz : instrumentation.getAllLoadedClasses()) {
            try {
                instrumentation.retransformClasses(clazz);
            } catch (Throwable exception) {
                System.out.println("Skipping " + clazz.getName() + " due to an exception");
                exception.printStackTrace();
            }
        }
    }
}