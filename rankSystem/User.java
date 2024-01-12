import java.util.*;

public class User {
    private int userRank;
    private int userProgress;
    private ArrayList<Integer> rankRange;

    public User(){
        userProgress = 0;
        rankRange = new ArrayList<Integer>(Arrays.asList(-8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8));
        userRank = rankRange.get(0);
    }

    public int rank(){
        return userRank;
    }

    public int progress(){
        return userProgress;
    }

    public void incRank(){
        try{
            userRank = rankRange.get(rankRange.indexOf(userRank) + 1);
        }
        catch(Exception e){
            System.out.println("You cannot rank up more");
        }
    }

    public int getPoints(int level){
        int rankIndex = rankRange.indexOf(userRank);
        int levelIndex = rankRange.indexOf(level);
        if(rankIndex == levelIndex){
            return 3;
        }
        else if(rankIndex < levelIndex){
            int d = levelIndex - rankIndex;
            return 10 * d * d;
        }
        else if((levelIndex + 1) == rankIndex){
            return 1;
        }
        else{
            return 0;
        }
    }

    public void incProgress(int level){
        if(level == 0 || level < -8 || level > 8){
            throw new IllegalArgumentException("Rank input out of range");
        } 
        int points = getPoints(level);
        System.out.println(points);
        int newPoints = userProgress + points;
        if(newPoints >= 100){
            if (userRank == 8) {
                userProgress = 0;
                System.out.println("You cannot get more points");
            }
            if (points > 100) {
                while (points > 100 && userRank < 8) {
                    incRank();
                    points -= 100;
                    if (userRank == 8) {
                        userProgress = 0;
                        System.out.println("You cannot get more points");
                        break;
                    }
                    userProgress = newPoints % 100;
                }
            }
            else{
                incRank();
                userProgress = newPoints % 100;
            }
        }
        else{
            userProgress += points;
        }
    }
}
