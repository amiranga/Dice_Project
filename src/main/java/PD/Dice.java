package PD;

import java.util.Random;

public class Dice implements IDice{

	private Integer numberOfFaces;
    private Integer result;
	
    
    //Constructor
    public Dice(Integer numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    //GetFaceValue
    public int getFaceValue() {
        setResult((new Random()).nextInt(numberOfFaces) + 1);
        return getResult();
    }

    //Getter Setter
    public Integer getNumberOfFaces() {
        return numberOfFaces;
    }

    
    public void setNumberOfFaces(Integer numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
