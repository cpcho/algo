class Helloworld {
	// toString for every object
	// referenced data type
	// immutable

	public static String reverseString(String original) {
		if (original.length() < 2) {
			return original;
		}
		return reverseString(original.substring(1)) + original.charAt(0));
		// elloh
		// ("ello") + 'h'
		// "llo" + 'e' + 'h'
		// "lo" + 'l' + 'e' + 'h'
	}

	public static void main(String[] args) {


		//Literal --> String pool (Heap -- perm space)
		String s = "Hello World";

		// New operator --> Heap
		String t = new String("Hello world");

		// Making a string:

		// Concatenate
		String h = "Hello ";
		String w = "World";
		System.out.println(h.concat(w));
		System.out.println(h + w + "s");

		//Formatting
		// %d --> integer
		// %s --> String
		// %f --> floats
		String d = String.format("Steve has %d cats", 5);
		
		// Substrings
		System.out.println(h + d.substring(0, 5));

		// String instance methods

		String hiThere = "Hi there";
		
		// Length
		System.out.println(hiThere.length());

		// charAt
		System.out.println(hiThere.charAt(3));

		// indexOf
		System.out.println(hiThere.indexOf('e'));
		System.out.println(hiThere.indexOf('e', 6));
		System.out.println(hiThere.lastIndexOf('e'));

		// toUpperCase()
		System.out.println(hiThere.toUpperCase());

		// toLowerCase()
		System.out.println(hiThere.toLowerCase());

		// replace()
		String hiThereReplaced = hiThere.replace('e', 'z');

		// How to reverse a String in Java
		String reverse = "hello";
		// 1. Library Method
		StringBuilder sB = new StringBuilder(reverse).reverse();
		System.out.println(sB);
		
		String original = "hello";
		// 2. Iterative
		String re = "";
		for (int i = original.length() - 1; i >= 0; i--) {
			re = re + reverse.charAt(i);
			// "" + o
			// "o" + l
			// "ol" + l
		}
		System.out.println(re);
		// 3. Recursion
		System.out.println(reverseString(original));



	}
}

class StringPT2 {

	public static void main(String[] args) {
		
		// compareTo(String s)
		// 0 -- =
		// + -- >
		// - -- <
		String hiThere = "Hi there!";
		System.out.println(hiThere.compareTo("hi there!"));
		System.out.println(hiThere.compareTo("Hi there!"));
		System.out.println(hiThere.compareTo(new String("Hi there")))

	}
}