package algoritm_lesson_6;
/**
 *  Домашняя работа Шевеленко Андрея Александровича к 6 лекции.
 *  для сдачи преподователю.
 */

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Random rand =new Random();
        int balansedTree=0;
        int nobalansedTree=0;
        int num;
        boolean znac;
        TreeImpl [] treenum = new TreeImpl[100];
        for(int i =0; i < treenum.length; i++)
        {
            treenum[i] = new TreeImpl<Integer>();
            Node<Integer> tmpRootNode = treenum[i].getRoot();            // Сохраняем узел root

            while (tmpRootNode.height(treenum[i].getRoot()) <= 3) {
                znac =rand.nextBoolean();
                num = rand.nextInt(25);
                if(!znac){
                    num = - num;
                }
                treenum[i].add(num);         // Добавляем узел
            }
            treenum[i].display();

            if(tmpRootNode.isBalanced(treenum[i].getRoot())){
                System.out.println("Сбалансированно.");
                balansedTree++;
            }else {
                System.out.println("Не сбалансированно");
                nobalansedTree++;
            }

        }
        System.out.println("Сбалансированных деревьев - "+balansedTree);
        System.out.println("Не сбалансированных деревьев - "+nobalansedTree);
}

//        Tree<Integer> tree = new TreeImpl<>();
//        for(Tree tree: treenum) {
//            Tree<Integer> tree = new TreeImpl<>();
//        }

//        tree.add(60);
//        tree.add(50);
//        tree.add(66);
//        tree.add(40);
//        tree.add(55);
//        tree.add(70);
//        tree.add(31);
//        tree.add(45);
//        tree.add(42);
//        tree.add(43);
//        tree.add(69);
//        tree.add(67);
//        tree.add(68);
//        tree.add(81);

/*        tree.display();

        tree.remove(55);

        tree.display();

        tree.remove(67);

        tree.display();

        tree.remove(40);*/

//        tree.display();

//        tree.traverse(Tree.TraversMode.IN_ORDER);
//        tree.traverse(Tree.TraversMode.PRE_ORDER);
//        tree.traverse(Tree.TraversMode.POST_ORDER);

}
