import java.util.Random;

public class Background {
    private Ball backgroundStars[]; 

    public Background(GameArena window, int xRes, int yRes)
    {
        int xCoord, yCoord, radius;
        backgroundStars = new Ball[400];
        Random generator = new Random();

        for (int i = 0; i < 400; i++){
            xCoord = generator.nextInt(xRes);
            yCoord = generator.nextInt(yRes) + 100;
            radius = generator.nextInt(7) - 3; //general radius of stars
            backgroundStars[i] = new Ball(xCoord, yCoord, radius, "#FFFFFF");
            window.addBall(backgroundStars[i]);
        }
    }   
}
