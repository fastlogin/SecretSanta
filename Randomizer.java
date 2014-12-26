import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Randomizer {
	
	public static void print(String[] input){
		String result = "";
		for(int i = 0; i < input.length; i++){
			result += input[i];
			result += " ";
		}
		System.out.println(result);
	}
	
	public static void random(String[] input){
		for(int i = 0; i < input.length;i++){
			int rand = (int)(Math.random() * input.length);
			String temp = input[rand];
			input[rand] = input[i];
			input[i] = temp;
		}
	}
	
	public static void write(String person, String[] matched){
		int rand = (int)(Math.random() * matched.length);
		while(matched[rand] == person || matched[rand] == null){
			rand = (int)(Math.random() * matched.length);
		}
		String temp = matched[rand];
		matched[rand] = null;
		try{
			File curr = new File("for"+ person +".txt");
			BufferedWriter output = new BufferedWriter(new FileWriter(curr));
			output.write(temp);
			output.close();
		}
		catch ( IOException e ) {
	           e.printStackTrace();
	     }
	}
	
	public static void pair(String[] input){
		String [] matched = input.clone();
		random(input);
		int i = 0;
		while(i < input.length){
			write(input[i],matched);
			i++;
		}
	}
	
	public static void main(String[] args){
		String[] participants = {"Marcia", 
						 "George" , 
						 "Daniel",  
						 "Steven",  
						 "Elaine",  
						 "Fred",
						 "Jason",
						 "Sheena",
						 "Lance",
						 "Steph",
						 "Clark"};
		pair(participants);
	}

}
