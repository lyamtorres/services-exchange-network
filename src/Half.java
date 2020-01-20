

public class Half implements Group {
	
	private String halfName;
	
	public Half () {
		this.halfName = "half";
	}
	
	public void reduceMoney(Member Member1, int res) {
		Member1.reduceMoney(res/2);
	}

	@Override
	public String toString() {
		return "Half [halfName=" + halfName + "]";
	}
}