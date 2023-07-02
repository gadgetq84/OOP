package Services;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

import Domen.Product;

public class MainFrame extends JFrame {

    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    private JTextField tfMoney;
    public Variables variables;
    Actions myActions;
    JLabel lbMessage;
    public JPanel formPanel;
    protected JList<String> tfProductList;
    private GridBagConstraints c;

    // конструктор
    public MainFrame() {
        this.variables = new Variables();
        this.tfProductList = new JList<String>();
        this.myActions = new Actions();
        this.c = new GridBagConstraints();
    }

    // создаем главное окно
    public void initialize() {
        // начинаем создавать элементы окна
        JLabel lbProductList = new JLabel("Продукты в автомате");
        tfProductList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // перечень продуктов в главном окне
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(tfProductList);
        tfProductList.setLayoutOrientation(JList.VERTICAL);
        tfProductList.setVisibleRowCount(12);
        // инпутбокс для внесения денег
        JLabel lbMoney = new JLabel("Монетоприемник");
        lbMoney.setFont(mainFont);

        tfMoney = new JTextField();
        tfMoney.setFont(mainFont);
        // кнопка купить
        JButton btnBy = new JButton("Купить");
        btnBy.setFont(mainFont);
        // метод обработки нажатия на кнопку.. 
        btnBy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // получаем индекс выбранного элемента 
                int selected = tfProductList.getSelectedIndex();
                if (selected != -1 && Integer.parseInt(tfMoney.getText())>0 ) {
                    

                    int userMoney = Integer.parseInt(tfMoney.getText());

                    // получаем список продуктов в чудо автомате
                    List<Product> prods = variables.venMachine.getProducts();
                    // поискали нужную позицию
                    List<Product> selProduct = prods.stream().filter(Product -> Product.getPlace() == (selected + 1))
                            .collect(Collectors.toList());
                            // если нашли наш товар
                    if (selProduct.size() == 1) {
                        for (Product prod : selProduct) {
                            // денежку добавили в автомат
                            variables.coinDesp.addCash(userMoney);
                            // метод проверяющий и удаляющий купленный товар
                            variables.venMachine.buyProduct(prod, lbMessage);
                            // обновляем список в окне
                            myActions.fillInList(tfProductList, variables);

                        }
                    }
                } else {
                    lbMessage.setText("Пустой Список");
                }

            }

        });
        JPanel byPanel = new JPanel(new BorderLayout());
        byPanel.setLayout(new GridLayout(1, 3, 5, 5));
        byPanel.setBackground(new Color(128, 128, 255));
        byPanel.add(lbMoney);
        byPanel.add(tfMoney);
        byPanel.add(btnBy);

        formPanel = new JPanel(new BorderLayout());
        formPanel.setLayout(new GridLayout(1, 1, 5, 5));
        formPanel.add(lbProductList);
        formPanel.add(scrollPane);

        lbMessage = new JLabel();
        lbMessage.setFont(mainFont);

        // при создании сразу заполняем список продуктов
        if (this.variables.getInList().size() > 0) {
            myActions.fillInList(tfProductList, variables);
        } else {
            lbMessage.setText("Пустой Список");
        }
// кнопка создающая модальное окно
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

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 1, 5, 5));
        // buttonPanel.add(btnClear);
        buttonPanel.add(addProd);
        // всратое форматирование форм
        // больные люди это придумали .. особенно BorderLayout
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 250;

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(128, 128, 255));
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 1.0f;
        mainPanel.add(formPanel, c);
        c.ipady = 40;
        mainPanel.add(byPanel, c);
        // первая ячейка по вертикали
        c.ipady = 40;

        mainPanel.add(buttonPanel, c);
        lbMessage.setText("Для покупки товара нужно 1) выбрать что-то из листбокса 2) ввести денежку 3) Нажать купить");
        c.ipady = 40;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.PAGE_END;
        mainPanel.add(lbMessage, c);

        add(mainPanel);

        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setOpaque(false);
        buttonPanel.setOpaque(false);

        setTitle("VendingMachines");
        setSize(500, 600);
        setMaximumSize(new Dimension(550, 650));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
