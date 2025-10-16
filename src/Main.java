import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DogWalkCompany[] companies = new DogWalkCompany[1000];
        Scanner companyReader = new Scanner(new File("companies.txt"));
        int companyCount = 0;
        while (companyReader.hasNextLine() && companyCount < 1000) {
            DogWalkCompany company = new DogWalkCompany();
            String[] dogs = companyReader.nextLine().trim().split(" ");
            for (int hour = 0; hour < 24; hour++) {
                int numDogs = Integer.parseInt(dogs[hour]);
                company.addDogs(hour, numDogs);
            }
            companies[companyCount] = company;
            companyCount++;
        }
        companyReader.close();
        System.out.println(companyCount + " companies");
        DogWalker[] walkers = new DogWalker[10000];
        int[][] walkerShifts = new int[10000][2];
        int walkerCount = 0;
        Scanner walkerReader = new Scanner(new File("walkers.txt"));
        while (walkerReader.hasNextLine() && walkerCount < 10000) {
            String[] data = walkerReader.nextLine().trim().split(" ");
            int maxDogs = Integer.parseInt(data[0]);
            int companyNum = Integer.parseInt(data[1]);
            int startHour = Integer.parseInt(data[2]);
            int endHour = Integer.parseInt(data[3]);
            walkers[walkerCount] = new DogWalker(companies[companyNum], maxDogs);
            walkerShifts[walkerCount][0] = startHour;
            walkerShifts[walkerCount][1] = endHour;
            walkerCount++;
        }
        walkerReader.close();
        System.out.println(walkerCount + " walkers");
        int totalPay = 0;
        for (int i = 0; i < walkerCount; i++) {
            int start = walkerShifts[i][0];
            int end = walkerShifts[i][1];
            int pay = walkers[i].dogWalkShift(start, end);
            totalPay += pay;
        }
        System.out.println("total pay " + totalPay);
    }
}
