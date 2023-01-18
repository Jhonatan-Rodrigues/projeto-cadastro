package br.com.jhonatan.dao;

import br.com.jhonatan.domain.Cliente;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ClienteSetDao implements IClienteDAO {

    private Set<Cliente> set;

    public ClienteSetDao(){
        this.set = new HashSet<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        return this.set.add(cliente);
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteEcontrado = null;

        for (Cliente cliente : this.set) {
            if (cliente.getCpf().equals(cpf)) {
                clienteEcontrado = cliente;
                break;
            }
        }
        if (clienteEcontrado != null){
            this.set.remove(clienteEcontrado);
        }
    }


    @Override
    public void alterar(Cliente cliente) {

        if (this.set.contains(cliente)) {
            for (Cliente clienteCadastrado : this.set) {
                clienteCadastrado.setNome(cliente.getNome());
                clienteCadastrado.setTel(cliente.getTel());
                clienteCadastrado.setNumero(cliente.getNumero());
                clienteCadastrado.setEnd(cliente.getEnd());
                clienteCadastrado.setCidade(cliente.getCidade());
                clienteCadastrado.setEstado(cliente.getEstado());
                break;
            }

        }
    }

    @Override
    public Cliente consultar(Long cpf) {
         for(Cliente clienteCadastrado: this.set){
             if (clienteCadastrado.getCpf().equals(cpf)) {
                 return clienteCadastrado;
             }
         }
         return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.set;
    }
}
