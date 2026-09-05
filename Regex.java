import java.util.Scanner;

public class Regex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean result;
        while(sc.hasNextLine()) {
             result = sc.nextLine().matches("[0-9]+");
            if(!result) {System.out.println("fuck you");}
        }

    }
}
