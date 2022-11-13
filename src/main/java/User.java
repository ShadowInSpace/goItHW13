

public class User {
    public static String userData(){
        return "  {\n" +
                "    \"name\": \"Ivan Yatskovets\",\n" +
                "    \"username\": \"ShadowSpace\",\n" +
                "    \"email\": \"ivan.yackovec@gmail.com\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"shyroka\",\n" +
                "      \"suite\": \"Suite 41\",\n" +
                "      \"city\": \"Lviv\",\n" +
                "      \"zipcode\": \"79050\",\n" +
                "      \"geo\": {\n" +
                "        \"lat\": \"24.8918\",\n" +
                "        \"lng\": \"21.8984\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"phone\": \"+380938246823\",\n" +
                "    \"website\": \"silverwds.com\",\n" +
                "    \"company\": {\n" +
                "      \"name\": \"Silver woods\",\n" +
                "      \"catchPhrase\": \"We thinking about you\",\n" +
                "      \"bs\": \"web studio\"\n" +
                "    }\n" +
                "  }";
    }
    private int id;
    private String name;
    private String username;
    private String email;
    private String address;


}
