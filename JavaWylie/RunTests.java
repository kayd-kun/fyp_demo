import org.rigpa.wylie.Wylie;

import java.util.Scanner;
import java.util.ArrayList;

public class RunTests {

    public static void out(String s) {
	System.out.println(s);
    }


    public static void main(String[] args) {
	Wylie w = new Wylie(true, false, false, true);
	Wylie w2 = new Wylie(true, true, false, true);
	String l = "";
	Scanner sc = new Scanner(System.in);
	int tests = 0;
	int fails = 0;

	while(true) {
	    try {
		l = sc.nextLine();
	    } catch (Exception ex) {
	        break;
	    }

	    if (l.startsWith("#")) {
		continue;
	    }

	    String a[] = l.split("\\t");
	    if (a.length < 6) {
		out("Line does not have 6 fields: (" + l + ")");
		break;
	    }

	    String wylie = a[0];
	    String uni = a[1];
	    int warns = Integer.parseInt(a[2]);

	    String wylie2 = a[3];
	    int wylie_warns = Integer.parseInt(a[4]);
	    int uni_diff = Integer.parseInt(a[5]);

	    tests++;
	    boolean fail = false;

	    ArrayList<String> e = new ArrayList<String>();
	    String s = w.fromWylie(wylie, e);

	    ArrayList<String> e2 = new ArrayList<String>();
	    String s2 = w2.fromWylie(wylie, e2);

	    // re-encode into wylie
	    ArrayList<String> e3 = new ArrayList<String>();
	    String rewylie = w.toWylie(s, e3, true);

	    // and again back into unicode
	    String reuni = w.fromWylie(rewylie);

	    // the two first unicodes must be same
	    if (!s.equals(s2)) {
		out("Wylie (" + wylie + "): got diff unicode w/ and w/o strict checking.");
		fail = true;
	    }
	    
	    // expected unicode?
	    if (!s.equals(uni)) {
		out("Wylie (" + wylie + "): wrong unicode, expected (" + uni + ") got (" + s + ")");
		fail = true;
	    }

	    // expected warnings?
	    if (e.size() != 0 && e2.size() == 0) {
		out("Wylie (" + wylie + "): Got warnings in easy mode but not in strict!");
		fail = true;
	    }

	    if (warns == 0) {
		if (e.size() > 0 || e2.size() > 0) {
		    out("Wylie (" + wylie + "): No warnings expected.");
		    fail = true;
		}
	    } else if (warns == 1) {
		if (e.size() != 0) {
		    out("Wylie (" + wylie + "): No non-strict warnings expected.");
		    fail = true;
		}
		if (e2.size() == 0)  {
		    out("Wylie (" + wylie + "): Expected strict warnings.");
		    fail = true;
		}
	    } else if (warns == 2) {
		if (e.size() == 0)  {
		    out("Wylie (" + wylie + "): Expected non-strict warnings.");
		    fail = true;
		}
	    }

	    // expected re-encoded wylie?
	    if (!wylie2.equals(rewylie)) {
		    out("Wylie (" + wylie + "): to_wylie expected (" + wylie2 + "), got (" + rewylie + ").");
		    fail = true;
	    }

	    // expected warnings in re-encoded wylie?
	    if (wylie_warns == 0) {
		if (e3.size() != 0) {
		    out("Wylie (" + wylie + "): unexpected to_wylie warnings.");
		    fail = true;
		}
	    } else {
		if (e3.size() == 0) {
		    out("Wylie (" + wylie + "): missing expected to_wylie warnings.");
		    fail = true;
		}
	    }

	    // expected re-encoded unicode (unless it's supposed to be different)
	    if (uni_diff > 0) {
		if (reuni.equals(s)) {
		    out("Wylie (" + wylie + "): should not round-trip to Unicode.");
		    fail = true;
		}
	    } else {
		if (!reuni.equals(s)) {
		    out("Wylie (" + wylie + "): should round-trip to Unicode.");
		    fail = true;
		}
	    }

	    if (fail) fails++;
	}

	out("Finished running " + tests + " tests, " + fails + " failures.");
	System.exit(0);
    }
}
