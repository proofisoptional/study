package horstmann_lessons.lambda_expressions;

import java.sql.Time;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Operationable op;

        op = (x,y)->x+y;

        int result = op.calculate(5, 6);
        System.out.println(result);

        String[] arrays = new String[5];
        arrays[0] = "John";
        arrays[1] = "brittney";
        arrays[2] = "astana";
        arrays[3] = "Magnus Karlsen";
        arrays[4] = "JsssssssssJ";

        /*comparator - functional intefrace realizes only one method*/
        Comparator comp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().length() - o2.toString().length();
            }
        };

        /*Arrays.sort(arrays, comp); - we can realize this method with separate instance*/
        Arrays.sort(arrays, (String x, String y) -> x.length() - y.length()); /*but we also can realize
        instance through lambda expression which will just show how method of this interface should be realized*/
        for(String array : arrays){
            System.out.println(array);
        }
        /*both will work the same*/


    }

    @FunctionalInterface /*functional interface*/
    interface Operationable{
        int calculate(int x, int y);
    }
}
