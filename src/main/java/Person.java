public class Person {

    protected final String name;
    protected final String surname;
    protected int age;
    protected String city;

    public Person (PersonBuilder personBuilder) {
        this.name = personBuilder.getName();
        this.surname = personBuilder.getSurname();
        this.age = personBuilder.getAge();
        this.city = personBuilder.getCity();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public boolean hasAge() {
        return this.age != 0;
    }

    public boolean hasCity() {
        return this.city != null;
    }

    public void setCity(String city) {
        if (!this.hasCity()) {
            this.city = city;
            System.out.printf("Место проживания %s установлено\n", city);
        } else {
            this.city = city;
            System.out.printf("Место проживания изменено на %s\n", city);
        }
    }

    public void happyBirthday() {
        if (!this.hasAge()) {
            System.out.println("Установите возраст человека, чтобы получить возможность изменять его на день рождения");
        } else {
            this.age += 1;
            System.out.println(this.name + " стал старше на 1 год");
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setCity(this.city);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
