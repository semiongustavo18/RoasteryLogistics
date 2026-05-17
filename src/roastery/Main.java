package roastery;

import java.util.ArrayList;
import java.util.Scanner;

import roastery.models.ProductionGoal;
import roastery.services.InputValidator;
import roastery.services.ReportService;
import roastery.users.Grinder;
import roastery.users.Harvester;
import roastery.users.Manager;
import roastery.users.Packager;
import roastery.users.ProductionWorker;
import roastery.users.Roaster;
import roastery.users.SortingCleaningOperator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductionGoal goal = new ProductionGoal();
        Manager manager = new Manager("Main Manager");

        ArrayList<ProductionWorker> workers = new ArrayList<>();
        workers.add(new Harvester("Harvester"));
        workers.add(new SortingCleaningOperator("Sorting & Cleaning Operator"));
        workers.add(new Roaster("Roaster"));
        workers.add(new Grinder("Grinder"));
        workers.add(new Packager("Packager"));

        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = InputValidator.readInt(scanner, "Select an option: ");
            switch (choice) {
                case 1:
                    runManagerMenu(scanner, manager, goal, workers);
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    ProductionWorker worker = workers.get(choice - 2);
                    runWorkerMenu(scanner, worker, goal);
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting RoasteryLogistics. Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }

    private static void showMainMenu() {
        System.out.println("Welcome to RoasteryLogistics");
        System.out.println();
        System.out.println("Select your role:");
        System.out.println("1. Manager");
        System.out.println("2. Harvester");
        System.out.println("3. Sorting & Cleaning Operator");
        System.out.println("4. Roaster");
        System.out.println("5. Grinder");
        System.out.println("6. Packager");
        System.out.println("7. Exit");
    }

    private static void runManagerMenu(Scanner scanner, Manager manager, ProductionGoal goal,
            ArrayList<ProductionWorker> workers) {
        boolean inManagerMenu = true;
        while (inManagerMenu) {
            manager.showMenu();
            int choice = InputValidator.readInt(scanner, "Select an option: ");
            switch (choice) {
                case 1:
                    setProductionGoals(scanner, goal);
                    break;
                case 2:
                    ReportService.displayOverallProgress(goal, workers);
                    break;
                case 3:
                    ReportService.displayRoleProgress(workers, goal);
                    break;
                case 4:
                    inManagerMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void setProductionGoals(Scanner scanner, ProductionGoal goal) {
        System.out.println("Set Production Goals");
        String goalPeriod = InputValidator.readNonEmptyString(scanner, "Goal Period (Daily/Weekly/Monthly): ");
        goal.setGoal(goalPeriod);

        System.out.println("Weight Targets:");
        goal.setHarvestWeightTarget(InputValidator.readPositiveDouble(scanner, "Harvest Target (kg): "));
        goal.setSortingCleaningWeightTarget(
                InputValidator.readPositiveDouble(scanner, "Sorting & Cleaning Output Target (kg): "));
        goal.setRoastingWeightTarget(InputValidator.readPositiveDouble(scanner, "Roasting Output Target (kg): "));
        goal.setGrindingWeightTarget(InputValidator.readPositiveDouble(scanner, "Grinding Output Target (kg): "));
        goal.setPackagingWeightTarget(InputValidator.readPositiveDouble(scanner, "Packaging Output Target (kg): "));

        System.out.println("Quality Targets:");
        goal.setHarvestQualityTarget(InputValidator.readPercentage(scanner, "Harvest Quality Target (%): "));
        goal.setSortingCleaningQualityTarget(
                InputValidator.readPercentage(scanner, "Sorting & Cleaning Quality Target (%): "));
        goal.setRoastingQualityTarget(InputValidator.readPercentage(scanner, "Roasting Quality Target (%): "));
        goal.setGrindingQualityTarget(InputValidator.readPercentage(scanner, "Grinding Quality Target (%): "));
        goal.setPackagingQualityTarget(InputValidator.readPercentage(scanner, "Packaging Quality Target (%): "));

        System.out.println("Goals updated successfully.");
    }

    private static void runWorkerMenu(Scanner scanner, ProductionWorker worker, ProductionGoal goal) {
        boolean inWorkerMenu = true;
        while (inWorkerMenu) {
            ReportService.displayCurrentGoal(goal);
            worker.showMenu();
            int choice = InputValidator.readInt(scanner, "Select an option: ");
            switch (choice) {
                case 1:
                    worker.recordWork(scanner, goal);
                    break;
                case 2:
                    worker.viewContribution(goal);
                    break;
                case 3:
                    inWorkerMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
