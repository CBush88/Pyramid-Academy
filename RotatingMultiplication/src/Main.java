import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] test = {2, 5, 6, 4};
        int[] output = rotatingMultiplier(test);
        System.out.println(Arrays.toString(output));
    }
    public static int[] rotatingMultiplier(int[] test) {
        int[] output = new int[test.length];
        for(int i = 0; i < test.length; i++){
            for(int j = 0; j < test.length; j++){
                if(j == 0){
                    output[i] = 1;
                }
                if(j != i){
                    output[i] *= test[j];
                }
            }
        }
        return output;
    }
}