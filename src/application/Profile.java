package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Profile {
	private String name = "cat";
	private String unit = "Metric";
	private String gender = "m";
	private int weight = 100;
	private int height = 100;
	
	public Profile(String i) {
		this.newProfile(i);
	}

	public String getProfileName() {
		
		return null;
	}
	
	// creates a (pro)file
	public void newProfile(String i) {
    	try {
    	File newProfile = new File("src/application/profiles/" + i + ".txt");
    	newProfile.createNewFile();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
	}
	
	public void saveProfile() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("src/application/profiles/" + name + ".txt"));
		PrintWriter pwriter = new PrintWriter(writer);
		pwriter.println(name);
		pwriter.println(unit);
		pwriter.println(gender);
		pwriter.println(weight);
		pwriter.println(height);
		pwriter.close();
	}
	
	public void loadProfile() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/application/profiles/" + name + ".txt"));
		name = reader.readLine();
		unit = reader.readLine();
		gender = reader.readLine();
		weight = Integer.parseInt(reader.readLine());
		height = Integer.parseInt(reader.readLine());
		reader.close();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
