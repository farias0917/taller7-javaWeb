package co.edu.sena.project2687365.model.repository;

import co.edu.sena.project2687365.model.User;

import java.sql.SQLException;

public class TestUserRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        Repository<User> repository = new UserRepositoryImpl();

        System.out.println("//----- saveObj Insert -----//");
        User userInsert = new User();
        userInsert.setUser_firstname("Axel");
        userInsert.setUser_lastname("Rose");
        userInsert.setUser_email("gunsyRoses@mail.com");
        userInsert.setUser_password("armasyrosas123");
        repository.saveObj(userInsert);
        userInsert.setUser_firstname("PEpa");
        userInsert.setUser_lastname("pIg");
        userInsert.setUser_email("PEPAoiGoIg@mail.com");
        userInsert.setUser_password("pepig0546");
        repository.saveObj(userInsert);

        System.out.println("//----- listAllObj  -----//");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("//----- byIdObj -----//");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("//----- saveObj-----//");
        User userUpdate = new User();
        userUpdate.setUser_id(4);
        userUpdate.setUser_firstname("Joselito");
        userUpdate.setUser_lastname("melo");
        userUpdate.setUser_email("Joselitom@gmail.com");
        userUpdate.setUser_password("mloj2354");
        repository.saveObj(userUpdate);
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("//----- deleteObj -----//");
        repository.deleteObj(2);
        repository.listAllObj().forEach(System.out::println);
    }
}
