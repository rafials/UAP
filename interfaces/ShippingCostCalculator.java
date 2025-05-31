package uap.interfaces;
public interface ShippingCostCalculator {
    int PRICE_PER_KG = 2000; 
    default int calculateCost(double weightInKg) {
        int kg = (int) Math.ceil(weightInKg);
        return kg * PRICE_PER_KG;
    }
}