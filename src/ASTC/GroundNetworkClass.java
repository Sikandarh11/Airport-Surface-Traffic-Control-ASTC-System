package ASTC;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.*;
import java.util.ArrayList;

public class GroundNetworkClass implements Serializable {

    public static void writeFile(ArrayList<Task> TaskList) throws IOException {
        try (ObjectOutputStream objWrite = new ObjectOutputStream(new FileOutputStream(new File("D:\\3rd semester\\1. O.O.P\\1. JAVA\\ParkedAeroplaneList.txt")))) {
            objWrite.writeObject(TaskList);  objWrite.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void DisplayAllItem() {
        String s = "";

        try (ObjectInputStream objRead = new ObjectInputStream(new FileInputStream(new File("D:\\3rd semester\\1. O.O.P\\1. JAVA\\ParkedAeroplaneList.txt")))) {
            ArrayList<Task> readP = (ArrayList<Task>) objRead.readObject();
            AirplaneRelatedTask airplaneRelatedTask = new AirplaneRelatedTask();

            for (Task task : readP) {
                s += "Name : " + task.getAeroplaneName() + "\nID : " + task.getID()+ "\nSource Country : "+task.getSource()+"\nPassengers : "+task.getPassengerCount()+"\nFlight Type :"+
                        task.getFlightType()+"\nLanding Type : "+task.getLandingType() +airplaneRelatedTask.EnteringTask(readP.get(readP.size()-1)) +"\n\n";

            }
        } catch (Exception e) {
            System.out.println("Not opened");
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, s, "Landing Flight Details", JOptionPane.PLAIN_MESSAGE);
    }

    public void startWork()throws IOException{
        String name = txtNameEntringPlane.getText();
        String id = txtID.getText();
        String  passengerCount = txtPassengerCount.getText();

        String landingType = comboBoxLandingType.getSelectedItem().toString();
        String flightType = comboBoxFlightType.getSelectedItem().toString();
        String sourceCountry = comboBoxSourceCountry.getSelectedItem().toString();

        InputValidator inputValidator = new InputValidator();
        if(inputValidator.txtisNotEmpty(name, id) && inputValidator.ComboboxInputValidation(sourceCountry, landingType, flightType)
                && inputValidator.isValidPassengerCount(passengerCount) ==true){
//===================================================================================
            Task task = new Task(name,id, passengerCount, landingType,flightType, sourceCountry);
            AirplaneRelatedTask airplaneRelatedTask = new AirplaneRelatedTask();

            String s = "Name : " + task.getAeroplaneName() + "\nID : " + task.getID()+ "\nSource Country : "+task.getSource()+"\nPassengers : "+task.getPassengerCount()+"\nFlight Type :"+
                    task.getFlightType()+"\nLanding Type : "+task.getLandingType() +airplaneRelatedTask.EnteringTask(task) +"\n\n";


            JOptionPane.showMessageDialog(null, s, "Landing Flight Details", JOptionPane.PLAIN_MESSAGE);

//=====================================================================================
            txtNameEntringPlane.setText(""); txtID.setText(""); txtPassengerCount.setText("");
            comboBoxLandingType.setSelectedIndex(0); comboBoxFlightType.setSelectedIndex(0); comboBoxSourceCountry.setSelectedIndex(0);

            writeFile(airplaneRelatedTask.getGroundNetworkTaskList());

        }
        else {
            JOptionPane.showMessageDialog(null, "Please Fill the form correctly ", "Flight Details", JOptionPane.PLAIN_MESSAGE);

        }

    }

    public void clock() {
        Thread clockThread = new Thread(() -> {
            try {
                while (true) {
                    Timelbl2.setText(globalClock.getTime());
                    Datelbl2.setText(globalClock.getDate());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ie) {
                System.out.println("An error occurred...");
                ie.printStackTrace();
            }
        });

        clockThread.start();
    }

    public GroundNetworkClass() {
        clock();
        savebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    startWork();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        Returnbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainForm mainForm = new MainForm();
                mainForm.mainForm();
            }
        });


        txtNameEntringPlane.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) {

            }});
        txtID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        txtPassengerCount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        comboBoxLandingType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        comboBoxFlightType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        comboBoxSourceCountry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        Timelbl2.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {super.componentResized(e);
            }
        });
        Datelbl2.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {super.componentResized(e);
            }
        });


    }

    public static void mainGroundNetworkClass() {
        JFrame frame = new JFrame("GroundNetworkClass");
        frame.setContentPane(new GroundNetworkClass().GroundNetworkClassPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }



    private GlobalClock globalClock = new GlobalClock();

    private JPanel GroundNetworkClassPanel;
    private JLabel Namelbl1;
    private JTextField txtNameEntringPlane;
    private JComboBox comboBoxSourceCountryAp;
    private JComboBox comboBoxSourceCountry;
    private JComboBox comboBox2;
    private JComboBox comboBoxLandingType;
    private JTextField txtID;
    private JComboBox comboBoxFlightType;
    private JLabel Datelbl2;
    private JLabel Timelbl2;
    private JTextField txtPassengerCount;
    private JButton savebtn;
    private JButton Returnbtn;


}
