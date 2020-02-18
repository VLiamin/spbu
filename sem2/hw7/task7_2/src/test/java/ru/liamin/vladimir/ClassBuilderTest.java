package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import static org.junit.jupiter.api.Assertions.*;

class ClassBuilderTest {
    private static ClassBuilder classBuilder = new ClassBuilder();

    @Test
    public void printStructureTest() throws IOException, ClassNotFoundException {
        ClassLoader printedClassLoader = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> printedClass = printedClassLoader.loadClass("ru.liamin.vladimir.UniversityTrip");
        String result = classBuilder.printStructure(printedClass);
        String expected = "package ru.liamin.vladimir.BuildClass;\n" +
                "\n" +
                "public class UniversityTrip extends Object {\n" +
                "\tprivate int numberOfBuses = 0;\n" +
                "\t\n" +
                "\tpublic UniversityTrip(int arg0) { }\n" +
                "\n" +
                "\tpublic int go ()   {\n" +
                "\t\treturn 0;\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "\t";
        assertEquals(expected, result);
    }

    @Test
    public void diffStructureTrueTest() throws IOException, ClassNotFoundException {
        ClassLoader printedClassLoader = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> printedClass = printedClassLoader.loadClass("ru.liamin.vladimir.ClassBuilder");
        classBuilder.printStructure(printedClass);

        ClassLoader buildClassLoader = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> buildClass = buildClassLoader.loadClass("ru.liamin.vladimir.BuildClass.ClassBuilder");
        assertTrue(classBuilder.diffClasses(printedClass, buildClass));
    }


    @Test
    public void diffStructureFalseTest() throws IOException, ClassNotFoundException {
        ClassLoader printedClassLoader = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> printedClass = printedClassLoader.loadClass("ru.liamin.vladimir.UniversityTrip");
        classBuilder.printStructure(printedClass);

        ClassLoader buildClassLoader = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> buildClass = buildClassLoader.loadClass("ru.liamin.vladimir.AnotherUniversityTrip");
        assertFalse(classBuilder.diffClasses(printedClass, buildClass));
    }
}