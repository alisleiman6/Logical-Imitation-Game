public class Verifier08 implements Verifier{
    public boolean check(int[] guess, int[] answer){
        int countGuess = 0;
        int countAnswer = 0;

        for (int i = 0; i < guess.length; i++){
            if(guess[i] == 1){
                countGuess++;
            }
        }

        for (int i = 0; i < answer.length; i++){
            if (answer[i] == 1){
                countAnswer++;
            }
        }

        if (countGuess == countAnswer){
            return true;
        } else{
            return false;
        }
    }

    public String toString(){
        return "number of 1s in the answer is";
    }
}
