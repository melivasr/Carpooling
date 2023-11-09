/**
 * Esta clase representa un objeto Usuario que puede ser utilizado para el registro de usuarios.
 * Cada usuario tiene un identificador único, un nombre de usuario, apellidos, correo electrónico y contraseña.
 */
class Usuario {
    var id: Int = 0
    var usuario: String = ""  // Nombre de usuario
    var apellidos: String = ""  // Apellidos del usuario
    var correoElectronico: String = ""  // Correo electrónico del usuario
    var password: String = ""  // Contraseña del usuario

    /**
     * Constructor por defecto de Usuario.
     */
    constructor() {}

    /**
     * Constructor que permite establecer todas las propiedades de Usuario.
     *
     * @param usuario Nombre de usuario del usuario.
     * @param apellidos Apellidos del usuario.
     * @param correoElectronico Correo electrónico del usuario.
     * @param password Contraseña del usuario.
     */
    constructor(usuario: String, apellidos: String, correoElectronico: String, password: String) {
        this.usuario = usuario
        this.apellidos = apellidos
        this.correoElectronico = correoElectronico
        this.password = password
    }

    /**
     * Comprueba si el objeto Usuario tiene todas sus propiedades establecidas.
     *
     * @return `true` si todas las propiedades están establecidas, `false` si alguna propiedad está vacía.
     */
    fun isNull(): Boolean {
        return !(usuario.isNotEmpty() || apellidos.isNotEmpty() || correoElectronico.isNotEmpty() || password.isNotEmpty())
    }

    /**
     * Convierte el objeto Usuario a una representación de cadena de texto.
     *
     * @return Una cadena que representa el objeto Usuario.
     */
    override fun toString(): String {
        return "Usuario{" +
                "id=" + id +
                ", usuario='$usuario'" +
                ", apellidos='$apellidos'" +
                ", correoElectronico='$correoElectronico'" +
                ", password='$password'" +
                '}'
    }
}
