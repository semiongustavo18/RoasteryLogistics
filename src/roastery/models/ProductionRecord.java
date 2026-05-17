package roastery.models;

public class ProductionRecord {
    private String roleName;
    private double inputWeight;
    private double outputWeight;
    private double defectPercentage;
    private double qualityScore;

    public ProductionRecord(String roleName, double inputWeight, double outputWeight, double defectPercentage,
            double qualityScore) {
        this.roleName = roleName;
        this.inputWeight = inputWeight;
        this.outputWeight = outputWeight;
        this.defectPercentage = defectPercentage;
        this.qualityScore = qualityScore;
    }

    public String getRoleName() {
        return roleName;
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
