package ThinkingInJava.generics.Simple;

import java.util.*;

class New {
    static <T> List<T> newArrayList(){
        return new ArrayList<T>();
    }

    static <T> List<T> newLinkedList(){
        return new LinkedList<>();
    }

    static <T> Set<T> newHashSet(){
        return new HashSet<>();
    }
}
