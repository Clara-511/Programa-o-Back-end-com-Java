package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo {

    private ArrayList<PessoaFisica> pessoas;

    public PessoaFisicaRepo() {
        pessoas = new ArrayList<>();
    }

    public void inserir(PessoaFisica pessoa) {
        pessoas.add(pessoa);
    }

    public void alterar(PessoaFisica pessoa) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getId() == pessoa.getId()) {
                pessoas.set(i, pessoa);
                break;
            }
        }
    }

    public void excluir(int id) {
        PessoaFisica pessoa = obter(id);
        if (pessoa != null) {
            pessoas.remove(pessoa);
        }
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return pessoas;
    }

    public void persistir(String nomeArquivo) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(pessoas);
        }
    }

    public void recuperar(String nomeArquivo) throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoas = (ArrayList<PessoaFisica>) in.readObject();
        }
    }
}
