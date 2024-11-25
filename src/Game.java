import controller.Controller;
import controller.IController;
import controller.Input;
import controller.ValorController;
import static controller.Color.BLACK;
import static controller.Color.BLUE;
import static controller.Color.RED;
import static controller.Color.RESET;
import static controller.Color.YELLOW;
/**
 * The main class to play game.
 */
public class Game {
    public static void main(String[] args) {
        IController controller = null;
        System.out.println(YELLOW+"\nSELECT THE GAME TO PLAY:"+RESET);
        System.out.println(BLUE+"1. Legends: Monsters and Heroes"+RESET);
        System.out.println(RED+"2. Legends of Valor"+RESET);
        System.out.println(BLACK+"0. Quit\n"+RESET);

        int index = Input.enterInt("Please select", 0, 2);
        if (index == 0) {
            return;
        } else if (index == 1) {
            controller = new Controller();
        } else {
            controller = new ValorController();
        }

        controller.showGameInfo();
        controller.play();
    }
}
