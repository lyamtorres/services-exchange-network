

public abstract interface Group {
	
	// Retire de l'argent en fonction du coef respectif dans chaque sous classe ayant cette methode (Zero, Half, Normal)
	public abstract void reduceMoney(Member Member1, int res); 
	
}