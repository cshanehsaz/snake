/*  
 *  Name: Cyrus Shanehsaz
 *  PennKey: cyrussh
 *  Recitation: 207
 *
 *  Execution: N/A not an execution function
 *
 *  Stores the current game score as well as
 *  the high scores from past runs.
 */
import java.util.ArrayList;

public class Scoreboard {
    private int score;
    private ArrayList<Integer> highScores = new ArrayList<Integer>();
    
    /*
     * Description: constructor for scoreboard. Sets game score
     *              and all high scores to default 1.
     * Input: N/A
     * Output: Scoreboard instance
     * 
     */
    public Scoreboard() {
        score = 1;
        for (int i = 0; i < 5; i++) {
            highScores.add(1);
        }
    }
    
    /*
     * Description: getter for current game score 
     * Input: N/A
     * Output: int current game score
     * 
     */
    public int getScore() {
        return score;
    }
    
    /*
     * Description: increments game score by +1
     * Input: N/A
     * Output: N/A
     * 
     */
    public void incScore() {
        score++;
    }
    
    /*
     * Description: sets current game score back to 1
     * Input: N/A
     * Output: N/A
     * 
     */
    public void resetScore() {
        score = 1;
    }
    
    /*
     * Description: getter for ArrayList of high scores
     * Input: N/A
     * Output: Array list of high scores
     * 
     */
    public ArrayList<Integer> getHighScores() {
        return highScores;
    }
    
    /*
     * Description: adds high score if greater than current
     *              high scores and bumps off old high scores
     * Input: final current game score
     * Output: N/A
     * 
     */
    public void addHighScore(int newScore) {
        for (int i = 0; i < highScores.size(); i++) {
            if (newScore > highScores.get(i)) {
                highScores.add(i, newScore);
                highScores.remove(highScores.size() - 1);
                break;
            }
        }
    }
}