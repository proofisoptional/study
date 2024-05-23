package horstmann_lessons;

public class StringBuilderBasics {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        /*builder allow to work with strings and chars, changing them*/

        builder.append('a'); //allow to append chars and strings
        builder.append("res");
        builder.setCharAt(1, 'f'); //set special character at special index
        builder.delete(1,3);//delete character on special index range


        String string = builder.toString();

        System.out.println(string);
    }
}
