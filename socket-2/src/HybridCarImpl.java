public class HybridCarImpl implements ICar,IElectricCharge, INavigation{
    int b=50;
    int sp=5;

	String destination;
    
    public static void main(String[] args){
        HybridCarImpl masaCar= new  HybridCarImpl();

        ICar car=(ICar) masaCar;
        car.setSpeed(60);
        car.printCarName();

        IElectricCharge charger =(IElectricCharge) masaCar;
        charger.chargeBattery(100);

		INavigation navigation = (INavigation) masaCar;
        navigation.setDestination("Tokyo");
        navigation.printRoute();

    
    }
    
    
	@Override
	public void chargeBattery(int b) {
		this.b=b;
		
	}

	@Override
	public int getAllBattery() {
	
		return b;
	}

	@Override
	public int consumeBattery(int b) {
		this.b-=b;
		return this.b;
	}

	@Override
	public void setSpeed(int sp) {
		this.sp=sp;
		
	}

	@Override
	public int getSpeed() {
		
		return sp;
	}

	@Override
	public void printCarName() {
		System.out.println("masacar");
		
	}
	@Override
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public void printRoute() {
        System.out.println("Destination is " + destination);
    }

}