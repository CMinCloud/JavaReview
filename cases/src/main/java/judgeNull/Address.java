package judgeNull;

/**
 * @Author：CM
 * @Package：judgeNull
 * @Project：JavaReview
 * @name：Adress
 * @Date：2023/5/7 15:54
 * @Filename：Adress
 */
public class Address {

    private String Country;

    private String province;

    public Address(String country, String province) {
        Country = country;
        this.province = province;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Country='" + Country + '\'' +
                ", province='" + province + '\'' +
                '}';
    }


}
