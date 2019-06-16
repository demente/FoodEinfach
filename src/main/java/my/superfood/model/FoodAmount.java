package my.superfood.model;

public class FoodAmount {

    private Food food;
    private Long amount; //as always, in micorgrams

    public FoodAmount(Food food, Long amount) {
        this.food = food;
        this.amount = amount;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
