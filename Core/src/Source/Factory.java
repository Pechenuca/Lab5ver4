package Source;

import javax.xml.bind.JAXBException;
import java.io.InputStream;
import java.util.Scanner;

public class Factory {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long annualTurnover; //Поле не может быть null, Значение поля должно быть больше 0
    private String fullName; //Поле может быть null
    private OrganizationType type; //Поле не может быть null
    private Address officialAddress; //Поле не может быть null
    private Double x;
    private long y;

    Scanner scanner = new Scanner(System.in);

    public Organization createOrganization() throws JAXBException {
        System.out.println("Вечер в хату! Если ты все же решил использовать мое недо-проект, то для начала введи данные о нужной тебе организации: ");
        System.out.println("Я тебя предупреждаю, выбери другой проект\n Введите имя организации");
        setName();
        System.out.println("Введи координаты, надеюсь, что это не те координаты, о которых я подумал :/ \nНачнем с X");
        setX();
        System.out.println("А чё по Y?");
        setY();
        System.out.println();
        setFullName();
        setAnnualTurnover();
        setOfficialAddress();
        return new Organization(id, name, x, y, coordinates, creationDate, annualTurnover, fullName, type, officialAddress);
    }

    public void setName() {
        String line = scanner.nextLine();
        try {

            if (line.length() >= 3 && line.length() <= 80)
                name = line;


        } catch (NumberFormatException e) {
            System.out.println("kek");
            setName();

        }

    }


    public void setX() {
        String line = scanner.nextLine();
        try {
            double parseDouble = Double.parseDouble(line);
            x = parseDouble;
            if (x == null) {
                System.out.println("Опа-чиньчопа, ты попал в ловушку Нулла, поле не должно быть null");
                setX();
            }
        } catch (NumberFormatException e) {
            System.out.println("Ты чет не то пишешь, подумой и напиши нормально");
            setX();
        }
    }

    public void setY() {
        String line = scanner.nextLine();
        try {
            long parseLong = Long.parseLong(line);
            y = parseLong;

        } catch (NumberFormatException e) {
            System.out.println("Чет ты совсем рукожоп, чиселки ввести нормально не можешь(");
            setY();
        }
    }

    public void setFullName() {
        System.out.println("Я не знаю зачем это надо, но введи еще полное имя:");
        String line = scanner.nextLine();
        try {
            if (line.length() >= 5 && line.length() <= 80)
                fullName = line;
            else {
                System.out.println("Я загуглил, нет имени такой длины");
                setFullName();

            }
        } catch (NumberFormatException e) {

            System.out.println("Error");

        }

    }

    public void setAnnualTurnover() {
        System.out.println("Абрам, таки самое время посчитать шекели твоей организации: ");
        String line = scanner.nextLine();
        try {
            long parseLong2 = Long.parseLong(line);
            if (line == null) {
                System.out.println("Абрам, таки не будьте гоем, не смеши мои пейсы - я знаю, что у тебя есть какой-никакой годовой оборот");
                setAnnualTurnover();
            }
            if (parseLong2 == 0) {
                System.out.println("Абрам, я начинаю злиться, ты таки уже давно не работаешь в Федеральной налоговой службе -- не надо тут с цифрами махинации проводить");
                setAnnualTurnover();
            }
            if(parseLong2 > 0)
                annualTurnover = parseLong2;
        } catch (NumberFormatException e) {
            System.out.println("Абрам, ты самый настойщий поц, выйди и зайди нормально");
            setAnnualTurnover();

        }

    }

    public void setOfficialAddress() {

        System.out.println("Введите адрес");
        String line = scanner.nextLine();
        try {
            officialAddress.setStreet(line);
        }catch (NullPointerException e) {
            officialAddress.setStreet(line);
        }


    }
    public void update(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }
}