package base_de_datos

import Usuario

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
/**
 * Esta clase gestiona las operaciones relacionadas con la base de datos de usuarios.
 */
class daoUsuario(context: Context) {
    private val c: Context = context
    private val lista: ArrayList<Usuario> = ArrayList()
    private val bd = "BDusuarios"
    private val tabla = "CREATE TABLE IF NOT EXISTS usuario(id INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT, correoElectronico TEXT, apellidos TEXT, password TEXT)"

    private val sql: SQLiteDatabase = c.openOrCreateDatabase(bd, Context.MODE_PRIVATE, null)

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param u El objeto Usuario que se va a insertar.
     * @return `true` si la inserción fue exitosa, `false` en caso contrario.
     */
    fun insertUsuario(u: Usuario): Boolean {
        if (buscar(u.correoElectronico) == 0) {
            val cv = ContentValues()
            cv.put("usuario", u.usuario)
            cv.put("correoElectronico", u.correoElectronico)
            cv.put("apellidos", u.apellidos)
            cv.put("password", u.password)
            return sql.insert("usuario", null, cv) > 0
        } else {
            return false
        }
    }

    /**
     * Busca un usuario por su correo electrónico en la base de datos.
     *
     * @param u El correo electrónico del usuario que se busca.
     * @return El número de coincidencias encontradas en la base de datos.
     */
    fun buscar(u: String): Int {
        var x = 0
        lista.clear()
        lista.addAll(selectUsuario())
        for (us in lista) {
            if (us.correoElectronico == u) {
                x++
            }
        }
        return x
    }

    /**
     * Selecciona todos los usuarios almacenados en la base de datos.
     *
     * @return Una lista de objetos Usuario con todos los usuarios almacenados.
     */
    fun selectUsuario(): ArrayList<Usuario> {
        val lista: ArrayList<Usuario> = ArrayList()
        val cr: Cursor = sql.rawQuery("SELECT * FROM usuario", null)
        if (cr != null && cr.moveToFirst()) {
            do {
                val u: Usuario = Usuario()
                u.id = cr.getInt(0)
                u.usuario = cr.getString(1)
                u.correoElectronico = cr.getString(2)
                u.apellidos = cr.getString(3)
                u.password = cr.getString(4)
                lista.add(u)
            } while (cr.moveToNext())
        }
        return lista
    }
}
