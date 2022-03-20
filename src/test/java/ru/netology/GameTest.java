package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();
    private Player player1 = new Player(1, "Vladimir", 6);
    private Player player2 = new Player(2, "Anton", 7);
    private Player player3 = new Player(3, "Alexandr", 10);
    private Player player4 = new Player(4, "Evgeny", 4);
    private Player player5 = new Player(5, "Artem", 2);
    private Player player6 = new Player(6, "Artur", 15);
    private Player player7 = new Player(7, "Maxim", 13);
    private Player player8 = new Player(8, "Denis", 6);
    private Player player9 = new Player(9, "Daniil", 9);
    private Player player10 = new Player(10, "Alexey", 5);


    @Test
    void roundWhenFirstPlayerWin() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        game.register(player8);
        game.register(player9);
        game.register(player10);

        int actual = game.round("Alexandr", "Artem");

        assertEquals(1, actual);

    }

    @Test
    void roundWhenSecondPlayerWin() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        game.register(player8);
        game.register(player9);
        game.register(player10);

        int actual = game.round("Alexey", "Artur");

        assertEquals(2, actual);

    }

    @Test
    void roundWhenDraw() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        game.register(player8);
        game.register(player9);
        game.register(player10);

        int actual = game.round("Vladimir", "Denis");

        assertEquals(0, actual);

    }

    @Test
    void shouldExcWhenTwoPlayersUnreg() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        game.register(player8);
        game.register(player9);
        game.register(player10);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Oleg", "Vladislav"));

    }

    @Test
    void shouldExcWhenFirstPlayerUnreg() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        game.register(player8);
        game.register(player9);
        game.register(player10);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Oleg", "Daniil"));

    }

    @Test
    void shouldExcWhenSecondPlayerUnreg() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        game.register(player8);
        game.register(player9);
        game.register(player10);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Vladimir", "Ivan"));

    }

    @Test
    void shouldWhenNotRegPlayers() {

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Oleg", "Vladislav"));
    }

    @Test
    void shouldWhenOneRegPlayer() {
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Oleg", "Vladislav"));

    }

}