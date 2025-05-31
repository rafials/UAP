package uap.models;
import uap.bases.Shape;
import uap.interfaces.ThreeDimensional;
import uap.interfaces.PiRequired;
import uap.interfaces.MassCalculable;
import uap.interfaces.MassConverter;
import uap.interfaces.ShippingCostCalculator;
public class Sphere extends Shape
    implements ThreeDimensional, PiRequired, MassCalculable, MassConverter, ShippingCostCalculator {

    private double radius; // r (cm)
    public Sphere() {
        super("Sphere");
    }
    public Sphere(double radius) {
        super("Sphere");
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public double getVolume() {
        return (4.0 / 3.0) * PI * radius * radius * radius;
    }
    @Override
    public double getSurfaceArea() {
        return 4 * PI * radius * radius;
    }
    @Override
    public double getMass() {
        double area = getSurfaceArea(); // cm²
        return DENSITY * area * THICKNESS; // gram
    }
    @Override
    public void printInfo() {
        double volume = getVolume();                   // cm³
        double surfaceArea = getSurfaceArea();         // cm²
        double massGram = getMass();                   // gram
        double massKg = gramToKilogram(massGram);      // kg (double)
        int costRp = calculateCost(massKg);            // Rp

        System.out.println("Volume\t\t: " + volume);
        System.out.println("Luas permukaan\t: " + surfaceArea);
        System.out.println("Massa\t\t: " + massGram);
        System.out.println("Massa dalam kg\t: " + massKg);
        System.out.println("Biaya kirim\t: Rp" + costRp);
    }
}
