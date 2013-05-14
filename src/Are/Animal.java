package Are;

public class Animal implements Comparable<Animal> {
	private int age;
	private int mass;
	private String species;

	public boolean equals(Object c) {

		if (!(c instanceof Animal))
			return false;
	
		Animal b = (Animal) c;

		if (this.age != b.age)
			return false;

		if (this.mass != b.mass)
			return false;

		if (!this.species.equals(b.species))
			return false;

		return true;
	}

	public Animal(int years, int kilogrammes, String species) {
		this.species = species;
		age = years;
		this.mass = kilogrammes;
	}

	public int getAge() {
		return this.age;
	}

	public int getMass() {
		return this.mass;
	}

	public int compareTo(Animal a) {
		return (this.mass - a.mass);
	}

	public String toString() {
		return species;
	}
}
