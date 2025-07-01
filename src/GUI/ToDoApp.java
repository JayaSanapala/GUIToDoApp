package GUI;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JFrame;  // <- added import
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class ToDoApp extends JFrame {  // <- extend JFrame

	    private DefaultListModel<String> listModel;
	    private JList<String> taskList;
	    private JButton addButton, deleteButton;

	    public ToDoApp() {
	        super("To-Do List App");

	        listModel = new DefaultListModel<>();
	        taskList = new JList<>(listModel);
	        addButton = new JButton("Add Task");
	        deleteButton = new JButton("Delete Task");

	        JPanel inputPanel = new JPanel();
	        inputPanel.add(addButton);
	        inputPanel.add(deleteButton);

	        setLayout(new BorderLayout());
	        add(inputPanel, BorderLayout.NORTH);
	        add(new JScrollPane(taskList), BorderLayout.CENTER);

	        addButton.addActionListener(e -> {
	            String task = JOptionPane.showInputDialog(this, "Enter a new task:");
	            if (task != null) {
	                task = task.trim();
	                if (!task.isEmpty()) {
	                    listModel.addElement(task);
	                } else {
	                    JOptionPane.showMessageDialog(this, "Task cannot be empty.");
	                }
	            }
	        });

	        deleteButton.addActionListener(e -> {
	            int selectedIndex = taskList.getSelectedIndex();
	            if (selectedIndex != -1) {
	                listModel.remove(selectedIndex);
	            } else {
	                JOptionPane.showMessageDialog(this, "Please select a task to delete.");
	            }
	        });

	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(500, 400);
	        setLocationRelativeTo(null);
	        setVisible(true);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(ToDoApp::new);
	    }
	}
