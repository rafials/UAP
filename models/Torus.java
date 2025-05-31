package uap.models;
import uap.bases.Shape;
import uap.interfaces.ThreeDimensional;
import uap.interfaces.PiRequired;
import uap.interfaces.MassCalculable;
import uap.interfaces.MassConverter;
import uap.interfaces.ShippingCostCalculator;
public class Torus extends Shape
    implements ThreeDimensional, PiRequired, MassCalculable, MassConverter, ShippingCostCalculator {

    private double majorRadius; // R (cm)
    private double minorRadius; // r (cm)
    public Torus() {
        super("Torus");
    }
    public Torus(double majorRadius, double minorRadius) {
        super("Torus");
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    public double getMajorRadius() {
        return majorRadius;
    }

    public void setMajorRadius(double majorRadius) {
        this.majorRadius = majorRadius;
    }

    public double getMinorRadius() {
        return minorRadius;
    }

    public void setMinorRadius(double minorRadius) {
        this.minorRadius = minorRadius;
    }
    @Override
    public double getVolume() {
        // π² = PI * PI
        return 2 * (PI * PI) * majorRadius * (minorRadius * minorRadius);
    }
    @Override
    public double getSurfaceArea() {
        return 4 * (PI * PI) * majorRadius * minorRadius;
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