package br.com.fiap.fiapzapv2;

import java.util.ArrayList;
import java.util.List;

public class GeraContatos
{
    public static List<Contato> getContatos()
    {
       List<Contato> contatos = new ArrayList<Contato>();

       Contato c1 = new Contato("João da Silva", "(11) 1111-1111", "Ocupado", R.drawable.p1);
       Contato c2 = new Contato("Pedro Martines", "(11) 2222-2222", "Disponível", R.drawable.p2);

       contatos.add(c1);
       contatos.add(c2);

       return contatos;

    }
}
