package uap.interfaces;
public interface MassConverter {
    int DENOMINATOR = 1000; 
    default double gramToKilogram(double gram) {
        return gram / DENOMINATOR;
    }
}