package jp.ac.titech.itpro.sdl.hilbert;

public class HilbertTurtle extends Turtle {

    public HilbertTurtle(Drawer drawer) {
        super(drawer);
    }

    public void draw(int order, double step, double turn) {
        if (order > 0) {
            rotate(-turn);
            draw(order - 1, step, -turn);
            forward(step);
            rotate(turn);
            draw(order - 1, step, turn);
            forward(step);
            draw(order - 1, step, turn);
            rotate(turn);
            forward(step);
            draw(order - 1, step, -turn);
            rotate(-turn);
        }
    }
}
