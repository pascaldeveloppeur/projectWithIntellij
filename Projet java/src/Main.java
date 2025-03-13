import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int x = 6;
        int y = ++x;
        //System.out.println("y="+ y +" x="+x);
        Scanner sc = new Scanner(System.in);
        System.out.println("Veillez votre phrase:");
        String donne = sc.nextLine();
        System.out.println(donne);

    }
}