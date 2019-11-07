package dto;

import java.util.List;

public class UserInterests{
	private List<InterestsItem> interests;

	public void setInterests(List<InterestsItem> interests){
		this.interests = interests;
	}

	public List<InterestsItem> getInterests(){
		return interests;
	}

	@Override
 	public String toString(){
		return 
			"dto.UserInterests{" +
			"interests = '" + interests + '\'' + 
			"}";
		}
}