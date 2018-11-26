import com.sun.jdi.StringReference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List <User> users = new ArrayList<>();
        String[] name = {"Kate", "Josh", "Elena", "Victor", "Eleonora"};
        Boolean[] active = {true, true, false, true, false};
        Double[] balance = {252.00, 1165.45, 212.544, 1201.21, 954.2};
        String[] emails = {"kate23@gmail.com","js4@gmail.com","elena18@gmail.com","victor_m@gmail.com","elena@gmail.com"};
        String[] roles = {"admin","user","user","manager","user"};
        int[] year = {2017,2016,2015,2016,2017};

        for (int i = 0; i < name.length; i++) {
            users.add(new User(name[i],active[i],roles[i],balance[i],emails[i],year[i]));
            //System.out.println(users.get(i).getName() + " , " + users.get(i).getBalance() + " , " + users.get(i).getIsActive());
        }

        // Get min balance
       users.stream()
                .min(Comparator.comparing(User::getBalance))
                .ifPresent(p->System.out.println("Min balance = "  + p.getBalance()));

       // Get max balance
        users.stream()
                .max(Comparator.comparing(User::getBalance))
                .ifPresent(p->System.out.println("Max balance = " + p.getBalance()));

        // Get average of balance
        users.stream()
                .mapToDouble(p->p.getBalance())
                .average()
                .stream().forEach(p->System.out.println("Average balance = " + p));

        // Get list if emails
        System.out.println("List of emails: " + users.stream()
                .map(p->p.getEmail())
                .collect(Collectors.toList()));

       System.out.println("Sorted list of distinct users: " + users.stream()
                .distinct()
                .sorted(Comparator.comparing(User::getName))
                .map(p->p.getName())
               .collect(Collectors.toList()));

        // Get number of non active users
        System.out.println("Number of non active users: " + users.stream()
                .filter(p->!p.getIsActive())
                .count());

        // Get first user with balance > 1000
        users.stream()
                .filter(p->p.getBalance() >= 1000)
                .findFirst()
                .ifPresent(p->System.out.println("First user with balance > 1000 : " + p.getName() + " and his balance: " + p.getBalance()));

        // Reduce all users names into 1 coma separated string
        System.out.println("Name of all users reduce into 1 comma: " + users.stream()
                .map(p->p.getName())
                .collect(Collectors.joining(",")));

        // Group users by registration date
        System.out.println("Grouping by registration date : " + users.stream()
                .collect(Collectors.groupingBy(p->p.getReggYear(), Collectors.mapping(p->p.getName(),Collectors.toSet()))));

        // Partition users by active and locked accounts
        System.out.println("Partition by active and locked account : " + users.stream()
                .collect(Collectors.groupingBy(p->p.getIsActive(), Collectors.mapping(p->p.getName(),Collectors.toSet()))));

        // Get set from list
        System.out.println("Set from list : " + users.stream()
                .collect(Collectors.toSet()));

        // Calculate factorial using IntStream
        int number = 8;
        System.out.println("Factorial of " + number + " is " + IntStream.rangeClosed(2,number)
                .reduce(1,(x,y)->x*y));

        List <Integer> integers = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            integers.add(i);

        String[] str = {"one","two","three","four","five"};
        List <String> strings = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            strings.add(str[i]);

        List <String> cartesianPr = new ArrayList<>();

        integers.stream()
                .forEach(a->strings.stream().forEach(b->cartesianPr.add(a+b)));

        System.out.println("Cartesian product of int and string: " +cartesianPr.stream()
                .collect(Collectors.joining(" , ")));
    }
}
