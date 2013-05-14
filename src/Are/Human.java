package Are;

public class Human extends Animal {

	private String name;

	public boolean equals(Object obj) {
		if (!(obj instanceof Human))
			return false;
		if(!super.equals(obj)){
			return false;
		}
		Human buf = (Human) obj;
		if (!this.name.equals(buf.getName()))
			return false;
		return true;
	}

	public String toString() {
		return (this.name);
	}

	public Human(int years, int weight, String buf) {
		super(years, weight, "Human");
		name = buf;
	}

	public String getName() {
		return name;
	}
}
