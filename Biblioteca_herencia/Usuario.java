import java.util.ArrayList;
public class Usuario {
    private String nombre;
    private String correo;
    private String codigo;

    private static ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();
    public Usuario(String nombre, String correo, String codigo) {
        this.nombre = nombre;
        this.correo = correo;
        this.codigo = codigo;
    }
    public java.lang.String getNombre() {
        return nombre;
    }

    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

    public java.lang.String getCorreo() {
        return correo;
    }

    public void setCorreo(java.lang.String correo) {
        this.correo = correo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public void setUsuariosRegistrados(ArrayList<Usuario> usuariosRegistrados) {
        this.usuariosRegistrados = usuariosRegistrados;
    }
    public static boolean usuarioRegistro(String correo, String codigo ){
        for(Usuario usuario : usuariosRegistrados){
            if(usuario.getCorreo().equals(correo) || usuario.getCodigo().equals(codigo)){
                return true;
            }
        }
        return false;
    }
    public void validUsuario(String nombre, String correo, String codigo){
        if(usuarioRegistro(correo,codigo)){
            System.out.println("El código PUCP o correo ya se encuentran registrados owo");
        }else{
            usuariosRegistrados.add(new Usuario(nombre, correo, codigo));
            System.out.println("Usuario registrado correctamente!");
        }
    }
}
