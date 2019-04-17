package ThinkingInJava.Annotation.UseAnnotation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases,1,2,3,4);
        UseCaseTracker tracker = new UseCaseTracker();
        tracker.trackUseCases(useCases,Person.class);
    }
}
