package ru.otus.data;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserDataSet extends DataSet {

    @Column(name = "name")
    private String name;

    /**
     * OneToMany unidirectional example
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private List<AddressDataSet> addresses = new ArrayList<>();


    //Important for Hibernate
    public UserDataSet() {
    }

    public UserDataSet(long id, String name, List<AddressDataSet> addresses) {
        this.setId(id);
        this.setName(name);
        if (addresses != null) {
            this.addresses.addAll(addresses);
        }
    }

    public UserDataSet(String name, List<AddressDataSet> addressess) {
        this(-1, name, addressess);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AddressDataSet> getAddresses() {
        return addresses;
    }


    @Override
    public String toString() {
        return "UserDataSet{" +
                "name='" + name + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}