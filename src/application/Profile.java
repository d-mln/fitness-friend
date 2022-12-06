package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Profile {
	private String name = "n/a";
	private int age = 0;
	private String unit = "n/a";
	private String gender = "n/a";
	private double weight = 0.0;
	private double height = 0.0;
	
	// if profile already exists, load, else create a new profile
	public Profile(String i) {
		File check = new File("src/application/profiles/" + i);
		if (check.exists()) {
			try {
				this.loadProfile(i);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			this.newProfile(i);
		}
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
	
	// saves all profile properties by line
	public void saveProfile() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("src/application/profiles/" + name + ".txt"));
		PrintWriter pwriter = new PrintWriter(writer);
		pwriter.println(name);
		pwriter.println(age);
		pwriter.println(unit);
		pwriter.println(gender);
		pwriter.println(weight);
		pwriter.println(height);
		pwriter.close();
	}
	
	// reads all profile properties by line
	public void loadProfile(String i) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/application/profiles/" + i));
		name = reader.readLine().toString();
		age = Integer.parseInt(reader.readLine());
		unit = reader.readLine();
		gender = reader.readLine();
		weight = Double.parseDouble(reader.readLine());
		height = Double.parseDouble(reader.readLine());
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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
