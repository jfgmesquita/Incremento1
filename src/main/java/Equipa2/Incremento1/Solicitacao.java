package Equipa2.Incremento1;

import java.util.UUID;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe para representar a Solicitação do serviço.
 */
@Getter
@Setter
@Entity
@Table(name = "solicitacao_de_servico")
@Inheritance(strategy = InheritanceType.JOINED)
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
      private UUID id;

    @Enumerated(EnumType.STRING)
    private StatusServico status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    @Column(name = "morada")
    private String morada;

	@OneToOne(cascade = CascadeType.ALL)
	private Pagamento pagamento;

    @Column(name = "data")
    private LocalDateTime data;
  
    /**
     * Construtor que inicializa uma nova solicitação de serviço com os dados fornecidos.
     * 
     * @param cliente		Cliente que solicitou.
     * @param profissional  Profissional que aceitou o pedido.
     * @param morada		Endereço do local.
     * @param data			Data e horas.
     */
    public Solicitacao(Cliente cliente, Profissional profissional, String morada, Pagamento pagamento, LocalDateTime data) {
        id = UUID.randomUUID();
        this.cliente = cliente;
        this.profissional = profissional;
        this.morada = morada;
		this.pagamento = pagamento;
        status = StatusServico.PENDENTE;
        this.data = data;
    }

    /**
     * Construtor vazio para a classe Solicitacao.
     * Inicializa todas variáveis de objeto como null.
     */
    public Solicitacao() {
    }

    /**
     * Retorna uma representação em string da solicitação.
     *
     * @return uma string que representa a solicitação
     */
    @Override
    public String toString() {
        return "ID: " + id + "\n" +
            "Status: " + status + "\n" +
            "Morada: " + morada + "\n" +
            "Data: " + data + "\n" +
            "Cliente: " + cliente.getNome() + "\n" +
            "Profissional: " + profissional.getNome();
    }
}
