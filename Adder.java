import java.util.*;

public class Adder {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter something like x + y + z but with numbers: ");
		String response = in.nextLine();
		in.close(); //there, now shut up please Eclipse
		System.out.println("resp got");
		Scanner s = new Scanner(response).useDelimiter("(((\\s*)(?:\\+)(\\s*))|((\\s*)(?:-)(\\s*)))");
		Scanner sign = new Scanner(response);
		System.out.println("scanner made + delim created & in use");
		int sum = 0;
		int c = 0;
		int index = 0;
		for(int i=0; i<response.length(); i++) {
			if(response.charAt(i) == '+' || response.charAt(i) == '-') {
				c += 1; //counts the space needed for an operator array
				System.out.println("Match found for operator! Total matches found: " + c);
			}
		}
		c += 1; //make space for leading sign
		char operators[] = new char[c];
		for(int i=0; i<response.length(); i++) {
			if(response.charAt(i) != ' ' && response.charAt(i) != '-') {
				operators[0] = '+'; //explicitly adds implicit '+' (i.e. the leading sign when positive)
				index = 1; //so that it doesn't get overwritten when working later
				break;
			}
			else {
				System.out.println("Mayday"); //I do not have to add a '-' if it is there because of how this work
				//I do have to inform myself when the battelship is sunk tho
			}
		}
		for(int i=0; i<response.length(); i++) {
			if(response.charAt(i) == '+' || response.charAt(i) == '-') {
				operators[index] = response.charAt(i); //fills operator array
				index += 1;
			}
		}
		int itervar = 0; //while I feel compelled to reuse index, I will not, for the sake of readability
		while(s.hasNextInt()) {
			System.out.println("doing the looperino");
			if(operators[itervar] == '+') { //will not req hasNext, checking for +|- is implicit in the hasNextInt
				System.out.println("doing the add");
				sum += s.nextInt();
				itervar += 1;
			}
			else if(operators[itervar] == '-') {
				System.out.println("doing the minus");
				sum -= s.nextInt();
				itervar += 1;
			}
		}
		System.out.println("Sum is " + sum);
		s.close();
	}
}
