public class PasswordEntry {
    private String servicio;
    private String contrasennaEncriptada;
    // Constructor
    public PasswordEntry(String servicio, String contrasennaEncriptada) {
        this.servicio = servicio;
        this.contrasennaEncriptada = contrasennaEncriptada;
    }
    // Getters
    public String getServicio() {
        return servicio;
    }
    public String getContrasennaEncriptada() {
        return contrasennaEncriptada;
    }
    // Setters (por si quieres modificar después)
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    public void setContrasennaEncriptada(String contrasennaEncriptada) {
        this.contrasennaEncriptada = contrasennaEncriptada;
    }
}
