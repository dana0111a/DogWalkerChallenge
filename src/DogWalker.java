public class DogWalker {
    private DogWalkCompany company;
    private int maxDogsPerHour;
    public DogWalker(DogWalkCompany c, int maxDogs) {
        company = c;
        maxDogsPerHour = maxDogs;
    }
    public int walkDogs(int hour) {
        int available = company.numAvailableDogs(hour);
        int walked;
        if (available <= maxDogsPerHour) {
            walked = available;
        } else {
            walked = maxDogsPerHour;
        }
        company.updateDogs(hour, walked);
        return walked;
    }
    public int dogWalkShift(int startHour, int endHour) {
        int pay = 0;
        int hour = startHour;
        while (hour <= endHour) {
            int walked = walkDogs(hour);
            pay += walked * 5;
            if (walked == maxDogsPerHour) {
                pay += 3;
            }
            hour++;
        }
        return pay;
    }
}