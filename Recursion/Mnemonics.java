import java.util.Scanner;
import java.util.Vector;
import java.lang.String;

public class Mnemonics{
	
	public Mnemonics(){
	
	}

	public void recursion(String number, String w){
		Vector<String> mnemonic = new Vector<String>();
		Vector<String> allLetters = new Vector<String>();
		allLetters.add(" "); //0
		allLetters.add(" "); //1
		allLetters.add("ABC"); //2
		allLetters.add("DEF"); //3
		allLetters.add("GHI"); //4
		allLetters.add("JKL"); //5
		allLetters.add("MNO"); //6
		allLetters.add("PQRS"); //7
		allLetters.add("TUV"); //8
		allLetters.add("WXYZ"); //9
		
		int digit = Integer.parseInt(number.substring(0,1));//Starts at 0 ends at 1 but does not give the digit at 1
		String remainingNumbers = number.substring(1); //String starting at 1
		
		char[] cLetter = allLetters.get(digit).toCharArray();
		
		for(int i = 0; i< cLetter.length; i++){
			char cL = cLetter[i];
			String word = w + cL;
			if(remainingNumbers.length()==0){
				mnemonic.add(word);
				System.out.println(word);
			}
			else{
				recursion(remainingNumbers, word);
			}
		}
	}
	
	public static void main(String[] args){
		Mnemonics m = new Mnemonics();
		Scanner scan = new Scanner(System.in);
		
		String num = "";
		System.out.println("Type in the number: ");
		num = scan.nextLine();
		
		m.recursion(num, "");
		
	}
}