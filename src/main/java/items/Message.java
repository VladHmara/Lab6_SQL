package main.java.items;

public class Message {
    public int Id;
    public int FromUserId;
    public int ToChatId;
    public String Content;

    public Message(int id, int fromUserId, int toChatId, String content){
        Id = id;
        FromUserId = fromUserId;
        ToChatId = toChatId;
        Content = content;
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public int getFromUserId() {
        return FromUserId;
    }
    public void setContent(String content) {
        Content = content;
    }
    public int getToChatId() {
        return ToChatId;
    }
    public void setFromUserId(int fromUserId) {
        FromUserId = fromUserId;
    }
    public String getContent() {
        return Content;
    }
    public void setToChatId(int toChatId) {
        ToChatId = toChatId;
    }

    @Override
    public boolean equals(Object obj) {
            return (Id == ((Message)obj).Id && FromUserId == ((Message)obj).FromUserId && ToChatId == ((Message)obj).ToChatId && Content.equals(((Message)obj).Content));
    }
}
