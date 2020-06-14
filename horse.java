package ridingFarm;

public class horse {

    private String name;
    private int reqSkillLevel;

    public horse(String name, int reqSkillLevel){
        this.name = name;
        this.reqSkillLevel = reqSkillLevel;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getReqSkillLevel() {
        return reqSkillLevel;
    }

    public void setReqSkillLevel(int reqSkillLevel) {
        this.reqSkillLevel = reqSkillLevel;
    }
}
