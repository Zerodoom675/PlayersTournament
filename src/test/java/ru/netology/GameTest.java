package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void testRoundPlayer1Wins() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 100);
        Player player2 = new Player(2, "Player2", 50);
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Player1", "Player2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundPlayer2Wins() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 50);
        Player player2 = new Player(2, "Player2", 100);
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Player1", "Player2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundDraw() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 100);
        Player player2 = new Player(2, "Player2", 100);
        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Player1", "Player2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerGetId() {
        Player player = new Player(1, "Player1", 100);

        int expected = 1;
        int actual = player.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundPlayer2NotRegisteredException() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 100);
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player1", "Player2");
        });
    }

    @Test
    public void testRoundPlayer1NotRegisteredException() {
        Game game = new Game();
        Player player2 = new Player(1, "Player1", 100);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player1", "Player2");
        });
    }

    @Test
    public void testRoundPlayersNotRegisteredException() {
        Game game = new Game();

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player1", "Player2");
        });
    }
}
