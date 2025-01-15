package Model;

public class Medicament {
    private int id;
    private String name;
    private double price;
    private String disease;


    public Medicament(int id,String name,double price,String disease){
        this.id=id;
        this.name=name;
        this.price=price;
        this.disease=disease;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", disease='" + disease + '\'' +
                '}';
    }
}
