import java.util.Random;

public class CarGame {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        int patrol = 30;
        int carPosition = 0;
        int[] patrolPump = {10, 20, 40, 60, 80};
        Random rand = new Random();
        int i = 0;
        while(patrol != 0) {
            if (patrol <= 0) {
                break;
            }

            int random = rand.nextInt(6);
            carPosition = carPosition + random;
            patrol = patrol - random;
            System.out.println("Move " + ++i + " - car at " + carPosition + ", petrol remaining " + patrol);

            if(patrol == patrolPump[0] || patrol == patrolPump[1] || patrol == patrolPump[2] ||
            patrol == patrolPump[3] || patrol == patrolPump[4]) {
                patrol = patrol + 20;
            }

            if(carPosition >= 100) {
                System.out.println("Reached!");
                break;
            }
        }

        if(patrol <= 0) {
            System.out.println("Game Over!");
        }
    }
}