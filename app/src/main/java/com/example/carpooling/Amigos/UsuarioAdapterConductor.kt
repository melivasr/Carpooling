package com.example.carpooling.Amigos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carpooling.R
/**
 * Adaptador para la lista de usuarios en el contexto de un conductor.
 *
 * @param usuarios Lista de nombres de usuarios a mostrar.
 * @param listener Interfaz para manejar eventos de clic en el botón de acción.
 */
class UsuarioAdapterConductor(private val usuarios: List<String>, private val listener: UsuarioAdapterConductorItemClickListener) :
    RecyclerView.Adapter<UsuarioAdapterConductor.UsuarioViewHolder>() {
    /**
     * Interfaz para manejar eventos de clic en el botón de acción.
     */
    interface UsuarioAdapterConductorItemClickListener {
        /**
         * Método llamado cuando se hace clic en el botón de acción.
         *
         * @param usuario Nombre del usuario seleccionado.
         */
        fun onAccionButtonClick(usuario: String)
    }
    /**
     * Método llamado cuando se crea un nuevo ViewHolder.
     *
     * @param parent Grupo de la vista principal.
     * @param viewType Tipo de vista del nuevo ViewHolder.
     * @return Nuevo ViewHolder que contiene la vista de un elemento de la lista.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_usuario, parent, false)
        return UsuarioViewHolder(view)
    }
    /**
     * Método llamado para mostrar datos en un ViewHolder.
     *
     * @param holder ViewHolder que debe ser actualizado.
     * @param position Posición del elemento en la lista de datos.
     */
    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.bind(usuario, listener)
    }
    /**
     * Método que devuelve la cantidad de elementos en la lista.
     *
     * @return Cantidad de elementos en la lista.
     */
    override fun getItemCount(): Int {
        return usuarios.size
    }
    /**
     * ViewHolder que representa la vista de un elemento de la lista.
     *
     * @param itemView Vista de un elemento de la lista.
     */
    class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewNombreUsuario: TextView = itemView.findViewById(R.id.textViewNombreUsuario)
        private val botonAccion: Button = itemView.findViewById(R.id.botonAccion)
        /**
         * Método para vincular datos a la vista del ViewHolder.
         *
         * @param usuario Nombre del usuario a mostrar.
         * @param listener Interfaz para manejar eventos de clic en el botón de acción.
         */
        fun bind(usuario: String, listener: UsuarioAdapterConductorItemClickListener) {
            textViewNombreUsuario.text = usuario

            botonAccion.setOnClickListener {
                listener.onAccionButtonClick(usuario)
            }
        }
    }
}

