import org.rigpa.wylie.Wylie;
import java.util.Scanner;

public class TestToWylie {
    public static void main(String[] args) {
	Wylie wl = new Wylie();
	String l = "";
	Scanner sc = new Scanner(System.in);

	while(true) {
	    try {
	        System.out.print("tibetan> ");
		l = sc.nextLine();
	    } catch (Exception ex) {
		System.exit(0);
	    }
	    String res = wl.toWylie(l, null, true);
	    System.out.println("-> ((" + res + "))");
	}

    }
}
