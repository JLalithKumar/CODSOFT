import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class StudentManagementGUI extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private java.util.List<Student> students = new ArrayList<>();
    private static final String FILE = "students.csv";

    public StudentManagementGUI() {
        super("Student Management System - GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(new String[] {"Roll", "Name", "Grade", "Email"}, 0);
        table = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(table);

        JPanel buttons = new JPanel();
        JButton addBtn = new JButton("Add");
        JButton editBtn = new JButton("Edit");
        JButton delBtn = new JButton("Delete");
        JButton loadBtn = new JButton("Load");
        JButton saveBtn = new JButton("Save");
        JButton exitBtn = new JButton("Exit");

        buttons.add(addBtn);
        buttons.add(editBtn);
        buttons.add(delBtn);
        buttons.add(loadBtn);
        buttons.add(saveBtn);
        buttons.add(exitBtn);

        add(scroll, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> showAddDialog());
        editBtn.addActionListener(e -> showEditDialog());
        delBtn.addActionListener(e -> deleteSelected());
        loadBtn.addActionListener(e -> { loadFromFile(FILE); refreshTable(); });
        saveBtn.addActionListener(e -> { saveToFile(FILE); });
        exitBtn.addActionListener(e -> { saveToFile(FILE); System.exit(0); });

        loadFromFile(FILE);
        refreshTable();
    }

    private void showAddDialog() {
        JTextField rollF = new JTextField();
        JTextField nameF = new JTextField();
        JTextField gradeF = new JTextField();
        JTextField emailF = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0,1));
        panel.add(new JLabel("Roll:")); panel.add(rollF);
        panel.add(new JLabel("Name:")); panel.add(nameF);
        panel.add(new JLabel("Grade:")); panel.add(gradeF);
        panel.add(new JLabel("Email:")); panel.add(emailF);

        int result = JOptionPane.showConfirmDialog(this, panel, "Add Student", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String roll = rollF.getText().trim();
            if (roll.isEmpty() || findByRoll(roll) != null) {
                JOptionPane.showMessageDialog(this, "Roll empty or already exists.");
                return;
            }
            Student s = new Student(roll, nameF.getText().trim(), gradeF.getText().trim(), emailF.getText().trim());
            students.add(s);
            tableModel.addRow(new Object[] { s.getRoll(), s.getName(), s.getGrade(), s.getEmail() });
        }
    }

    private void showEditDialog() {
        int row = table.getSelectedRow();
        if (row == -1) { JOptionPane.showMessageDialog(this, "Select a row to edit."); return; }
        String roll = (String) tableModel.getValueAt(row, 0);
        Student s = findByRoll(roll);
        if (s == null) return;

        JTextField nameF = new JTextField(s.getName());
        JTextField gradeF = new JTextField(s.getGrade());
        JTextField emailF = new JTextField(s.getEmail());

        JPanel panel = new JPanel(new GridLayout(0,1));
        panel.add(new JLabel("Name:")); panel.add(nameF);
        panel.add(new JLabel("Grade:")); panel.add(gradeF);
        panel.add(new JLabel("Email:")); panel.add(emailF);

        int result = JOptionPane.showConfirmDialog(this, panel, "Edit Student " + roll, JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            s.setName(nameF.getText().trim());
            s.setGrade(gradeF.getText().trim());
            s.setEmail(emailF.getText().trim());
            tableModel.setValueAt(s.getName(), row, 1);
            tableModel.setValueAt(s.getGrade(), row, 2);
            tableModel.setValueAt(s.getEmail(), row, 3);
        }
    }

    private void deleteSelected() {
        int row = table.getSelectedRow();
        if (row == -1) { JOptionPane.showMessageDialog(this, "Select a row to delete."); return; }
        String roll = (String) tableModel.getValueAt(row, 0);
        Student s = findByRoll(roll);
        if (s != null) students.remove(s);
        tableModel.removeRow(row);
    }

    private Student findByRoll(String roll) {
        for (Student s: students) if (s.getRoll().equalsIgnoreCase(roll)) return s;
        return null;
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Student s: students) {
            tableModel.addRow(new Object[] { s.getRoll(), s.getName(), s.getGrade(), s.getEmail() });
        }
    }

    private void saveToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Student s : students) bw.write(s.toCSV() + "\n");
            JOptionPane.showMessageDialog(this, "Saved to " + filename);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Save error: " + e.getMessage());
        }
    }

    private void loadFromFile(String filename) {
        students.clear();
        File f = new File(filename);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                Student s = Student.fromCSV(line);
                if (s != null) students.add(s);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Load error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentManagementGUI gui = new StudentManagementGUI();
            gui.setVisible(true);
        });
    }
}
