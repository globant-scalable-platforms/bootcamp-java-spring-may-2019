package davidAcuna.enums;

/**
 * Enums role types
 * 
 */
public enum RolEnum {
	ADMIN("admin"),
	SALES("sales");
	
	private String rol;
	
	RolEnum(final String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public static RolEnum getValueOf(final String rol) {
        for (RolEnum re : values()) {
            if (re.getRol().equals(rol)) {
                return re;
            }
        }
        throw new IllegalArgumentException ("The role: " + rol + "does not exists");
    }
	
}
