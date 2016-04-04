package com.courses.spalah;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Ievgen Tararaka
 */
public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Reflection> clazz = Reflection.class; // на этапе компиляции

        Class clazzRuntime = Class.forName("com.courses.spalah.Reflection"); // в runtim'e
        // Необходимо указывать полное имя класса. Если класс не будет найдет - вылетит ClassNotFoundException

        String fullName = clazz.getName();
        // com.courses.spalah.Reflection

        String simpleName = clazzRuntime.getSimpleName();
        // Reflection

        for (Method m : SampleClass.class.getMethods()) {
            System.out.println(m.toString());
        }
    }

    public static void sample() {
        Class<SampleClass> clazz = SampleClass.class;
        int modifiers = clazz.getModifiers(); // все модификаторы хранятся в виде битовой маски в переменной типа int

        Modifier.isAbstract(modifiers);
        Modifier.isFinal(modifiers);
        Modifier.isInterface(modifiers);
        Modifier.isNative(modifiers);
        Modifier.isPrivate(modifiers);
        Modifier.isProtected(modifiers);
        Modifier.isPublic(modifiers);
        Modifier.isStatic(modifiers);
        Modifier.isStrict(modifiers);
        Modifier.isSynchronized(modifiers);
        Modifier.isTransient(modifiers);
        Modifier.isVolatile(modifiers);

        Class superClass = clazz.getSuperclass();
        Class superSuperClass = superClass.getSuperclass();
        // ...  так пока не дойдем до Object
        Class object = superSuperClass.getSuperclass(); // object = null

        Class[] interfaces = clazz.getInterfaces(); // список всех интерфейсов, которые имплементят данный класс
        // массив содержит только те классы которые исплементятся напрямую
        // не включая родительские имплементации

        Constructor[] constructors = clazz.getConstructors();
        // все конструкторы класса (с параметрами и без)

        Method[] methods = clazz.getMethods();
        // методы класса

        Field[] method = clazz.getFields();
        // поля класса

        Annotation[] annotations = clazz.getAnnotations();
        // аннотации класса
    }

    public static void constructors() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class clazz = SampleClass.class;
        Constructor[] constructors = clazz.getConstructors(); // получение конструкторов

        Object instance;
        for (Constructor c : constructors) {
            if (c.getParameterTypes().length == 0) { // получение параметров конструктора
                instance = c.newInstance(); // создание объекта
            }
        }

        Constructor constructor = clazz.getConstructor(long.class, int.class, String.class, boolean.class); // получение конкретного конструктора
        instance = constructor.newInstance(1, 1, "", false);  // создание обьекта
    }

    public static void fields() {

    }
}
