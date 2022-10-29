import org.rigpa.wylie.Wylie;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
	Wylie wl = new Wylie(true, true, true, true);
	String l = "";
	Scanner sc = new Scanner(System.in);

	while(true) {
	    try {
	        System.out.print("wylie> ");
		l = sc.nextLine();
	    } catch (Exception ex) {
		System.exit(0);
	    }
	    String tib = wl.fromWylie(l);
	    System.out.println("-> ((" + tib + "))");
	}

    }
}
