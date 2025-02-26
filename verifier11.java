public class Verifier11 implements Verifier{
    public boolean check (int[] guess, int[] answer){
        if (guess [0] < guess[1] && answer [0] < answer[1]){
            return true;
        }
    else if(guess [0] == guess [1] && answer [0] == answer [1]){
        return true;
    }

    else if(guess [0] > guess [1] && answer [0] > answer[1]){
        return true;
    }
    else{
        return false;
    }
    }

    public String toString(){
        return "Checks the 1st digit compared to the 2nd";
    }
}
