import java.util.*;

public class Jets {
	public static void main(String[] args) {
		run();
	}

	public static void initialFleet(Jet[] jetArray) {
		Jet a = new Jet("Cesna", 100, 102200, 1000000);
		Jet b = new Jet("Cesna", 102, 1011333300, 1000000);
		Jet c = new Jet("Cesna", 105, 1444400, 1000000);
		Jet d = new Jet("Cesna", 103, 10022200, 1000000);
		Jet e = new Jet("Cesna", 109, 11110, 1000000);

		jetArray[0] = a;
		jetArray[1] = b;
		jetArray[2] = c;
		jetArray[3] = d;
		jetArray[4] = e;
	}

	public static void run() {
		Scanner input = new Scanner(System.in);
		int choice;
		Jet[] jetArray = new Jet[100];
		initialFleet(jetArray);
		System.out.println("Welcome to the Jet Menu");
		do {
			System.out.println("enter your choice type 5 to quit:");
			System.out.println("1: List Fleet");
			System.out.println("2: View fastest jet");
			System.out.println("3: View Jet with longest range");
			System.out.println("4: add jet to Fleet");
			choice = input.nextInt();

			if (choice == 1) {
				listJets(jetArray);
			} else if (choice == 2) {
				sortSpeed(jetArray);
			} else if (choice == 3) {
				sortRange(jetArray);
			} else if (choice == 4) {
				addJets(jetArray, input);
			}
		} while (choice != 5);
	}

	public static void listJets(Jet[] jetArray) {

		for (int i = 0; i < jetArray.length; i++) {
			if (jetArray[i] != null) {
				System.out.println(i + " " + jetArray[i]);
			}
		}
	}

	public static void addJets(Jet[] jetArray, Scanner input) {
		String model;
		double speed;
		double range;
		double price;
		String placeHolder;

		System.out.println("What is the model of the plane?");
		placeHolder = input.nextLine();
		model = input.nextLine();
		System.out.println("What is the jet's speed in Miles Per Hour?");
		speed = input.nextDouble();
		System.out.println("What is the jet's range");
		range = input.nextDouble();
		System.out.println("What is the jet's price");
		price = input.nextDouble();

		Jet jet = new Jet(model, speed, range, price);
		for (int i = 0; i < jetArray.length; i++) {
			if (jetArray[i] == null) {
				jetArray[i] = jet;
				listJets(jetArray);
				break;
			}
		}

	}

	public static void sortSpeed(Jet[] jetArray){
		Jet fastest = jetArray[0];
		for (int i =0; i < jetArray.length; i++){
			if (jetArray[i] != null) {
				if (fastest.getSpeed() < jetArray[i].getSpeed()){
				fastest = jetArray[i];
				}
			}
		}
		System.out.println(fastest);	
	}
	public static void sortRange(Jet[] jetArray){
		Jet range = jetArray[0];
		for (int i =0; i < jetArray.length; i++){
			if (jetArray[i] != null) {
				if (range.getRange() < jetArray[i].getRange()){
				range = jetArray[i];
				}
			}
		}
		System.out.println(range);	
	}
}