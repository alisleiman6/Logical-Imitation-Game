public class Verifier03 implements Verifier{
    public boolean check(int [] guess, int [] answer){
        if (guess [1] < 3 && answer [1] < 3){
            return true;
        }
        else if (guess[1] == 3 && answer [1] == 3){
            return true;
        }
        else if (guess [ 1] > 3 && answer [1] > 3){
            return true;
        }
        else {
            return false;
        }
    }


    public String toString(){
        return "Compares the 2nd digit to the value of '3' (is it < 3, = 3 or > 3?)";
    }
}
