package busResv;

import java.util.Scanner;
import java.util.ArrayList;

public class BusDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Bus> buses = new ArrayList<Bus>();
		buses.add(new Bus(1, true, 30));
		buses.add(new Bus(2, true, 45));
		buses.add(new Bus(3, true, 60));
		
		int userOpt = 1;
		Scanner scanner = new Scanner(System.in);
		while(userOpt==1) {
			System.out.println("Enter 1 to book or 2 to Exit Menu");
			userOpt = scanner.nextInt();
			if(userOpt==1) {
				System.out.println("Booking.....");
			}
		}
		for(Bus b:buses) {
			b.displayBusInfo();
		}
	}

}
