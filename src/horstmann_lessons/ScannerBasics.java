package horstmann_lessons;

import java.util.Scanner;

public class ScannerBasics {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //scanner allow us to read inputs from console (and not only)

        System.out.println("input name:");

        String name = in.next(); //read next word until the space character

        System.out.println("input name2:");

        String name2 = in.nextLine(); //read next line including space characters

        System.out.println("input integer: ");

        int r = in.nextInt();//read next integer

        System.out.println(name);
        System.out.println(name2);
        System.out.println(r);
    }
}
