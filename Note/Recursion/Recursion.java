//Recursion
//https://stackoverflow.com/questions/15941818/java-understanding-recursion
/*why this method prints out 1 2 3 4 5 instead of printing out as 4 3 2 1 0?*/
public class whatever {
    /**
     * @param args
     */
    public static void main(String[] args) {
        xMethod(5);
    }

    public static void xMethod(int n){
        if (n>0){
            xMethod(n-1);
            System.out.print(n + " ");
        }
    }
}

/*It's the result of the call stack. Here's what it would look like after a call with n = 5. 
Rotate your head about 180 degrees, since the bottom of this call chain is actually 
the top of the stack.*/

xMethod(5)
	xMethod(4)
		xMethod(3)
			xMethod(2)
				xMethod(1)
					xMethod(0)

/*In a recursive call, you have two cases: a base case and a recursive case. 
The base case here is when n == 0, and no further recursion occurs.

Now, what happens when we start coming back from those calls? 
That is, what takes place after the recursive step? We start doing System.out.print(). 
Since there's a condition which prevents both recursion and printing when n == 0, 
we neither recurse nor print.

So, the reason that you get 1 2 3 4 5 as output is due to the way the calls are being 
popped from the stack.*/

/*It is pretty simple, these are the calls*/

main
   xMethod(5)
      xMethod(4)
          xMethod(3)
             xMethod(2)
                 xMethod(1)
                     xMethod(0)
                 print 1
             print 2
          print 3
      print 4
  print 5

/*So you see the prints are 1,2,3,4,5
When the innermost call to xMethod(n) returns, the next-to-innermost call 
will start right back where it left off: right after the call to itself, 
at the print.

Because this is recursion in action, on each recursion level after xMethod(n) returns 
there is a print statement System.out.print(n+" "), then the level returns to the 
upper level that called it, and it prints its value, so on until the main level is 
reached and the program ends.*/