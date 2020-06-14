package ridingFarm;

import java.util.*;
import java.io.*;

public class horseMatchingMachine {

    private List<horse> horses;
    private List<horseman> horsemen;

    public horseMatchingMachine() {
        horses = new ArrayList<horse>();
        horsemen = new ArrayList<horseman>();
    }

    public void scanPaths () {
        boolean er = true;
        while(er){
            System.out.println("Enter the path to your horse file");
            String horsePath = hMethods.getFilePath();
            System.out.println("Enter the path to your horseman file");
            String horsemanPath = hMethods.getFilePath();
            try{
                loadData(horsemanPath, horsePath);
                er = false;
            } catch(nonValidFormException e) {
                System.out.println("Reading File failed: " + e.getMessage());
            }
        }
        Result r = match(horsemen, horses);
        System.out.println(r.toString());
    }

    public void loadData(String horsemanPath, String horsePath) throws nonValidFormException{

        try {
            File sourceFile = new File(horsePath);
            FileInputStream fis = new FileInputStream(sourceFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] elements = line.split(";");
                if (elements.length != 2) {
                    throw new nonValidFormException("The form of your horse File is incorrect");
                }
                horse horse = new horse(elements[0], Integer.parseInt(elements[1]));
                horses.add(horse);
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        try {
            File sourceFile = new File(horsemanPath);
            FileInputStream fis = new FileInputStream(sourceFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] elements = line.split(";");
                if (elements.length < 2) {
                    throw new nonValidFormException("The form of your horsemen File is incorrect");
                }
                List<horse> wishedHorses = new ArrayList<horse>();
                for (int i = 2; i < elements.length; i++) {
                    boolean found = false;
                    for (horse h : horses) {
                        if (h.getName().equals(elements[i])) {
                            wishedHorses.add(h);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        throw new nonValidFormException("Error: horsename not found(" + elements[i] + ")");
                    }
                }
                horseman horseman = new horseman(elements[0], Integer.parseInt(elements[1]), wishedHorses);
                horsemen.add(horseman);
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public Result match(List<horseman> horsemenList, List<horse> horseList) {

        Result result = new Result();
        for (horseman horseman : horsemenList) {
            for (horse horse : horseList) {

                if (horseman.getSkillLevel() >= horse.getReqSkillLevel()) {

                    List<horseman> new_horsemenList = new ArrayList<>(horsemenList.size());
                    new_horsemenList.addAll(horsemenList);
                    new_horsemenList.remove(horseman);

                    List<horse> new_horseList = new ArrayList<>(horseList.size());
                    new_horseList.addAll(horseList);
                    new_horseList.remove(horse);

                    Result new_result = match(new_horsemenList, new_horseList);

                    new_result.getMap().put(horseman, horse);
                    new_result.increaseScore();
                    if (horseman.getWish().contains(horse)) {
                        new_result.increaseScore();
                    }

                    if (new_result.getScore() > result.getScore()) {
                        result = new_result;
                    }
                }
            }

        }
        return result;
    }
}
