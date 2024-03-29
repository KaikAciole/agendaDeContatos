package repository;

import domain.Contato;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDataService implements ContatoDataService {
    protected List<Contato> contatos = new ArrayList<>();
    @Override
    public void add(Contato c) {
        contatos.add(c);
        CSVDataService.exportar();
    }

    @Override
    public List<Contato> getAll() {
        return contatos;
    }

    public void update(Contato c) {
        int index = contatos.indexOf(c);
        contatos.set(index, c);
    }

    @Override
    public List<Contato> search(String termo) {
        return contatos.stream().filter(c -> (c.getNome() + c.getSobrenome()).toLowerCase().contains(termo.toLowerCase())).toList();
    }

    @Override
    public boolean existsNumber(String numero) {
        return contatos.stream().anyMatch(c -> c.getNumero().equals(numero));
    }

    @Override
    public boolean existsName(String termo) {
        return contatos.stream().anyMatch(c -> (c.getNome() + c.getSobrenome()).equalsIgnoreCase(termo));
    }

    @Override
    public void remove(Contato c) {
        contatos.remove(c);
        CSVDataService.exportar();
    }
}