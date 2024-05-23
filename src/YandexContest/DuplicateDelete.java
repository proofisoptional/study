package YandexContest;


import java.io.*;

public class DuplicateDelete {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());
        String s = "";
        for(int i = 0; i<n; i++){
            String l = r.readLine();
            if(!l.equals(s)){
                System.out.println(l);
                s = l;
            }
        }

    }
}
