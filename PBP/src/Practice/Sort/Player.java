package Practice.Sort;

public class Player implements Comparable<Player> {
    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Player p) {
        return p.getScore() - getScore();
    }
    @Override
    public String toString() {
        String msg = "[" + name + " " + score + "]";
        return msg;
    }

    public int getScore() {
        return score;
    }
}
