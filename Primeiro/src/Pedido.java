/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Felipe
 */
public class Pedido {

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getLocalsaida() {
        return localsaida;
    }

    public void setLocalsaida(String localsaida) {
        this.localsaida = localsaida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHorasaida() {
        return horasaida;
    }

    public void setHorasaida(String horasaida) {
        this.horasaida = horasaida;
    }

    public String getHoraretorno() {
        return horaretorno;
    }

    public void setHoraretorno(String horaretorno) {
        this.horaretorno = horaretorno;
    }

    public String getDatasaida() {
        return datasaida;
    }

    public void setDatasaida(String datasaida) {
        this.datasaida = datasaida;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public int getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }

    public String getQntusuario() {
        return qntusuario;
    }

    public void setQntusuario(String qntusuario) {
        this.qntusuario = qntusuario;
    }

    public int getObs() {
        return obs;
    }

    public void setObs(int obs) {
        this.obs = obs;
    }

    public String getObs2() {
        return obs2;
    }

    public void setObs2(String obs2) {
        this.obs2 = obs2;
    }

    public String getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(String passageiro) {
        this.passageiro = passageiro;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTempo_espera() {
        return tempo_espera;
    }

    public void setTempo_espera(String tempo_espera) {
        this.tempo_espera = tempo_espera;
    }
        String situacao;
        String tempo_espera;
        String departamento;
        String localsaida;
        String destino;
        String horasaida;
        String horaretorno;
        String datasaida;
	String justificativa;
	int urgencia;
	String qntusuario;
	int obs;

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }
        Long usuario;
    

    public void setPedido(Long pedido) {
        this.pedido = pedido;
    }

    public String getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(String autorizado) {
        this.autorizado = autorizado;
    }

    public Long getPedido() {
        return pedido;
    }
        Long pedido;
        String autorizado;
	String obs2;
	String passageiro;

    public String getDataD() {
        return dataD;
    }

    public void setDataD(String dataD) {
        this.dataD = dataD;
    }

    public String getDataM() {
        return dataM;
    }

    public void setDataM(String dataM) {
        this.dataM = dataM;
    }

    public String getDataA() {
        return dataA;
    }

    public void setDataA(String dataA) {
        this.dataA = dataA;
    }
        String dataD;
        String dataM;
        String dataA;
        
    
}
