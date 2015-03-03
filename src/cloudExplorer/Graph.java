/**
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */
package cloudExplorer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Graph implements Runnable {

    NewJFrame mainFrame;
    String Home = System.getProperty("user.home");
    File config = new File(Home + File.separator + ".cloudExplorerIRC");
    String what = null;

    public Graph(NewJFrame Frame, String Awhat) {
        mainFrame = Frame;
        what = Awhat;
    }

    void calibrateTextArea() {
        NewJFrame.jTextArea1.append("\n");
        try {
            NewJFrame.jTextArea1.setCaretPosition(NewJFrame.jTextArea1.getLineStartOffset(NewJFrame.jTextArea1.getLineCount() - 1));
        } catch (Exception e) {

        }
    }

    public void run() {

        final JButton save = new JButton("Save");
        final JButton graph = new JButton("Graph");
        final JButton close = new JButton("Close");
        final JLabel graph_name = new JLabel("Name:");
        final JLabel x_name = new JLabel("X-axis name:");
        final JLabel x_whattograph = new JLabel("X column # in CSV:");
        final JLabel y_whattograph = new JLabel("Y column # in CSV:");
        final JLabel graph_size_x = new JLabel("Horizontal Graph Size: ");
        final JLabel graph_size_y = new JLabel("Vertical Graph Size:");
        final JLabel blank = new JLabel(" ");
        final JLabel blank2 = new JLabel(" ");
        final JLabel blank3 = new JLabel(" ");
        final JLabel blank4 = new JLabel(" ");
        final JLabel blank5 = new JLabel(" ");
        final JLabel blank6 = new JLabel(" ");
        final JLabel y_name = new JLabel("Y-axis name:");
        final JTextField x_whattograph_field = new JTextField("0");
        final JTextField y_whattograph_field = new JTextField("1");
        final JTextField graph_name_field = new JTextField("New Graph");
        final JTextField x_name_field = new JTextField(null);
        final JTextField y_name_field = new JTextField(null);
        final JTextField x_graphsize_field = new JTextField("600");
        final JTextField y_graphsize_field = new JTextField("300");

        x_whattograph_field.setMaximumSize(new Dimension(250, 20));
        y_whattograph_field.setMaximumSize(new Dimension(250, 20));

        y_graphsize_field.setMaximumSize(new Dimension(250, 20));
        x_graphsize_field.setMaximumSize(new Dimension(250, 20));

        graph_name_field.setMaximumSize(new Dimension(250, 20));
        x_name_field.setMaximumSize(new Dimension(250, 20));
        y_name_field.setMaximumSize(new Dimension(250, 20));

        y_whattograph.setBackground(Color.white);
        y_whattograph.setForeground(Color.blue);
        y_whattograph.setBorder(null);

        x_whattograph.setBackground(Color.white);
        x_whattograph.setForeground(Color.blue);
        x_whattograph.setBorder(null);

        graph_name.setBackground(Color.white);
        graph_name.setForeground(Color.blue);
        graph_name.setBorder(null);

        graph_size_x.setBackground(Color.white);
        graph_size_x.setForeground(Color.blue);
        graph_size_x.setBorder(null);

        graph_size_y.setBackground(Color.white);
        graph_size_y.setForeground(Color.blue);
        graph_size_y.setBorder(null);

        y_name.setBackground(Color.white);
        y_name.setForeground(Color.blue);
        y_name.setBorder(null);

        x_name.setBackground(Color.white);
        x_name.setForeground(Color.blue);
        x_name.setBorder(null);

        save.setBackground(Color.white);
        save.setForeground(Color.blue);
        save.setBorder(null);

        close.setBackground(Color.white);
        close.setBorder(null);
        close.setForeground(Color.blue);

        graph.setBackground(Color.white);
        graph.setBorder(null);
        graph.setForeground(Color.blue);

        close.setMaximumSize(new Dimension(150, 15));
        save.setMaximumSize(new Dimension(150, 15));

        mainFrame.jPanel11.removeAll();
        mainFrame.jPanel14.removeAll();
        mainFrame.jPanel11.setLayout(new BoxLayout(mainFrame.jPanel11, BoxLayout.Y_AXIS));
        mainFrame.jPanel11.add(graph_name);
        mainFrame.jPanel11.add(graph_name_field);
          mainFrame.jPanel11.add(blank6);
        mainFrame.jPanel11.add(graph_size_x);
        mainFrame.jPanel11.add(x_graphsize_field);
        mainFrame.jPanel11.add(graph_size_y);
        mainFrame.jPanel11.add(y_graphsize_field);
        mainFrame.jPanel11.add(blank);
        mainFrame.jPanel11.add(y_name);
        mainFrame.jPanel11.add(y_name_field);
        mainFrame.jPanel11.add(blank2);
        mainFrame.jPanel11.add(x_name);
        mainFrame.jPanel11.add(x_name_field);
        mainFrame.jPanel11.add(blank4);
        mainFrame.jPanel11.add(blank5);
        mainFrame.jPanel11.add(x_whattograph);
        mainFrame.jPanel11.add(x_whattograph_field);
        mainFrame.jPanel11.add(y_whattograph);
        mainFrame.jPanel11.add(y_whattograph_field);
        mainFrame.jPanel11.add(blank3);
        mainFrame.jPanel11.add(close);
        mainFrame.jPanel11.add(save);
        mainFrame.jPanel11.add(graph);

        mainFrame.jPanel11.repaint();
        mainFrame.jPanel11.revalidate();
        mainFrame.jPanel11.validate();

        mainFrame.jPanel11.add(blank2);

        save.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                mainFrame.jPanel9.setVisible(true);
                NewJFrame.jTextArea1.append("\nConfiguration saved.");
                calibrateTextArea();
            }
        });

        close.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                mainFrame.jPanel11.removeAll();
                mainFrame.jPanel11.repaint();
                mainFrame.jPanel11.revalidate();
                mainFrame.jPanel11.validate();

            }
        });

    }

    void startc(String Awhat) {
        (new Thread(new Graph(mainFrame, Awhat))).start();
    }
}