package lesson_5;

/**
 *  Домашняя работа Шевеленко Андрея Александровича к 5 уроку.
 *
 */
// пункт 1 ДЗ создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
class   Worker{

    String Fio, Post, Email, Tel;
    int Wages, Age;

    // Конструктор по умолчанию
    Worker() {}

// пункт 2 ДЗ  Конструктор класса должен заполнять эти поля при создании объекта.
    Worker (String Fio, String Post, String Email, String Tel, int Wages,int Age) {
        this.Fio = Fio;
        this.Post = Post;
        this.Email = Email;
        this.Tel = Tel;
        this.Wages = Wages;
        this.Age = Age;
    }

// пункт 3 ДЗ  Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    void workerShow(){
        System.out.println("ФИО: "+ this.Fio+ " " +Age+" лет.\n должность - "+this.Post+"\n e-mail - "+this.Email+"\n телефон - "+this.Tel+"\n зарплата - "+Wages+" рублей.\n");
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
        if (personAray[i].Age>40) personAray[i].workerShow();



    }
}
