package com.lya.whatsapplist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lya.whatsapplist.Adapter.AdapterUsuario;
import com.lya.whatsapplist.Model.Usuario;
import com.lya.whatsapplist.RecyclerItemClickListener.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_usuario;  //1)

    //Chegamos, depois de sair de configurar o Adapter. O último code foi um construtor para meu usuarioLista, dai viemos para cá
    // entao, agora o que vamos fazer, é passar o ADAPTER. Primeiro criamos uma List<Usuario >....

    private List<Usuario> usuarioList = new ArrayList<>();  //depois daqui, vamos abaixo pssar o adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recycler_usuario = findViewById(R.id.recycler_usuarios); //2)

        //o layout fica na vertical o tipo de lista,
        recycler_usuario.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        recycler_usuario.setHasFixedSize(true);  //esse metodo setHasFixed, ira dar mais desempenho para a nossa lista, na hora que for recyclar dara mais desempenho, melhorar a lista
     //   recycler_usuario.setAdapter();  //aqui vamos adaptar ele, precisamos do adaptar para adptar os dados que vamos criar o objeto do usuario
        //agora vamos criar nosso modelo de dado do usuário
        //Aqui vamos utilizar o adapter
       AdapterUsuario adapterUsuario = new AdapterUsuario(usuarioList); // feito isso, podemos descomentar o que comentamos o  //   recycler_usuario.setAdapter(); Mas vou repetir aqui embaixo , so para me entender mais tarde como fiz isso
        recycler_usuario.setAdapter(adapterUsuario); // feito isso, se a gente tentar executar, nao vai visualizar nada, porque ainda nao temos item nenhum na nossa lista. Entao vamos criar nosso primeiro item



        Usuarios(); // depois de fazer la embaixo .add( usuario 1) , viemos aqui. Executamos, se dê certom voltamos la embaixo para criar outros usuários

        //Evento de click na recyclerView

        recycler_usuario.addOnItemTouchListener(new RecyclerItemClickListener(
                //aqui vou passar tres argumentos
                getApplicationContext(),
                recycler_usuario,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // vai definir o clique normal da minha lista, o onItemClick, quando clicar na minha lista, vou poder fazer uma ação nesse item
                        Usuario usuario = usuarioList.get(position);
                        Toast.makeText(getApplicationContext(), "Usuário: " + usuario.getNome(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        //o onLongItemClick, quando eu clicar e segurar um pouquinho, vou definir o clique longo
                        //lembrando que o toast é para colocar uma mensagem
                        Usuario usuario = usuarioList.get(position);
                        Toast.makeText(getApplicationContext(), "Usuário: " + usuario.getNome(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }


        ));  //



    }

    //criando os itens

    public void Usuarios() {
        Usuario usuario1 = new Usuario(R.drawable.usuario1, "Toby", "Olá como vai?");
      //metodo add
        usuarioList.add(usuario1); //feito isso, ja tenho meu metodo, ai vamos colocar no OnCreate, passando o metodo Usuarios();

        Usuario usuario2 = new Usuario(R.drawable.usuario2, "Dias", "Olá você está bem?");
        usuarioList.add(usuario2);

        Usuario usuario3 = new Usuario(R.drawable.usuario1, "Smith", "Amanhã passo ai?");
        usuarioList.add(usuario3);

        Usuario usuario4 = new Usuario(R.drawable.usuario2, "Yuna", "Estou bem e você?");
        usuarioList.add(usuario4);

        Usuario usuario5 = new Usuario(R.drawable.usuario1, "Thiago", "Hi");
        usuarioList.add(usuario5);

        Usuario usuario6 = new Usuario(R.drawable.usuario2, "Stefanie", "Vem assisti a live?");
        usuarioList.add(usuario6);

        Usuario usuario7 = new Usuario(R.drawable.usuario1, "Burns", "Bora jogar?");
        usuarioList.add(usuario7);

        Usuario usuario8 = new Usuario(R.drawable.usuario2, "Naggini", "Logando");
        usuarioList.add(usuario8);

        Usuario usuario9 = new Usuario(R.drawable.usuario1, "Lino", "Saiu o Edital");
        usuarioList.add(usuario9);

        Usuario usuario10 = new Usuario(R.drawable.usuario2, "Skaylla", "Segundo a fonte:");
        usuarioList.add(usuario10);

        Usuario usuario11 = new Usuario(R.drawable.usuario1, "Hadd", "Enviei muitos reels no instagram");
        usuarioList.add(usuario11);

        Usuario usuario12 = new Usuario(R.drawable.usuario2, "Lua", "O macarrão que eu fiz estava bom.");
        usuarioList.add(usuario12);



    }


}


