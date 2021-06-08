package com.fiap.globalsolution.domain.dica.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fiap.globalsolution.domain.hotel.entity.Hotel;
import com.fiap.globalsolution.domain.enums.Idioma;

import javax.persistence.*;

@Entity
@Table(name="TB_GS_DICA")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dica {

	@Id
	@Column(name = "id_dica")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="ds_fuso_horario", length = 100)
	private String FUSOHORARIO;

	@Column(name="vl_temperatura")
	private Double temperatura;

	@Column(name = "tsp_tempoMedio_negocio")
	private int TMNEGOCIO;

	@Column(name = "tsp_tempoMedio_passeio")
	private int TMPASSEIO;

	@Enumerated(EnumType.STRING)
	@Column(name="ds_idioma", length = 20)
	private Idioma idioma;

	@Column(name="ds_voltagem_tomada", length = 100)
	private String voltagemTomada;

	@Column(name="nm_moeda", length = 20)
	private String moeda;

	@Column(name="ds_documentos")
	private String documentos;

	@Column(name="ds_bagagem")
	private String bagagem;

	@Column(name="ds_locomocao")
	private String locomocao;

	@Column(name="ds_estacao")
	private String estacao;

	@JsonIgnore
	@OneToOne(mappedBy = "dica", cascade = CascadeType.PERSIST)
	private Hotel hotel;

	public Dica() {}


	public Dica(Double temperatura, String moeda, String estacao, String FUSOHORARIO, int TMNEGOCIO, int TMPASSEIO,Idioma idioma, String voltagemTomada,
				String documentos, String bagagem, String locomocao) {
		super();
		this.temperatura = temperatura;
		this.idioma = idioma;
		this.voltagemTomada = voltagemTomada;
		this.moeda = moeda;
		this.documentos = documentos;
		this.bagagem = bagagem;
		this.locomocao = locomocao;
		this.estacao = estacao;
		this.FUSOHORARIO = FUSOHORARIO;
		this.TMNEGOCIO = TMNEGOCIO;
		this.TMPASSEIO = TMPASSEIO;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstacao() {
		return estacao;
	}

	public void setEstacao(String estacao) {
		this.estacao = estacao;
	}

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public String getVoltagemTomada() {
		return voltagemTomada;
	}

	public void setVoltagemTomada(String voltagemTomada) {
		this.voltagemTomada = voltagemTomada;
	}

	public String getMoeda() {
		return moeda;
	}

	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}

	public String getDocumentos() {
		return documentos;
	}

	public void setDocumentos(String documentos) {
		this.documentos = documentos;
	}

	public String getBagagem() {
		return bagagem;
	}

	public void setBagagem(String bagagem) {
		this.bagagem = bagagem;
	}

	public String getLocomocao() {
		return locomocao;
	}

	public void setLocomocao(String locomocao) {
		this.locomocao = locomocao;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getFUSOHORARIO() {
		return FUSOHORARIO;
	}

	public int getTMNEGOCIO() {
		return TMNEGOCIO;
	}

	public int getTMPASSEIO() {
		return TMPASSEIO;
	}



}
