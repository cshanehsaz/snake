/*  
 *  Name: Cyrus Shanehsaz
 *  PennKey: cyrussh
 *  Recitation: 207
 *
 *  Execution: java Snake
 *
 *  Runs the snake game. Use WASD to control
 *  your snake without hitting the walls or 
 *  your tail!
 *
 */

public class Snake {
    
    /*
     * Description: checks if a key has been pressed. If so,
     *  see if direction needs to be changed. If not, advance
     *  the snake in its current direction.
     * Input: slither - the snake to control
     *        scoreboard - redraws the score
     * Output: N/A
     * 
     */
    public static void move(Slither slither, Scoreboard scoreboard) {
        if (PennDraw.hasNextKeyTyped()) {
            
            PennDraw.clear(PennDraw.BLACK);
            Snake.drawBorders(scoreboard);
            
            char input = PennDraw.nextKeyTyped();
            if (input == 'w' ||
                input == 'a' ||
                input == 's' ||
                input == 'd') {
                slither.advance(input);
            } else {
                System.out.println("not a valid key");
                slither.advance();
            }
        } else {
            PennDraw.clear(PennDraw.BLACK);
            Snake.drawBorders(scoreboard);
            slither.advance();
        }
        
    }
    
    /*
     * Description: creates a new SlitherBody piece
     *              that must be eaten by snake
     * Input: slither - checks to make sure it doesn't
     *                  spawn inside snake
     * Output: new SlitherBody block to be eaten
     * 
     */
    public static SlitherBody spawnBody(Slither slither) {
        while (true) {
            int x = (int) Math.floor(Math.random() * 41);
            int y = (int) Math.floor(Math.random() * 41);
            for (SlitherBody body : slither.getBodyParts()) {
                if (x == body.getX() && y == body.getY()) {
                    continue;
                }
            }
            SlitherBody newPiece = new SlitherBody(x, y);
            return newPiece;
        }
    }

    /*
     * Description: draws the right side border and the
     *              scores
     * Input: scoreboard - gets the current and high scores
     * Output: N/A
     * 
     */
    public static void drawBorders(Scoreboard scoreboard) {
        double size = 0.53;
        for (int y = 0; y < 49; y++) {
            PennDraw.filledRectangle(41, y, size, size);
        }
        PennDraw.text(45, 35, "Score: " + scoreboard.getScore());
        PennDraw.text(45, 30, "High Scores:");
        PennDraw.text(45, 28, "1: " + scoreboard.getHighScores().get(0));
        PennDraw.text(45, 26, "2: " + scoreboard.getHighScores().get(1));
        PennDraw.text(45, 24, "3: " + scoreboard.getHighScores().get(2));
        PennDraw.text(45, 22, "4: " + scoreboard.getHighScores().get(3));
        PennDraw.text(45, 20, "5: " + scoreboard.getHighScores().get(4));
                      
        
    }
    
    /*
     * Description: checks to see if the head of the snake
     *              has collided with walls or itself
     * Input: slither - checks the position of the head
     *                  and all body parts
     * Output: true if collision has occurred
     *         false otherwise
     * 
     */
    public static boolean checkCollision(Slither slither) {
        SlitherBody head = slither.getBodyParts().get(0);
        int xCoor = head.getX();
        int yCoor = head.getY();
        
        //check if the head has collided with walls
        if (xCoor < 0 || xCoor > 40) {
            return true;
        }
        if (yCoor < 0 || yCoor > 40) {
            return true;
        }
        
        //check if has collided with body
        for (SlitherBody body : slither.getBodyParts()) {
            if (body == slither.getBodyParts().get(0)) {
                continue;
            }
            if (xCoor == body.getX() && yCoor == body.getY()) {
                return true;
            }
        }
        
        return false;   
    }
    
    /*
     * Description: checks if the head of the snake 
     *              has eaten the food
     * Input: newPiece - the current food on the board
     *        slither - the snake
     * Output: true if the head is in same spot as food
     *         false otherwise
     * 
     */
    public static boolean checkAddition(SlitherBody newPiece, Slither slither) {
        if (newPiece.getX() == slither.getHead().getX() && 
            newPiece.getY() == slither.getHead().getY()) {
            return true;
        }
        return false;
    }
    
    /*
     * Description: Runs the game
     * Input: N/A
     * Output: N/A
     * 
     */
    public static void main(String[] args) {
        PennDraw.setCanvasSize(600, 500);
        PennDraw.setXscale(-0.5, 48.5);
        PennDraw.setYscale(-0.5, 40.5);
        PennDraw.setFontSize(15);
        double size = 0.53;
        Scoreboard scoreboard = new Scoreboard();
        
        while (true) {
            PennDraw.clear(PennDraw.BLACK);
            Snake.drawBorders(scoreboard);
            PennDraw.setPenColor(PennDraw.WHITE);
            
            scoreboard.resetScore();
            
            PennDraw.text(20, 20, "Press any key to play!");
            while (true) {
                if (PennDraw.hasNextKeyTyped()) {
                    break;
                }
            }
            
            
            //draw background and setup the border
            PennDraw.clear(PennDraw.BLACK);
            Snake.drawBorders(scoreboard);
            
            //create the slither
            Slither slither = new Slither(20, 20, 1);
            
            SlitherBody newPiece = spawnBody(slither);
            boolean addNew = false;
            SlitherBody addition = null;
            
            PennDraw.enableAnimation(10);
            while (true) {
                
                addNew = Snake.checkAddition(newPiece, slither);
                if (addNew) {
                    addition = slither.addition();
                }

                Snake.move(slither, scoreboard);

                if (addNew) {
                    newPiece = Snake.spawnBody(slither);
                    slither.add(addition);
                    scoreboard.incScore();
                    addNew = false;
                }
                
                //draw slither
                for (SlitherBody body : slither.getBodyParts()) {
                    PennDraw.filledRectangle(body.getX(), body.getY(), size, size);
                }
                //draw newPiece
                PennDraw.filledRectangle(newPiece.getX(), newPiece.getY(), 
                                         size, size);
                
                PennDraw.advance();
               
                
                if (checkCollision(slither)) {
                    PennDraw.disableAnimation();
                    break;
                }
            }
            //losing screen
            scoreboard.addHighScore(scoreboard.getScore());
            PennDraw.text(20, 20, "You lose!");
            PennDraw.text(20, 10, "Press y to start again!");
            while (true) {
                if (PennDraw.hasNextKeyTyped()) {
                    if (PennDraw.nextKeyTyped() == 'y') {
                        break;
                    }
                }
            }
        }
    }
}