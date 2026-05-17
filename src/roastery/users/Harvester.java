package roastery.users;

import java.util.Scanner;

import roastery.models.ProductionGoal;
import roastery.services.InputValidator;

public class Harvester extends ProductionWorker {
    private double ripeCherryWeight;
    private double defectiveCherryWeight;

    public Harvester(String name) {
        super(name, "Harvester");
    }

    @Override
    public void recordWork(Scanner scanner, ProductionGoal goal) {
        System.out.println("Enter harvest data.");
        double totalPicked = InputValidator.readPositiveDouble(scanner, "Total picked weight (kg): ");
        ripeCherryWeight = InputValidator.readPositiveDouble(scanner, "Ripe cherry weight (kg): ");
        defectiveCherryWeight = InputValidator.readPositiveDouble(scanner, "Defective cherry weight (kg): ");

        inputWeight = totalPicked;
        outputWeight = totalPicked;
        defectPercentage = totalPicked > 0 ? (defectiveCherryWeight / totalPicked) * 100 : 0;
        qualityScore = calculateQualityScore();

        double targetQuality = getTargetQuality(goal);
        double contribution = calculateContribution(getTargetWeight(goal));

        System.out.println("Harvest recorded successfully.");
        System.out.printf("Total Picked Weight: %.1f kg%n", totalPicked);
        System.out.printf("Ripe Cherry Weight: %.1f kg%n", ripeCherryWeight);
        System.out.printf("Defective Cherry Weight: %.1f kg%n", defectiveCherryWeight);
        System.out.printf("Defect Percentage: %.1f%%%n", defectPercentage);
        System.out.printf("Harvest Quality Score: %.1f%%%n", qualityScore);
        System.out.printf("Manager Harvest Quality Target: %.1f%%%n", targetQuality);
        System.out.printf("Status: %s%n", getStatus(targetQuality));
        System.out.printf("Contribution to Harvest Goal: %.1f%%%n", contribution);
    }

    @Override
    public double calculateQualityScore() {
        if (outputWeight <= 0) {
            return 0;
        }
        return (ripeCherryWeight / outputWeight) * 100;
    }

    @Override
    public void viewContribution(ProductionGoal goal) {
        double contribution = calculateContribution(getTargetWeight(goal));
        System.out.printf("Contribution to Harvest Goal: %.1f%%%n", contribution);
    }

    @Override
    public double getTargetWeight(ProductionGoal goal) {
        return goal.getHarvestWeightTarget();
    }

    @Override
    public double getTargetQuality(ProductionGoal goal) {
        return goal.getHarvestQualityTarget();
    }
}
