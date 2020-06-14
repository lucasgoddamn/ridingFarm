package ridingFarm;

import java.util.*;

public class horseman {

    private String name;
    private int skillLevel;
    private List<horse> wish;

    public horseman(String name, int difficulty, List<horse> wishedHorses) {

        this.name = name;
        this.skillLevel= skillLevel;
        this.wish = wish;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public List<horse> getWish(){
        return wish;
    }

    public void setWish(List<horse> wish) {
        this.wish = wish;
    }


}
