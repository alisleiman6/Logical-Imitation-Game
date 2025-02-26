import java.util.List;
import java.util.Arrays;

public class Machine{
    private int[] answer;
    private List<Verifier> verifiers;

    public  Machine(int[] answer, Verifier[] verifiers) throws IncorrectDataException{
        validateAnswer(answer);
        this.answer = answer;
        this.verifiers = Arrays.asList(verifiers);
    }

    public Machine(int[] answer, List<Verifier> verifiers) throws IncorrectDataException{
        validateAnswer(answer);
        this.answer = answer;
        this.verifiers = verifiers;
    }

    private void validateAnswer(int[] answer) throws IncorrectDataException{
        if (answer.length != 3){
            throw new IncorrectDataException("Answer hsa to be 3 digits long");
        }
        for (int i = 0; i < answer.length; i++){
            if (answer[i] < 1 || answer[i] > 5){
                throw new IncorrectDataException("Digit has to be between 1 and 5");
            }
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Verifiers:\n");
        char label = 'A';
        for (Verifier verifier : verifiers){
            sb.append(label).append(") ").append(verifier.toString()).append("\n");
            label++;
        }
        return sb.toString();
    }

    public String turn(int[] guess, char[] verifierChoices) throws IncorrectDataException{
        validateGuess(guess);
        if (verifierChoices.length != 3){
            throw new IncorrectDataException("Exactly 3 verifier choices must be provided.");
        }

        StringBuilder result = new StringBuilder("Results for guess ");
        result.append(arrayToString(guess)).append(":\n");

        for (char choice : verifierChoices){
            int index = Character.toUpperCase(choice) - 'A';
            if (index < 0 || index >= verifiers.size()){
                throw new IncorrectDataException("Invalid verifier choice: " + choice);
            }
            result.append(choice).append(") ").append(verifiers.get(index).check(guess, answer)).append("\n");
        }
        return result.toString();
    }

    public String turn(int[] guess, String verifierChoices) throws IncorrectDataException{
        char[] verifierChoicesArray = verifierChoices.replace(" ","").toUpperCase().toCharArray();
        return turn(guess, verifierChoicesArray);
    }

    public boolean finalGuess(int[] guess) throws IncorrectDataException{
        validateGuess(guess);
        return Arrays.equals(guess, answer);
    }

    private void validateGuess(int[] guess) throws IncorrectDataException{
        if (guess.length != 3){
            throw new IncorrectDataException("Gues has to be 3 digits long.");
        }
        for (int i = 0; 1 < guess.length; i++){
            if (guess[i] < 1 || guess[i] > 5){
                throw new IncorrectDataException("Digit has to be between 1 and 5.");
            }
        }
    }

    private String arrayToString(int[] array){
        StringBuilder sb = new StringBuilder();
        for (int num : array){
            sb.append(num);
        }
        return sb.toString();
    }
}
