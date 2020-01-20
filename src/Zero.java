

public class Zero implements Group {
	
	public String zeroName;
	
	public Zero(){
		this.zeroName="Zero";
	}
	public void reduceMoney(Member Member1, int res) {
		Member1.reduceMoney(0);
	}
	
	@Override
	public String toString() {
		return "Zero [zeroName=" + zeroName + "]";
	}
}