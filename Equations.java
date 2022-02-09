import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Equations here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Equations extends Solve

{
    /**
     * Act - do whatever the Equations wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int count = 0;

    String key;
    String upImage;
    String downImage;

    boolean answeredGood = false;

    int value;
    int position;
    int answer;
    int score = 0;
    
    int index = 0;
    int number1;
    int number2;

    int positionGoodAnswer = 0;
    int newPosition = 0;
    int[] randomNumbers;
    int randSound = Greenfoot.getRandomNumber(500) + 100;

    public Equations() {
        setImage(new GreenfootImage("                  ", 60, Color.WHITE, new Color(8,156,228 ))); 

    }

    public void act()
    {
        // Add your action code here.
        
        if (((AdditionWorld)getWorld()).declaredWinner == false) {
            if (count == 0) 
                printOnBoard();
            if (count - newPosition > 20)
                answeredGood = false;
            findIfTouched();
        }
        waterSoundSwimming();
        count++;


    }


    public boolean verifyClick1() {
        if(Greenfoot.mouseClicked(null) == true){
            if(Greenfoot.getMouseInfo() == null){return false;}
            Actor a = Greenfoot.getMouseInfo().getActor();
            if (a instanceof Squares1) {
                return true;
            }
        } 
        return false;
    }

    public boolean verifyClick2() {
        if(Greenfoot.mouseClicked(null) == true){
            if(Greenfoot.getMouseInfo() == null){return false;}
            Actor a = Greenfoot.getMouseInfo().getActor();
            if (a instanceof Squares2) {
                return true;
            }
        } 
        return false;
    }

    public boolean verifyClick3() {
        if(Greenfoot.mouseClicked(null) == true){
            if(Greenfoot.getMouseInfo() == null){return false;}
            Actor a = Greenfoot.getMouseInfo().getActor();
            if (a instanceof Squares3) {
                return true;
            }
        } 
        return false;
    }

    public boolean verifyClick4() {
        if(Greenfoot.mouseClicked(null) == true){
            if(Greenfoot.getMouseInfo() == null){return false;}
            Actor a = Greenfoot.getMouseInfo().getActor();
            if (a instanceof Squares4) {
                return true;
            }
        } 
        return false;
    }

    public void waterSoundSwimming() {
        if (count % randSound == 0) {
            Greenfoot.playSound("water5 _adjustedvolume.wav");
            randSound = Greenfoot.getRandomNumber(500) + 100;
        }

    }

    public void showAnswer() {
        ((AdditionWorld)getWorld()).firstOperand[((AdditionWorld)getWorld()).index] = number1;
        ((AdditionWorld)getWorld()).secondOperand[((AdditionWorld)getWorld()).index] = number2;
        ((AdditionWorld)getWorld()).thirdOperand[((AdditionWorld)getWorld()).index] = answer;
        ((AdditionWorld)getWorld()).index++;
        
        System.out.print("\n" + number1 + " " + number2 + " "+ answer);
        
        if (positionGoodAnswer == 1) {

            getWorld().showText("", 820, 540);
            getWorld().showText("", 930, 540);
            getWorld().showText("", 1040, 540);

            Greenfoot.delay(60);
            

        }

        else if (positionGoodAnswer == 2)  {

            getWorld().showText("", 710, 540);
            getWorld().showText("", 930, 540);
            getWorld().showText("", 1040, 540);

            Greenfoot.delay(60);
        }

        else if (positionGoodAnswer == 3) {    

            getWorld().showText("", 710, 540);
            getWorld().showText("", 820, 540);
            getWorld().showText("", 1040, 540);

            Greenfoot.delay(60);
        }

        else if (positionGoodAnswer == 4) {

            getWorld().showText("", 710, 540);
            getWorld().showText("", 820, 540);
            getWorld().showText("", 930, 540);

            Greenfoot.delay(60);
        }

    }

    public int[] generateNumbers(int sum) {
        int min = sum / 10 * 10;
        int max = min + 10;

        int n1 = Greenfoot.getRandomNumber(max - min + 1) + min;

        int n2 = Greenfoot.getRandomNumber(max - min + 1) + min;
        while (n2 == n1)
            n2 = Greenfoot.getRandomNumber(max - min + 1) + min;

        int n3 = Greenfoot.getRandomNumber(max - min + 1) + min;
        while (n3 == n2 || n3 == n1)
            n3 = Greenfoot.getRandomNumber(max - min + 1) + min;

        int n4 = Greenfoot.getRandomNumber(max - min + 1) + min;
        while (n4 == n3 || n4 == n2 || n4 == n1)
            n4 = Greenfoot.getRandomNumber(max - min + 1) + min;

        int[] arr = new int[4];
        arr[0] = n1;
        arr[1] = n2;
        arr[2] = n3;
        arr[3] = n4;

        boolean answerAlreadyThere = false;

        for (int i = 0; i < 4; i++)
            if (arr[i] == sum) {
                positionGoodAnswer = i + 1;
                answerAlreadyThere = true;
            }

        if (!answerAlreadyThere) {
            int newRandom = Greenfoot.getRandomNumber(3);
            positionGoodAnswer = newRandom + 1;
            arr[newRandom] = sum;
        }

        return arr;

    }

    public void printOnBoard() {
        //((Squares1)getWorld().getObjects(Squares1.class).get(0)).ok = 1;

        number1 = Greenfoot.getRandomNumber(100);
        number2 = Greenfoot.getRandomNumber(100);
        int temp;

        if (number2 > number1) {
            temp = number1;
            number1 = number2;
            number2 = temp;
        }

        int newRand = Greenfoot.getRandomNumber(2);

        if (newRand == 0) {
            answer = number1 + number2;
            setImage(new GreenfootImage("   " + number1 + " + " + number2 + " :   ", 60, Color.WHITE, new Color(8,156,228 ), Color.BLACK)); 
        }

        else {
            answer = number1 - number2;
            setImage(new GreenfootImage("   " + number1 + " - " + number2 + " :   ", 60, Color.WHITE, new Color(8,156,228 ), Color.BLACK)); 
        }

        int sum = answer;
        randomNumbers = generateNumbers(sum);

        Squares1 squares1 = new Squares1("" + 1, "white-key.jpeg", "white-key-down.jpeg",""+ randomNumbers[0], 1);
        getWorld().addObject(squares1, 710, 540);

        Squares2 squares2 = new Squares2("" + 2, "white-key.jpeg", "white-key-down.jpeg",""+ randomNumbers[1], 2);
        getWorld().addObject(squares2, 820, 540);

        Squares3 squares3 = new Squares3("" + 3, "white-key.jpeg", "white-key-down.jpeg",""+ randomNumbers[2], 3);
        getWorld().addObject(squares3, 930, 540);

        Squares4 squares4 = new Squares4("" + 4, "white-key.jpeg", "white-key-down.jpeg",""+ randomNumbers[3], 4);
        getWorld().addObject(squares4, 1040, 540);
    }

    public void goodAnswerSound() {
        Greenfoot.playSound("corect.wav");
    }

    public void wrongAnswerSound() {
        Greenfoot.playSound("wrong.wav");
    }

    public void advanceRightPlayer() {
        int positionPlayer = Characters.selectedPerson(); 
        
        if (positionPlayer == 1) {
            Actor fish = (Actor)getWorld().getObjects(FishPlayer.class).get(0);
            ((FishPlayer)getWorld().getObjects(FishPlayer.class).get(0)).setLocation(fish.getX() + 20, fish.getY());
        }
        
        if (positionPlayer == 2) {
            Actor fish1 = (Actor)getWorld().getObjects(FishPlayer1.class).get(0);
            ((FishPlayer1)getWorld().getObjects(FishPlayer1.class).get(0)).setLocation(fish1.getX() + 20, fish1.getY());
        }
        
        if (positionPlayer == 3) {
            Actor fish2 = (Actor)getWorld().getObjects(FishPlayer2.class).get(0);
            ((FishPlayer2)getWorld().getObjects(FishPlayer2.class).get(0)).setLocation(fish2.getX() + 20, fish2.getY());
        }
        
        if (positionPlayer == 4) {
            Actor fish3 = (Actor)getWorld().getObjects(FishPlayer3.class).get(0);
            ((FishPlayer3)getWorld().getObjects(FishPlayer3.class).get(0)).setLocation(fish3.getX() + 20, fish3.getY());
        }
    }

    public void moveBackPlayer() {
        int positionPlayer = Characters.selectedPerson(); 
        
        if (positionPlayer == 1) {
            Actor fish = (Actor)getWorld().getObjects(FishPlayer.class).get(0);
            ((FishPlayer)getWorld().getObjects(FishPlayer.class).get(0)).setLocation(fish.getX() - 10, fish.getY());
        }
        
        if (positionPlayer == 2) {
            Actor fish1 = (Actor)getWorld().getObjects(FishPlayer1.class).get(0);
            ((FishPlayer1)getWorld().getObjects(FishPlayer1.class).get(0)).setLocation(fish1.getX() - 10, fish1.getY());
        }
        
        if (positionPlayer == 3) {
            Actor fish2 = (Actor)getWorld().getObjects(FishPlayer2.class).get(0);
            ((FishPlayer2)getWorld().getObjects(FishPlayer2.class).get(0)).setLocation(fish2.getX() - 10, fish2.getY());
        }
        
        if (positionPlayer == 4) {
            Actor fish3 = (Actor)getWorld().getObjects(FishPlayer3.class).get(0);
            ((FishPlayer3)getWorld().getObjects(FishPlayer3.class).get(0)).setLocation(fish3.getX() - 10, fish3.getY());
        }
        
    }

    public void findIfTouched() {
        if (((Squares1)getWorld().getObjects(Squares1.class).get(0)).value == ("" + answer))
            positionGoodAnswer = 1;
        else if (((Squares2)getWorld().getObjects(Squares2.class).get(0)).value == ("" + answer))
            positionGoodAnswer = 2;
        else if (((Squares3)getWorld().getObjects(Squares3.class).get(0)).value == ("" + answer))
            positionGoodAnswer = 3;
        else if (((Squares4)getWorld().getObjects(Squares4.class).get(0)).value == ("" + answer))
            positionGoodAnswer = 4;

        if (Greenfoot.isKeyDown("1") || verifyClick1() ) {
            if (positionGoodAnswer == 1) {
                score++;
                ((AdditionWorld)getWorld()).score++;
                answeredGood = true;
                newPosition = count;
                advanceRightPlayer();
                goodAnswerSound();
                printOnBoard();
            }
            else {
                if (answeredGood == true)
                    ;
                else {
                    moveBackPlayer();
                    answeredGood = false;
                    wrongAnswerSound();
                    showAnswer();      
                    ((AdditionWorld)getWorld()).wrongAnswers++;
                }
            }
        }

        else if (Greenfoot.isKeyDown("2") || verifyClick2()) {
            if (positionGoodAnswer == 2) {
                score++;
                ((AdditionWorld)getWorld()).score++;
                answeredGood = true;
                newPosition = count;
                advanceRightPlayer();
                goodAnswerSound();
                printOnBoard();
            }
            else {
                if (answeredGood == true)
                    ;
                else {
                    moveBackPlayer();
                    answeredGood = false;
                    wrongAnswerSound();
                    showAnswer();   
                    ((AdditionWorld)getWorld()).wrongAnswers++;
                }
            }

        }
        else if (Greenfoot.isKeyDown("3") || verifyClick3()) {
            if (positionGoodAnswer == 3) { 
                score++;
                ((AdditionWorld)getWorld()).score++;
                answeredGood = true;
                newPosition = count;
                advanceRightPlayer();
                goodAnswerSound();
                printOnBoard(); 
            }
            else {
                if (answeredGood == true)
                    ;
                else {
                    moveBackPlayer();
                    answeredGood = false;
                    wrongAnswerSound();
                    showAnswer();       
                    ((AdditionWorld)getWorld()).wrongAnswers++;
                }
            }
        }
        else if (Greenfoot.isKeyDown("4") || verifyClick4()) {
            if (positionGoodAnswer == 4) {
                score++;
                ((AdditionWorld)getWorld()).score++;
                answeredGood = true;
                newPosition = count;
                advanceRightPlayer();
                goodAnswerSound();
                printOnBoard();
            }
            else {
                if (answeredGood == true)
                    ;
                else {
                    moveBackPlayer();
                    answeredGood = false;
                    wrongAnswerSound();
                    showAnswer();          
                    ((AdditionWorld)getWorld()).wrongAnswers++;
                }
            }
        }

    }
}
