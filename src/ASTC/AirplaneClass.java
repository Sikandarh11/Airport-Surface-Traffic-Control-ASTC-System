package ASTC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AirplaneClass implements Serializable {

    public void flightDeparture(Task pr, String runway){
        String str;
        str = "Name : " + pr.getAeroplaneName() + "\nID: "+pr.getID()+"\nPassenger Count : "+ pr.getPassengerCount()+"\nTime : "+pr.getTime() + "\nPriority : " + pr.getPriority() + "\nClass : " + pr.getClass() + "\nPrice : " + pr.getShortestPath() + "\nDeparture Date : " + pr.getDepartureDate() +"\n"+ runway+"\nSource : " +pr.getSource()+"-------------------------------------------->" + "Destination : "+pr.getDestination()+"\n\n";

        for(Task task : taskEngine.getTasklist()){
            if(task.getID() == pr.getID()){
                taskEngine.getTasklist().remove(task);
            }
        }
        JOptionPane.showMessageDialog(null, str, "Flight Details", JOptionPane.PLAIN_MESSAGE);
    }

    public void clock() {

        Thread clockThread = new Thread(() -> {
            try {
                while (true) {
                    taskEngine.dispatchTasks();
                    lblClock.setText(globalClock.getTime());
                    datelbl2.setText(globalClock.getDate());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ie) {
                System.out.println("An error occurred...");
                ie.printStackTrace();
            }
        });

        clockThread.start();
    }

    public static void writeFile(ArrayList<Task> TaskList) throws IOException {
        System.out.println("Called Write file");
        File file = new File("D:\\3rd semester\\1. O.O.P\\1. JAVA\\AeroplaneList1.txt");
        try (ObjectOutputStream objWrite = new ObjectOutputStream(new FileOutputStream(file))) {
            System.out.println("File Writed");
            objWrite.writeObject(TaskList);
            objWrite.close();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void DisplayAllItem() {
        String str = "";
        try (ObjectInputStream objRead = new ObjectInputStream(new FileInputStream(new File("D:\\3rd semester\\1. O.O.P\\1. JAVA\\AeroplaneList.txt")))) {
            for (Task pr : (ArrayList<Task>) objRead.readObject()) {
                str += "Name : " + pr.getAeroplaneName() + "\nID: "+pr.getID()+"\nPassengers : "+ pr.getPassengerCount()+"\nTime : "+pr.getTime() +
                        "\nPriority : " + pr.getPriority() + "\nClass : " + pr.getSelectClass() + "\nPrice : " + pr.getShortestPath() + "      Departure Date : " + pr.getDepartureDate() + "      \nSource : " + pr.getSource()+"---------------------------->" + "Destination : "+pr.getDestination()+"\n\n";
            }
        } catch (Exception e) {
            System.out.println("Not opened");
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, str, "Flight Details", JOptionPane.PLAIN_MESSAGE);
    }

    public void StartWork() throws IOException {
        String sourse = comboBoxSource.getSelectedItem().toString();
        String destinatioin = comboBoxDestination.getSelectedItem().toString();
        String time = comboBoxTime.getSelectedItem().toString();
        String passengerCount = comboBoxPassengers.getSelectedItem().toString();
        String priority = comboBoxPriority.getSelectedItem().toString();
        String selectClass = comboBoxSelectClass.getSelectedItem().toString();

        String id = txtID.getText();
        String AeroplaneName = txtAeroplaneName.getText();
        String departureDate = txtdepartureDate.getText();

        InputValidator inputValidator = new InputValidator();

        if (inputValidator.txtisNotEmpty(id, AeroplaneName) &&
                inputValidator.ComboboxInputValidation(sourse, destinatioin, time, passengerCount, priority, selectClass) &&
                inputValidator.isValidDate(departureDate)) {

            taskEngine.PriorityTask(new Task(id, sourse, destinatioin, passengerCount, time, priority, AeroplaneName, selectClass, departureDate));
            System.out.println("Write Called");
            writeFile(taskEngine.getTasklist());

            comboBoxSource.setSelectedIndex(0);
            comboBoxDestination.setSelectedIndex(0);
            comboBoxPassengers.setSelectedIndex(0);
            comboBoxPriority.setSelectedIndex(0);
            comboBoxTime.setSelectedIndex(0);
            comboBoxSelectClass.setSelectedIndex(0);

            txtID.setText("");
            txtAeroplaneName.setText("");
            txtdepartureDate.setText("");

        }
        else {
            JOptionPane.showMessageDialog(null, "Please Fill the form correctly ", "Flight Details", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public AirplaneClass() {
        taskEngine = new TaskEngine(globalClock);
        taskEngine.start(); clock();

        mainFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainForm mainForm = new MainForm();
                mainForm.mainForm();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StartWork();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



        txtAeroplaneName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        txtID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        txtdepartureDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        lblClock.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {super.componentResized(e);
            }
        });
        datelbl2.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {super.componentResized(e);
            }
        });


        comboBoxSource.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        comboBoxTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        comboBoxPassengers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        comboBoxDestination.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        comboBoxPriority.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        comboBoxSelectClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }

    public static void mainAeroplane() {
        JFrame frame = new JFrame("AirplaneClass");
        frame.setContentPane(new AirplaneClass().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }











    private GlobalClock globalClock = new GlobalClock();
    private TaskEngine taskEngine;

    private JLabel SIA;
    private JComboBox comboBoxSource;
    private JComboBox comboBoxDestination;
    private JComboBox comboBoxTime;
    private JTextField txtID;
    private JComboBox comboBoxPassengers;
    private JLabel AeroplaneName;
    private JLabel sourcelbl;
    private JLabel destinationlbl;
    private JLabel timelbl;
    private JLabel IDlbl;
    private JLabel SelectPassengerlbl;
    private JPanel Panel;
    private JLabel GlobalTimelbl;
    private JButton savebtn;
    private JButton MainFormbtn;
    private JButton CheckAirolanesbtn;
    private JLabel priorityLbl;
    private JComboBox comboBoxPriority;
    private JLabel lblClock;
    private JTextField txtAeroplaneName;
    private JLabel datelbl2;
    private JLabel datelbl1;
    private JFormattedTextField txtdepartureDate;
    private JComboBox comboBoxSelectClass;
    private JLabel lblClassType;
    private JLabel DepartureDatelbl;
    private JComboBox comboBox1;
    private JButton mainFormButton;
    private JButton saveButton;
    private JPanel JPAnelAeroplane;
    private JTable table1;

}



