package br.com.massuda.alexander.crm.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.massuda.alexander.autenticacao.orm.bo.BOUsuario;
import br.com.massuda.alexander.autenticacao.orm.modelo.usuario.Usuario;
import br.com.massuda.alexander.spring.framework.infra.controller.Controlador;

@CrossOrigin
@Controller
@RequestMapping("/usuario")
public class UsuarioCRUD extends Controlador<Usuario> {
	
	@Autowired
	private BOUsuario bo;

	@RequestMapping(method=RequestMethod.POST)
	public void incluir(Usuario usuario) {
		/*if (existe(usuario.getFotos()) && !usuario.getFotos().isEmpty()) {
			try {
				String raiz = System.getProperty("catalina.home");
				File pastaArquivosTemporarios = new File(raiz + "/temp/");
				if (!pastaArquivosTemporarios.exists()) {
					pastaArquivosTemporarios.mkdirs();
				}
				try{
					String storage = "/storage/";
					File caminhoArquivo = new File(raiz+storage);
					if (!caminhoArquivo.exists()) {
						caminhoArquivo.mkdirs();
					}
					caminhoArquivo = caminhoArquivo + "/";

					while (i.hasNext()) {
						FileItem item = i.next();
						if (!item.isFormField()) {
							String nomeCampo = item.getFieldName();
							String nomeArquivo = item.getName();
							String tipoConteudo = item.getContentType();
							boolean estaEmMemoria = item.isInMemory();
							long tamanhoEmBytes = item.getSize();

							if (nomeArquivo.lastIndexOf("/") >= 0) {
								arquivo = new File(caminhoArquivo + nomeArquivo.substring(nomeArquivo.lastIndexOf("\\")));
							} else {
								arquivo = new File(caminhoArquivo + nomeArquivo.substring(nomeArquivo.lastIndexOf("\\")+1));
							}

							item.write(arquivo);
							Foto foto = new Foto();
							foto.setCaminho(arquivo.getAbsolutePath());
							foto.setData(GregorianCalendar.getInstance());
							foto.setDescricao(arquivo.getName());
							fotos.add(foto);
						} else {
						}
					}
				} catch (Exception e) {
					getWriter(null, resposta).println("Erro: "+e.getMessage());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		
		bo.incluir(usuario);
	}
	
	@ResponseBody
	@RequestMapping("{id}")
	public Usuario pesquisar (@PathVariable Long id) {
		return bo.pesquisar(id);
	}

	@ResponseBody
	@RequestMapping("/pesquisarPorNome")
	public List<Usuario> pesquisarPorNome (String nome) {
		return bo.pesquisarPorNome(nome);
	}

	@ResponseBody
	@RequestMapping("/pesquisarPorLogin")
	public Usuario pesquisar (String login) {
		return bo.pesquisarPorLogin(login);
	}

}
