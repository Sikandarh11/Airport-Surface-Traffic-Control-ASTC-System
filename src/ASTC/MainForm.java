package ASTC;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class MainForm {
    private JButton btnaddAircraft;
    private JButton btnlandingRequestButton;
    private JButton btnflightSchedule;
    private JButton btnparkedPlanesButton;
    private JPanel Jpanel;
    private JLabel timelbl;
    private JLabel datelbl;
    private static AirplaneClass airplaneClass = new AirplaneClass();
    private static GroundNetworkClass groundNetworkClass = new GroundNetworkClass();
    GlobalClock globalClock = new GlobalClock();

    public void clock() {
        Thread clockThread = new Thread(() -> {
            try {
                while (true) {
                    timelbl.setText(globalClock.getTime());
                    datelbl.setText(globalClock.getDate());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ie) {
                System.out.println("An error occurred...");
                ie.printStackTrace();
            }
        });

        clockThread.start();
    }

    public MainForm() {
        clock();
        btnaddAircraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                airplaneClass.mainAeroplane();
            }
        });
        btnlandingRequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groundNetworkClass.mainGroundNetworkClass();
            }
        });
        btnflightSchedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    airplaneClass.DisplayAllItem();
                }catch (Exception e1){
                    e1.printStackTrace();
                }

            }
        });
        btnparkedPlanesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groundNetworkClass.DisplayAllItem();
            }
        });
        timelbl.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
        datelbl.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
    }

    public static void mainForm() {
        JFrame frame = new JFrame("Info");
        frame.setContentPane(new MainForm().Jpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
