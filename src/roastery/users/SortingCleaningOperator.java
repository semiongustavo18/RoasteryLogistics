package roastery.users;

import java.util.Scanner;

import roastery.models.ProductionGoal;
import roastery.services.InputValidator;

public class SortingCleaningOperator extends ProductionWorker {
    private double defectiveBeanWeight;
    private double impurityWeight;

    public SortingCleaningOperator(String name) {
        super(name, "Sorting & Cleaning Operator");
    }

    @Override
    public void recordWork(Scanner scanner, ProductionGoal goal) {
        System.out.println("Enter sorting and cleaning data.");
        inputWeight = InputValidator.readPositiveDouble(scanner, "Incoming weight (kg): ");
        outputWeight = InputValidator.readPositiveDouble(scanner, "Usable clean bean weight (kg): ");
        defectiveBeanWeight = InputValidator.readPositiveDouble(scanner, "Defective bean weight (kg): ");
        impurityWeight = InputValidator.readPositiveDouble(scanner, "Impurity weight (kg): ");

        double removedWeight = defectiveBeanWeight + impurityWeight;
        defectPercentage = inputWeight > 0 ? (removedWeight / inputWeight) * 100 : 0;
        qualityScore = calculateQualityScore();

        double targetQuality = getTargetQuality(goal);
        double contribution = calculateContribution(getTargetWeight(goal));

        System.out.println("Sorting & Cleaning recorded successfully.");
        System.out.printf("Incoming Weight: %.1f kg%n", inputWeight);
        System.out.printf("Usable Clean Bean Weight: %.1f kg%n", outputWeight);
        System.out.printf("Defective Bean Weight: %.1f kg%n", defectiveBeanWeight);
        System.out.printf("Impurity Weight: %.1f kg%n", impurityWeight);
        System.out.printf("Total Removed Weight: %.1f kg%n", removedWeight);
        System.out.printf("Defect/Impurity Percentage: %.1f%%%n", defectPercentage);
        System.out.printf("Sorting & Cleaning Quality Score: %.1f%%%n", qualityScore);
        System.out.printf("Manager Sorting & Cleaning Quality Target: %.1f%%%n", targetQuality);
        System.out.printf("Status: %s%n", getStatus(targetQuality));
        System.out.printf("Contribution to Sorting & Cleaning Goal: %.1f%%%n", contribution);
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
        System.out.printf("Contribution to Sorting & Cleaning Goal: %.1f%%%n", contribution);
    }

    @Override
    public double getTargetWeight(ProductionGoal goal) {
        return goal.getSortingCleaningWeightTarget();
    }

    @Override
    public double getTargetQuality(ProductionGoal goal) {
        return goal.getSortingCleaningQualityTarget();
    }
}
