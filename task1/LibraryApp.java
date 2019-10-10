/*
 * 6.tasks
 * Task 1
 * Artsiom Barodka
 *
 */
package tasks.task1;

import tasks.task1.controller.MainMenu;
import tasks.task1.controller.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LibraryApp {

    public void play(){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            Menu menu = new MainMenu(reader);
            menu.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
