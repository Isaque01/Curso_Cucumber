package br.ce.wcaquino.steps;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import io.cucumber.java.ParameterType;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;


public class AprenderCucumberSteps {

    private Date dataEntrega;
    private double valorPassagem;
    private int contador;
    private String ticket;
    private String telefonePassageiro;
    
    
    @ParameterType(".*")
    public Date data(String data) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(data);
    }
  
    @Dado("^que criei o arquivo corretamente$")
    public void queCrieiOArquivoCorretamente() throws Throwable {
        System.out.println("qualquer coisa");
    }

    @Quando("^executa lo$")
    public void executaLo() throws Throwable {
    }

    @Entao("^a especificacao deve finalizar com sucesso$")
    public void aEspecificacaoDeveFinalizarComSucesso() throws Throwable {
    }

    @Dado("^que o valor do contador é (\\d+)$")
    public void queOValorDoContadorÉ(int valor) {
        this.contador = valor;
    }

    @Quando("^eu incrementar em (\\d+)$")
    public void euIncrementarEm(int incremento) {
        this.contador += incremento;
    }

    @Então("^o valor do contador será (\\d+)$")
    public void oValorDoContadorSerá(int valorEsperado) {
        assert this.contador == valorEsperado;
    }

    
    @Dado("que a entrega é dia {data}")
    public void queAEntregaÉDia(Date data) throws ParseException {
    	dataEntrega = data;
        System.out.println(dataEntrega);
    }

    @Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
    public void aEntregaAtrasarEmDias(int int1, String tempo) throws Throwable {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataEntrega);
        if (tempo.equals("dias") || tempo.equals("dia")) {
            cal.add(Calendar.DAY_OF_MONTH, int1);
        } else if (tempo.equals("meses") || tempo.equals("mes")) {
            cal.add(Calendar.MONTH, int1);
        }
        dataEntrega = cal.getTime();
    }

    @Então("^a entrega será efetuada em (\\d{2}/\\d{2}/\\d{4})$")
    public void aEntregaSeráEfetuadaEm(String data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(dataEntrega);
        Assert.assertEquals(data, dataFormatada);
    }

    @Dado("que o ticket especial é {string}")
    public void queOTicketEspecialÉ(String ticket) {
        this.ticket = ticket;
    }

    @Dado("^que o valor da passagem é R\\$ ([\\d,.]+)$")
    public void queOValorDaPassagemÉR$(String valor) {
        valor = valor.replace(".", "").replace(",", ".");
        this.valorPassagem = Double.parseDouble(valor);
    }

    @Dado("que o nome do passageiro é {string}")
    public void que_o_nome_do_passageiro_é(String nome) {
    }

    @Dado("que o telefone do passageiro é {string}")
    public void que_o_telefone_do_passageiro_é(String telefone) {
    }

    @Dado("que o ticket é {string}")
    public void queOTicketÉ(String ticket) {
        this.ticket = ticket;
    }

    @Quando("^criar os steps$")
    public void criarOsSteps() {
    }

    @Então("^o teste vai funcionar$")
    public void oTesteVaiFuncionar() {
    }

    @Dado("que o ticket é AF345")
    public void que_o_ticket_é_af345() {
        this.ticket = "AF345";
    }

    @Dado("que o telefone do passageiro é {int}-{int}")
    public void que_o_telefone_do_passageiro_é(Integer int1, Integer int2) {
        this.telefonePassageiro = int1 + "-" + int2;
    }

    @Dado("que o ticket é AB167")
    public void que_o_ticket_é_ab167() {
        this.ticket = "AB167";
    }

    @Dado("que o ticket especial é AB167")
    public void que_o_ticket_especial_é_ab167() {
        this.ticket = "AB167";
    }

    @Dado("que o ticket é CD123")
    public void que_o_ticket_é_cd123() {
        this.ticket = "CD123";
    }

    @Dado("que o ticket é AG1234")
    public void que_o_ticket_é_ag1234() {
        this.ticket = "AG1234";
    }
}
