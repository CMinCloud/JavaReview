package judgeNull;

/**
 * @Author：CM
 * @Package：judgeNull
 * @Project：JavaReview
 * @name：Company
 * @Date：2023/5/7 15:54
 * @Filename：Company
 */
public class Company {

    private String companyName;

    private Address address;

    public Company(String companyName, Address address) {
        this.companyName = companyName;
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", address=" + address +
                '}';
    }
}
