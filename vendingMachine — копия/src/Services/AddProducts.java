package Services;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
// наследуем класс от родителя
public class AddProducts extends MainFrame {
    private JFrame parent;

    private Font modalFont = new Font("Segoe print", Font.BOLD, 14);
    private JTextField tfPrice, tfPlace, tfName, tfId, tfVolume, tfTemperature;
    private final String[] productType = { "Продукты", "Соки/Воды", "Горячие напитки" };
    // менеджер компановки
    private GridBagConstraints c;
// констрктор
    public AddProducts(JFrame parent,Variables vars) {
        super();
        this.parent = parent;
        this.c = new GridBagConstraints();
        variables = vars;
    }

    public void createGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog frame = new JDialog(parent, "Добавление продуктов в автомат", true);
        frame.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

        JLabel lbList = new JLabel("Тип продукта");
        lbList.setFont(modalFont);

        JList<String> tfList = new JList<String>(this.productType);
        tfList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // создаем панель для вывода
        JPanel formPanel2 = new JPanel();
        formPanel2.setLayout(new GridLayout(1, 1, 1, 1));

        // создаем список всех товаров
        JList<String> tfMenuList = new JList<String>();
        tfMenuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tfMenuList.setVisibleRowCount(10);

        // c.fill = GridBagConstraints.HORIZONTAL;
        // c.weightx = 0.7;
        // c.gridx = 2;
        // c.gridy = 0;
        // Добавляем в панель наш лист
        formPanel2.add(tfMenuList);

        // если список не пустой заполняем его
        if (this.variables.getInList().size() > 0) {
            myActions.fillInList(tfMenuList, variables);
        }

        // кнока удаления товаров
        JButton btnDelitem = new JButton("Del Item");
        btnDelitem.setFont(modalFont);
        ////////////////////////////////////////////////////////////////
        btnDelitem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // тут могла быть функция но пока тут пусто 
            }

        });

        formPanel2.add(btnDelitem);
        ///////////////////////////////////////////////////////////////

        tfMenuList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Выделенная строка
                int selected = ((JList<?>) e.getSource()).getSelectedIndex();
            }
        });
        ///////////////////////////////////////////////////////////////

        JLabel lbId = new JLabel("ID");
        lbId.setFont(modalFont);
        tfId = new JTextField();
        tfId.setFont(modalFont);

        JLabel lbName = new JLabel("Наименование");
        lbName.setFont(modalFont);
        tfName = new JTextField();
        tfName.setFont(modalFont);

        JLabel lbPrice = new JLabel("Цена(в рублях целое)");
        lbPrice.setFont(modalFont);
        tfPrice = new JTextField();
        tfPrice.setFont(modalFont);

        JLabel lbPlace = new JLabel("Позиция(номер)");
        lbPlace.setFont(modalFont);
        tfPlace = new JTextField();
        tfPlace.setFont(modalFont);

        JLabel lbVolume = new JLabel("Обьем в литрах");
        lbVolume.setFont(modalFont);
        tfVolume = new JTextField();
        tfVolume.setFont(modalFont);

        JLabel lbTemper = new JLabel("Температура в градусах");
        lbTemper.setFont(modalFont);

        tfTemperature = new JTextField();
        tfTemperature.setFont(modalFont);

        JLabel lbMessage = new JLabel();
        lbMessage.setFont(modalFont);

        JButton btnAdd = new JButton("Add");
        btnAdd.setFont(modalFont);
        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int result = myActions.validateData(variables, tfList, tfId, tfName, tfPrice, tfPlace, tfVolume,
                        tfTemperature);
                        // вызываем функцию добавления товара
                myActions.fillInList(tfMenuList, variables);
// внизу окна типа строка со статусом выполняемой задачи
                lbMessage.setText(Integer.toString(variables.getInList().size()));
            }

        });
// кнопочка закрывает окно
        JButton btnClose = new JButton("Close");
        btnClose.setFont(modalFont);
        btnClose.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                parent.revalidate();
                parent.repaint();
                parent.update(parent.getGraphics());
                frame.dispose();
            }

        });
// панелька с бесконечными элементами
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(8, 1, 1, 1));

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
        formPanel.add(btnAdd);
        formPanel.add(btnClose);

        // при выборе типа продуктов показываются или скрываются нужные поля
        tfList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Выделенная строка
                int selected = ((JList<?>) e.getSource()).getSelectedIndex();
                lbMessage.setText("Выделенная строка : " + String.valueOf(selected));
                switch (selected) {
                    case 1:
                        // продукты
                        tfVolume.setVisible(true);
                        lbVolume.setVisible(true);
                        tfVolume.setText("1.5");
                        tfTemperature.setVisible(false);
                        lbTemper.setVisible(false);
                        tfTemperature.setText("75");
                        break;
                    case 2:
                        // соки воды
                        tfVolume.setVisible(false);
                        lbVolume.setVisible(false);
                        tfVolume.setText("0");
                        tfTemperature.setVisible(true);
                        lbTemper.setVisible(true);
                        tfTemperature.setText("75");
                        break;
                    default:
                        // горячие напитки
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


        JPanel modalPanel = new JPanel();
        modalPanel.setLayout(new BorderLayout());
        modalPanel.setBackground(new Color(128, 128, 255));

        modalPanel.add(formPanel, BorderLayout.NORTH);
        modalPanel.add(formPanel2, BorderLayout.CENTER);
        modalPanel.add(lbMessage, BorderLayout.SOUTH);

        frame.getContentPane().add(modalPanel);

        frame.setPreferredSize(new Dimension(400, 700));

        frame.pack();
        frame.setVisible(true);
    }
}
