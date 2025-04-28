public  class User {
    protected String name;
    protected String password;
    protected String username;
    protected String role;
    public User(){

    }
    public User(String username,String password){
        this.username = username;
        this.password = password;
    }

    public User(String username, String password,String role) {

        this.username = username;
        this.password = password;
        this.role = role;
    }
    public boolean Login(String InputUsername, String InputPassword){
        if (this.username.equals(InputUsername) && this.password.equals(InputPassword)){
            return true;
        }
        return false;
    }
    public String getUsername() {
        return username;
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
        return role;
    }
    public Boolean verifyPassword(String Inputpassword) {

        return this.password.equals(Inputpassword);
    }
    public void displayDashboard(){
        System.out.println("Name: " + this.name);
        System.out.println("Role: " + this.role);
    }
}
