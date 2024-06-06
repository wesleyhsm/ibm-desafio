package br.com.wesley.ibm.entity;

import java.math.BigDecimal;
import java.util.Date;

import br.com.wesley.ibm.enuns.TipoTransacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="transacao")
public class Transacao {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo")
	private TipoTransacao tipo;
	
	@Column(name="valor")
	private BigDecimal valor;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name="data")
	private Date data;
	
	@ManyToOne	
	@JoinColumn(name="id_cliente")	
	private Cliente cliente;
}
