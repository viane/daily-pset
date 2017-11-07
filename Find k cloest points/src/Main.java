import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws IOException {
        double min = -20, max = 20;
        Random rand = new Random();
        List<Tuple> testPoints = new ArrayList<Tuple>();
        for (int i =0; i <rand.nextInt(20)+10; i++){
            testPoints.add(new Tuple(Math.floor(ThreadLocalRandom.current().nextDouble(min, max)*100) / 100,Math.floor(ThreadLocalRandom.current().nextDouble(min, max)*100) / 100));
        }

        System.out.println("Random test points: " + testPoints);

        System.out.print("Enter how many k points need: ");
        int k = new Scanner(System.in).nextInt();

        Solution sol = new Solution(testPoints);

        System.out.println(k + " closest points: " + sol.findCloestPoints(k));
    }
}
