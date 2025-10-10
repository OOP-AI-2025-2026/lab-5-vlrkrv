package ua.opnu;

public class GameShape {

    @Override
    public String toString() {
        return "Game shape";
    }
}
class Rock extends GameShape {
    @Override
    public String toString() {
        return "Rock";
    }
}

class Paper extends GameShape {
    @Override
    public String toString() {
        return "Paper";
    }
}

class Scissors extends GameShape {
    @Override
    public String toString() {
        return "Scissors";
    }
}
