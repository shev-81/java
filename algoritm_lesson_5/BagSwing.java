package algoritm_lesson_5;

/**
 * Домашнее задание по 5 лекции для сдачи преподавателю
 * п.2 Задача о Рюкзаке на SWING
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BagSwing extends JFrame {

    // создание  объекта модели данных  для двух списков для последующего заполнения
    private DefaultListModel<String> modelList = new DefaultListModel<>();
    private DefaultListModel<String> modelListBag = new DefaultListModel<>();

    BagSwing(){
        setSize(720,320);
        setTitle("Задача о рюкзаке.");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo (null);

        // Создание панели
        JPanel panel = new JPanel();
        panel.setSize(720,320);
        panel.setLayout(null);

        // Создадим список элементов которые можно забрать
        List <Element> listElements = new ListSet().getList();
        //возьмем рюкзак объемом на 10 кг и решим какие  вещи из списка туда положить
        Bag bag = new Bag(10,listElements);

/**
 * Создание первого списка со всеми элементами
 */
        // Заполнение модели списка данными из listElements
        String str;
        for(Element u:listElements){
            str = u.name.concat(" вес - ").concat(Integer.toString(u.weght)).concat(" цена - ").concat(Integer.toString(u.cost));
            modelList.add(0, str);
        }
        //создание JList 1 списка ВСЕХ ВЕЩЕЙ со строками для модели modelList
        JList<String> list1 = new JList<>(modelList);
        list1.setBounds(10,40,200,200);
/**
 *  Создание Второго списка с вещами КОТОРЫЕ В Рюкзаке
 */
        // Заполнение модели списка данными из listElements
        final String[] strBag = new String[1];
//        for(Element u:listElements){
//            strBag[0] = u.name.concat(" вес - ").concat(Integer.toString(u.weght)).concat(" цена - ").concat(Integer.toString(u.cost));
//            modelListBag.add(0, strBag[0]);
//        }
        //создание JList 2 списка с набором вещей который мы возьмем в рюкзак
        JList<String> list2 = new JList<>(modelListBag);
        list2.setBounds(500,40,200,200);
/**
 *  Создание Кнопок
 */
        // Создание кнопки
        JButton buttonAdd = new JButton("Взять самые дорогие -->");
        buttonAdd.setBounds(250,100,200,50);
        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                modelList.add(modelList.getSize(), "-- Новая запись --");
//                validate();
// Заполнение модели списка данными из listElements
                if(modelListBag.isEmpty()){
                    for(Element u: bag.getBestElements()){
                        strBag[0] = u.name.concat(" вес - ").concat(Integer.toString(u.weght)).concat(" цена - ").concat(Integer.toString(u.cost));
                        modelListBag.add(0, strBag[0]);
                    }
                }
            }
        });
/**
 *  Создание меток описания
 */
        //метка для название вещей которые МОЖНО взять
        JLabel allItemsLabl = new JLabel("Все вещи");
        allItemsLabl.setBounds(60,10,200,20);

        //метка для название вещей которые ВЗЯЛИ
        JLabel ItemsBagLabl = new JLabel("Вещи в рюкзаке");
        ItemsBagLabl.setBounds(540,10,200,20);
/**
 *  Добавление всех элементов на панель
 */
        panel.add(list1);
        panel.add(list2);
        panel.add(buttonAdd);
        panel.add(allItemsLabl);
        panel.add(ItemsBagLabl);
        add(panel);


        setVisible(true);
    }

    public static void main(String[] args) {
        new BagSwing();
    }
}
