public abstract class User {
    protected String name;
    protected String password;
    protected String username;

    public User( String username, String password) {

        this.username = username;
        this.password = password;
    }
    public boolean Login(String InputUsername, String InputPassword){
        if (this.username.equals(InputUsername) && this.password.equals(InputPassword)){
            return true;
        }
        return false;
    }
    public String getName() {
        return name;
    }
    public void Logout(){
        this.username = null;
        this.password = null;
        System.out.println("You are logged out");
    }
    public String getRole(){
        return "user";
    }
    public abstract void displayDashboard();
}
