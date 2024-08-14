package model;

public class ShoppingCart {
    private String idItem;
    private int amountItem;

    public ShoppingCart() {
    }

    public ShoppingCart(String idItem, int amountItem) {
        this.idItem = idItem;
        this.amountItem = amountItem;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public int getAmountItem() {
        return amountItem;
    }

    public void setAmountItem(int amountItem) {
        this.amountItem = amountItem;
    }

    @Override
    public String toString() {
        return "Giỏ hàng bao gồm: " +
                "id vật phẩm= " + idItem  +
                ",số lượng sản phẩm=" + amountItem ;
    }
}
