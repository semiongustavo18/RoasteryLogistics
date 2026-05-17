package roastery.services;

import java.util.ArrayList;

import roastery.models.ProductionGoal;
import roastery.users.ProductionWorker;

public class ReportService {
    public static void displayCurrentGoal(ProductionGoal goal) {
        System.out.println("Current Manager Goal:");
        String goalPeriod = goal.getGoalPeriod();
        if (goalPeriod == null || goalPeriod.trim().isEmpty()) {
            goalPeriod = "Not set";
        }
        System.out.printf("Goal Period: %s%n", goalPeriod);
        System.out.printf("Harvest Target: %.1f kg | Quality Target: %.1f%%%n", goal.getHarvestWeightTarget(),
                goal.getHarvestQualityTarget());
        System.out.printf("Sorting & Cleaning Target: %.1f kg | Quality Target: %.1f%%%n",
                goal.getSortingCleaningWeightTarget(), goal.getSortingCleaningQualityTarget());
        System.out.printf("Roasting Target: %.1f kg | Quality Target: %.1f%%%n", goal.getRoastingWeightTarget(),
                goal.getRoastingQualityTarget());
        System.out.printf("Grinding Target: %.1f kg | Quality Target: %.1f%%%n", goal.getGrindingWeightTarget(),
                goal.getGrindingQualityTarget());
        System.out.printf("Packaging Target: %.1f kg | Quality Target: %.1f%%%n", goal.getPackagingWeightTarget(),
                goal.getPackagingQualityTarget());
    }

    public static void displayOverallProgress(ProductionGoal goal, ArrayList<ProductionWorker> workers) {
        System.out.println("Overall Progress Report:");
        for (ProductionWorker worker : workers) {
            double targetWeight = worker.getTargetWeight(goal);
            double targetQuality = worker.getTargetQuality(goal);
            double progress = worker.calculateContribution(targetWeight);
            double actualQuality = worker.getQualityScore();
            double actualOutput = worker.getOutputWeight();
            String status = worker.getStatus(targetQuality);

            System.out.printf("%s:%n", worker.getRole());
            System.out.printf("Target Weight: %.1f kg%n", targetWeight);
            System.out.printf("Actual Output: %.1f kg%n", actualOutput);
            System.out.printf("Progress: %.1f%%%n", progress);
            System.out.printf("Target Quality: %.1f%%%n", targetQuality);
            System.out.printf("Actual Quality: %.1f%%%n", actualQuality);
            System.out.printf("Status: %s%n", status);
            System.out.println();
        }
    }

    public static void displayRoleProgress(ArrayList<ProductionWorker> workers, ProductionGoal goal) {
        System.out.println("Role Progress Report:");
        for (ProductionWorker worker : workers) {
            double targetWeight = worker.getTargetWeight(goal);
            double targetQuality = worker.getTargetQuality(goal);
            double contribution = worker.calculateContribution(targetWeight);
            String status = worker.getStatus(targetQuality);

            System.out.printf("%s:%n", worker.getRole());
            System.out.printf("Input Weight: %.1f kg%n", worker.getInputWeight());
            System.out.printf("Output Weight: %.1f kg%n", worker.getOutputWeight());
            System.out.printf("Defect/Loss Percentage: %.1f%%%n", worker.getDefectPercentage());
            System.out.printf("Quality Score: %.1f%%%n", worker.getQualityScore());
            System.out.printf("Target Quality: %.1f%%%n", targetQuality);
            System.out.printf("Status: %s%n", status);
            System.out.printf("Contribution: %.1f%%%n", contribution);
            System.out.println();
        }
    }
}
