package me.micartey.dumping;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.nio.file.Files;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.List;

public class DumpClassTransformer implements ClassFileTransformer {

    private static final List<String> BLACKLIST = Arrays.asList(
            "java/",
            "javax/",
            "sun/",
            "com/sun/",
            "jdk/"
    );

    private final File folder;

    public DumpClassTransformer(File folder) {
        this.folder = folder;
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

        if (BLACKLIST.stream().anyMatch(className::startsWith))
            return classfileBuffer;

        System.out.println("Dumping class: " + className);
        String path = className.replace('.', '/');

        try {
            File destination = new File(folder, path);
            destination.getParentFile().mkdirs();
            Files.write(destination.toPath(), classfileBuffer);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return classfileBuffer;
    }
}
