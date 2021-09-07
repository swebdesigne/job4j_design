package job4j.generics;

public class Role extends Base {
    private String role;
    private int access;

    public Role(String id, String role, int access) {
        super(id);
        this.role = role;
        this.access = access;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return "Role{"
                + "role='" + role + '\''
                + ", access=" + access
                + '}';
    }
}
