package ms.checkout.checkoutms.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "robots")

public class Robot {
    String _id;
    String name;
    String photo;
    int height;
    int price;
    int stock;
    List<String> powers;

    public Robot(String _id, String name, String photo, int height, int price, List<String> powers, int stock) {
        this._id = _id;
        this.name = name;
        this.height = height;
        this.photo = photo;
        this.price = price;
        this.powers = powers;
        this.stock = stock;
    }

    public String getId() {
        return this._id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getPowers() {
        return this.powers;
    }

    public void setPowers(List<String> powers) {
        this.powers = powers;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }
}