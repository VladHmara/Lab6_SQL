package main.java.items;

public class Chat {
    public int Id;
    public String Name;

    public Chat(int id, String name){
        Id = id;
        Name= name;
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    @Override
    public boolean equals(Object obj) {
            return (Id == ((Chat)obj).Id && Name.equals(((Chat)obj).Name));
    }
}
