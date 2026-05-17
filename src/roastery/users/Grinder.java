package roastery.users;

import java.util.Scanner;

import roastery.models.ProductionGoal;
import roastery.services.InputValidator;

public class Grinder extends ProductionWorker {
    private String processingType;
    private String grindType;

    public Grinder(String name) {
        super(name, "Grinder");
    }

    @Override
    public void recordWork(Scanner scanner, ProductionGoal goal) {
        System.out.println("Enter grinding data.");
        inputWeight = InputValidator.readPositiveDouble(scanner, "Incoming roasted weight (kg): ");
        processingType = InputValidator.readNonEmptyString(scanner, "Processing type (Ground or Whole Bean): ");

        if (isWholeBean(processingType)) {
            processingType = "Whole Bean";
            grindType = "Whole Bean";
        } else {
            processingType = "Ground";
            grindType = InputValidator.readNonEmptyString(scanner, "Grind type (Coarse/Medium/Fine): ");
        }

        outputWeight = InputValidator.readPositiveDouble(scanner, "Output weight (kg): ");

        double grindingLoss = inputWeight - outputWeight;
        defectPercentage = inputWeight > 0 ? (grindingLoss / inputWeight) * 100 : 0;
        qualityScore = calculateQualityScore();

        double targetQuality = getTargetQuality(goal);
        double contribution = calculateContribution(getTargetWeight(goal));

        System.out.println("Grinding recorded successfully.");
        System.out.printf("Incoming Weight: %.1f kg%n", inputWeight);
        System.out.printf("Processing Type: %s%n", processingType);
        System.out.printf("Grind Type: %s%n", grindType);
        System.out.printf("Output Weight: %.1f kg%n", outputWeight);
        System.out.printf("Grinding Loss: %.1f kg%n", grindingLoss);
        System.out.printf("Grinding Loss Percentage: %.1f%%%n", defectPercentage);
        System.out.printf("Grinding Quality Score: %.1f%%%n", qualityScore);
        System.out.printf("Manager Grinding Quality Target: %.1f%%%n", targetQuality);
        System.out.printf("Status: %s%n", getStatus(targetQuality));
        System.out.printf("Contribution to Grinding Goal: %.1f%%%n", contribution);
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
        System.out.printf("Contribution to Grinding Goal: %.1f%%%n", contribution);
    }

    @Override
    public double getTargetWeight(ProductionGoal goal) {
        return goal.getGrindingWeightTarget();
    }

    @Override
    public double getTargetQuality(ProductionGoal goal) {
        return goal.getGrindingQualityTarget();
    }

    private boolean isWholeBean(String value) {
        String normalized = value.trim().toLowerCase();
        return normalized.equals("whole bean") || normalized.equals("whole") || normalized.equals("wholebean");
    }
}
