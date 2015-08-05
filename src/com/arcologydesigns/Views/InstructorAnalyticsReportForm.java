package com.arcologydesigns.Views;

import com.arcologydesigns.DataStructures.*;
import com.arcologydesigns.ept.schoolItems.Assignment;
import com.arcologydesigns.ept.schoolItems.Classes;
import com.arcologydesigns.ept.schoolItems.DataContainer;
import com.arcologydesigns.ept.users.Instructor;
import com.arcologydesigns.ept.users.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * InstructorAnalyticsReportForm created by Borislav S. on 7/14/2015 @ 7:25 PM.
 */
public class InstructorAnalyticsReportForm extends JDialog {
   private JPanel instructorAnalyticsPanel;
   DefaultTableModel model;
   JTable table;
   String col[] = {"Name","Avg Grade","Class Grade"};

   public static void main(String args[])
   {
      new InstructorAnalyticsReportForm().start();
   }

   public void start() {
      // Set title and default close operation
      setTitle("Class Analysis Report");
      setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

      // Add the panels to the JFrame
      //add(instructorAnalyticsPanel, BorderLayout.NORTH);
      model = new DefaultTableModel(col, 50);
      table = new JTable(model) {
         @Override
         public boolean isCellEditable(int arg0, int arg1) {
            return false;
         }
      };
      JScrollPane pane = new JScrollPane(table);

      BST<Student> studentBST = DataContainer.DataContainerInst.getStudentsData();
      Queue<Assignment> assignmentQueue = DataContainer.DataContainerInst.getAssignmentData();
      ArrayList<Instructor> instructorArrayList = DataContainer.DataContainerInst.getInstructorsData();
      ArrayList<Classes> classesArrayList = DataContainer.DataContainerInst.getClassesData();

      String studentList = studentBST.inOrderTraversal();
      final String[] split1 = studentList.split(";");
      int index = 0;


      for(String s : split1) {
         boolean inBounds = (index >= 0) && (index < split1.length);
         final String split[] = s.split(",");
         if(split.length > 1) {
            if (split[1] != null && inBounds) {
               if(index == 0) {
                  table.setValueAt(split[1], index, 0);
               } else {
                  table.setValueAt(split[2], index, 0);
               }

            }
         }
         index++;
      }


      //table.setValueAt("csanuragjain", 0, 0);


      add(pane, BorderLayout.SOUTH);
      // Set the size of the JFrame and make it visible
      setSize(1200, 1000);
      setVisible(true);
      setLayout(new FlowLayout());
   }

   public InstructorAnalyticsReportForm() {
      String col[] = {"Student","Avg Grade"};
   }
}
