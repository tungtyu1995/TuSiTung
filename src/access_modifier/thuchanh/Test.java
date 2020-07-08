package access_modifier.thuchanh;

class	Application{
    public static void main(String[] args) {
        System.out.println(Application.language);
    }
    public	static	String	language;
    static	{
        if(System.getProperty("user.language").equals("en")){
            language	= "english";
        } else {
            language = "spanish";
        }
    }
}