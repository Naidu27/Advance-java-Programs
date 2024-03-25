package java8practice;

interface service{
	public String voteCheck(String name,int age, String location);
}
public class Vote {

	public static void main(String[] args) {
		
	service s=(name,age,location)->{
		
		if(age>=18 && location.equals("hyd"))
		{
			return "yes";
		}
		else
		{
			return "no";
		}
	};
	
	System.out.println(s.voteCheck("sai", 18, "hyd"));
	}

}
