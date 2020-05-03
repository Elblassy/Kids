package app.elblasy.kids.models;

public class NumbersLevel2Model {

    private int firstNumber, sign, secondNumber, equal;
    private int audio;

    public NumbersLevel2Model(int firstNumber, int sign, int secondNumber, int equal, int audio) {
        this.firstNumber = firstNumber;
        this.sign = sign;
        this.secondNumber = secondNumber;
        this.equal = equal;
        this.audio = audio;
    }

    public int getAudio() {
        return audio;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSign() {
        return sign;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public int getEqual() {
        return equal;
    }
}
