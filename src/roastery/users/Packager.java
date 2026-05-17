package roastery.users;

import java.util.Scanner;

import roastery.models.ProductionGoal;
import roastery.services.InputValidator;

public class Packager extends ProductionWorker {
    private double packageSize;
    private int numberOfPackages;

    public Packager(String name) {
        super(name, "Packager");
    }

    @Override
    public void recordWork(Scanner scanner, ProductionGoal goal) {
        System.out.println("Enter packaging data.");
        inputWeight = InputValidator.readPositiveDouble(scanner, "Available coffee weight (kg): ");
        packageSize = InputValidator.readPositiveDouble(scanner, "Package size (kg): ");
        outputWeight = InputValidator.readPositiveDouble(scanner, "Packaged output weight (kg): ");

        numberOfPackages = (int) (outputWeight / packageSize);
        double packagingWaste = inputWeight - outputWeight;
        defectPercentage = inputWeight > 0 ? (packagingWaste / inputWeight) * 100 : 0;
        qualityScore = calculateQualityScore();

        double targetQuality = getTargetQuality(goal);
        double contribution = calculateContribution(getTargetWeight(goal));

        System.out.println("Packaging recorded successfully.");
        System.out.printf("Available Coffee Weight: %.1f kg%n", inputWeight);
        System.out.printf("Package Size: %.1f kg%n", packageSize);
        System.out.printf("Packaged Output Weight: %.1f kg%n", outputWeight);
        System.out.printf("Number of Packages: %d%n", numberOfPackages);
        System.out.printf("Packaging Waste: %.1f kg%n", packagingWaste);
        System.out.printf("Packaging Waste Percentage: %.1f%%%n", defectPercentage);
        System.out.printf("Packaging Quality Score: %.1f%%%n", qualityScore);
        System.out.printf("Manager Packaging Quality Target: %.1f%%%n", targetQuality);
        System.out.printf("Status: %s%n", getStatus(targetQuality));
        System.out.printf("Contribution to Packaging Goal: %.1f%%%n", contribution);
    }

    @Override
    public double calculateQualityScore() {
        if (inputWeight <= 0) {
            return 0;
        }
        return (outputWeight / inputWeight) * 100;
    }

    @Override
    public void viewContribution(ProductionGoal goal) {
        double contribution = calculateContribution(getTargetWeight(goal));
        System.out.printf("Contribution to Packaging Goal: %.1f%%%n", contribution);
    }

    @Override
    public double getTargetWeight(ProductionGoal goal) {
        return goal.getPackagingWeightTarget();
    }

    @Override
    public double getTargetQuality(ProductionGoal goal) {
        return goal.getPackagingQualityTarget();
    }
}
