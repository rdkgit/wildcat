
public class Z
{
    public static void main(String[] args)
    {
	Z aZ;

        System.out.println("Git this!");

        aZ = new Z(10);
      
    } /* main */

    int a;

    public Z(int anInt)
    {   
	a = anInt;
    }

    public static void fib(int n) {
	if (n <= 1) return 1;
	else 
           return fib(n-1) + fib(n-2);
   }

} /* Z */

