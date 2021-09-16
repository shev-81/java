package lesson_7;

/**
 * Класс голодных котов
 */
public class Cat {
    private String name;
    private int appetite;
/** п.2  Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
*        Если коту удалось покушать (хватило еды), сытость = true. - satiety
*        изначально каждый кот голоден
*/
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
/**     п.1 Сделать так, чтобы в тарелке с едой не могло получиться отрицательного
 *          количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
 *      п.3 Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт
 */
        if(appetite>p.getFood()) System.out.printf("Котик "+this.name+" не трогает еду в тарелке.");
            // если в тарелке еды достаточно что бы удовлетворить его апетит он ее съедает и становится сыт
        else {
            p.decreaseFood(appetite);
            satiety=true;
            System.out.printf("Котик "+this.name+" съел из тарелки "+this.appetite+" еды и стал сыт.");
        }
    }
}