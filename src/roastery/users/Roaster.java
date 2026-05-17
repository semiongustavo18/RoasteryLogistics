package roastery.users;

import java.util.Scanner;

import roastery.models.ProductionGoal;
import roastery.services.InputValidator;

public class Roaster extends ProductionWorker {
    private String roastLevel;
    private double temperature;
    private int roastTime;

    public Roaster(String name) {
        super(name, "Roaster");
    }

    @Override
    public void recordWork(Scanner scanner, ProductionGoal goal) {
        System.out.println("Enter roasting data.");
        inputWeight = InputValidator.readPositiveDouble(scanner, "Incoming green bean weight (kg): ");
        outputWeight = InputValidator.readPositiveDouble(scanner, "Roasted output weight (kg): ");
        roastLevel = InputValidator.readNonEmptyString(scanner, "Roast level: ");
        temperature = InputValidator.readPositiveDouble(scanner, "Temperature (C): ");
        roastTime = InputValidator.readInt(scanner, "Roast time (minutes): ");

        double roastingLoss = inputWeight - outputWeight;
        defectPercentage = inputWeight > 0 ? (roastingLoss / inputWeight) * 100 : 0;
        qualityScore = calculateQualityScore();

        double targetQuality = getTargetQuality(goal);
        double contribution = calculateContribution(getTargetWeight(goal));

        System.out.println("Roasting recorded successfully.");
        System.out.printf("Incoming Weight: %.1f kg%n", inputWeight);
        System.out.printf("Roasted Output Weight: %.1f kg%n", outputWeight);
        System.out.printf("Roast Level: %s%n", roastLevel);
        System.out.printf("Temperature: %.1f C%n", temperature);
        System.out.printf("Roast Time: %d minutes%n", roastTime);
        System.out.printf("Roasting Loss: %.1f kg%n", roastingLoss);
        System.out.printf("Roasting Loss Percentage: %.1f%%%n", defectPercentage);
        System.out.printf("Roasting Quality Score: %.1f%%%n", qualityScore);
        System.out.printf("Manager Roasting Quality Target: %.1f%%%n", targetQuality);
        System.out.printf("Status: %s%n", getStatus(targetQuality));
        System.out.printf("Contribution to Roasting Goal: %.1f%%%n", contribution);
    }

    @Override
    public double calculateQualityScore() {
        boolean temperatureOk = temperature >= 200 && temperature <= 220;
        boolean timeOk = roastTime >= 10 && roastTime <= 15;

        if (temperatureOk && timeOk) {
            return 95;
        }
        if (temperatureOk || timeOk) {
            return 80;
        }
        return 65;
    }

    @Override
    public void viewContribution(ProductionGoal goal) {
        double contribution = calculateContribution(getTargetWeight(goal));
        System.out.printf("Contribution to Roasting Goal: %.1f%%%n", contribution);
    }

    @Override
    public double getTargetWeight(ProductionGoal goal) {
        return goal.getRoastingWeightTarget();
    }

    @Override
    public double getTargetQuality(ProductionGoal goal) {
        return goal.getRoastingQualityTarget();
    }
}
