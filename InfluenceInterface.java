/**
 * The Influence interface describes any external influence on a student
 * with regards to scheduling assignments such as energy level, 
 * motivation, stress, etc.
 */
public interface InfluenceInterface {
    
    public String level = "none";

    String getLevel();

    void changeLevel(String newLevel);

}