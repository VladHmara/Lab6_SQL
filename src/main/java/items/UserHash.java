package items;


public class UserHash {
    public String Hash;
    public int UserId;

    public UserHash(){}

    public UserHash(String hash, int userId){
        Hash = hash;
        UserId = userId;
    }

    public int getUserId() {
        return UserId;
    }
    public void setUserId(int userId) {
        UserId = userId;
    }
    public String getHash() {
        return Hash;
    }
    public void setHash(String hash) {
        Hash = hash;
    }

    @Override
    public boolean equals(Object obj) {
        return (Hash.equals(((UserHash)obj).Hash)&& UserId == ((UserHash)obj).UserId);
    }
}
