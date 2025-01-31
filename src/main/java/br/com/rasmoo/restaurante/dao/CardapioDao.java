package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Cardapio cardapio) {
        this.entityManager.persist(cardapio);

    }

    public Cardapio consultarPorId(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }

    public Cardapio consultarPorNome(final String filtro) {
        try {
            String jpql = "select c from Cardapio c where upper(c.nome) = upper(:nome)";
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("nome", filtro).getSingleResult();
        } catch (Exception e) {
            return null;
        }


    }

    public List<Cardapio> consultarPorValor(final BigDecimal filtro) {
        try {
            String jpql = "select c from Cardapio c where c.valor = :valor";
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("valor", filtro).getResultList();

        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Cardapio> cosultarTodos() {
        try {
            String jpql = "select c from Cardapio c";
            return this.entityManager.createQuery(jpql, Cardapio.class).getResultList();

        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public void atualizar(final Cardapio cardapio) {
        this.entityManager.merge(cardapio);
    }

    public void deletar(final Cardapio cardapio) {
        this.entityManager.remove(cardapio);
    }
}
