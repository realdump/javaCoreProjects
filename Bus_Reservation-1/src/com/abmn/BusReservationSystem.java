package com.abmn;

import java.util.Scanner;

public class BusReservationSystem {

    static int totalSeats = 50; // Total number of seats available in the bus
    static int availableSeats = totalSeats; // Initially, all seats are available
    static boolean[] seats = new boolean[totalSeats]; // Seat availability status (true = booked, false = available)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBus Reservation System");
            System.out.println("1. Book a seat");
            System.out.println("2. Cancel a booking");
            System.out.println("3. View available seats");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookSeat(scanner);
                    break;
                case 2:
                    cancelBooking(scanner);
                    break;
                case 3:
                    viewAvailableSeats();
                    break;
                case 4:
                    System.out.println("Thank you for using the bus reservation system!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void bookSeat(Scanner scanner) {
        if (availableSeats == 0) {
            System.out.println("Sorry, no seats are available.");
            return;
        }

        System.out.println("Available seats: ");
        for (int i = 0; i < totalSeats; i++) {
            if (!seats[i]) {
                System.out.print((i + 1) + " ");
            }
        }

        System.out.println();
        System.out.print("Enter the seat number to book: ");
        int seatNumber = scanner.nextInt();

        if (seatNumber < 1 || seatNumber > totalSeats || seats[seatNumber - 1]) {
            System.out.println("Invalid seat number or seat already booked. Please try again.");
        } else {
            seats[seatNumber - 1] = true;
            availableSeats--;
            System.out.println("Seat " + seatNumber + " has been successfully booked.");
        }
    }

    public static void cancelBooking(Scanner scanner) {
        System.out.print("Enter the seat number to cancel the booking: ");
        int seatNumber = scanner.nextInt();

        if (seatNumber < 1 || seatNumber > totalSeats || !seats[seatNumber - 1]) {
            System.out.println("Invalid seat number or seat is not booked. Please try again.");
        } else {
            seats[seatNumber - 1] = false;
            availableSeats++;
            System.out.println("Booking for seat " + seatNumber + " has been successfully canceled.");
        }
    }

    public static void viewAvailableSeats() {
        System.out.println("Available seats: ");
        for (int i = 0; i < totalSeats; i++) {
            if (!seats[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }
}
