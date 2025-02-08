
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusReservationGUI extends JFrame {
    
    // Total number of seats in the bus
    private static final int TOTAL_SEATS = 20;
    // Array to track seat availability (true = booked, false = available)
    private boolean[] seats = new boolean[TOTAL_SEATS];
    private JLabel statusLabel;
    private JPanel seatPanel;
    private JButton[] seatButtons;

    public BusReservationGUI() {
        setTitle("Bus Reservation System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize components
        statusLabel = new JLabel("Available seats: " + getAvailableSeats(), JLabel.CENTER);
        add(statusLabel, BorderLayout.NORTH);
        
        seatPanel = new JPanel();
        seatPanel.setLayout(new GridLayout(5, 4)); // 5 rows, 4 columns of buttons
        seatButtons = new JButton[TOTAL_SEATS];
        
        // Create buttons for each seat and add them to the panel
        for (int i = 0; i < TOTAL_SEATS; i++) {
            seatButtons[i] = new JButton("Seat " + (i + 1));
            seatButtons[i].setBackground(Color.GREEN);
            seatButtons[i].setFont(new Font("Arial", Font.BOLD, 14));
            seatButtons[i].addActionListener(new SeatButtonActionListener(i));
            seatPanel.add(seatButtons[i]);
        }
        add(seatPanel, BorderLayout.CENTER);

        // Add a reset button to refresh the system
        JPanel buttonPanel = new JPanel();
        JButton resetButton = new JButton("Reset System");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetSystem();
            }
        });
        buttonPanel.add(resetButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Get the number of available seats
    private int getAvailableSeats() {
        int availableCount = 0;
        for (boolean seat : seats) {
            if (!seat) {
                availableCount++;
            }
        }
        return availableCount;
    }

    // ActionListener for seat button click
    private class SeatButtonActionListener implements ActionListener {
        private int seatIndex;

        public SeatButtonActionListener(int seatIndex) {
            this.seatIndex = seatIndex;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!seats[seatIndex]) {
                // Seat is available, book it
                seats[seatIndex] = true;
                seatButtons[seatIndex].setBackground(Color.RED);
                seatButtons[seatIndex].setText("Booked");
                statusLabel.setText("Available seats: " + getAvailableSeats());
            } else {
                // Seat is already booked, cancel the booking
                seats[seatIndex] = false;
                seatButtons[seatIndex].setBackground(Color.GREEN);
                seatButtons[seatIndex].setText("Seat " + (seatIndex + 1));
                statusLabel.setText("Available seats: " + getAvailableSeats());
            }
        }
    }

    // Reset the system
    private void resetSystem() {
        for (int i = 0; i < TOTAL_SEATS; i++) {
            seats[i] = false; // Mark all seats as available
            seatButtons[i].setBackground(Color.GREEN);
            seatButtons[i].setText("Seat " + (i + 1));
        }
        statusLabel.setText("Available seats: " + TOTAL_SEATS);
    }

    public static void main(String[] args) {
        new BusReservationGUI();
    }
}

