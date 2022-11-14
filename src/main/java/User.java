

public class User {

    private int id;
    private String name;
    private String username;
    private String email;
    private Addres addres;

    public User(String name, String username, String email, String street, String suite, String city, String zipcode, String lat, String lng) {
                this.name = name;
        this.username = username;
        this.email = email;
        this.addres = new Addres(street, suite, city, zipcode, lat, lng);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class Addres {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public Addres(String street, String suite, String city, String zipcode, String lat, String lng) {
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = new Geo(lat, lng);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}

class Geo {
    private String lat;
    private String lng;

    public Geo(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}