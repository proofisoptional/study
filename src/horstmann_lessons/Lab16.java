package horstmann_lessons;

public class Lab16 {
    public static void CountArsinh(){
        double res = 0;
        double x = 0.11;
        double sign = 1;
        double index = 1;
        while(index<100){
            int i = 1;
            double coef = sign;
            while(i<index){
                if(i%2==0){
                    coef = coef/i;
                } else {
                    coef = coef * i;
                }
                i++;
            }
            coef = coef/index;
            res = res + coef * Math.pow(x, index);
            sign = sign * (-1);
            index = index +2;
        }

        System.out.println(res);
    }

    public static void main(String[] args) {
        CountArsinh();
    }
}
