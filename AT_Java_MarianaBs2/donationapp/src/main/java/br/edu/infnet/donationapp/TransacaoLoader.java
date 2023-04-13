package br.edu.infnet.donationapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.donationapp.model.domain.Doador;
import br.edu.infnet.donationapp.model.domain.Produto;
import br.edu.infnet.donationapp.model.domain.Transacao;
import br.edu.infnet.donationapp.model.domain.Usuario;
import br.edu.infnet.donationapp.model.service.TransacaoService;

@Order(4)
@Component
public class TransacaoLoader implements ApplicationRunner {

	@Autowired
	private TransacaoService transacaoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			String arq = "transacoes.txt";

			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();
				String[] campos = null;

				while (linha != null) {

					campos = linha.split(";");
					
					Usuario usuario = new Usuario();
					usuario.setId(1);
					
					
					Doador doador = new Doador();
					doador.setId(1);
					
					//Produto produto = new Produto();
					//produto.setId(1);
					
					Transacao transacao = new Transacao();
					transacao.setDescricao(campos[0]);
					transacao.setEntregaComFrete(Boolean.valueOf(campos[1]));
					transacao.setData(campos[2]);
					
					
					//transacao.setProduto(produto);
					transacao.setDoador(doador);
					
					transacao.setUsuario(usuario);
					
					transacaoService.incluir(transacao);

					System.out.println("Transação " + transacao.getDescricao() + " incluída com sucesso!");

					linha = leitura.readLine();
				}

				leitura.close();
				fileR.close();
			} catch (

			IOException e) {
				System.out.println("[ERRO] " + e.getMessage());
			}

		} finally {
			System.out.println("Processamento realizado com sucesso! :D");
		}
	}

}
