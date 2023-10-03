package Topic;

public class Pass {
	private int age;
	private String id;
	
	public Pass(int age, String id) {
		this.age = age;
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public boolean isPriority() {
		if(getAge() > 64) {
			return true;
		}
		return false;
	}
	
	@ Override
	public String toString() {
		return getId() + ":" + getAge();
	}
}