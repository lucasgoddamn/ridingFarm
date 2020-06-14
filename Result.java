package ridingFarm;

import java.util.*;

public class Result {

    private int score;
    private Map<horseman,horse> map;

    public Result(){
        map = new HashMap<>();
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Map<horseman, horse> getMap() {
        return map;
    }

    public void setMap(Map<horseman, horse> map) {
        this.map = map;
    }

    public void increaseScore() {

        score++;
    }


    @Override
    public String toString(){
        StringBuilder b = new StringBuilder("Result of matching\n");
        for (Map.Entry<horseman, horse> match : map.entrySet()) {
            b.append(String.format(" %10s -> %-10s\n", match.getKey().getName(), match.getValue().getName()));
        }
        b.append(String.format("Score: %d", score));
        return b.toString();
    }
}
