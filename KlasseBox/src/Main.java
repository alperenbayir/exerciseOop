
public class Main {

	public static void main(String[] args) {
		
		Box box1 = new Box(30,40,53);
		Box box2 = new Box(20,40,62);
		
		System.out.println(box1.compareTo(box2)); // If the volume of box is equal to the volume of box2 "0"  
												//  is greater than box2 "1"  
											   //	is less than box 2 "-1" will be written. 
		System.out.println("Is box1 box2 encloses? " + box1.encloses(box2));
		System.out.println("Area size of box1 is: " + box1.getAreaSize() + " -Area size of box2 is: " + box2.getAreaSize());
		System.out.println("Edges lenght of box1 is: " +box1.getEdgesLength() + " -Edges lenght of box2 is: " + box2.getAreaSize());
		System.out.println("Volume size of box1 is: " +box1.getVolumeSize() + " -Volume size of box2 is: " + box2.getAreaSize());
		System.out.println("Is box1 cube? " + box1.isCube());
		
	}

}
