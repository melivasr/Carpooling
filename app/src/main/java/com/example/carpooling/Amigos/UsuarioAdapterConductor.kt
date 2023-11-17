package com.example.carpooling.Amigos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carpooling.R
class UsuarioAdapterConductor(private val usuarios: List<String>, private val listener: UsuarioItemClickListener) :
    RecyclerView.Adapter<UsuarioAdapterConductor.UsuarioViewHolder>() {

    interface UsuarioItemClickListener {
        fun onAccionButtonClick(usuario: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_anadir_amigos, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.bind(usuario, listener)
    }

    override fun getItemCount(): Int {
        return usuarios.size
    }

    class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewNombreUsuario: TextView = itemView.findViewById(R.id.textViewNombreUsuario)
        private val botonAccion: Button = itemView.findViewById(R.id.botonAccion)

        fun bind(usuario: String, listener: UsuarioItemClickListener) {
            textViewNombreUsuario.text = usuario

            botonAccion.setOnClickListener {
                listener.onAccionButtonClick(usuario)
            }
        }
    }
}