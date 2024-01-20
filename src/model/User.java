package model;

public class User {
    String name;
    String gender;
    int age;
    int[] userSource;
    int[] userDestination;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int[] getUserSource() {
        return userSource;
    }

    public void setUserSource(int[] userSource) {
        this.userSource = userSource;
    }

    public int[] getUserDestination() {
        return userDestination;
    }

    public void setUserDestination(int[] userDestination) {
        this.userDestination = userDestination;
    }

    public User(String name, String gender, int age, int[] userSource, int[] userDestination){
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.userSource = userSource;
        this.userDestination = userDestination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
