public interface UserInterface {
    /**
     * This method will override in Admin,BranchEmployee,Tp and customer class
     * its check if the user in system or not
     */
    void LoginSystem();
    /**
     * This method will override in Admin,BranchEmployee,Tp and customer class
     * its return user attributes for printing to the screen
     * @return String
     */
    String toString();
}
