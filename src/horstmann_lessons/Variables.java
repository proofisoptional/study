package horstmann_lessons;

public class Variables {
    public static void main(String[] args) {
        /*
        Char - declared in single quote = ''
        String - declared in double quote = ""
         */
        char s = 'a';
        String str = "A";

        /*
        Constants declared with a FINAL keyword
        FINAL means that variable cannnot be changed
         */
        final int fin = 4;

        /*
        fin = 5 cannot be assigned
         */

        String test = "Test of String";

        /*
        String is mutable, what means it cannot be changed after it was declared
        Strings are checked for equality by .equals() method. We cannot compare them with == operator, because
        == operator is applied only for primitive types
         */

        if(test == "Test of String"){
            System.out.println("1");
        }
        if(test.substring(0,4)=="Test"){
            System.out.println("0");
        }
        if(test.substring(0,4).equals("Test")){
            System.out.println("2");
        }

        /*
        Example will show only 1 and 2, because second check will return false. "Test" and substring of test are not realted to
        same memory cell, and == operator does not work
         */





    }
}
