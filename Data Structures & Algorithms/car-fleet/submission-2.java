

class Car {
    int pos;
    double time;

    Car(int pos, double time) {
        this.pos = pos;
        this.time = time;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<Car> cars = new ArrayList<>();
        
        for (int i = 0; i < speed.length; i++) {
            double time = (double) (target - position[i]) / speed[i];
            cars.add(new Car(position[i], time));
        }

        // Sort by position in descending order (closest to target first)
        cars.sort((a, b) -> Integer.compare(b.pos, a.pos));

        Stack<Double> stack = new Stack<>();

        for (Car c : cars) {
            // If the stack is not empty, check the time of the fleet immediately ahead.
            // If the current car's time is LESS than or EQUAL to the fleet ahead,
            // it catches up and becomes part of that same fleet. We do nothing (don't push).
            if (!stack.isEmpty() && c.time <= stack.peek()) {
                continue;
            }
            
            // Otherwise, it cannot catch up, so it forms a new fleet.
            stack.push(c.time);
        }

        return stack.size();
    }
}