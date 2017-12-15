package main.java.items;

public class User {
    public int Id;
    public String FirstName;
    public String LastName;

    public User(int id, String firstName, String lastName){
        Id = id;
        FirstName = firstName;
        LastName = lastName;
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getLastdName() {
        return LastName;
    }
    public void setLastdName(String lastdName) {
        LastName = lastdName;
    }

    @Override
    public boolean equals(Object obj) {
            return (Id == ((User)obj).Id && FirstName.equals(((User)obj).FirstName) && LastName.equals (((User)obj).LastName));
    }
}
