import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private Integer proCode;
    private String proName;
    private Integer qty;
    private Double price;
    private LocalDate importDate;

    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }

    public Product(Integer productCode, String productName, Integer qty, Double price, LocalDate importDate) {
        this.proCode = productCode;
        this.proName = productName;
        this.qty = qty;
        this.price = price;
        this.importDate = importDate;
    }

    public Integer getProCode() {
        return proCode;
    }

    public void setProCode(Integer proCode) {
        this.proCode = proCode;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode=" + proCode +
                ", productName='" + proName + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", importDate=" + importDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(proCode, product.proCode) && Objects.equals(proName, product.proName) && Objects.equals(qty, product.qty) && Objects.equals(price, product.price) && Objects.equals(importDate, product.importDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proCode, proName, qty, price, importDate);
    }
}
