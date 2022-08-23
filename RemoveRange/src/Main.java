import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int from = 3;
        int to = 7;
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.println(removeRange(nums, from, to));
    }
    public static List<Integer> removeRange(ArrayList<Integer> nums, int from, int to){
        return nums.stream().filter(n -> n < from || n > to).collect(Collectors.toList());
    }
}