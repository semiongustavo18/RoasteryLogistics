package roastery.models;

public class ProductionGoal {
    private String goalPeriod;

    private double harvestWeightTarget;
    private double sortingCleaningWeightTarget;
    private double roastingWeightTarget;
    private double grindingWeightTarget;
    private double packagingWeightTarget;

    private double harvestQualityTarget;
    private double sortingCleaningQualityTarget;
    private double roastingQualityTarget;
    private double grindingQualityTarget;
    private double packagingQualityTarget;

    public ProductionGoal() {
        this.goalPeriod = "";
    }

    public ProductionGoal(String goalPeriod) {
        setGoalPeriod(goalPeriod);
    }

    public void setGoal(String goalPeriod) {
        setGoalPeriod(goalPeriod);
    }

    public void setGoal(String goalPeriod, double harvestWeightTarget) {
        setGoalPeriod(goalPeriod);
        setHarvestWeightTarget(harvestWeightTarget);
    }

    public void setGoal(String goalPeriod, double harvestWeightTarget, double packagingWeightTarget) {
        setGoalPeriod(goalPeriod);
        setHarvestWeightTarget(harvestWeightTarget);
        setPackagingWeightTarget(packagingWeightTarget);
    }

    public String getGoalPeriod() {
        return goalPeriod;
    }

    public void setGoalPeriod(String goalPeriod) {
        if (goalPeriod == null || goalPeriod.trim().isEmpty()) {
            throw new IllegalArgumentException("Goal period must not be empty.");
        }
        this.goalPeriod = goalPeriod.trim();
    }

    public double getHarvestWeightTarget() {
        return harvestWeightTarget;
    }

    public void setHarvestWeightTarget(double harvestWeightTarget) {
        validateWeightTarget(harvestWeightTarget, "Harvest weight target must be greater than zero.");
        this.harvestWeightTarget = harvestWeightTarget;
    }

    public double getSortingCleaningWeightTarget() {
        return sortingCleaningWeightTarget;
    }

    public void setSortingCleaningWeightTarget(double sortingCleaningWeightTarget) {
        validateWeightTarget(sortingCleaningWeightTarget,
                "Sorting & Cleaning weight target must be greater than zero.");
        this.sortingCleaningWeightTarget = sortingCleaningWeightTarget;
    }

    public double getRoastingWeightTarget() {
        return roastingWeightTarget;
    }

    public void setRoastingWeightTarget(double roastingWeightTarget) {
        validateWeightTarget(roastingWeightTarget, "Roasting weight target must be greater than zero.");
        this.roastingWeightTarget = roastingWeightTarget;
    }

    public double getGrindingWeightTarget() {
        return grindingWeightTarget;
    }

    public void setGrindingWeightTarget(double grindingWeightTarget) {
        validateWeightTarget(grindingWeightTarget, "Grinding weight target must be greater than zero.");
        this.grindingWeightTarget = grindingWeightTarget;
    }

    public double getPackagingWeightTarget() {
        return packagingWeightTarget;
    }

    public void setPackagingWeightTarget(double packagingWeightTarget) {
        validateWeightTarget(packagingWeightTarget, "Packaging weight target must be greater than zero.");
        this.packagingWeightTarget = packagingWeightTarget;
    }

    public double getHarvestQualityTarget() {
        return harvestQualityTarget;
    }

    public void setHarvestQualityTarget(double harvestQualityTarget) {
        validateQualityTarget(harvestQualityTarget, "Harvest quality target must be between 0 and 100.");
        this.harvestQualityTarget = harvestQualityTarget;
    }

    public double getSortingCleaningQualityTarget() {
        return sortingCleaningQualityTarget;
    }

    public void setSortingCleaningQualityTarget(double sortingCleaningQualityTarget) {
        validateQualityTarget(sortingCleaningQualityTarget,
                "Sorting & Cleaning quality target must be between 0 and 100.");
        this.sortingCleaningQualityTarget = sortingCleaningQualityTarget;
    }

    public double getRoastingQualityTarget() {
        return roastingQualityTarget;
    }

    public void setRoastingQualityTarget(double roastingQualityTarget) {
        validateQualityTarget(roastingQualityTarget, "Roasting quality target must be between 0 and 100.");
        this.roastingQualityTarget = roastingQualityTarget;
    }

    public double getGrindingQualityTarget() {
        return grindingQualityTarget;
    }

    public void setGrindingQualityTarget(double grindingQualityTarget) {
        validateQualityTarget(grindingQualityTarget, "Grinding quality target must be between 0 and 100.");
        this.grindingQualityTarget = grindingQualityTarget;
    }

    public double getPackagingQualityTarget() {
        return packagingQualityTarget;
    }

    public void setPackagingQualityTarget(double packagingQualityTarget) {
        validateQualityTarget(packagingQualityTarget, "Packaging quality target must be between 0 and 100.");
        this.packagingQualityTarget = packagingQualityTarget;
    }

    private void validateWeightTarget(double value, String message) {
        if (value <= 0) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validateQualityTarget(double value, String message) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException(message);
        }
    }
}
