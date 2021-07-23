package generics;

public class ParticipantTest {
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Igor", 33);
        Schoolar schoolar2 = new Schoolar("Alina", 35);

        Student student1 = new Student("Nikolay", 20);
        Student student2 = new Student("Boris", 35);

        Employee employee1 = new Employee("Micha", 31);
        Employee employee2 = new Employee("Ivan", 33);

        Team<Schoolar> schoolarTeam = new Team("Dragons");
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);
    }


}
