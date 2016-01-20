package com.example.cesijeujura.IDAO;

public interface GenericIDAO<T> {

	/**
	 * Créer une valeur dans la table
	 * @param t
	 * @return
	 */
	public T create(T t);
	/**
	 * Mettre à jour la valeur dans la table 
	 * @param t
	 * @return
	 */
	public T update(T t);
	/**
	 * Trouver un champ dans la table
	 * @param id
	 * @return
	 */
	public T find(int id);
	/**
	 * Supprimer un champ dans la table
	 * @param id
	 * @return
	 */
	public void delete(int id);
}
