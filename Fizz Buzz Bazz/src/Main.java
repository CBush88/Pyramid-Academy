public class Main {
    public static void main(String[] args) {
        System.out.println(fizzbuzzbazz(7));
    }
    public static String fizzbuzzbazz(int num){
        if(num % 3 == 0 && num % 5 == 0){
            return "fizz buzz bazz";
        }else if(num % 3 == 0){
            return "fizz";
        }else if(num % 5 == 0){
            return "buzz";
        }else{
            return "";
        }

    }
}