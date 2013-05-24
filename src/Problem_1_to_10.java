import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class Problem_1_to_10 {

	/**
	 * @param args
	 */
	
	
	// find the sum of multiple of 3 and 5
	public static void problemOne()
	{
		int sum = 0;
		
		for(int i = 1;i<1000;i++)
		{
			if(i % 3 == 0 || i % 5 == 0)
			{
				sum += i;
			}
		}
		
		System.out.println(sum);
	}
	
	//Even Finonacci Numbers
	public static void probemTwo()
	{
		int firstItem = 0;
		int secondItem = 1;
		
		int sum = 0;
		int total = 0;
		
		do
		{
			
			sum = firstItem + secondItem;
			//System.out.print(sum + ",");
			firstItem = secondItem;
			secondItem = sum;
			
			if(sum % 2 == 0)
				total += sum;
			
		}while(sum < 4000000);
		
		System.out.println(total);
		
		
		
	}

	//Largest Prime Number
	public static void problemThree(String number)
	{
		BigInteger reallyBig = new BigInteger(number);
		BigInteger sum = new BigInteger("1");
		BigInteger i = new BigInteger("1");
		
		while(true)
		{
			if(reallyBig.remainder(i) == BigInteger.ZERO)
			{
				//System.out.println("number is  not prime " + i);
				sum = sum.multiply(i);
				System.out.println(sum);
			}
			if(sum.compareTo(reallyBig) == 0)
			{
				System.out.println("Largest prime number " + i);
				break;
			}
			
			i = i.add(BigInteger.ONE);
			
			//System.out.println(i);
		}
	}
	
	//Largest Palindrome product
	public static void problemFour()
	{
		int max = 0;
		for(int i = 1;i<=999;i++)
		{
			for(int j = i + 1;j<=999;j++)
			{
				if(isPalinDrome(i * j))
				{
					if(i * j > max)
						max = i*j;
				}
			}
		}
		
		System.out.println("Largest palindrome product" + max);
		
	}
	
	//reverses number **(**Trouble**)** and check if palindrome (problemfour)
	public static boolean isPalinDrome( int number)
	{
		//check if the number is an actually palindrome
		int orignalNo = number;
		int reversedNo = 0;
		int temp = 0;
		
		
		while(number > 0)
		{
			//this gets the remainder when we divide the number x 10(the remainder will be the last number)
			temp = number%10;
			//System.out.println("Temp = " + temp);
			//we then multiply the reversedNo * 10 and add the remainder (the number gains an extra digit each time)
			reversedNo = reversedNo * 10 + temp;
			//System.out.println("Reversed Number now = " + reversedNo);
			//we then divde the number by 10 which will remove he last number
			number = number /10;
			//System.out.println("Number =" + number);
		}
		
		if(reversedNo == orignalNo)
		{
			//System.out.println("It is a palindrome" + reversedNo);
			return true;
		}
		else
			return false;
		
	}
	
	//Smallest Multiple
	public static void problemFive()
	{
		int currentNumber = 11;
		int timesMatched = 0;
		while(true)
		{
			for(int i = 0;i<20;i++)
			{
				if(currentNumber % (i +1) == 0)
				{
					timesMatched++;	
				}
				else
				{
					break;
				}
			}
	
			
			if(timesMatched == 20)
			{
				System.out.println("Smallest Multiple divisble by 1-20 is " + currentNumber);
				
				break;
			}
			currentNumber++;
			
			timesMatched = 0;
		}
	}
	
	//Sum square differences
	public static void problemSix()
	{
		int sumSquares = 0;
		int squareSum = 0;
		
		for(int i = 1;i<= 100;i++)
		{
			sumSquares += (i * i);
			squareSum += i;
		}
		
		squareSum = squareSum * squareSum;
		System.out.println("The sum of the squares of the first ten natural numbers is" + sumSquares);
		System.out.println("The square of the sum of the first ten natural numbers is," + squareSum);
		System.out.println("The Difference is:" + (squareSum - sumSquares));
	}

	//Print Nth prime number (**Trouble**) and print sum of Prime numebrs under 2,000,000
	public static void problemSeven(int number)
	{
	
		long sum = 2;
		
		for(int x = 3;x<2000000;x = x + 2)
		{
	
			if(isPrime(x))
			{
				//System.out.print(x + ",");
				sum = sum + x;
				///primesFound++;
			}
			//if(primesFound == number)
			//{
				//System.out.println(printToPrime + " prime number is =" + x);
				//break;
			//}
		}
		
		System.out.println(sum);
	}
	//part of problem seven
	public static boolean isPrime(int number)
	{

		for(int i = 3;i<=Math.sqrt(number);i = i +2)
		{
			if(number % i == 0)
			{
				return false;
			}
		}
	
		return true;
	}
	
	//Find largest product in series (Misunderstood question)
	public static void problemEight()
	{
		//look trough each substring of length 5 in string 
		// make 1st one the largest and check everyone afterward against that if larger make that the mean
		String large = 
				"7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
	

		int max = 0;
		
		int sum = 1;
		
		for(int i =0;i<large.length() - 4;i++)
		{


			sum = Integer.parseInt(large.valueOf(large.charAt(i))) * Integer.parseInt(large.valueOf(large.charAt(i + 1))) * Integer.parseInt(large.valueOf(large.charAt(i + 2))) 
					* Integer.parseInt(large.valueOf(large.charAt(i + 3))) * Integer.parseInt(large.valueOf(large.charAt(i + 4)));

			
			
			if(sum > max)
				max = sum;
		}
		//System.out.println();
		System.out.println(max);
		
		
	}
	
	//Special Pythagorean triplet (**Hard didnt know)**)
	public static void problemNine()
	{
		int sum = 1000;
		
		for(int a = 1;a<sum;a++)
			for(int b = a + 1;b<sum;b++)
			{
				int c = sum - a - b;
				if((a*a + b*b == c*c))
				{
					System.out.println(a + "," + b + "," + c);
				}
			}
	}
	
	public static void main(String[] args) {
		problemOne();
		 probemTwo();
		 problemThree("600851475143");
		 problemFour();
		 //problemFive();
		 problemSix();
		 problemSeven(10001);
		 problemEight();
		 problemNine();

	}

}
