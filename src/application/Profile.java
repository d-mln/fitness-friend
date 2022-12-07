package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Profile {
	private String name = "n/a";
	private int age = 0;
	private String unit = "n/a";
	private String gender = "n/a";
	private double weight = 0.0;
	private double height = 0.0;
	private Date date = new Date();
	
	private int walking = 0;
	private int running = 0;
	private int biking = 0;
	private int swimming = 0;
	private int workout = 0;
	// relative amount of exercise per week, determined by exercisescenecontroller
	private int exercise = 0;
	
	// if profile already exists and was expected to load, load, else create a new profile
	public Profile(String i, boolean doesExist) throws IOException {
		File check = new File("src/application/profiles/" + i);
		File check2 = new File("src/application/profiles/" + i + ".txt");
		if (check.exists() && doesExist) {
			try {
				this.loadProfile(i);
			} catch (IOException e) {
				e.printStackTrace();
			}
	// don't load a profile and throw an exception if you weren't expecting to load one
		} else if (check2.exists() && !doesExist) {
			throw new IOException();
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
	
	/**
	 * Writes all instance variables to a file, formatted by line:
	 * name, age, unit, gender, weight, height, date, walking, running, biking, swimming, workout, exercise
	 * @throws IOException
	 */
	public void saveProfile() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("src/application/profiles/" + name + ".txt"));
		PrintWriter pwriter = new PrintWriter(writer);
		pwriter.println(name);
		pwriter.println(age);
		pwriter.println(unit);
		pwriter.println(gender);
		pwriter.println(weight);
		pwriter.println(height);
		pwriter.println(date.getTime());
		pwriter.println(walking);
		pwriter.println(running);
		pwriter.println(biking);
		pwriter.println(swimming);
		pwriter.println(workout);
		pwriter.println(exercise);

		pwriter.close();
	}
	
	/**
	 * Reads a save file and initializes the variables
	 * @param i name of the file (including .txt)
	 * @throws IOException
	 */
	public void loadProfile(String i) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/application/profiles/" + i));
		name = reader.readLine().toString();
		age = Integer.parseInt(reader.readLine());
		unit = reader.readLine();
		gender = reader.readLine();
		weight = Double.parseDouble(reader.readLine());
		height = Double.parseDouble(reader.readLine());
		date = new Date(Long.parseLong(reader.readLine()));
		walking = Integer.parseInt(reader.readLine());
		running = Integer.parseInt(reader.readLine());
		biking = Integer.parseInt(reader.readLine());
		swimming = Integer.parseInt(reader.readLine());
		workout = Integer.parseInt(reader.readLine());
		exercise = Integer.parseInt(reader.readLine());
		
		reader.close();
	}
	
	/**
	 * Writes profile save file weight and date to another file
	 * @param i file to write to
	 * @throws IOException
	 */
	private void saveHistory(File i) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/application/profiles/" + this.name + ".txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter(i));
		PrintWriter pwriter = new PrintWriter(writer);
		reader.readLine();
		reader.readLine();
		reader.readLine();
		reader.readLine();
		// weight 
		pwriter.println(Double.parseDouble(reader.readLine()));
		reader.readLine();
		// date
		pwriter.println(Long.parseLong(reader.readLine()));
		
		reader.close();
		pwriter.close();
	}
	
	/**
	 * Copies a history file, will die horribly if any other file is input
	 * @param i input file directory
	 * @param o output file directory
	 * @throws IOException
	 */
	protected void copyHistory(File i, File o) throws IOException {
		if (!i.exists()) {
			return;
		}
		BufferedReader reader = new BufferedReader(new FileReader(i));
		if (!o.exists()) {
			o.createNewFile();
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter(o));
		PrintWriter pwriter = new PrintWriter(writer);
		
		pwriter.println(Double.parseDouble(reader.readLine()));
		pwriter.println(Long.parseLong(reader.readLine()));
		
		reader.close();
		pwriter.close();
	}
	
	/**
	 * Saves current profile to a separate history folder, ordered 1 through 8, with 1 being the newest and 8 being the oldest. Oldest deleted if more than 8 are added.
	 * @throws IOException
	 */
	
	public void toHistory() throws IOException {

		File history1 = new File("src/application/history/" + this.name + "1.txt");
		if (!history1.exists()) {
			history1.createNewFile();
			saveHistory(history1);
		} else {
			File history2 = new File("src/application/history/" + this.name + "2.txt");
			if (!history2.exists()) {
				copyHistory(history1, history2);
			} else {
				File history3 = new File("src/application/history/" + this.name + "3.txt");
				if (!history3.exists()) {
					copyHistory(history2, history3);
				} else {
					File history4 = new File("src/application/history/" + this.name + "4.txt");
					if (!history4.exists()) {
						copyHistory(history3, history4);
					} else {
						File history5 = new File("src/application/history/" + this.name + "5.txt");
						if (!history5.exists()) {
							copyHistory(history4, history5);
						} else {
							File history6 = new File("src/application/history/" + this.name + "6.txt");
							if (!history6.exists()) {
								copyHistory(history5, history6);
							} else {
								File history7 = new File("src/application/history/" + this.name + "7.txt");
								if (!history7.exists()) {
									copyHistory(history6, history7);
								} else {
									File history8 = new File("src/application/history/" + this.name + "8.txt");
									history8.delete();
									copyHistory(history7, history8);
								}
								copyHistory(history6, history7);
							}
							copyHistory(history5, history6);
						}
						copyHistory(history4, history5);
					}
					copyHistory(history3, history4);
				}
				copyHistory(history2, history3);
			}
			copyHistory(history1, history2);
		}
		history1.createNewFile();
		saveHistory(history1);
	}
	
	/*
	 * 
	 * 
	 *  Setter and getter methods
	 *  
	 *  
	 */
	
	/**
	 * Gets the date from a history file, 1 is youngest and 8 is oldest
	 * @param i recency of file as an int
	 * @return when that history file was logged into last as a string !!REMEMBER TO CONVERT AFTER!!
	 * @throws IOException
	 */
	public String getHistoryDate(int i) throws IOException {
		File check = new File("src/application/history/");
		check = new File("src/application/history/" + this.name + i + ".txt");
		if (check.exists()) {
			BufferedReader reader = new BufferedReader(new FileReader(check));
			reader.readLine();
			String output =  reader.readLine();
			reader.close();
			return output;
		} else {
			return "NONE";
		}
	}
	/**
	 * Gets the weight from a history file, 1 is youngest and 8 is oldest
	 * @param i recency of the file as int
	 * @return Weight in that history file as a string !!REMEMBER TO CONVERT AFTER!!
	 * @throws IOException
	 */
	public String getHistoryWeight(int i) throws IOException {
		File check = new File("src/application/history/");
		check = new File("src/application/history/" + this.name + i + ".txt");
		if (check.exists()) {
			BufferedReader reader = new BufferedReader(new FileReader(check));
			String output = reader.readLine();
			reader.close();
			return output;
		} else {
			return "NONE";
		}
	}
	/**
	 * Returns the oldest file in that profile's history
	 * @return Oldest file as a File
	 */
	public File getHistoryOldest() {
		int count = 8;
		File f = new File("src/");
		while (count > 0) {
			f = new File("src/application/history/" + this.name + count + ".txt");
			if (f.exists()) {
				return f;
			} else {
				count--;
			}
		}	
		return null;
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

	public void setWeight(double weight) throws NegativeNumberException  {
		if (weight >= 0) {
			this.weight = weight;
		} else {
			throw new NegativeNumberException();
		}
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) throws NegativeNumberException  {
		if (height >= 0) {
			this.height = height;
		} else {
			throw new NegativeNumberException();
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws NegativeNumberException  {
		if (height >= 0) {
			this.age = age;
		} else {
			throw new NegativeNumberException();
		}
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date i) {
		this.date = i;
	}

	public int getWalking() {
		return walking;
	}

	public void setWalking(int walking) throws NegativeNumberException  {
		if (walking >= 0) {
			this.walking = walking;
		} else {
			throw new NegativeNumberException();
		}
	}

	public int getRunning() {
		return running;
	}

	public void setRunning(int running) throws NegativeNumberException  {
		if (running >= 0) {
			this.running = running;
		} else {
			throw new NegativeNumberException();
		}
	}

	public int getBiking() {
		return biking;
	}

	public void setBiking(int biking) throws NegativeNumberException  {
		if (biking >= 0) {
			this.biking = biking;
		} else {
			throw new NegativeNumberException();
		}
	}

	public int getSwimming() {
		return swimming;
	}

	public void setSwimming(int swimming) throws NegativeNumberException  {
		if (swimming >= 0) {
			this.swimming = swimming;
		} else {
			throw new NegativeNumberException();
		}
	}

	public int getWorkout() {
		return workout;
	}

	public void setWorkout(int workout) throws NegativeNumberException {
		if (workout >= 0) {
			this.workout = workout;
		} else {
			throw new NegativeNumberException();
		}
	}
	
	public int getExercise() {
		return exercise;
	}

	// exercise can't be more than 10
	public void setExercise(int exercise) {
		this.exercise = exercise;
		if (this.exercise > 10) {
			exercise = 10;
		}
	}

	// formula found here https://www.gigacalculator.com/calculators/tdee-calculator.php
	public int getTDEE() {
		
		// gender constant (see formula source)
		int g;
		if (gender.equals("Male")) {
			g = 5;
		} else {
			g = -161;
		}
		
		// formula for imperial and metric
		double bmr = 0;
		if(unit.equals("Metric")) {
			bmr = (10 * weight) + (6.25 * height) + (5 * age) + g;
		} else {
			bmr = (4.5359 * weight) + (15.875 * height) + (5 * age) + g;
		}
		
		// multiply bmr depending on given exercise class
		double TDEE = 0;
		if (exercise <= 1) {
			TDEE = bmr * 1.035;
		} else if (exercise == 2) {
			TDEE = bmr * 1.07;
		} else if (exercise == 3) {
			TDEE = bmr * 1.12;
		} else if (exercise == 4) {
			TDEE = bmr * 1.23;
		} else if (exercise == 5) {
			TDEE = bmr * 1.31;
		} else if (exercise == 6) {
			TDEE = bmr * 1.39;
		} else if (exercise == 7) {
			TDEE = bmr * 1.47;
		} else if (exercise == 8) {
			TDEE = bmr * 1.54;
		} else if (exercise == 9) {
			TDEE = bmr * 1.63;
		} else if (exercise == 10) {
			TDEE = bmr * 1.70;
		}
		return (int) TDEE;
		
	}


}
