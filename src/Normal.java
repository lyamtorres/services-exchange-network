

public class Normal implements Group {
	
	private String normalName;

	Normal(){
		this.normalName="Normal";
	}
	public void reduceMoney(Member Member1, int res) {
		Member1.reduceMoney(res);
		
	}
	@Override
	public String toString() {
		return "Normal [normalName=" + normalName + "]";
	}

}