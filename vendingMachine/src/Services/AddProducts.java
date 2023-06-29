package Services;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AddProducts extends MainFrame {
    private JFrame parent;
    private Variables vars;

    // final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    private JTextField tfPrice, tfPlace, tfName, tfId, tfVolume, tfTemperature;
    private final String[] productType = { "Продукты", "Соки/Воды", "Горячие напитки" };

    public AddProducts(JFrame parent, Variables vars) {
        super();
        this.parent = parent;
        this.vars = vars;
    }

    public void createGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog frame = new JDialog(parent, "Добавление продуктов в автомат", true);
        frame.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        // JLabel label = new JLabel("Добавление продуктов в автомат");
        JLabel lbList = new JLabel("Тип продукта");
        JList<String> tfList = new JList<String>(this.productType);
        tfList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JLabel lbId = new JLabel("ID");
        lbId.setFont(super.getFont());
        tfId = new JTextField();
        tfId.setFont(super.getFont());

        JLabel lbName = new JLabel("Наименование");
        lbName.setFont(super.getFont());
        tfName = new JTextField();
        tfName.setFont(super.getFont());

        JLabel lbPrice = new JLabel("Цена(в рублях целое)");
        lbPrice.setFont(super.getFont());
        tfPrice = new JTextField();
        tfPrice.setFont(super.getFont());

        JLabel lbPlace = new JLabel("Позиция(номер)");
        lbName.setFont(super.getFont());
        tfPlace = new JTextField();
        tfPlace.setFont(super.getFont());

        JLabel lbVolume = new JLabel("Обьем в литрах");
        lbVolume.setFont(super.getFont());
        tfVolume = new JTextField();
        tfVolume.setFont(super.getFont());

        JLabel lbTemper = new JLabel("Температура в градусах");
        lbTemper.setFont(super.getFont());
        tfTemperature = new JTextField();
        tfTemperature.setFont(super.getFont());

        JLabel lbMessage = new JLabel();
        lbMessage.setFont(super.getFont());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(8, 1, 5, 5));
        formPanel.add(lbList);
        formPanel.add(tfList);
        formPanel.add(lbId);
        formPanel.add(tfId);
        formPanel.add(lbName);
        formPanel.add(tfName);
        formPanel.add(lbPrice);
        formPanel.add(tfPrice);
        formPanel.add(lbPlace);
        formPanel.add(tfPlace);
        formPanel.add(lbVolume);
        formPanel.add(tfVolume);
        formPanel.add(lbTemper);
        formPanel.add(tfTemperature);
        tfList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Выделенная строка
                int selected = ((JList<?>) e.getSource()).getSelectedIndex();
                lbMessage.setText("Выделенная строка : " + String.valueOf(selected));
                switch (selected) {
                    case 1:
                        tfVolume.setVisible(true);
                        lbVolume.setVisible(true);
                        tfVolume.setText("1.5");
                        tfTemperature.setVisible(false);
                        lbTemper.setVisible(false);
                        tfTemperature.setText("75");
                        break;
                    case 2:
                        tfVolume.setVisible(false);
                        lbVolume.setVisible(false);
                        tfVolume.setText("0");
                        tfTemperature.setVisible(true);
                        lbTemper.setVisible(true);
                        tfTemperature.setText("75");
                        break;
                    default:
                        tfVolume.setVisible(false);
                        lbVolume.setVisible(false);
                        tfVolume.setText("0");
                        tfTemperature.setVisible(false);
                        lbTemper.setVisible(false);
                        tfTemperature.setText("0");
                        break;
                }

            }
        });

        JButton btnAdd = new JButton("Add");
        btnAdd.setFont(super.getFont());
        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int result = myActions.validateData(vars, tfList, tfId, tfName, tfPrice, tfPlace, tfVolume,
                        tfTemperature);
                lbMessage.setText(Integer.toString(result));
                //lbMessage.setText(Integer.toString(vars.getInList().size()));
            }

        });

        JButton btnClose = new JButton("Close");
        btnClose.setFont(super.getFont());
        btnClose.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                parent.revalidate();
                parent.repaint();
                parent.update(parent.getGraphics());
                frame.dispose();
            }

        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 1, 5, 5));
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnClose);

        JPanel modalPanel = new JPanel();
        modalPanel.setLayout(new BorderLayout());
        modalPanel.setBackground(new Color(128, 128, 255));

        modalPanel.add(formPanel, BorderLayout.NORTH);

        modalPanel.add(lbMessage, BorderLayout.CENTER);

        modalPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(modalPanel);

        // frame.getContentPane().add(label);

        frame.setPreferredSize(new Dimension(400, 600));

        frame.pack();
        frame.setVisible(true);
    }
}
