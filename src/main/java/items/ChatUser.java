package items;


public class ChatUser {
    public int Id;
    public int ChatId;
    public int UserId;

    public ChatUser(){}

    public ChatUser(int id, int chatId, int userId){
        Id = id;
        ChatId = chatId;
        UserId = userId;
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public int getChatId() {
        return ChatId;
    }
    public void setChatId(int chatId) {
        ChatId = chatId;
    }
    public int getUserId() {
        return UserId;
    }
    public void setUserId(int userId) {
        UserId = userId;
    }

    @Override
    public boolean equals(Object obj) {
            return (Id == ((ChatUser)obj).Id && ChatId == ((ChatUser)obj).ChatId && UserId == ((ChatUser)obj).UserId);
    }
}
