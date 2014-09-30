package clueGame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClueGame {
	Map<Character,String> rooms = new HashMap<Character,String>();
	 Board theBoard;
	private String layoutFile;
	private String configFile;
	
	public ClueGame(String layout,String legend)
	{
		layoutFile = layout;
		configFile = legend;
				
	}
	
	public void loadRoomConfig()
	{
		
	
		
		FileReader fr = null;
		Scanner sc = null;
		String line = " ";
		String[] splitLine;
		Character tempKey = ' ';
		String tempValue = " ";
		
		try
		{
			fr = new FileReader(configFile);
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		
		sc = new Scanner(fr);
		
		
		
		while(sc.hasNextLine())
		{
			
			line = sc.nextLine();
			splitLine = line.split(",");
				
			tempKey =  line.charAt(0);
		
			
			
			tempValue = splitLine[1];
		

			
			rooms.put(tempKey,tempValue);
			
			System.out.println(tempKey + " "  + rooms.get(tempKey));
						
			
		}
		
		
		//test to see what is in rooms
		
		
		
		
		sc.close();
		
	}
	
	public void loadConfigFiles(){
		
		theBoard.loadBoardConfig();
	//	loadBoardConfig();
		
		
	}
	
	public static void main(String[] args)
	{
		
		ClueGame game = new ClueGame("ClueLayout.csv","ClueLegend.txt");
		
		game.loadRoomConfig();
		
		//game.loadConfigFiles();
		
	}
	
}