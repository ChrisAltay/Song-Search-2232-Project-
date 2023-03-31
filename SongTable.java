package GenderMag2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SongTable {
	public static void main(String[] args) {
		//Finds File Path for Song Text File and Updates it with Random Generated ID 
		//Creating a new Text File With ID's for each Song
		String inputFilePath = "C:\\Users\\chris\\eclipse-workspace\\DataStructures\\src\\GenderMag2\\Songs.txt";
		String outputFilePath = "C:\\Users\\chris\\eclipse-workspace\\DataStructures\\src\\GenderMag2\\Output.txt";
		processSongs(inputFilePath, outputFilePath);
		System.out.println("Completed");
	}

	private static void processSongs(String inputFilePath, String outputFilePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
				FileWriter fw = new FileWriter(outputFilePath)) {

			String line;
			boolean isFirstLine = true;
			Random random = new Random();

			while ((line = br.readLine()) != null) {
				if (isFirstLine) {
					isFirstLine = false;
					fw.write("SongID," + line + System.lineSeparator());
				} else if (!line.trim().isEmpty()) {
					int randomId = random.nextInt(9999999) + 1000000;
					fw.write(randomId + "," + line + System.lineSeparator());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


