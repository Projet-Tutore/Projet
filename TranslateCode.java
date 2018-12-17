package projetS3;

import java.io.File;
import java.util.Scanner;
import bsh.Interpreter;

public class TranslateCode {
	
	Interpreter interpreter = new Interpreter();
	private String fichier;
	
	public void test()
	{
		try
		{
		interpreter.eval("tab = new int[5]");
		interpreter.eval("tab[0] = 6");
		interpreter.eval("a = 5");
		interpreter.eval("result = (a+tab[0])");
		System.out.println( interpreter.get("a") );
		System.out.println( interpreter.get("result") );
		interpreter.eval("result = (7* (a+2)) > 2");
		System.out.println( interpreter.get("result") );
		}
		catch(Exception e)
		{
		System.out.println ( "expression invalide" );
		}
	}
	
	
	public TranslateCode(String fichier)
	{
		this.fichier = fichier;
	}
	
	public String toString()
	{
		String s = "| Code |\n\n";
		for(int i=0; i<66; i++) { s += "-"; }
		s+= "\n";
		
		int cpt = 0;
		try{
			Scanner sc = new Scanner(new File(this.fichier));
			while(sc.hasNextLine())
			{
				s += String.format("%-5s","| " + cpt + " ")+ 
			         String.format("%-60s",sc.nextLine()) + "|\n";
				cpt++;
			}
			for(int i=0; i<66; i++) { s += "-"; }
			sc.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
		return s;
		
	}

}
