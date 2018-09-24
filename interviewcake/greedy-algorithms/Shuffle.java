public class InPlaceShuffle {

    public int getRandom(int floor, int ceiling) {
        int range = (ceiling - floor) + 1;
        return (int) (Math.random() * range) + floor;
    }

    public static void shuffle1(int[] numbers) {
        int floor = 0;
        int ceiling = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            int j = getRandom(floor, ceiling);
            floor++;
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }

    // this is not the optimal solution, but an attempt to try to randomise the positions of each placement
    // instead of the numbers like in the solution above
    public static void shuffle2(int[] numbers) {
        // positions is 0, 1, 2, 3...
        // we keep a list with the positions and remove the used ones
        // we will also get positions randomly from this list
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            positions.add(i);
        }

        int floor = 0;
        int ceiling = positions.size() - 1;
        for (int i = 0; i < numbers.length; i++) {
            int randomIndex = getRandom(floor, ceiling);
            int j = positions.get(randomIndex);
            positions.remove(randomIndex);
            ceiling--;
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }

}