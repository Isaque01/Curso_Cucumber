package br.ce.wcaquino.steps;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.NotaAluguel;
import br.ce.wcaquino.entidades.TipoAluguel;
import br.ce.wcaquino.servicos.AluguelService;
import br.ce.wcaquino.utils.DateUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;


public class AlugarFilmeSteps {

	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;
	private String erro;
	private TipoAluguel tipoAluguel = TipoAluguel.COMUM;

	@Dado("um filme")
	public void um_filme(DataTable table) throws Throwable {
		List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			filme = new Filme();
			filme.setEstoque(Integer.parseInt(row.get("estoque")));
			filme.setAluguel(Integer.parseInt(row.get("preco")));
		}
	}

	@Dado("um filme com estoque de {int} unidades")
	public void um_filme_com_estoque_de_unidades(int int1) {
		filme = new Filme();
		filme.setEstoque(int1);
	}

	@Dado("que o preço de aluguel seja R$ {int}")
	public void que_o_preço_de_aluguel_seja_r$(int int1) {
		filme.setAluguel(int1);
	}

	@Quando("alugar")
	public void alugar() {
		try {
			nota = aluguel.alugar(filme, tipoAluguel);
		} catch (RuntimeException e) {
			erro = e.getMessage();
		}
	}

	@Então("o preço do aluguel será R$ {int}")
	public void o_preço_do_aluguel_será_r$(int int1) {
		Assert.assertEquals(int1, nota.getPreco());
	}

	@Então("o estoque do filme será {int} unidade")
	public void o_estoque_do_filme_será_unidade(int int1) {
		Assert.assertEquals(int1, filme.getEstoque());
	}

	@Então("não será possível por falta de estoque")
	public void não_será_possível_por_falta_de_estoque() {
		Assert.assertEquals("Filme sem estoque", erro);
	}

	@Dado("o tipo de aluguel seja {string}")
	public void o_tipo_de_aluguel_seja(String tipo) {
		tipoAluguel = tipo.equals("semanal") ? TipoAluguel.SEMANAL
				: tipo.equals("extendido") ? TipoAluguel.EXTENDIDO : TipoAluguel.COMUM;
	}

	@Então("a data de entrega será em {int} dia(s)")
	public void a_data_de_entrega_será_em_dias(int int1) {
		Date dataEsperada = DateUtils.obterDataDiferenciaDias(int1);
		Date dataReal = nota.getDataEntrega();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
	}

	@Então("a pontuação recebida será de {int} pontos")
	public void a_pontuação_recebida_será_de_pontos(int int1) {
		Assert.assertEquals(int1, nota.getPontuacao());
	}
}
