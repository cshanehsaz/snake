/*  
 *  Name: Cyrus Shanehsaz
 *  PennKey: cyrussh
 *  Recitation: 207
 *
 *  Execution: N/A not an execution function
 *
 *  Stores the coordinates and direction of
 *  each individual piece of the snake as
 *  well as the new piece on the board.
 *
 */
public class SlitherBody {
    private int xCoor;
    private int yCoor;
    
    //directions are: 0 - none 1 - up, 2 - right, 3 - down, 4 - left
    private int direction;
    
    /*
     * Description: Constructor for SlitherBody instance
     * Input: xCoor - desired x coordinate
     *        yCoor - desired y coordinate
     * Output: SlitherBody instance
     * 
     */
    public SlitherBody(int xCoor, int yCoor) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.direction = 0;
    }
    
    /*
     * Description: Constructor for SlitherBody instance
     *              with direction included
     * Input: xCoor - desired x coordinate
     *        yCoor - desired y coordinate
     *        direction - desired direction
     * Output: SlitherBody instance
     * 
     */
    public SlitherBody(int xCoor, int yCoor, int direction) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.direction = direction;
    }
    
    /*
     * Description: Moves xCoor by x
     * Input: x - some amount to move
     * Output: N/A
     * 
     */
    public void xMove(int x) {
        xCoor += x;
    }
    
    /*
     * Description: Moves yCoor by y
     * Input: y - amount to move
     * Output: N/A
     * 
     */
    public void yMove(int y) {
        yCoor += y;
    }
    
    /*
     * Description: getter for xCoor
     * Input: N/A
     * Output: x coordinate
     * 
     */
    public int getX() {
        return xCoor;
    }
    
    /*
     * Description: getter for yCoor
     * Input: N/A
     * Output: y coordinate
     * 
     */
    public int getY() {
        return yCoor;
    }
    
    /*
     * Description: getter for direction
     * Input: N/A
     * Output: direction
     * 
     */
    public int getDir() {
        return direction;
    }
    
    /*
     * Description: setter for x
     * Input: xCoor - desired x coordinate
     * Output: N/A
     * 
     */
    public void setX(int xCoor) {
        this.xCoor = xCoor;
    }
    
    /*
     * Description: setter for y
     * Input: yCoor - desired y coordiante
     * Output: N/A
     * 
     */
    public void setY(int yCoor) {
        this.yCoor = yCoor;
    }
    
    /*
     * Description: setter for direction
     * Input: direction - int from 0-4 to set direction
     * Output: N/A
     * 
     */
    public void setDir(int direction) {
        this.direction = direction;
    }
}