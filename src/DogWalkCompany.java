public class DogWalkCompany {
    private int[] dogsPerHour;
    public DogWalkCompany() {
        dogsPerHour = new int[24];
    }
    public int addDogs(int hour, int numDogs) {
        dogsPerHour[hour] += numDogs;
        return hour;
    }
    public int numAvailableDogs(int hour) {
        return dogsPerHour[hour];
    }
    public void updateDogs(int hour, int numWalked) {
        dogsPerHour[hour] -= numWalked;
        if (dogsPerHour[hour] < 0) {
            dogsPerHour[hour] = 0;
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dogsPerHour.length; i++) {
            sb.append(i).append(":00 -> ").append(dogsPerHour[i]).append(" dogs\n");
        }
        return sb.toString();
    }
}
