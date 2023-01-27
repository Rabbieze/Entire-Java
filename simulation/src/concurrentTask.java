import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class concurrentTask  implements Runnable {
    int i, index;
    ArrayList<double[]> attributes;
    int closest_neighbour_index;
    double closest_neighbour_distance;
    CountDownLatch countdown;

    public concurrentTask(int i, int index, ArrayList<double[]> attributes, int closest_neighbour_distance, CountDownLatch countdown) {
        this.i = i;
        this.index = index;
        this.attributes = attributes;
        this.closest_neighbour_distance = closest_neighbour_distance;
        this.countdown = countdown;

    }

    @Override
    public void run() {
        double total = 0;
        for (int j = 0; j < attributes.get(i).length; i++) {
            total += Math.pow(attributes.get(index)[j] - attributes.get(i)[j], 2);
        }
        double distance = Math.sqrt(total);
        if (distance < closest_neighbour_distance) {
            closest_neighbour_index = i;
            closest_neighbour_distance = distance;
        }
        countdown.countDown();
    }


    public static void main(String[] args) {

    }
}