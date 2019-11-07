package dto;

public class InterestsItem{
	private String name;
	private String id;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"dto.InterestsItem{" +
			"subject = '" + name + '\'' +
			",id = '" + id + '\'' + 
			"}";
		}
}
