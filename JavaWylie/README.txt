   This Java package implements the conversion between Unicode Tibetan text, and
   Wylie (EWTS) transliteration.

   It is based on the equivalent Perl module, Lingua::BO::Wylie, found at 
   http://www.digitaltibetan.org/cgi-bin/wylie.pl

   The Extended Wylie Transliteration System is documented at:
   http://www.thlib.org/reference/transliteration/#essay=/thl/ewts/

   OVERVIEW
   ========

   This code is a library; it is meant to be embedded in other software.

      import org.rigpa.wylie.Wylie;
	    ...
      Wylie wl = new Wylie();
      System.out.println(wl.fromWylie("sems can thams cad"));
      System.out.println(wl.toWylie("\u0f66\u0f44\u0f66\u0f0b\u0f62\u0f92\u0fb1\u0f66\u000a"));

   From the command-line, you can use the provided "Test" and "TestToWylie"
   programs, which requests lines in Wylie from the user and prints the unicode to
   stdout, and vice versa.  Run them with:
      java Test
      java TestToWylie

   To run the test suite, run this command:
      javac -g RunTests.java && java RunTests < test.txt


   CONSTRUCTOR
   ===========

   Two constructors are available:

       Wylie wl = new Wylie();		// uses all the default options
   and
       Wylie wl = new Wylie(check, check_strict, print_warnings, fix_spacing);

   The meanings of the parameters are:
   - check (boolean)          : generate warnings for illegal consonant sequences; default is true.
   - check_strict (boolean)   : stricter checking, examine the whole stack; default is true.
   - print_warnings (boolean) : print generated warnings to STDOUT; default is false.
   - fix_spacing (boolean)    : remove spaces after newlines, collapse multiple tseks into one, etc;
				default is true.

   PUBLIC METHODS
   ==============

   String fromWylie(String wylie_string);
      Converts from Wylie (EWTS) to Unicode.

   String fromWylie(String wylie_string, ArrayList<String> warns);
      Converts from Wylie (EWTS) to Unicode; puts the generated warnings in the list.

   String toWylie(String unicode_string);
      Converts from Unicode to Wylie. 
      Anything that is not Tibetan Unicode is converted to EWTS comment blocks [between brackets].

   String toWylie(String unicode_string, ArrayList<String> warns, boolean escape);
      Converts from Unicode to Wylie.   Puts the generated warnings in the list.
      If escape is false, anything that is not Tibetan Unicode is just passed through as it is.


   PERFORMANCE AND CONCURRENCY
   ===========================

   This code should perform quite decently.  When converting from Wylie to
   Unicode, the entire string is split into tokens, which are themselves
   strings.  If this takes too much memory, consider converting your text in
   smaller chunks.  With today's computers, it should not be a problem to
   convert several megabytes of tibetan text in one call.  Otherwise, it could
   be worthwhile to tokenize the input on the fly, rather than all at once.

   This class is entirely thread-safe.  In a multi-threaded environment,
   multiple threads can share the same instance without any problems.


   AUTHOR AND LICENSE
   ==================

   Copyright (C) 2010 Roger Espel Llima

   This library is Free Software.  You can redistribute it or modify it, under
   the terms of, at your choice, the GNU General Public License (version 2 or
   higher), the GNU Lesser General Public License (version 2 or higher), the
   Mozilla Public License (any version) or the Apache License version 2 or
   higher.  

   Please contact the author if you wish to use it under some terms not covered
   here.

