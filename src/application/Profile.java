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
		pwriter.println(date.getTime());
		pwriter.println(walking);
		pwriter.println(running);
		pwriter.println(biking);
		pwriter.println(swimming);
		pwriter.println(workout);
		pwriter.println(exercise);

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
		date = new Date(Long.parseLong(reader.readLine()));
		walking = Integer.parseInt(reader.readLine());
		running = Integer.parseInt(reader.readLine());
		biking = Integer.parseInt(reader.readLine());
		swimming = Integer.parseInt(reader.readLine());
		workout = Integer.parseInt(reader.readLine());
		exercise = Integer.parseInt(reader.readLine());
		
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
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date i) {
		this.date = i;
	}

	public int getWalking() {
		return walking;
	}

	public void setWalking(int walking) {
		this.walking = walking;
	}

	public int getRunning() {
		return running;
	}

	public void setRunning(int running) {
		this.running = running;
	}

	public int getBiking() {
		return biking;
	}

	public void setBiking(int biking) {
		this.biking = biking;
	}

	public int getSwimming() {
		return swimming;
	}

	public void setSwimming(int swimming) {
		this.swimming = swimming;
	}

	public int getWorkout() {
		return workout;
	}

	public void setWorkout(int workout) {
		this.workout = workout;
	}
	
	public int getExercise() {
		return exercise;
	}

	public void setExercise(int exercise) {
		this.exercise = exercise;
		if (this.exercise > 5) {
			exercise = 5;
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
		
		// multiply bmr depending on exercise class
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
