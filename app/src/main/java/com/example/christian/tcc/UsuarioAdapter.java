package com.example.christian.tcc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.christian.tcc.modelo.Usuario;
import com.example.christian.tcc.modelo.UsuarioDAO;

import java.util.List;

/**
 * Created by christian on 25/03/2018.
 */

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioHolder> {

    private final List<Usuario> usuarios;


    public UsuarioAdapter(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void atualizarUsuarios(Usuario usuario){
        usuarios.set(usuarios.indexOf(usuario), usuario);
        notifyItemChanged(usuarios.indexOf(usuario));
    }

    public void adicionarUsuario(Usuario usuario){
        usuarios.add(usuario);
        notifyItemInserted(getItemCount());
    }

    public void removerUsuario(Usuario usuario){
        int position = usuarios.indexOf(usuario);
        usuarios.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public UsuarioHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UsuarioHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista, parent, false));
    }

    @Override
    public void onBindViewHolder(UsuarioHolder holder, int position) {
        holder.nomeUsuario.setText(usuarios.get(position).getIdUsuario());
        final Usuario usuario = usuarios.get(position);
        holder.btnExcluir.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View view = v;
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Confirmação")
                        .setMessage("Tem certeza que deseja excluir este cliente?")
                        .setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                UsuarioDAO dao = new UsuarioDAO(view.getContext());
                                boolean sucesso = dao.excluir(usuario.getIdUsuario());
                                if(sucesso) {
                                    removerUsuario(usuario);
                                    Snackbar.make(view, "Excluiu!", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                }else{
                                    Snackbar.make(view, "Erro ao excluir o cliente!", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                }
                            }
                        })
                        .setNegativeButton("Cancelar", null)
                        .create()
                        .show();
            }
        });

        holder.btnEditar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = getActivity(v);
                Intent intent = activity.getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("usuario", usuario);
                activity.finish();
                activity.startActivity(intent);
            }
        });
    }

    private Activity getActivity(View view) {
        Context context = view.getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity)context;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return usuarios != null ? usuarios.size() : 0;
    }

}