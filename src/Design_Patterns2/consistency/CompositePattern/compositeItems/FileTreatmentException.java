package Design_Patterns2.consistency.CompositePattern.compositeItems;

public class FileTreatmentException extends RuntimeException {
    FileTreatmentException(){

    }

    FileTreatmentException(String msg){
        super(msg);
    }
}
