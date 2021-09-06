package lesson_5;

/**
 *  Домашняя работа Шевеленко Андрея Александровича к 5 уроку.
 *
 */
// пункт 1 ДЗ создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
class   Worker{
    private String fio;
    private String post;
    private String email;
    private String tel;
    private int wages;
    private int age;

    // Конструктор по умолчанию
    Worker() {}

// пункт 2 ДЗ  Конструктор класса должен заполнять эти поля при создании объекта.
    Worker (String fio, String post, String email, String tel, int wages,int age) {
      this.fio = fio;
      this.post = post;
      this.email = email;
      this.tel = tel;
      this.wages = wages;
      this.age = age;
    }

// пункт 3 ДЗ  Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    void workerShow(){
      System.out.println("ФИО: "+ this.fio+ " " +age+" лет.\n должность - "+this.post+"\n e-mail - "+this.email+"\n телефон - "+this.tel+"\n зарплата - "+wages+" рублей.\n");
    }
// метод геттер для возраста сотрудников
    int getAge (){
      return this.age;
    }
}


public class HomeWork {
    public static void main(String[] args){

// пункт 4 ДЗ   Создать массив из 5 сотрудников.
    Worker [] personAray = new Worker[5];
    personAray[0] = new Worker("Иванов Иван Иванович","Инженер","qwer@mail.ru","8-912-123-22-33", 100_000,35);
    personAray[1] = new Worker("Сергеев Сергей Сергеевич","Летчик","fly-man@mail.ru","8-923-655-55-32", 150_000,45);
    personAray[2] = new Worker("Петров Иван Васильевич","Повар","Cook@mail.ru","8-912-123-22-33", 30_000,25);
    personAray[3] = new Worker("Васечкин Алексей Петрович","Менеджер","manager@mail.ru","8-912-123-22-33", 80_000,56);
    personAray[4] = new Worker("Шевеленко Андрей Александрович","Програмист","shev-81@mail.ru","8-912-123-22-33", 200_000,40);

// выведем на печать всех сотрудников старше 40 лет
    for (int i=0; i<personAray.length; i++)
        if (personAray[i].getAge ()>40) personAray[i].workerShow();



    }
}
