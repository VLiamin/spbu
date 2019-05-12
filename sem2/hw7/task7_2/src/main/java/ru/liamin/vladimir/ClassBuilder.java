package ru.liamin.vladimir;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.*;

/** Class overwrites classes to file */
public class ClassBuilder {

    /**
     * Method overwrites classes to file
     * @param args array of arguments
     * @throws IOException exception, when file to write not found
     */
    public static void main(String[] args) throws IOException {
        ClassBuilder classBuilder = new ClassBuilder();
        classBuilder.printStructure(ClassBuilder.class);
    }

    /**
     * Prints the information about class by rewriting to a file
     * @param clazz class which will be rewriting
     * @return string in which the class is overwritten
     * @throws IOException exception, when file to write not found
     */
    public String printStructure(Class clazz) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        String fileName = "src\\test\\java\\ru\\liamin\\vladimir\\BuildClass\\";
        fileName = fileName + clazz.getSimpleName() + ".java";
        FileWriter fileWriter = new FileWriter(fileName);
        stringBuilder.append("package ru.liamin.vladimir.BuildClass;\n\n");
        writeStructure(clazz, stringBuilder);

        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
        return  stringBuilder.toString();
    }

    private void writeStructure(Class clazz, StringBuilder stringBuilder) {

        writeClassDeclaration(clazz, stringBuilder);
        stringBuilder.append("{\n\t");
        writeFields(clazz, stringBuilder);
        writeConstructors(clazz, stringBuilder);
        writeMethods(clazz, stringBuilder);
        writeInnerClasses(clazz, stringBuilder);
        stringBuilder.append("\n}");
        stringBuilder.append("\n\n\t");
    }

    private void  writeClassDeclaration(Class clazz, StringBuilder stringBuilder) {

        if (clazz.getModifiers() != 0)
            stringBuilder.append(Modifier.toString(clazz.getModifiers()));

        stringBuilder.append(" class ");
        writeClasses(clazz, stringBuilder);
        writeSuperClasses(clazz, stringBuilder);
        writeInterfaces(clazz, stringBuilder);

    }

    private void writeClasses(Class clazz, StringBuilder stringBuilder) {

        stringBuilder.append(clazz.getSimpleName());
        if (clazz.getTypeParameters().length != 0) {

            TypeVariable[] parameters = clazz.getTypeParameters();

            stringBuilder.append("<");
            for (int i = 0; i < clazz.getTypeParameters().length; i++) {

                stringBuilder.append(parameters[i].getName());

                if (i != clazz.getTypeParameters().length - 1)
                    stringBuilder.append(", ");
            }
            stringBuilder.append(">");
        }

        stringBuilder.append(" ");
    }

    private void writeSuperClasses(Class clazz, StringBuilder stringBuilder) {

        if (clazz.getSuperclass() != null) {

            stringBuilder.append("extends ");
            writeClasses(clazz.getSuperclass(), stringBuilder);
        }
    }

    private void writeInterfaces(Class clazz, StringBuilder stringBuilder) {

        if (clazz.getInterfaces().length != 0) {

            stringBuilder.append("implements");
            Class[] interfaces = clazz.getInterfaces();

            for (int i = 0; i < interfaces.length; i++) {

                writeInterface(interfaces[i], stringBuilder);

                if (interfaces.length - 1 != i)
                    stringBuilder.append(", ");
            }
        }
    }

    private void writeInterface(Class clazz, StringBuilder stringBuilder) {

        stringBuilder.append(clazz.getName());

        if (clazz.getTypeParameters().length != 0) {

            stringBuilder.append("<");
            TypeVariable[] typeVariables = clazz.getTypeParameters();

            for (int i = 0; i < typeVariables.length; i++) {

                stringBuilder.append(typeVariables[i]);

                if (i != typeVariables.length - 1)
                    stringBuilder.append(", ");
            }
            stringBuilder.append(">");
        }
    }

    private void writeFields(Class clazz, StringBuilder stringBuilder) {

        if (clazz.getDeclaredFields().length != 0) {

            Field[] fields = clazz.getDeclaredFields();

            for (int i = 0; i < fields.length; i++) {

                writeField(fields[i], stringBuilder);
                stringBuilder.append("\n\t");
            }
        }
    }

    private void writeField(Field field, StringBuilder stringBuilder) {

        if (field.getModifiers() != 0) {

            stringBuilder.append(Modifier.toString(field.getModifiers()));
            stringBuilder.append(" ");
        }

        stringBuilder.append(field.getType().getSimpleName());
        stringBuilder.append(" ");
        stringBuilder.append(field.getName() + " = ");
        writeType(field.getType(), stringBuilder);
    }

    private void writeType(Type type, StringBuilder stringBuilder) {

        switch (type.getTypeName()) {

            case "Integer":
                stringBuilder.append("Integer.valueOf(0);");
                break;
            case "int":
                stringBuilder.append("0;");
                break;
            case "Double":
                stringBuilder.append("Double.valueOf(0.0);");
                break;
            case "double":
                stringBuilder.append("0.0;");
                break;
            case "Float":
                stringBuilder.append("Float.valueOf(0);");
                break;
            case "float":
                stringBuilder.append("0;");
                break;
            case "Boolean":
                stringBuilder.append("false;");
                break;
            case "boolean":
                stringBuilder.append("false;");
                break;
            case "Byte":
                stringBuilder.append("Byte.valueOf(0);");
                break;
            case "byte":
                stringBuilder.append("0;");
                break;
            case "Long":
                stringBuilder.append("Long.valueOf(0);");
                break;
            case "long":
                stringBuilder.append("0;");
                break;
            case "Char":
                stringBuilder.append("Char.valueOf('x');");
                break;
            case "char":
                stringBuilder.append("'x';");
                break;
            case "Short":
                stringBuilder.append("Short.valueOf(0);");
                break;
            case "short":
                stringBuilder.append("0;");
                break;
            case "String":
                stringBuilder.append("Short.valueOf(\"\");");
            case "void":
                stringBuilder.append(";");
                break;
            default:
                stringBuilder.append("null;");
                break;

        }
    }

    private void writeMethods(Class clazz, StringBuilder stringBuilder) {

        if (clazz.getDeclaredMethods().length != 0) {
            Method[] methods = clazz.getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                writeMethod(methods[i], stringBuilder);

                if (i < methods.length - 1) {
                    stringBuilder.append("\n\n\t");
                }
            }
        }
    }

    private void writeMethod(Method method, StringBuilder stringBuilder) {

        if (method.getModifiers() != 0) {
            stringBuilder.append(Modifier.toString(method.getModifiers()));
            stringBuilder.append(" ");
        }

        stringBuilder.append(method.getReturnType().getSimpleName());
        stringBuilder.append(" ");
        stringBuilder.append(method.getName());
        stringBuilder.append(" (");

        Parameter[] parameters = method.getParameters();
        writeParameters(parameters, stringBuilder);

        stringBuilder.append(") ");
        writeExceptions(method, stringBuilder);
        stringBuilder.append(" {\n\t\treturn ");
        writeType(method.getReturnType(), stringBuilder);
        stringBuilder.append("\n\t}");
    }

    private void writeParameters(Parameter[] parameters, StringBuilder stringBuilder) {

        for (int i = 0; i < parameters.length; i++) {

            stringBuilder.append(parameters[i].getParameterizedType().getTypeName());
            stringBuilder.append(" ");
            stringBuilder.append(parameters[i].getName());
            if (i != parameters.length - 1)
                stringBuilder.append(", ");
        }
    }

    private void writeExceptions(Method method, StringBuilder stringBuilder) {

        if (method.getExceptionTypes().length != 0) {

            stringBuilder.append("throws ");
            Class[] exceptions = method.getExceptionTypes();
            for (int i = 0; i < exceptions.length; i++) {
                stringBuilder.append(exceptions[i].getName());
                if (i != exceptions.length - 1)
                    stringBuilder.append(", ");
            }
        }
        stringBuilder.append(" ");
    }

    private void writeConstructors(Class clazz, StringBuilder stringBuilder) {

        stringBuilder.append("\n\t");
        if (clazz.getDeclaredConstructors().length != 0) {

            Constructor[] constructors = clazz.getDeclaredConstructors();
            for (int i = 0; i < constructors.length; i++) {

                writeConstructor(clazz, constructors[i], stringBuilder);
                stringBuilder.append("\n\n\t");
            }
        }
    }

    private void writeConstructor(Class clazz, Constructor constructor, StringBuilder stringBuilder) {

        if (constructor.getModifiers() != 0) {

            stringBuilder.append(Modifier.toString(constructor.getModifiers()));
            stringBuilder.append(" ");
        }

        Parameter[] parameters = constructor.getParameters();
        stringBuilder.append(clazz.getSimpleName());
        stringBuilder.append("(");
        writeParameters(parameters, stringBuilder);
        stringBuilder.append(") { }");
    }

    private void writeInnerClasses(Class clazz, StringBuilder stringBuilder) {

        if (clazz.getDeclaredClasses().length != 0)
            stringBuilder.append("\n\t");

        for (Class<?> innerClass : clazz.getDeclaredClasses()) {
            writeStructure(innerClass, stringBuilder);
            stringBuilder.append("\n\n\t");
        }
    }

    /**
     * Method that compares two classes
     * @param firstClass first class which will compare with second class
     * @param secondClass second class which will compare with first class
     * @return two classes are different or not
     */
    public boolean diffClasses(Class firstClass, Class secondClass) {

        StringBuilder differenceBetweenClasses = new StringBuilder();
        writeDifference(firstClass, secondClass, differenceBetweenClasses);

        if (differenceBetweenClasses.length() == 0) {
            System.out.println("Classes are equal");
            return true;
        }
        System.out.println("Classes are not equal");
        System.out.println(differenceBetweenClasses);
        return false;
    }

    private void writeDifference(Class firstClass, Class secondClass, StringBuilder differenceBetweenClasses) {

        areFieldsDiffer(firstClass, secondClass, differenceBetweenClasses);
        areMethodsDiffer(firstClass, secondClass, differenceBetweenClasses);
        areInnerClassesDiffer(firstClass, secondClass, differenceBetweenClasses);
    }

    private void areFieldsDiffer(Class firstClass, Class secondClass, StringBuilder differenceBetweenClasses) {

        Field[] fieldsFirst = firstClass.getDeclaredFields();
        Field[] fieldsSecond = secondClass.getDeclaredFields();
        if (fieldsFirst.equals(fieldsSecond))
            return;

        for (Field i : fieldsFirst) {

            if (!containsCurrentField(i, secondClass))
                writeField(i, differenceBetweenClasses);
        }
        for (Field i : fieldsSecond) {

            if (!containsCurrentField(i, firstClass))
                writeField(i, differenceBetweenClasses);
        }
    }

    private boolean containsCurrentField(Field field, Class clazz) {
        if (Modifier.isFinal(field.getModifiers()) && field.getName().equals("this$0$"))
            return true;
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder();
        writeField(field, stringBuilder);
        for (Field i : fields) {

            StringBuilder currentFieldDeclaration = new StringBuilder();
            writeField(i, stringBuilder);
            if (stringBuilder.toString().equals(currentFieldDeclaration.toString()))
                return true;
        }
        return false;
    }

    private void areMethodsDiffer(Class first, Class second, StringBuilder differenceBetweenClasses) {

        Method[] methodsFirst = first.getDeclaredMethods();
        Method[] methodsSecond = second.getDeclaredMethods();
        if (methodsFirst.equals(methodsSecond))
            return;

        for (Method i : methodsFirst) {

            if (!containsCurrentMethod(i, second)) {

                writeMethod(i, differenceBetweenClasses);
                differenceBetweenClasses.append("\n");
            }
        }
        for (Method i : methodsSecond) {

            if (!containsCurrentMethod(i, first)) {

                writeMethod(i, differenceBetweenClasses);
                differenceBetweenClasses.append("\n");
            }
        }
    }

    private boolean containsCurrentMethod(Method method, Class clazz) {

        Method[] methods = clazz.getDeclaredMethods();
        StringBuilder givenMethodDeclaration = new StringBuilder();
        writeMethod(method, givenMethodDeclaration);
        for (Method i : methods) {

            StringBuilder currentMethodDeclaration = new StringBuilder();
            writeMethod(i, currentMethodDeclaration);
            if (currentMethodDeclaration.toString().equals(givenMethodDeclaration.toString()))
                return true;

        }
        return false;
    }

    private void areInnerClassesDiffer(Class firstClass, Class secondClass, StringBuilder differenceBetweenClasses) {
        if ((firstClass.getDeclaredClasses().length != 0) && (secondClass.getDeclaredClasses().length != 0)) {

            Class[] innerClassesFirst = firstClass.getDeclaredClasses();
            Class[] innerClassesSecond = secondClass.getDeclaredClasses();
            if (innerClassesFirst.equals(innerClassesSecond))
                return;

            for (Class i : innerClassesFirst) {

                Class curClass = i;

                for (Class j : innerClassesSecond) {
                    Class curSecondClass = j;
                    writeDifference(curClass, curSecondClass, differenceBetweenClasses);
                }
            }
        } else if ((firstClass.getDeclaredClasses().length != 0) && (secondClass.getDeclaredClasses().length == 0)
                || (firstClass.getDeclaredClasses().length == 0) && (secondClass.getDeclaredClasses().length != 0)) {

            Class[] innerClasses = firstClass.getDeclaredClasses();
            for (Class i : innerClasses)
                writeStructure(i, differenceBetweenClasses);
        }
    }
}
