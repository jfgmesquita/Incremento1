package Equipa2.Incremento1;

import java.util.UUID;
import java.io.Serializable;
import jakarta.persistence.*;

/**
 * Classe que representa um utilizador.
 */
@Entity
@Table(name = "utilizador")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilizador {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    private String password;

    @Column(name = "morada")
    private String morada;

    /**
     * Construtor que inicializa um novo utilizador com os dados fornecidos.
     * O ID é gerado automaticamente e aleatoriamente.
     *
     * @param nome     Nome do utilizador.
     * @param email    Email do utilizador.
     * @param password Password do utilizador.
     * @param morada   Morada do utilizador.
     */
    public Utilizador(String nome, String email, String password, String morada) {
       
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.morada = morada;
    }

    /**
     * Construtor padrão para a classe Utilizador.
     * Inicializa os campos id, nome, email, password e morada com strings vazias.
     */
    public Utilizador(){}

    /**
     * Obtém o ID do utilizador.
     *
     * @return ID do utilizador.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Obtém o nome do utilizador.
     *
     * @return Nome do utilizador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o email do utilizador.
     *
     * @return Email do utilizador.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtém a password do utilizador.
     *
     * @return Password do utilizador.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Obtém a morada do utilizador.
     *
     * @return Morada do utilizador.
     */
    public String getMorada() {
        return morada;
    }

    /**
     * Define o nome do utilizador.
     *
     * @param nome Nome do utilizador.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define o email do utilizador.
     *
     * @param email Email do utilizador.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Define a password do utilizador.
     *
     * @param password Password do utilizador.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Define a morada do utilizador.
     *
     * @param morada Morada do utilizador.
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }
    /**
     * Define o Id do utilizador.
     *
     * @param id novo Id do utilizador.
     */
    public void setId(UUID id){
        this.id = id;
    }

    /**
     * Retorna uma representação em string do utilizador.
     *
     * @return String que representa o utilizador.
     */
    @Override
    public String toString() {
        return "ID: " + id + "\n" + 
           "Nome: " + nome + "\n" + 
           "Email: " + email + "\n" + 
           "Morada: " + morada;
    }
}
