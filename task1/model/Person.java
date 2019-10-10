/*
 * 6.tasks
 * Task 1
 * Artsiom Barodka
 *
 */
package tasks.task1.model;

import tasks.task1.properties.Role;

public class Person {

    private int id;
    private String name;
    private int password;
    private String mail;
    private Role role;

    public Person() {
    }

    public Person(int id, String name, int password, String mail, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
