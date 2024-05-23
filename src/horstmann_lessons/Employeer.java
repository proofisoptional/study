package horstmann_lessons;

import java.util.Date;

public class Employeer {
    private String name;
    private int age;
    private Date birthdate;
    private int salary;

    private Employeer(String name, int age, Date birthdate, int salary){
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public Date getBirthdate() {
        return birthdate;
    }

    public static void main(String[] args) {
        Employeer empl = new Employeer("Adam", 12, new Date(1970, 11, 17), 150);

        Date h = empl.getBirthdate();

        h.setMonth(5);

        System.out.println(h);
        System.out.println(empl.getBirthdate());

        /*нарушение принципа инкапсуляции - переменная ссылающаяся на скрытое поле объекта имеет возможность
        * поменять переменную в объекте
        * для ненарушения инкапсуляции требуется представлять get через clone если поле имеет
        * модифицируюшие методы*/

    }

}
