package fj21_jdbc.course;

import java.util.Calendar;

/**
 * Created by gersonsales on 05/01/17.
 */
public class Contact {
    private Long id;
    private String nome;
    private String email;
    private String endereco;
    private Calendar dataNascimento;

    public Contact(String nome, String email, String endereco, Calendar dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public Contact() {
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String novo) {
        this.nome = novo;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String novo) {
        this.email = novo;
    }
    public String getEndereco() {
        return this.endereco;
    }
    public void setEndereco(String novo) {
        this.endereco = novo;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long novo) {
        this.id = novo;
    }
    public Calendar getDataNascimento() {
        return this.dataNascimento;
    }
    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
