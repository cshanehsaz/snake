/*  
 *  Name: Cyrus Shanehsaz
 *  PennKey: cyrussh
 *  Recitation: 207
 *
 *  Execution: N/A not an execution function
 *
 *  Stores the collection of SlitherBody instances
 *  that make up the actual snake in game. 
 *
 */
import java.util.ArrayList;

public class Slither {
    private ArrayList<SlitherBody> bodyParts = new ArrayList<SlitherBody>();
    private SlitherBody head;
    
    /*
     * Description: constructor - creates new slither instance
     * Input: xCoor - desired x coordinate of the head
     *        yCoor - desired y coordinate of the head
     *        direction - desired direction of the head
     * Output: slither object
     * 
     */
    public Slither(int xCoor, int yCoor, int direction) {
        head = new SlitherBody(xCoor, yCoor, direction);
        bodyParts.add(head);
    }
    
    /*
     * Description: checks if the direction needs to be updated
     *              based on keyboard inputs
     * Input: body - head of the slither instance
     *        ch - character input from keyboard
     * Output: true if direction does not need to be changed
     *         false if direction needs to be changed
     * 
     */
    public boolean checkDirMatch(SlitherBody body, char ch) {
        if (ch == 'w' || ch == 's') {
            if (body.getDir() == 1 || body.getDir() == 3) {
                return true;
            }
            return false;
        }
        if (ch == 'a' || ch == 'd') {
            if (body.getDir() == 2 || body.getDir() == 4) {
                return true;
            }
            return false;
        }
        return true;
    }

    /*
     * Description: advances each part of the snake by one frame
     *              based on direction of head
     * Input: N/A
     * Output: N/A
     * 
     */
    public void advance() {
        int pos = bodyParts.size() - 1;
        for (SlitherBody body = bodyParts.get(pos); body != head; 
            body = bodyParts.get(pos)) {
                
                body.setX(bodyParts.get(pos - 1).getX());
                body.setY(bodyParts.get(pos - 1).getY());
                pos--;
            }
            
            if (head.getDir() == 1) {
                head.yMove(1);
            }
            else if (head.getDir() == 3) {
                head.yMove(-1);
            }
            else if (head.getDir() == 2) {
                head.xMove(1);
            }
            else if (head.getDir() == 4) {
                head.xMove(-1);
            }            
    }
    
    /*
     * Description: advances each part of the snake by one frame
     *              based on direction of the head. Changes
     *              direction based on keyboard input
     * Input: ch - keyboard input indicating direction
     * Output: N/A
     * 
     */
    public void advance(char ch) {
        int pos = bodyParts.size() - 1;
        for (SlitherBody body = bodyParts.get(pos); body != head; 
            body = bodyParts.get(pos)) {
                
                body.setX(bodyParts.get(pos - 1).getX());
                body.setY(bodyParts.get(pos - 1).getY());
                pos--;
                //System.out.println(pos - 1);
            }
            //see if direction needs to be changed
            //if so, update direction
            if (!checkDirMatch(head, ch)) {
                if (ch == 'w') {
                    head.setDir(1);
                }
                else if (ch == 'd') {
                    head.setDir(2);
                }
                else if (ch == 's') {
                    head.setDir(3);
                }
                else if (ch == 'a') {
                    head.setDir(4);
                }
            }
            
            if (head.getDir() == 1) {
                head.yMove(1);
            }
            else if (head.getDir() == 3) {
                head.yMove(-1);
            }
            else if (head.getDir() == 2) {
                head.xMove(1);
            }
            else if (head.getDir() == 4) {
                head.xMove(-1);
            }
    }

    /*
     * Description: copies the tail piece to a new
     *              piece to be added to the snake 
     *              in the next frame.
     * Input: N/A
     * Output: N/A
     * 
     */
    public SlitherBody addition() {
        int last = bodyParts.size() - 1;
        SlitherBody lastBody = bodyParts.get(last);
        SlitherBody newPiece = 
            new SlitherBody(lastBody.getX(), lastBody.getY(), 
                            lastBody.getDir());
        return newPiece;
    }
    
    
    /*
     * Description: adds to the ArrayList of slither
     * Input: body - SlitherBody instance to add
     * Output: N/A
     * 
     */
    public void add(SlitherBody body) {
        bodyParts.add(body);
    }
    
    /*
     * Description: getter for the ArrayList
     * Input: N/A
     * Output: bodyParts array list
     * 
     */
    public ArrayList<SlitherBody> getBodyParts() {
        return bodyParts;
    }
    
    /*
     * Description: getter for the head of the snake
     * Input: N/A
     * Output: head of the slither snake
     * 
     */
    public SlitherBody getHead() {
        return head;
    }
    
    /*
     * Description: toString for testing
     * Input: N/A
     * Output: prints coordinates of each piece
     *         of snake
     * 
     */
    public String toString() {
        String ans = "";
        for (SlitherBody body : bodyParts) {
            ans += "(" + body.getX() + ", " + body.getY() + ") ";
        }
        return ans;
    }    
}