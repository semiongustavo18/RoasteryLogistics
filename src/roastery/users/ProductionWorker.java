package roastery.users;

import java.util.Scanner;

import roastery.models.ProductionGoal;

public abstract class ProductionWorker extends User {
    protected double inputWeight;
    protected double outputWeight;
    protected double defectPercentage;
    protected double qualityScore;

    public ProductionWorker(String name, String role) {
        super(name, role);
    }

    @Override
    public void showMenu() {
        System.out.println("1. Record work");
        System.out.println("2. View contribution to overall goal");
        System.out.println("3. Exit");
    }

    public abstract void recordWork(Scanner scanner, ProductionGoal goal);

    public abstract double calculateQualityScore();

    public abstract void viewContribution(ProductionGoal goal);

    public abstract double getTargetWeight(ProductionGoal goal);

    public abstract double getTargetQuality(ProductionGoal goal);

    public double calculateContribution(double targetWeight) {
        if (targetWeight <= 0) {
            return 0;
        }
        return (outputWeight / targetWeight) * 100;
    }

    public String getStatus(double targetQuality) {
        return qualityScore >= targetQuality ? "Target met" : "Below target";
    }

    public double getInputWeight() {
        return inputWeight;
    }

    public double getOutputWeight() {
        return outputWeight;
    }

    public double getDefectPercentage() {
        return defectPercentage;
    }

    public double getQualityScore() {
        return qualityScore;
    }
}
