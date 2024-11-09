package com.lya.whatsapplist.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lya.whatsapplist.Model.Usuario;
import com.lya.whatsapplist.R;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

public class AdapterUsuario extends RecyclerView.Adapter<AdapterUsuario.UsuarioViewHolder> { //primeiro ela precisa herdar as caracteristica do recyclerview,  digiando extends RecyclerView, nisoso importa o pacote automatico..
    //viewholder acima é responsavel por criar visualizao na tela


    private List<Usuario> usuarioList = new ArrayList<>();// é uma lista que nao sabemos o tamanho total da lista, feito isso vamos voltar la para OnBindViewHolder

    public AdapterUsuario(List<Usuario> usuarioList) {     ///aqui criamos nosso construtor , como disse la no comentario final de baixo, seria o retoque esse
        this.usuarioList = usuarioList;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {  //O metodo onCreateViewHolder é responsavel por criar as nossas visualizações,

        //primeiro vamos comecar aqui , dentro desse metodo

        View itemLista;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());  // context é contexto atual, nisso vamos poder recuperar o contexto get,
        itemLista = layoutInflater.inflate(R.layout.usuario_item, parent, false); //itemLista é uma view, ele vai receber meu layoutinflater, que ja tem o contexto do adapter, dai damos o pontos e vamos utilizar o metodo inflate(). Esse metodo de inflate
        //é reponsável por inflar o layout, entao vamos inflar o layout que criamos la. Entao, vamos passar o R.layout. e aqui vamos recuperar aquele layout que criou: usuario_item, dai precisa passar mais um parametro que é nosso View Grupe, nisso passamos como .parent, dai tambem precisamos passar um false, porque nao vamos utilizar esse, ToRoot
      //  return null; // aqui vamos retornar o ViewHolder, ou seja o que criamos, nesse caso o UsuarioViewHolder(). nisso vai retornar um novo ViewHolder, passando minha variavel, que nesse caso é uma view : (itemLista)
        //fazendo tudo isso, ele vai criar as visualizações todas as vezes que um objeto for adicionado em nossa lista
        return new UsuarioViewHolder(itemLista);

    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {   //onBindaViewHolder é o contrario, ele vai ser o metodo que vai ser responsavel por exibir as nossas visualizações criadas.Entao, vai exibir os itens da nossa lista

        //onBindViewHolder, responsavel por exibir esses itens de lista
        holder.foto.setImageResource(usuarioList.get(position).getFoto()); // setimageresource, sign que vou carregar essa foto, vou rederinzar a imagem la do meu componente fotoUsuario. Dai temos que criar uma lista., array de objetos, ir la no inicio:  private List<Usuario> usuarioList = new ArrayList...
        //no metodo get vou passar a posição do meu itemLista, que pode esta na posicao zero, um..nesse caso, nao vamos passar a posição manualmente, zero,um, e sim pegar a position que tem no onBindViewHoler ; int position, la em cima. E utilizando o position, vamos obter a posiçaõ de cada itemList. Esse getfoto, vem la dos get e set, entao recuperamos
        holder.nome.setText(usuarioList.get(position).getNome());
        holder.mensagem.setText(usuarioList.get(position).getMensagem());
    }

    @Override
    public int getItemCount() {  //o  getItemCount vai retornar o tamanho total da minha lista, se minha lista tiver 50 itens, ele vai saber quantas lista deve retornar, entao ele vai retornar a quantidade de itens da nossa lista, utilizando esse metodo getItemCout
      //aqui no getItemCount, é o tamanho total da minha lista,

       //para a gente definir esse tamanho total que ele vai passar, é so definir:

        return usuarioList.size();  //passando isso , ele vai saber o total da minha lista, se minha lista crescer , ele ja vai saber o tamanho total.
    }


// aqui vamos criar um objeto que vai recuperar o id, de cada componente la do nosso UsuarioItem

    public class UsuarioViewHolder extends RecyclerView.ViewHolder {

        private ImageView foto;
        private TextView nome;
        private TextView mensagem;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);  // e aqui vamos fazer a recuperação
            //primeiro vamos recuperar da foto que vai receber minha propriedade itemView, dando ponto, consigo usaro findViewById, dai recuperamos com R.id.fotoUsuario, que ta la no xml, usuariio_item.xml,
            foto = itemView.findViewById(R.id.fotoUsuario);

            //Tambem vou recuperar nome que recebe um itemView ponto, findViewById().....etc

            nome = itemView.findViewById(R.id.nomeUsuario);
            mensagem = itemView.findViewById(R.id.mensagemUsuario);


            //okay, apos acabar de escrever o mensagem = itemview etc... vamos la pra cima para configurar o onBindViewHolder

            //FEITO ISSO, ULTIMO CODIGO FOI O COMENTARIO ACIMA OKAY...., Ja configuramos nosso adapter, ja esta tudo certo. SO precisamos criar um construtor la em cima, para nosso usuarioList
        }
    }



}
