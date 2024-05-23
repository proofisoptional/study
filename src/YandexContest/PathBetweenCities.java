package YandexContest;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class City{
    int x;
    int y;

    List<City> reachable;

    public City(int x, int y){
        this.x = x;
        this.y = y;
        this.reachable = new ArrayList<>();
    }

    public void addCity(City city){
        this.reachable.add(city);
    }

    public boolean equals(City city) {
        return this.x == city.x && this.y == city.y;
    }
}

public class PathBetweenCities {
    private static final String FILE_INPUT = "input.txt";
    private static final String FILE_OUTPUT = "output.txt";
    private static BufferedReader bufferedReader = null;
    private static BufferedWriter bufferedWriter = null;

    static int limit = 0;
    static int mincount = Integer.MAX_VALUE;
    public static int distanceBetweenCities(City A, City B){
        return Math.abs(A.x - B.x) + Math.abs(A.y - B.y);
    }

    public static void helper(City root, List<City> cities, int count, City end){
        if(cities.size()==0){
            return;
        }
        Iterator<City> iter = cities.iterator();

        while(iter.hasNext()){
            City city = iter.next();
            if(distanceBetweenCities(root, city)<=limit){
                if(city.equals(end)){
                    if(count<mincount){
                        mincount = count;
                    }
                }
                root.addCity(city);
                iter.remove();
            }
        }

        for(City city: root.reachable){
            List<City> copy = new ArrayList<>(cities);
            helper(city, copy, count + 1, end);

        }
    }

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new FileReader(FILE_INPUT));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<City> cities = new ArrayList<>();
        for(int i = 0; i<n; i++){
            String s = bufferedReader.readLine();
            String[] ss = s.split(" ");
            int x = Integer.parseInt(ss[0]);
            int y = Integer.parseInt(ss[1]);
            City city = new City(x ,y);
            cities.add(city);
        }
        limit = Integer.parseInt(bufferedReader.readLine());
        String s = bufferedReader.readLine();
        String[] ss = s.split(" ");
        int root = Integer.parseInt(ss[0]);
        int end = Integer.parseInt(ss[1]);
        bufferedReader.close();
        City origin = cities.remove(root);
        City endcity = cities.get(end);
        helper(origin, cities, 1, endcity);
        System.out.println(mincount);

    }



}
