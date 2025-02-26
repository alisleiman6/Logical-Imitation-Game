public class Verifier21 implements Verifier{
    public boolean check(int [] guess, int [] answer){
        boolean guessHasTwice = containsExactlyTwice(guess);
        boolean answerHasTwice = containsExactlyTwice(answer);

        return guessHasTwice == answerHasTwice;
    }

    private boolean containsExactlyTwice(int[] array){
        for (int i = 1; i < 5; i++){
            int count = 0;
            for (int r = 0; r < array.length; r++){
                if(array[r] == i){
                    count++;
                }
            }

        if (count == 2){
            return true;
        }
    }
    return false;
    }

public String toString(){
    return "If there is a number present exactly twice";
}
}
