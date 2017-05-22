package br.org.cancer.modred.dto;

import java.util.ArrayList;
import java.util.List;

import br.org.cancer.modred.model.LogradouroCorreio;
import br.org.cancer.modred.vo.CepCorreio;

/**
 * Classe de conversão do LogradouroCorreio para CepCorreioVo
 * 
 * 
 * @author bruno.sousa
 *
 */
public class CepCorreioDTO {

    private static volatile CepCorreioDTO INSTANCE;
    
    private List<LogradouroCorreio> listaToTransformer;
    private LogradouroCorreio entityToTransformer;

    private static CepCorreioDTO instance() {
        if (INSTANCE == null) {
            synchronized (CepCorreioDTO.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CepCorreioDTO();
                }
            }
        }
        return INSTANCE;
    }

    
    /**
     * @param logradouro
     * @return CepCorreio
     */
    private CepCorreio buildEntity(LogradouroCorreio logradouro) {
        if (logradouro == null) {
            return new CepCorreio();
        }
        CepCorreio cep = new CepCorreio();
        cep.setCep(logradouro.getCep());
        cep.setUf(logradouro.getBairroInicial().getLocalidade().getUnidadeFederativa().getSigla());
        cep.setLocalidade(logradouro.getBairroInicial().getLocalidade().getNome());
        cep.setBairro(logradouro.getBairroInicial().getNome());
        cep.setTipoLogradouro(logradouro.getTipoLogradouro().getNome());
        cep.setLogradouro(logradouro.getNome());
        return cep;
    }

    /**
     * @param lista
     * @return uma instancia da 
     */
    public static IListTransformer<CepCorreio> transformar(List<LogradouroCorreio> lista) {
        instance().listaToTransformer = lista;
        return instance().new ListTransformer();
    }

    /**
     * @param entity
     * @return
     */
    public static IEntityTransformer<CepCorreio> transformar(LogradouroCorreio entity) {
        instance().entityToTransformer = entity;
        return instance().new EntityTransformer();
    }
    
    /**
     * Classe interna que transforma uma lista de LoradouroCorreio em lista de CepCorrreio
     * 
     * @author bruno.sousa
     *
     */
    private class ListTransformer implements IListTransformer<CepCorreio> {

        @Override
        public List<CepCorreio> Transformar() {
                List<CepCorreio> retorno = new ArrayList<CepCorreio>();
                for (LogradouroCorreio logradouro: listaToTransformer) {
                        retorno.add(buildEntity(logradouro));
                }
                
                return retorno;
        }               
    }
    
    
    
    /**
     * Classe interna que transforma um LogradouroCorreio em CepCorreio
     * 
     * @author bruno.sousa
     *
     */
    private class EntityTransformer implements IEntityTransformer<CepCorreio> {

        @Override
        public CepCorreio Transformar() {
                return buildEntity(entityToTransformer);
        }
    }
    
    
}
