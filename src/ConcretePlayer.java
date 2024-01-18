public class ConcretePlayer implements Player {
    //creat class to the real player
    private boolean isPlayerOne;
    private int countWins;

    public ConcretePlayer(boolean isPlayerOne) {
        this.isPlayerOne = isPlayerOne;
        countWins = 0;
    }

    @Override
    public boolean isPlayerOne() {
        return isPlayerOne;

    }

    @Override
    public int getWins() {
        return countWins;
    }
}
