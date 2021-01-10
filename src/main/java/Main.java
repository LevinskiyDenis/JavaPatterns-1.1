public class Main {

    public static void main(String[] args) {

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setCity("Сидней")
                .build();

        mom.happyBirthday();
        mom.setCity("Москва");

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        System.out.println("У " + mom + " есть сын, " + son);

        try {
            // Имя не на русском
            Person person = new PersonBuilder().setName("Denis")
                    .setSurname("Левинский")
                    .setAge(30)
                    .build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setName("Коля").setSurname("Петров").setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }
}
