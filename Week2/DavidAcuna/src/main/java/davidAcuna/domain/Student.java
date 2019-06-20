package davidAcuna.domain;

public class Student {
    
	private String name;
	private Integer identification;
	private Integer age;
	
	public Student(String name, Integer identification, Integer age) {
		super();
		this.name = name;
		this.identification = identification;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIdentification() {
		return identification;
	}

	public void setIdentification(Integer identification) {
		this.identification = identification;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}	
		
}
