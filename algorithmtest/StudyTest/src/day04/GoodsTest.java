package day04;

/**
 * @author hongtao
 * @create 2022-04-13-13:29
 */

public class GoodsTest implements Comparable {
    private String name ;
    private int price;

    public GoodsTest() {
        super();
    }

    public GoodsTest(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GoodsTest{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明商品比较大小方法 按照价格从低到高  如果价格一样，比较价格名称
    @Override
    public int compareTo(Object o) {
        if (o instanceof GoodsTest){
            GoodsTest goods = (GoodsTest) o;
            if (this.price>goods.price){
                return 1;
            }else if (this.price < goods.price){
                return -1;
            }else {
                return this.name.compareTo(goods.name);
            }
        }
        throw new RuntimeException("传入的数据类型不一致");
    }
}
