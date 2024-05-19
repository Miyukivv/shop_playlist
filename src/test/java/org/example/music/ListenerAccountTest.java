package org.example.music;

import org.example.auth.Account;
import org.example.database.DatabaseConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.naming.AuthenticationException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListenerAccountTest {

    @BeforeAll
    static void openDatabase() throws SQLException {
//        PAMIĘTAJ O POPRAWNEJ ŚCEIŻCE, BO NIE BĘDZIE CI SIĘŁAĆZYĆ DO BAZY DANYCH!(JAKBY WSZYSTKO ZAWIODŁO,
//        TO KLIKASZ NA PLIK Z BAZĄ DANYCH PRAWYM RPZYCISKIEM "COPY PATH/REFERENCE")

        DatabaseConnection.connect("src/main/java/org/example/music/songs.db");
        ListenerAccount.Persistence.init();
    }
    @Test
    public void test_RegisterUser() throws SQLException, AuthenticationException {
        String username = "Michał";
        String password = "Ziober";

        int id = ListenerAccount.Persistence.register(username, password);
        System.out.println(id);
        assertTrue(id!=0);
    }
    @Test
    public void test_LoginUser() throws SQLException, AuthenticationException {
        String username = "Michał";
        String password = "Ziober";

        ListenerAccount.Persistence.register(username, password);
        ListenerAccount account = ListenerAccount.Persistence.authenticate(username, password);
        assertEquals(username, account.getUsername());
    }

    @AfterAll
    static void CloseDatabase(){
        DatabaseConnection.disconnect("");
    }

}