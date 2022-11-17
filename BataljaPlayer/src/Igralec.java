import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Igralec {
	public static void main(String[] args) throws Exception {
		FileWriter fstream = new FileWriter("Igralec.log");
		BufferedWriter out = new BufferedWriter(fstream);
		try {
			/*
				**************
				Initialization
				**************
			*/
			Scanner bralec = new Scanner(System.in);
			String line = bralec.nextLine();// line of input from the game

			String[] tokens = line.split(" ");
			int x = Integer.parseInt(tokens[1]);
			int y = Integer.parseInt(tokens[2]);
			String color = tokens[3];

			out.write(line+"\n");
			out.flush();

			/*
				**************
				Main game loop
				**************
			*/
			while (true) {
				/*
					******************************
					clear state from previous turn
					******************************
				*/

				NapadalniPlanet np = new NapadalniPlanet(x,y,color);


				/*
					********************************
					read the input from the game and 
					parse it (state of the game)
					********************************
				*/


					/*
						U	<int>,<int>,<string>						Universe - size (x in y) playing field (allways 100,100), and your color
						P	<int>,<int>,<int>,<float>,<int>,<string>	Planet:	- name (number), - position x, - position y, - planet size, - fleet size, - planet color (red, blue or null)
						S	-											Start - when a player receives this command from the game he starts responding 
					*/
				line = bralec.nextLine();
				while(!line.equals("S")){
					out.write(line+"\n");
					out.flush();

					tokens = line.split(" ");

					if(tokens[0].equals("P")){
						np.dodajPlanet(tokens);
					}
					line = bralec.nextLine();
				}


				/*
					*********************************
					LOGIC: figure out what to do with 
					your turn
					*********************************
				*/
				String attack = np.napad();

				/*
					*********************************
					Print the attack command and thus
					end the turn
					*********************************
				*/
				attack += "E"; // end of turn command
				System.out.println(attack); // send commands to the game
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.write("ERROR: ");
			out.write(e.getMessage());
			out.flush();
		}
		out.close();
	}
}
