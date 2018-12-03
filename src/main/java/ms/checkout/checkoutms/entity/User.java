package ms.checkout.checkoutms.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")

public class User {
    String _id;
    String usid;
    int balance;

    public User (String _id, String usid, int balance) {
        this._id = _id;
        this.usid = usid;
        this.balance = balance;
    }

    public String getId() {
        return this._id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getUsid() {
        return this.usid;
    }

    public void setUsid(String usid) {
        this.usid = usid;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}