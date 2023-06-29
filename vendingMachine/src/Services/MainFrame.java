package Services;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
// import javax.swing.event.ListSelectionEvent;
// import javax.swing.event.ListSelectionListener;

public class MainFrame extends JFrame {

    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    private JTextField tfFirstName, tfLastName;
    public Variables variables;
    Actions myActions;
    JLabel lbMessage;
    public JPanel formPanel;
    protected JList<String> tfProductList;

    public MainFrame() {
        this.variables = new Variables();
        this.tfProductList = new JList<String>();
        this.myActions = new Actions();
    }

    public void initialize() {
        JLabel lbProductList = new JLabel("Продукты в автомате");
        tfProductList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tfProductList.setVisibleRowCount(12);
        // tfProductList.setFont(mainFont);

        JLabel lbFirstName = new JLabel("Монето");
        lbFirstName.setFont(mainFont);

        tfFirstName = new JTextField();
        tfFirstName.setFont(mainFont);

        JLabel lbLastName = new JLabel("First Name");
        lbLastName.setFont(mainFont);

        tfLastName = new JTextField();
        tfLastName.setFont(mainFont);

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 1, 5, 5));
         formPanel.add(lbProductList);
        formPanel.add(tfProductList);
        formPanel.add(lbFirstName);
        formPanel.add(tfFirstName);
        formPanel.add(lbLastName);
        formPanel.add(tfLastName);

        lbMessage = new JLabel();
        lbMessage.setFont(mainFont);

        // tfProductList.addListSelectionListener(new ListSelectionListener() {
        //     @Override
        //     public void valueChanged(ListSelectionEvent e) {
        //         // Выделенная строка
        //         Actions.fillInList(tfProductList, variables);
        //     }
        // });

        if (this.variables.getInList().size() > 0) {
            myActions.fillInList(tfProductList, variables);
        } else {
            lbMessage.setText("Пустой Список");
        }

        JButton btnOk = new JButton("Update list");
        btnOk.setFont(mainFont);
        btnOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
            }

        });

        JButton addProd = new JButton("Add product");
        addProd.setFont(mainFont);
        addProd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                AddProducts prod = new AddProducts(MainFrame.this, variables);
                prod.createGUI();
                myActions.fillInList(tfProductList, variables);

            }

        });

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                tfFirstName.setText("");
                tfFirstName.setText("");
                lbMessage.setText("");

            }

        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 1, 5, 5));
        buttonPanel.add(btnOk);
        buttonPanel.add(btnClear);
        buttonPanel.add(addProd);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));

        mainPanel.add(formPanel, BorderLayout.NORTH);

        mainPanel.add(lbMessage, BorderLayout.CENTER);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setOpaque(false);
        buttonPanel.setOpaque(false);

        setTitle("VendingMachines");
        setSize(500, 600);
        setMaximumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
