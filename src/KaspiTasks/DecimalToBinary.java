package KaspiTasks;

public class DecimalToBinary {
    public static String toBinary(int num) {
        if(num == 0){
            return "0";
        }
        String res = "";
        while(num>0){
            int rem = num%2;
            res = rem + res;
            num = num/2;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(toBinary(1337));
    }
}
