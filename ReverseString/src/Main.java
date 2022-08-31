import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String str = "abc123";
        System.out.println(reverse1(str));
        System.out.println(reverse2(str));
    }
    public static String reverse1(String str){
        String[] strArr = str.split("");
        String output = "";
        for(int i = strArr.length - 1; i >= 0; i--){
            output += strArr[i];
        }
        return output;
    }
    public static String reverse2(String str){
        List<String> stringList = Arrays.asList(str.split(""));
        return stringList.stream().reduce((strAcc, s) -> s + strAcc).get();
    }
}