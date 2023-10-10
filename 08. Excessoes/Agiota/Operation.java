package Agiota;

public class Operation {
	private int id;
	private String name;
	private Label label;
	private int value;
	
	public Operation(int id, String name, Label label, int value) {
		super();
		this.id = id;
		this.name = name;
		this.label = label;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Label getLabel() {
		return label;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLabel(Label label) {
		this.label = label;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public String toString() {
		// id:0 give:maria 300
		return "id:" + getId() + " " + label.toString(label) + ":" + getName() + " " + getValue();
	}
}
