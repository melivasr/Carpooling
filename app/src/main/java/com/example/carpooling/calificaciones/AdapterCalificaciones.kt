package com.example.carpooling.calificaciones

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carpooling.R
/**
 * Adaptador personalizado para la lista de calificaciones de usuarios.
 *
 * @property usuarios Lista de nombres de usuarios.
 * @property listener Interfaz para manejar eventos de clic en el botón de acción.
 */
class AdapterCalificaciones(private val usuarios: List<String>, private val listener: CalificacionesItemClickListener) :
    RecyclerView.Adapter<AdapterCalificaciones.UsuarioViewHolder>() {
    /**
     * Interfaz para manejar eventos de clic en el botón de acción.
     */
    interface CalificacionesItemClickListener {
        /**
         * Método llamado cuando se hace clic en el botón de acción.
         *
         * @param usuario Nombre del usuario seleccionado.
         * @param context Contexto de la aplicación.
         */
        fun onAccionButtonClick(usuario: String, context: Context)
    }
    /**
     * Crea y devuelve una nueva instancia de [UsuarioViewHolder].
     *
     * @param parent El grupo al que se va a añadir la nueva vista.
     * @param viewType El tipo de vista de la nueva vista.
     * @return Nuevo [UsuarioViewHolder].
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_calificaciones_usuario, parent, false)
        return UsuarioViewHolder(view)
    }
    /**
     * Actualiza el contenido de la vista en la posición dada.
     *
     * @param holder El [UsuarioViewHolder] que debe ser actualizado.
     * @param position La posición del elemento dentro de la lista de datos.
     */

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.bind(usuario, listener)
    }
    /**
     * Obtiene el número total de elementos en el conjunto de datos.
     *
     * @return El número total de elementos.
     */

    override fun getItemCount(): Int {
        return usuarios.size
    }
    /**
     * ViewHolder que representa cada elemento en la lista.
     *
     * @property itemView La vista que representa el elemento en la lista.
     */
    class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewNombreUsuario: TextView = itemView.findViewById(R.id.textViewNombreUsuario)
        private val botonAccion: Button = itemView.findViewById(R.id.botonAccion)

        fun bind(usuario: String, listener: CalificacionesItemClickListener) {
            textViewNombreUsuario.text = usuario

            botonAccion.setOnClickListener {
                listener.onAccionButtonClick(usuario, itemView.context)
            }
        }
    }
}
